package pageObjects.jQuery;

import org.openqa.selenium.WebDriver;

public class PageGenerator {
    public static HomePO getHomePage(WebDriver driver){
        return new HomePO(driver);
    }
}
