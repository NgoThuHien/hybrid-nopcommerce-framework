package pageObjects.nopCommerce.user;

import org.openqa.selenium.WebDriver;

public class UserChangePasswordPO extends UserSideBarPageObject {
    private WebDriver driver;

    public UserChangePasswordPO(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }

}
