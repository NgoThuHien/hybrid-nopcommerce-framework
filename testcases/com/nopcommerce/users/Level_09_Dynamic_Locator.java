package com.nopcommerce.users;

import commons.BaseTest;
import commons.PageGeneratorManagerNopCommerce;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pageObjects.nopCommerce.user.*;


public class Level_09_Dynamic_Locator extends BaseTest {
    //Declare Variables
    private WebDriver driver;
    private UserHomePageObject homePage;
    private UserRegisterPageObject registerPage;
    private UserLoginPageObject loginPage;
    private UserCustomerInfoPO customerInfoPage;
    private UserOrderPageObject orderPage;
    private UserAddressPO addressPage;
    private UserRewardPageObject rewardPage;
    private UserChangePasswordPO changePasswordPage;
    private UserMyProductReviewPO myProductReviewPage;
    private UserSideBarPageObject sideBarPage;
   private String firstName, lastName, email, company, password;

    //Pre-condition
    @Parameters("browser")
    @BeforeClass
    public void beforeClass(String browserName){
       driver = getBrowser(browserName);

        // nó đc khoi tao ra và bắt dau lam những action của page đó
        homePage = PageGeneratorManagerNopCommerce.getUserHomePage(driver);
        firstName = "John";
        lastName = "Mayer";
        company = "GG";
        password = "123456";
        email = "Testing" + getRandomNumber()+ "@gmail.com";

    }
    //Testcases
    @Test
    public void User_01_Register(){

        registerPage = homePage.openRegisterPage();
        registerPage.clickToMaleRadio();
        registerPage.enterToFirstNameTextbox(firstName);
        registerPage.enterToLastNameTextbox(lastName);
        registerPage.enterToEmailTextbox(email);
        registerPage.enterToCompanyTextbox(company);
        registerPage.enterToPasswordTextbox(password);
        registerPage.enterToConfirmPasswordTextbox(password);
        registerPage.clickToRegisterButton();

        Assert.assertEquals(registerPage.getRegisterSuccessMessage(),"Your registration completed");

    }

    @Test
    public void User_02_Login(){
        loginPage = registerPage.openLoginPage();

        homePage = loginPage.loginToSystem(email,password);

        //Assert.assertTrue(homePage.isMyAccountLinkisDisplayed());
    }

    @Test
    public void User_03_MyAccount(){

        customerInfoPage = homePage.openMyAccountPage();
        Assert.assertTrue(customerInfoPage.isGenderMailSelected());

        Assert.assertEquals(customerInfoPage.getFirstNameTextboxValue(),firstName);
        Assert.assertEquals(customerInfoPage.getLastNameTextboxValue(),lastName);
        Assert.assertEquals(customerInfoPage.getEmailTextboxValue(),email);
        Assert.assertEquals(customerInfoPage.getCompanyTextboxValue(),company);


    }

    @Test
    public void User_04_Switch_Page(){
        //Customer Info => Address
        addressPage = (UserAddressPO) customerInfoPage.openDynamicPage("Addresses");

        //Address => Reward
        rewardPage = (UserRewardPageObject) addressPage.openDynamicPage("Reward points");

        //Reward => Order
        orderPage = (UserOrderPageObject) rewardPage.openDynamicPage("Orders");

        //Order => Address
        addressPage = (UserAddressPO) orderPage.openDynamicPage("Addresses");

        //Address => Customer Info
        customerInfoPage = (UserCustomerInfoPO) addressPage.openDynamicPage("Customer info");

        //Customer Info => Change password
        changePasswordPage = (UserChangePasswordPO) customerInfoPage.openDynamicPage("Change password");

        //Change password => My product review
        myProductReviewPage = (UserMyProductReviewPO) changePasswordPage.openDynamicPage("My product reviews");


    }
    @Test
    public void User_05_Switch_Page(){
        //My product review => Address
        myProductReviewPage.openDynamicPages("Addresses");
        addressPage = PageGeneratorManagerNopCommerce.getUserAddressPage(driver);

        //Address => Reward
        addressPage.openDynamicPage("Reward points");
        rewardPage = PageGeneratorManagerNopCommerce.getUserRewardPage(driver);

                //Reward => Order
        rewardPage.openDynamicPage("Orders");
        orderPage = PageGeneratorManagerNopCommerce.getUserOrderPage(driver);

                //Order => Address
        orderPage.openDynamicPage("Addresses");
        addressPage = PageGeneratorManagerNopCommerce.getUserAddressPage(driver);

        //Address => Customer Info
        addressPage.openDynamicPage("Customer info");
        customerInfoPage = PageGeneratorManagerNopCommerce.getUserCustomerInfoPage(driver);
        //Customer Info => Change password
        customerInfoPage.openDynamicPage("Change password");
        changePasswordPage = PageGeneratorManagerNopCommerce.getUserChangePasswordPage(driver);
        //Change password => My product review
        changePasswordPage.openDynamicPage("My product reviews");
        myProductReviewPage = PageGeneratorManagerNopCommerce.getUserProductReviewPage(driver);

    }
    //Post-condition
    @AfterClass
    public void afterClass(){
        driver.quit();
    }

}
