package pageObjects;

import commons.BasePage;
import org.openqa.selenium.WebDriver;
import pageUIs.HomePageUI;

public class HomePageObject extends BasePage {
    private WebDriver driver;
    public HomePageObject(WebDriver driver) {
        this.driver = driver;
    }


    public void clickToRegisterLink(){
        waitForElementClickable(driver, HomePageUI.REGISTER_LINK);
        clickToElement(driver,HomePageUI.REGISTER_LINK);
    }

    public boolean isMyAccountLinkisDisplayed() {
        waitForElementVisible(driver,HomePageUI.MY_ACCOUNT_LINK);
        return isControlDisplayed(driver,HomePageUI.MY_ACCOUNT_LINK);

    }

    public void clickToMyAccountLink() {
        waitForElementClickable(driver,HomePageUI.MY_ACCOUNT_LINK);
        clickToElement(driver,HomePageUI.MY_ACCOUNT_LINK);
    }
}
