package pageObjects.nopCommerce.user;

import commons.BasePage;
import commons.PageGeneratorManagerNopCommerce;
import org.openqa.selenium.WebDriver;
import pageUIs.nopCommerce.user.HomePageUI;

public class UserHomePageObject extends BasePage {
    private WebDriver driver;
    public UserHomePageObject(WebDriver driver) {
        this.driver = driver;
    }


    public UserRegisterPageObject openRegisterPage(){
        waitForElementClickable(driver, HomePageUI.REGISTER_LINK);
        clickToElement(driver,HomePageUI.REGISTER_LINK);
        return PageGeneratorManagerNopCommerce.getUserRegisterPage(driver);
    }

//    public boolean isMyAccountLinkisDisplayed() {
//        waitForElementVisible(driver,HomePageUI.MY_ACCOUNT_LINK);
//        return isControlDisplayed(driver,HomePageUI.MY_ACCOUNT_LINK);
//
//    }

    public UserCustomerInfoPO openMyAccountPage() {
        waitForElementClickable(driver,HomePageUI.MY_ACCOUNT_LINK);
        clickToElement(driver,HomePageUI.MY_ACCOUNT_LINK);
        return PageGeneratorManagerNopCommerce.getUserCustomerInfoPage(driver);
    }
}

