package pageObjects.nopCommerce.admin;

import commons.BasePage;
import org.openqa.selenium.WebDriver;

public class AdminDashboardPagePO extends BasePage {
    private WebDriver driver;

    public AdminDashboardPagePO(WebDriver driver) {
        this.driver = driver;
    }
}
