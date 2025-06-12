package pageObjects.nopCommerce.user;

import org.openqa.selenium.WebDriver;

public class UserRewardPageObject extends UserSideBarPageObject {
    private WebDriver driver;

    public UserRewardPageObject(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }
}
