package pageObjects.nopCommerce.user;

import commons.BasePage;
import commons.PageGeneratorManagerNopCommerce;
import org.openqa.selenium.WebDriver;
import pageUIs.nopCommerce.user.LoginPageUI;

public class UserLoginPageObject extends BasePage {

    private WebDriver driver;
    public UserLoginPageObject(WebDriver driver) {
        this.driver = driver;
    }


    public void enterToEmailTextbox(String emailAddress) {
        waitForElementVisible(driver, LoginPageUI.EMAIL_TEXTBOX);
        sendKeyToElement(driver,LoginPageUI.EMAIL_TEXTBOX,emailAddress);
    }

    public void enterToPasswordTextbox(String password) {
        waitForElementVisible(driver, LoginPageUI.PASSWORD_TEXTBOX);
        sendKeyToElement(driver,LoginPageUI.PASSWORD_TEXTBOX,password);
    }

    public void clickToLoginButton() {
        waitForElementClickable(driver,LoginPageUI.LOGIN_BUTTON);
        clickToElement(driver,LoginPageUI.LOGIN_BUTTON);
    }

    public UserHomePageObject loginToSystem(String emailAddress, String password ){
        enterToEmailTextbox(emailAddress);
        enterToPasswordTextbox(password);
        clickToLoginButton();
        return PageGeneratorManagerNopCommerce.getUserHomePage(driver);
    }
}
