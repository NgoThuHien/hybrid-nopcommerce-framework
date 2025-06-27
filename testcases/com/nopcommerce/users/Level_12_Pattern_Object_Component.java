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
import pageUIs.nopCommerce.user.UserRegisterPageUI;


public class Level_12_Pattern_Object_Component extends BaseTest {
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
        registerPage.clickToRadioById(driver,"gender-male");

        registerPage.enterToTextboxById(driver,"FirstName",firstName);
        registerPage.enterToTextboxById(driver,"LastName",lastName);
        registerPage.enterToTextboxById(driver,"Email",email);
        registerPage.enterToTextboxById(driver,"Company",company);
        registerPage.enterToTextboxById(driver,"Password",password);
        registerPage.enterToTextboxById(driver,"ConfirmPassword",password);


        registerPage.clickToButtonByText(driver,"Register");

        Assert.assertEquals(registerPage.getRegisterSuccessMessage(),"Your registration completed");

    }

    @Test
    public void User_02_Login(){
        loginPage = registerPage.openLoginPage();

        loginPage.enterToTextboxById(driver,"Email",email);
        loginPage.enterToTextboxById(driver,"Password",password);

        loginPage.clickToButtonByText(driver,"Log in");
        homePage = PageGeneratorManagerNopCommerce.getUserHomePage(driver);

        //Assert.assertTrue(homePage.isMyAccountLinkisDisplayed());
    }

    @Test
    public void User_03_MyAccount(){

        customerInfoPage = homePage.openMyAccountPage();

        Assert.assertTrue(customerInfoPage.isRadioByIdSelected(driver,"gender-male"));


        Assert.assertEquals(customerInfoPage.getTextboxValueById(driver,"FirstName"),firstName);
        Assert.assertEquals(customerInfoPage.getTextboxValueById(driver,"LastName"),lastName);
        Assert.assertEquals(customerInfoPage.getTextboxValueById(driver,"Email"),email);
        Assert.assertEquals(customerInfoPage.getTextboxValueById(driver,"Company"),company);


    }


    //Post-condition
    @AfterClass
    public void afterClass(){
        driver.quit();
    }

}
