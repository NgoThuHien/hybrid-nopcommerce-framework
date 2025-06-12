package com.nopcommerce.users;

import commons.BaseTest;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pageObjects.nopCommerce.user.UserCustomerInfoPO;
import pageObjects.nopCommerce.user.UserHomePageObject;
import pageObjects.nopCommerce.user.UserLoginPageObject;
import pageObjects.nopCommerce.user.UserRegisterPageObject;

public class Level_04_Multi_Browser extends BaseTest {
    //Declare Variables
    private WebDriver driver;
    private UserHomePageObject homePage;
    private UserRegisterPageObject registerPage;
    private UserLoginPageObject loginPage;
    private UserCustomerInfoPO customerInfoPage;
   private String firstName, lastName, email, company, password;

    //Pre-condition
    @Parameters("browser")
    @BeforeClass
    public void beforeClass(String browserName){
       driver = getBrowser(browserName);

        // nó đc khoi tao ra và bắt dau lam những action của page đó
        homePage = new UserHomePageObject(driver);
        firstName = "John";
        lastName = "Mayer";
        company = "GG";
        password = "123456";
        email = "Testing" + getRandomNumber()+ "@gmail.com";

    }
    //Testcases
    @Test
    public void User_01_Register(){
        homePage.openRegisterPage();

        registerPage = new UserRegisterPageObject(driver);

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
        registerPage.openLoginPage();

        loginPage = new UserLoginPageObject(driver);
        loginPage.enterToEmailTextbox(email);
        loginPage.enterToPasswordTextbox(password);
        loginPage.clickToLoginButton();

        homePage = new UserHomePageObject(driver);
        //Assert.assertTrue(homePage.isMyAccountLinkisDisplayed());
    }

    @Test
    public void User_03_MyAccount(){
        homePage.openMyAccountPage();

        customerInfoPage = new UserCustomerInfoPO(driver);
        Assert.assertTrue(customerInfoPage.isGenderMailSelected());

        Assert.assertEquals(customerInfoPage.getFirstNameTextboxValue(),firstName);
        Assert.assertEquals(customerInfoPage.getLastNameTextboxValue(),lastName);
        Assert.assertEquals(customerInfoPage.getEmailTextboxValue(),email);
        Assert.assertEquals(customerInfoPage.getCompanyTextboxValue(),company);

    }

    //Post-condition
    @AfterClass
    public void afterClass(){
        driver.quit();
    }

}
