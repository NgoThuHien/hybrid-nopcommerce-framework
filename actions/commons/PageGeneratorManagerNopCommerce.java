package commons;

import org.openqa.selenium.WebDriver;
import pageObjects.nopCommerce.admin.AdminDashboardPagePO;
import pageObjects.nopCommerce.admin.AdminLoginPagePO;
import pageObjects.nopCommerce.user.*;


public class PageGeneratorManagerNopCommerce {
    public static UserHomePageObject getUserHomePage(WebDriver driver){
       return new UserHomePageObject(driver);
    }
    public static UserRegisterPageObject getUserRegisterPage(WebDriver driver){
       return new UserRegisterPageObject(driver);
    }
    public static UserLoginPageObject getUserLoginPage(WebDriver driver){
       return new UserLoginPageObject(driver);
    }
    public static UserCustomerInfoPO getUserCustomerInfoPage(WebDriver driver){
       return new UserCustomerInfoPO(driver);
    }
    public static UserAddressPO getUserAddressPage(WebDriver driver){
       return new UserAddressPO(driver);
    }
    public static UserOrderPageObject getUserOrderPage(WebDriver driver){
       return new UserOrderPageObject(driver);
    }
    public static UserRewardPageObject getUserRewardPage(WebDriver driver){
       return new UserRewardPageObject(driver);
    }
    public static UserChangePasswordPO getUserChangePasswordPage(WebDriver driver){
        return new UserChangePasswordPO(driver);
    }
    public static UserMyProductReviewPO getUserProductReviewPage(WebDriver driver){
        return new UserMyProductReviewPO(driver);
    }
    public static AdminLoginPagePO getAdminLoginPage(WebDriver driver){
        return new AdminLoginPagePO(driver);
    }
    public static AdminDashboardPagePO getAdminDashboardPage(WebDriver driver){
        return new AdminDashboardPagePO(driver);
    }

}
