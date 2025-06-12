package pageObjects.nopCommerce.admin;

import commons.BasePage;
import commons.PageGeneratorManagerNopCommerce;
import org.openqa.selenium.WebDriver;
import pageUIs.nopCommerce.admin.AdminLoginPageUIs;

public class AdminLoginPagePO extends BasePage {
    private WebDriver driver;

    public AdminLoginPagePO(WebDriver driver) {
        this.driver = driver;
    }
    public void enterToEmailTextbox(String adminEmailValue){
        waitForElementVisible(driver,AdminLoginPageUIs.ADMIN_EMAIL_TEXTBOX);
        sendKeyToElement(driver,AdminLoginPageUIs.ADMIN_EMAIL_TEXTBOX,adminEmailValue);
    }
    public void enterToPasswordTextbox(String adminPassword){
        waitForElementVisible(driver, AdminLoginPageUIs.ADMIN_PASSWORD_TEXTBOX);
        sendKeyToElement(driver,AdminLoginPageUIs.ADMIN_PASSWORD_TEXTBOX,adminPassword);
    }

    public void clickToLoginButton(){
        waitForElementClickable(driver,AdminLoginPageUIs.ADMIN_LOGIN_BUTTON);
        clickToElement(driver,AdminLoginPageUIs.ADMIN_LOGIN_BUTTON);
    }
    public AdminDashboardPagePO openAdminDashboardSite(String adminEmailValue, String adminPassword) {
        enterToEmailTextbox(adminEmailValue);
        enterToPasswordTextbox(adminPassword);
        clickToLoginButton();
        return PageGeneratorManagerNopCommerce.getAdminDashboardPage(driver);
    }
}
