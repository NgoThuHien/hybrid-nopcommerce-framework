package com.nopcommerce.common;

import commons.BasePage;
import commons.BaseTest;
import commons.PageGeneratorManagerNopCommerce;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.*;
import pageObjects.nopCommerce.user.*;

import java.util.Set;

public class Login extends BaseTest {
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
    public static Set<Cookie> nopcommerceCookie;

    //Pre-condition
    @Parameters({"browser","userUrl"})
    @BeforeTest
    public void beforeTest(String browserName,String url) {
        driver = getBrowser(browserName,url);

        // nó đc khoi tao ra và bắt dau lam những action của page đó
        homePage = PageGeneratorManagerNopCommerce.getUserHomePage(driver);
        firstName = "John";
        lastName = "Mayer";
        company = "GG";
        password = "123456";
        email = "Testing" + getRandomNumber() + "@gmail.com";

    //new user
        registerPage = homePage.openRegisterPage();
        registerPage.clickToRadioById(driver, "gender-male");

        registerPage.enterToTextboxById(driver, "FirstName", firstName);
        registerPage.enterToTextboxById(driver, "LastName", lastName);
        registerPage.enterToTextboxById(driver, "Email", email);
        registerPage.enterToTextboxById(driver, "Company", company);
        registerPage.enterToTextboxById(driver, "Password", password);
        registerPage.enterToTextboxById(driver, "ConfirmPassword", password);


        registerPage.clickToButtonByText(driver, "Register");

        Assert.assertEquals(registerPage.getRegisterSuccessMessage(), "Your registration completed");


        //Login page
        loginPage = registerPage.openLoginPage();

        loginPage.enterToTextboxById(driver, "Email", email);
        loginPage.enterToTextboxById(driver, "Password", password);

        loginPage.clickToButtonByText(driver, "Log in");
        homePage = PageGeneratorManagerNopCommerce.getUserHomePage(driver);

        //get cookies
        nopcommerceCookie = homePage.getAllCookies(driver);
        driver.quit();

    }

}
