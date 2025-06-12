package pageObjects.nopCommerce.user;

import commons.BasePage;
import commons.PageGeneratorManagerNopCommerce;
import org.openqa.selenium.WebDriver;
import pageUIs.nopCommerce.user.UserSideBarUIs;

public class UserSideBarPageObject extends BasePage {
    WebDriver driver;

    public UserSideBarPageObject(WebDriver driver) {
        this.driver = driver;
    }
    public UserAddressPO openAddressPage() {
        waitForElementClickable(driver, UserSideBarUIs.ADDRESS_LINK);
        clickToElement(driver, UserSideBarUIs.ADDRESS_LINK);
        return PageGeneratorManagerNopCommerce.getUserAddressPage(driver);
    }

    public UserRewardPageObject openRewardPage() {
        waitForElementClickable(driver, UserSideBarUIs.REWARD_LINK);
        clickToElement(driver, UserSideBarUIs.REWARD_LINK);
        return PageGeneratorManagerNopCommerce.getUserRewardPage(driver);
    }

    public UserOrderPageObject openOrderPage() {
        waitForElementClickable(driver, UserSideBarUIs.ORDER_LINK);
        clickToElement(driver, UserSideBarUIs.ORDER_LINK);
        return PageGeneratorManagerNopCommerce.getUserOrderPage(driver);
    }

    public UserCustomerInfoPO openCustomerInfoPage() {
        waitForElementClickable(driver, UserSideBarUIs.CUSTOMER_INFO_LINK);
        clickToElement(driver, UserSideBarUIs.CUSTOMER_INFO_LINK);
        return PageGeneratorManagerNopCommerce.getUserCustomerInfoPage(driver);
    }

    public UserChangePasswordPO openChangePasswordPage() {
        waitForElementClickable(driver, UserSideBarUIs.CHANGE_PASSWORD_LINK);
        clickToElement(driver, UserSideBarUIs.CHANGE_PASSWORD_LINK);
        return PageGeneratorManagerNopCommerce.getUserChangePasswordPage(driver);
    }

    public UserMyProductReviewPO openMyProductReviewPage() {
        waitForElementClickable(driver, UserSideBarUIs.PRODUCT_REVIEW_LINK);
        clickToElement(driver, UserSideBarUIs.PRODUCT_REVIEW_LINK);
        return PageGeneratorManagerNopCommerce.getUserProductReviewPage(driver);
    }

    public UserSideBarPageObject openDynamicPage(String pageName){
        waitForElementVisible(driver,UserSideBarUIs.DYNAMIC_LINK_ALL_PAGE,pageName);
        clickToElement(driver, UserSideBarUIs.DYNAMIC_LINK_ALL_PAGE,pageName);
        switch(pageName){
            case "Customer info":
                return PageGeneratorManagerNopCommerce.getUserCustomerInfoPage(driver);

            case "Addresses":
                return PageGeneratorManagerNopCommerce.getUserAddressPage(driver);

            case "Orders":
                return PageGeneratorManagerNopCommerce.getUserOrderPage(driver);
            case "Reward points":
                return PageGeneratorManagerNopCommerce.getUserRewardPage(driver);

            case "Change password":
                return PageGeneratorManagerNopCommerce.getUserChangePasswordPage(driver);

            case "My product reviews":
                return  PageGeneratorManagerNopCommerce.getUserProductReviewPage(driver);

            default:
                throw new RuntimeException("The page is not supported!!!");
        }
    }
    public void openDynamicPages(String pageName){
        waitForElementVisible(driver,UserSideBarUIs.DYNAMIC_LINK_ALL_PAGE,pageName);
        clickToElement(driver, UserSideBarUIs.DYNAMIC_LINK_ALL_PAGE,pageName);

    }
}
