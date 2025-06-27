package com.nopcommerce.users;

import com.nopcommerce.common.Login;
import commons.BaseTest;
import commons.PageGeneratorManagerNopCommerce;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pageObjects.nopCommerce.user.*;


public class Level_13_Share_State extends BaseTest {
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
    @Parameters({"browser","userUrl"})
    @BeforeClass
    public void beforeClass(String browserName,String url){
       driver = getBrowser(browserName,url);

        // nó đc khoi tao ra và bắt dau lam những action của page đó
        homePage = PageGeneratorManagerNopCommerce.getUserHomePage(driver);
        //set cookies
        homePage.setCookies(driver, Login.nopcommerceCookie);
        homePage.refreshCurrentPage(driver);


    }
    //Testcases
    @Test
    public void User_01_My_Account(){
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
