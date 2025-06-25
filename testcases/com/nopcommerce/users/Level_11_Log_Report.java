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


public class Level_11_Log_Report extends BaseTest {
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
        log.info("User_01_Register - STEP 01: Open Register page");
        registerPage = homePage.openRegisterPage();

        log.info("User_01_Register - STEP 02: Click to Male radio button");
        registerPage.clickToMaleRadio();

        log.info("User_01_Register - STEP 03: Enter to First Name textbox with value" + firstName);
        registerPage.enterToFirstNameTextbox(firstName);

        log.info("User_01_Register - STEP 04: Enter to Last Name textbox with value" + lastName);
        registerPage.enterToLastNameTextbox(lastName);

        log.info("User_01_Register - STEP 05: Enter to Email textbox with value" + email);
        registerPage.enterToEmailTextbox(email);

        log.info("User_01_Register - STEP 06: Enter to Company textbox with value" + company);
        registerPage.enterToCompanyTextbox(company);

        log.info("User_01_Register - STEP 07: Enter to Password textbox with value" + password);
        registerPage.enterToPasswordTextbox(password);

        log.info("User_01_Register - STEP 08: Enter to Confirm Password textbox with value" + password);
        registerPage.enterToConfirmPasswordTextbox(password);

        log.info("User_01_Register - STEP 09: Click Register button");
        registerPage.clickToRegisterButton();

        log.info("User_01_Register - STEP 10: Verify success message is displayed");
        Assert.assertEquals(registerPage.getRegisterSuccessMessage(),"Your registration completed");

    }


    //Post-condition
    @AfterClass
    public void afterClass(){
        driver.quit();
    }

}
