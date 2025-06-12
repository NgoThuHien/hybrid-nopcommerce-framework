package com.nopcommerce.users;

import commons.BaseTest;
import commons.PageGeneratorManagerNopCommerce;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pageObjects.nopCommerce.admin.AdminDashboardPagePO;
import pageObjects.nopCommerce.admin.AdminLoginPagePO;
import pageObjects.nopCommerce.user.UserHomePageObject;
import pageObjects.nopCommerce.user.UserLoginPageObject;
import pageObjects.nopCommerce.user.UserRegisterPageObject;


public class Level_08_Switch_Site extends BaseTest {

    //Pre-condition
    @Parameters({"browser","userUrL","adminUrl"})
    @BeforeClass
    public void beforeClass(String browserName, String userUrl, String adminUrl){
       driver = getBrowser(browserName);
        adminUrlValue = adminUrl;
        userUrlValue = userUrl;

        // nó đc khoi tao ra và bắt dau lam những action của page đó
        userHomePage = PageGeneratorManagerNopCommerce.getUserHomePage(driver);
        firstName = "John";
        lastName = "Mayer";
        company = "GG";
        password = "123456";
        email = "Testing" + getRandomNumber()+ "@gmail.com";

        //pre-condition
        userRegisterPage = userHomePage.openRegisterPage();
        userRegisterPage.clickToMaleRadio();
        userRegisterPage.enterToFirstNameTextbox(firstName);
        userRegisterPage.enterToLastNameTextbox(lastName);
        userRegisterPage.enterToEmailTextbox(email);
        userRegisterPage.enterToCompanyTextbox(company);
        userRegisterPage.enterToPasswordTextbox(password);
        userRegisterPage.enterToConfirmPasswordTextbox(password);
        userRegisterPage.clickToRegisterButton();

        Assert.assertEquals(userRegisterPage.getRegisterSuccessMessage(),"Your registration completed");
    }
    //Testcases
    @Test
    public void Role_01_User_Site_To_Admin_Site(){
        userLoginPage = userRegisterPage.openLoginPage();

        userHomePage = userLoginPage.loginToSystem(email,password);

        //Assert.assertTrue(userHomePage.isMyAccountLinkisDisplayed());

        //qua trang admin
        userHomePage.openPageUrl(driver,adminUrlValue);
        adminLoginPage = PageGeneratorManagerNopCommerce.getAdminLoginPage(driver);

        //login trang admin =>  đến trang dashboard và khởi tạo trang dashboard luôn 1 thể
        adminDashboardPage = adminLoginPage.openAdminDashboardSite(adminEmail,adminPassword);


    }

    @Test
    public void Role_02_Admin_Site_To_User_Site(){
        adminDashboardPage.openPageUrl(driver,userUrlValue);
        userHomePage = PageGeneratorManagerNopCommerce.getUserHomePage(driver);


    }


    //Post-condition
    @AfterClass
    public void afterClass(){
        driver.quit();
    }
    //Declare Variables
    private WebDriver driver;
    private UserHomePageObject userHomePage;
    private UserRegisterPageObject userRegisterPage;
    private UserLoginPageObject userLoginPage;
    private AdminLoginPagePO adminLoginPage;
    private AdminDashboardPagePO adminDashboardPage;
    private String firstName, lastName, email, company, password, adminEmail,adminPassword ;
    private String userUrlValue, adminUrlValue;


}
