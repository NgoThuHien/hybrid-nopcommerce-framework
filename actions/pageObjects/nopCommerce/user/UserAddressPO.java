package pageObjects.nopCommerce.user;

import org.openqa.selenium.WebDriver;

public class UserAddressPO extends UserSideBarPageObject {
    private WebDriver driver;

    public UserAddressPO(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }

}
