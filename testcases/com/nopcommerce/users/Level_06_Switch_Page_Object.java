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

public class Level_06_Switch_Page_Object extends BaseTest {
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
        addressPage = customerInfoPage.openAddressPage(driver);

        //Address => Reward
        rewardPage = addressPage.openRewardPage(driver);

        //Reward => Order
        orderPage = rewardPage.openOrderPage(driver);

        //Order => Address
        addressPage = orderPage.openAddressPage(driver);

        //Address => Customer Info
        customerInfoPage = addressPage.openCustomerInfoPage(driver);

        //Customer Info => Change password
        changePasswordPage = customerInfoPage.openChangePasswordPage(driver);

        //Change password => My product review
        myProductReviewPage = changePasswordPage.openMyProductReviewPage(driver);

    }
    //Post-condition
    @AfterClass
    public void afterClass(){
        driver.quit();
    }

}
