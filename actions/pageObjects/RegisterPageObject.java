package pageObjects;

import commons.BasePage;
import org.openqa.selenium.WebDriver;
import pageUIs.RegisterPageUI;

public class RegisterPageObject extends BasePage {
    private WebDriver driver;
    public RegisterPageObject(WebDriver driver) {
        this.driver = driver;
    }


    public void clickToMaleRadio(){
        waitForElementClickable(driver, RegisterPageUI.GENDER_MAIL_RADIO);
        checkTheCheckboxOrRadio(driver,RegisterPageUI.GENDER_MAIL_RADIO);
    }

    public void enterToFirstNameTextbox(String firstName) {
        waitForElementVisible(driver,RegisterPageUI.FIRST_NAME_TEXTBOX);
        sendKeyToElement(driver,RegisterPageUI.FIRST_NAME_TEXTBOX,firstName);
    }

    public void enterToLastNameTextbox(String lastName) {
        waitForElementVisible(driver,RegisterPageUI.LAST_NAME_TEXTBOX);
        sendKeyToElement(driver,RegisterPageUI.LAST_NAME_TEXTBOX,lastName);
    }

    public void enterToEmailTextbox(String emailAddress) {
        waitForElementVisible(driver,RegisterPageUI.EMAIL_TEXTBOX);
        sendKeyToElement(driver,RegisterPageUI.EMAIL_TEXTBOX,emailAddress);
    }

    public void enterToCompanyTextbox(String companyName) {
        waitForElementVisible(driver,RegisterPageUI.COMPANY_NAME_TEXTBOX);
        sendKeyToElement(driver,RegisterPageUI.COMPANY_NAME_TEXTBOX,companyName);
    }

    public void enterToPasswordTextbox(String password) {
        waitForElementVisible(driver,RegisterPageUI.PASSWORD_TEXTBOX);
        sendKeyToElement(driver,RegisterPageUI.PASSWORD_TEXTBOX,password);
    }

    public void enterToConfirmPasswordTextbox(String password) {
        waitForElementVisible(driver,RegisterPageUI.CONFIRM_PASSWORD_TEXTBOX);
        sendKeyToElement(driver,RegisterPageUI.CONFIRM_PASSWORD_TEXTBOX,password);
    }

    public void clickToRegisterButton() {
        waitForElementClickable(driver,RegisterPageUI.REGISTER_BUTTON);
        clickToElement(driver,RegisterPageUI.REGISTER_BUTTON);
    }

    public String getRegisterSuccessMessage() {
        waitForElementVisible(driver,RegisterPageUI.REGISTER_SUCCESS_MESSAGE);
        return getTextElement(driver,RegisterPageUI.REGISTER_SUCCESS_MESSAGE);
    }

    public void clickToLoginLink() {
        waitForElementClickable(driver,RegisterPageUI.LOGIN_LINK);
        clickToElement(driver,RegisterPageUI.LOGIN_LINK);
    }
}
