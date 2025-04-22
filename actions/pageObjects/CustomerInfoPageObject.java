package pageObjects;

import commons.BasePage;
import org.openqa.selenium.WebDriver;
import pageUIs.CustomerInfoPageUI;

public class CustomerInfoPageObject extends BasePage {

    public CustomerInfoPageObject(WebDriver driver) {
        this.driver = driver;
    }

    WebDriver driver;
    public boolean isGenderMailSelected() {
        waitForElementSelected(driver, CustomerInfoPageUI.GENDER_MAIL_RADIO);
        return isControlSelected(driver, CustomerInfoPageUI.GENDER_MAIL_RADIO);
    }

    public String getFirstNameTextboxValue() {
        waitForElementVisible(driver,CustomerInfoPageUI.FIRST_NAME_TEXTBOX);
        return getAttributeValue(driver,CustomerInfoPageUI.FIRST_NAME_TEXTBOX, "value");
    }

    public String getLastNameTextboxValue() {
        waitForElementVisible(driver,CustomerInfoPageUI.LAST_NAME_TEXTBOX);
        return getAttributeValue(driver,CustomerInfoPageUI.LAST_NAME_TEXTBOX, "value");
    }

    public String getEmailTextboxValue() {
        waitForElementVisible(driver,CustomerInfoPageUI.EMAIL_TEXTBOX);
        return getAttributeValue(driver,CustomerInfoPageUI.EMAIL_TEXTBOX, "value");
    }

    public String getCompanyTextboxValue() {
        waitForElementVisible(driver,CustomerInfoPageUI.COMPANY_NAME_TEXTBOX);
        return getAttributeValue(driver,CustomerInfoPageUI.COMPANY_NAME_TEXTBOX, "value");
    }
}
