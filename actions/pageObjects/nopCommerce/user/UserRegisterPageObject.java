package pageObjects.nopCommerce.user;

import commons.BasePage;
import commons.PageGeneratorManagerNopCommerce;
import org.openqa.selenium.WebDriver;
import pageUIs.nopCommerce.user.UserRegisterPageUI;

public class UserRegisterPageObject extends BasePage {
    private WebDriver driver;
    public UserRegisterPageObject(WebDriver driver) {
        this.driver = driver;
    }


    public void clickToMaleRadio(){
        waitForElementClickable(driver, UserRegisterPageUI.GENDER_MAIL_RADIO);
        checkTheCheckboxOrRadio(driver, UserRegisterPageUI.GENDER_MAIL_RADIO);
    }

    public void enterToFirstNameTextbox(String firstName) {
        waitForElementVisible(driver, UserRegisterPageUI.FIRST_NAME_TEXTBOX);
        sendKeyToElement(driver, UserRegisterPageUI.FIRST_NAME_TEXTBOX,firstName);
    }

    public void enterToLastNameTextbox(String lastName) {
        waitForElementVisible(driver, UserRegisterPageUI.LAST_NAME_TEXTBOX);
        sendKeyToElement(driver, UserRegisterPageUI.LAST_NAME_TEXTBOX,lastName);
    }

    public void enterToEmailTextbox(String emailAddress) {
        waitForElementVisible(driver, UserRegisterPageUI.EMAIL_TEXTBOX);
        sendKeyToElement(driver, UserRegisterPageUI.EMAIL_TEXTBOX,emailAddress);
    }

    public void enterToCompanyTextbox(String companyName) {
        waitForElementVisible(driver, UserRegisterPageUI.COMPANY_NAME_TEXTBOX);
        sendKeyToElement(driver, UserRegisterPageUI.COMPANY_NAME_TEXTBOX,companyName);
    }

    public void enterToPasswordTextbox(String password) {
        waitForElementVisible(driver, UserRegisterPageUI.PASSWORD_TEXTBOX);
        sendKeyToElement(driver, UserRegisterPageUI.PASSWORD_TEXTBOX,password);
    }

    public void enterToConfirmPasswordTextbox(String password) {
        waitForElementVisible(driver, UserRegisterPageUI.CONFIRM_PASSWORD_TEXTBOX);
        sendKeyToElement(driver, UserRegisterPageUI.CONFIRM_PASSWORD_TEXTBOX,password);
    }

    public void clickToRegisterButton() {
        waitForElementClickable(driver, UserRegisterPageUI.REGISTER_BUTTON);
        clickToElement(driver, UserRegisterPageUI.REGISTER_BUTTON);
    }

    public String getRegisterSuccessMessage() {
        waitForElementVisible(driver, UserRegisterPageUI.REGISTER_SUCCESS_MESSAGE);
        return getTextElement(driver, UserRegisterPageUI.REGISTER_SUCCESS_MESSAGE);
    }

    public UserLoginPageObject openLoginPage() {
        waitForElementClickable(driver, UserRegisterPageUI.LOGIN_LINK);
        clickToElement(driver, UserRegisterPageUI.LOGIN_LINK);
        return PageGeneratorManagerNopCommerce.getUserLoginPage(driver);
    }
}
