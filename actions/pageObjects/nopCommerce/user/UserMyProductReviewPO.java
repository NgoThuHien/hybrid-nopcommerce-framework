package pageObjects.nopCommerce.user;

import org.openqa.selenium.WebDriver;

public class UserMyProductReviewPO extends UserSideBarPageObject {
    private WebDriver driver;

    public UserMyProductReviewPO(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }

}
