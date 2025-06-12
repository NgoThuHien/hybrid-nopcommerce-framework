package commons;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.Color;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import pageObjects.nopCommerce.user.*;

import pageUIs.nopCommerce.user.BasePageUIs;
import pageUIs.nopCommerce.user.HomePageUI;
import pageUIs.nopCommerce.user.UserSideBarUIs;

import java.time.Duration;
import java.util.List;
import java.util.Set;


public class BasePage {
    protected WebElement getElement(WebDriver driver, String locator){
        return driver.findElement(getByLocator(locator));
    }
    private String castParameter(String locator, String... restParameter){
       return String.format(locator, (Object[]) restParameter);
    }
    private By getByLocator(String prefixLocator){
        By by = null;
        if(prefixLocator.toLowerCase().startsWith("xpath")){
            by = By.xpath(prefixLocator.substring(6));
        } else if (prefixLocator.toLowerCase().startsWith("id")){
            by = By.id(prefixLocator.substring(3));
        } else if(prefixLocator.toLowerCase().startsWith("css")){
            by = By.cssSelector(prefixLocator.substring(4));
        }
        else if(prefixLocator.toLowerCase().startsWith("name")){
            by = By.name(prefixLocator.substring(5));
        }
        else if(prefixLocator.toLowerCase().startsWith("tagname")){
            by = By.tagName(prefixLocator.substring(8));
        }
        else if(prefixLocator.toLowerCase().startsWith("class")){
            by = By.className(prefixLocator.substring(6));
        } else {
            throw new RuntimeException("Locator type is not supported.");
        }
        return by;
    }

    protected List<WebElement> getListElement(WebDriver driver, String locator){
        return driver.findElements(getByLocator(locator));
    }
    protected List<WebElement> getListElement(WebDriver driver, String locator, String...restParameter){
        return driver.findElements(getByLocator(castParameter(locator,restParameter)));
    }

    private By getXpathLocator(String locator){
        return By.xpath(locator);
    }
    public void openPageUrl(WebDriver driver,String url) {
        driver.get(url);
    }

    public String getPageTitle(WebDriver driver) {
        return driver.getTitle();
    }

    public String getCurrentUrl(WebDriver driver) {
        return driver.getCurrentUrl();
    }

    public String getCurrentPageSource(WebDriver driver) {
        return driver.getPageSource();
    }
    public void backToPage(WebDriver driver) {
         driver.navigate().back();
    }
    public void forwardToPage(WebDriver driver) {
         driver.navigate().forward();
    }
    public void refreshCurrentPage(WebDriver driver) {
         driver.navigate().refresh();
    }
    public Alert waitAlertPresence(WebDriver driver ) {
       return new WebDriverWait(driver,Duration.ofSeconds(GlobalConstants.LONG_TIMEOUT)).
               until(ExpectedConditions.alertIsPresent());
    }
    public void acceptAlert(WebDriver driver) {
        waitAlertPresence(driver).accept();
    }
    public void cancelAlert(WebDriver driver) {
       waitAlertPresence(driver).dismiss();
    }
    public String getTextAlert(WebDriver driver) {
        return waitAlertPresence(driver).getText();
    }
    public void sendKeyToAlert(WebDriver driver,String message) {
        waitAlertPresence(driver).sendKeys(message);
    }

    public String  getWindowHandle(WebDriver driver){
       return driver.getWindowHandle();
    }

    public void switchToWindowByTitle(WebDriver driver, String title){
        Set<String> windowIds = driver.getWindowHandles();
        for(String windowId: windowIds){
            driver.switchTo().window(windowId);
            String currentTitle = driver.getTitle();
            if(currentTitle.equals(title)){
                break;
            }

        }

    }

    public void switchToWindowByID(WebDriver driver, String parentId){
        Set<String> allWinIds = driver.getWindowHandles();
        for(String windowId: allWinIds){
            if(!windowId.equals(parentId)){
                driver.switchTo().window(windowId);
                break;
            }
        }
    }

    public void closeAllWindowWithoutParent(WebDriver driver,String parentId){
        Set<String> allWindowIds = driver.getWindowHandles();
        for(String windowId: allWindowIds){
            if(!windowId.equals(parentId)){
                driver.switchTo().window(windowId).close();
            }
        }
        driver.switchTo().window(parentId);
    }
    public void clickToElement(WebDriver driver, String locator){
        getElement(driver,locator).click();
    }
    public void clickToElement(WebDriver driver, String locator, String... restParameter){
        getElement(driver,castParameter(locator, restParameter)).click();
    }

    public void sendKeyToElement(WebDriver driver, String locator, String keyToSend){
        getElement(driver,locator).clear();
        getElement(driver,locator).sendKeys(keyToSend);
    }
    public void sendKeyToElement(WebDriver driver, String locator,String keyToSend, String... restParameter){
        getElement(driver,castParameter(locator, restParameter)).clear();
        getElement(driver,castParameter(locator, restParameter)).sendKeys(keyToSend);
    }
    public void selectItemInDropdown(WebDriver driver, String locator, String item){
        new Select(getElement(driver,locator)).selectByVisibleText(item);
    }
    public void selectItemInDropdown(WebDriver driver, String locator, String item, String... restParameter){
        new Select(getElement(driver,castParameter(locator, restParameter))).selectByVisibleText(item);
    }
    public String getSelectedItemInDropdown(WebDriver driver, String locator){
        return new Select(getElement(driver,locator)).getFirstSelectedOption().getText();
    }
    public String getSelectedItemInDropdown(WebDriver driver, String locator, String restParameter){
        return new Select(getElement(driver,castParameter(locator, restParameter))).getFirstSelectedOption().getText();
    }
    public boolean dropdownIsMultiple(WebDriver driver, String locator){
        return new Select(getElement(driver,locator)).isMultiple();
    }

    public void selectItemInCustomDropdown(WebDriver driver, String parentLocator, String childItemLocator, String expectedItem) {
        getElement(driver,parentLocator).click();
        sleepInSecond(2);

        List<WebElement> allItems = new WebDriverWait(driver, Duration.ofSeconds(GlobalConstants.LONG_TIMEOUT))
                .until(ExpectedConditions.presenceOfAllElementsLocatedBy((getByLocator(childItemLocator))));
        sleepInSecond(2);
        for (WebElement item : allItems) {
            if (item.getText().trim().equals(expectedItem)) {
                item.click();
                break;
            }
        }
    }

    public String getAttributeValue(WebDriver driver, String locator, String attribute){
        return getElement(driver,locator).getDomAttribute(attribute);

    }
    public String getAttributeValue(WebDriver driver, String locator, String attribute,String restParameter){
        return getElement(driver,castParameter(locator,restParameter)).getDomAttribute(attribute);

    }
    public String getTextElement(WebDriver driver, String locator){
        return getElement(driver,locator).getText();
    }
    public String getTextElement(WebDriver driver, String locator, String restParameter){
        return getElement(driver,castParameter(locator,restParameter)).getText();
    }
    public String getTextCssValue(WebDriver driver, String locator, String cssProperty){
        return getElement(driver,locator).getCssValue(cssProperty);
    }
    public String getTextCssValue(WebDriver driver, String locator, String cssProperty,String restParameter){
        return getElement(driver,castParameter(locator,restParameter)).getCssValue(cssProperty);
    }
    public String getHexColorFromRGBA(WebDriver driver, String locator, String cssProperty){
        return Color.fromString(getTextCssValue(driver,locator,cssProperty)).asHex().toUpperCase();
        //sử dụng hàm này khi mà hàm getTextCssValue trả giá trị là rgba
    }




    public int getElementsSize(WebDriver driver, String locator){
        return getListElement(driver,locator).size();

    }
    public int getElementsSize(WebDriver driver, String locator,String restParameter){
        return getListElement(driver,castParameter(locator,restParameter)).size();

    }
    public void checkTheCheckboxOrRadio(WebDriver driver, String locator){
       if(!getElement(driver,locator).isSelected()){
           getElement(driver,locator).click();
       }

    }
    public void checkTheCheckboxOrRadio(WebDriver driver, String locator,String... restParameter){
       if(!getElement(driver,castParameter(locator,restParameter)).isSelected()){
           getElement(driver,castParameter(locator,restParameter)).click();
       }

    }
    public void uncheckTheCheckbox(WebDriver driver, String locator){
       if(getElement(driver,locator).isSelected()){
           getElement(driver,locator).click();
       }

    }
    public void uncheckTheCheckbox(WebDriver driver, String locator, String ... restParameter){
       if(getElement(driver,castParameter(locator, restParameter)).isSelected()){
           getElement(driver,castParameter(locator, restParameter)).click();
       }

    }
    public boolean isControlDisplayed(WebDriver driver, String locator,String restParameter) {
        try {
            return getElement(driver, castParameter(locator,restParameter)).isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }
    public boolean isControlSelected(WebDriver driver, String locator) {
        try {
            return getElement(driver, locator).isSelected();
        } catch (Exception e) {
            return false;
        }
    }
    public boolean isControlEnabled(WebDriver driver, String locator) {
        try {
            return getElement(driver, locator).isEnabled();
        } catch (Exception e) {
            return false;
        }
    }
    public void switchToFrame(WebDriver driver, String locator){
        driver.switchTo().frame(getElement(driver,locator));
    }

    public void switchToDefaultPage(WebDriver driver){
        driver.switchTo().defaultContent();
    }

    public void doubleClickToElement(WebDriver driver, String locator){
         new Actions(driver).doubleClick(getElement(driver,locator)).perform();
    }
    public void clickByActions(WebDriver driver, String locator){
         new Actions(driver).click(getElement(driver,locator)).perform();
    }
    public void clickAndHoldByActions(WebDriver driver, String locator){
         new Actions(driver).clickAndHold(getElement(driver,locator)).perform();
    }
    public void releaseLeftMouseByActions(WebDriver driver){
         new Actions(driver).release();
    }

    public void hoverMouseToElement(WebDriver driver, String locator){
        new Actions(driver).moveToElement(getElement(driver,locator)).perform();
    }
    public void rightClick(WebDriver driver, String locator){
        new Actions(driver).contextClick(getElement(driver,locator)).perform();
    }

    public void dragAndDrop(WebDriver driver,String SourceLocator, String TargetLocator ){
        new Actions(driver).dragAndDrop(getElement(driver,SourceLocator), getElement(driver,TargetLocator)).perform();
    }

    public void scrollToElementAction(WebDriver driver, String locator){
        new Actions(driver).scrollToElement(getElement(driver,locator)).perform();
    }

    public void sendKeyboardToElement(WebDriver driver,String locator,Keys key){
         new Actions(driver).sendKeys(getElement(driver,locator),key).perform();
    }
    public void sendKeyboardToElement(WebDriver driver,String locator,Keys key, String ... restParameter){
         new Actions(driver).sendKeys(getElement(driver,castParameter(locator,restParameter)),key).perform();
    }

    public String getInnerTextByJs(WebDriver driver) {
        return (String) ((JavascriptExecutor) driver).
                executeScript("return document.documentElement.innerText;");
    }

    public boolean isExpectedTextInInnerTextByJs(WebDriver driver,String textExpected) {
        String textActual = (String) ((JavascriptExecutor) driver).executeScript(
                "return document.documentElement.innerText.match('" + textExpected + "')[0];");
        return textActual.equals(textExpected);
    }

    public void navigateToUrlByJS(WebDriver driver,String url) {
        ((JavascriptExecutor) driver ).executeScript("window.location = '" + url + "'");
        sleepInSecond(3);
    }

    public  String getDomainByJs(WebDriver driver) {
        return (String)  ((JavascriptExecutor) driver).executeScript("return document.domain");
    }

    public  String getPageUrlByJs(WebDriver driver) {
        return (String) ((JavascriptExecutor) driver).executeScript("return document.URL");

    }

    public void highlightElementByJs(WebDriver driver,String locator) {
        WebElement element = getElement(driver,locator);
        String originalStyle = element.getDomAttribute("style");
        ((JavascriptExecutor) driver).executeScript(
                "arguments[0].setAttribute('style', arguments[1])",
                element, "border: 2px solid red; border-style: dashed;");
        sleepInSecond(2);
        ((JavascriptExecutor) driver).executeScript(
                "arguments[0].setAttribute('style', arguments[1])", element, originalStyle);
    }

    public void clickToElementByJS(WebDriver driver,String locator) {
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", getElement(driver,locator));
        sleepInSecond(3);
    }

    public String getElementTextByJS(WebDriver driver, String locator) {
        return (String) ((JavascriptExecutor) driver).
                executeScript("return arguments[0].textContent;", getElement(driver,locator));
    }

    public void scrollToElementOnTopByJs(WebDriver driver, String locator) {
        ((JavascriptExecutor) driver).
                executeScript("arguments[0].scrollIntoView(true);", getElement(driver,locator));
    }

    public void scrollToElementOnDownByJs(WebDriver driver,String locator) {
        ((JavascriptExecutor) driver).
                executeScript("arguments[0].scrollIntoView(false);", getElement(driver,locator));
    }

    public void setAttributeInDOMByJs(WebDriver driver,String locator, String attributeName, String attributeValue) {
        ((JavascriptExecutor) driver).executeScript(
                "arguments[0].setAttribute('" + attributeName + "', '" + attributeValue +"');", getElement(driver,locator));
    }

    public void removeAttributeInDOM(WebDriver driver,String locator, String attributeRemove) {
        ((JavascriptExecutor) driver).executeScript
                ("arguments[0].removeAttribute('" + attributeRemove + "');", getElement(driver,locator));
    }

    public void sendKeyToElementByJS(WebDriver driver,String locator, String value) {
        ((JavascriptExecutor) driver).executeScript
                ("arguments[0].setAttribute('value', '" + value + "')", getElement(driver,locator));
    }

    public String getAttributeInDOMByJs(WebDriver driver,String locator, String attributeName) {
        return (String) ((JavascriptExecutor) driver).executeScript
                ("return arguments[0].getAttribute('" + attributeName + "');", getElement(driver,locator));
    }

    public String getElementValidationMessageByJs(WebDriver driver,String locator) {
        return (String) ((JavascriptExecutor) driver).executeScript
                ("return arguments[0].validationMessage;", getElement(driver,locator));
    }

    public boolean isImageLoadedByJs(WebDriver driver,String locator) {
       return (boolean) ((JavascriptExecutor) driver).executeScript(
                "return arguments[0].complete && typeof arguments[0].naturalWidth != 'undefined' && arguments[0].naturalWidth > 0",
               getElement(driver,locator));

    }



    public void waitForElementVisible(WebDriver driver,String locator){
        new WebDriverWait(driver,Duration.ofSeconds(GlobalConstants.LONG_TIMEOUT)).
                until(ExpectedConditions.visibilityOfElementLocated(getXpathLocator(locator)));
    }
    public void waitForElementVisible(WebDriver driver,String locator, String... restParameter){
        new WebDriverWait(driver,Duration.ofSeconds(GlobalConstants.LONG_TIMEOUT)).
                until(ExpectedConditions.visibilityOfElementLocated(getByLocator(
                        (castParameter(locator,restParameter)))));
    }

    public void waitForListElementVisible(WebDriver driver,String locator){
        new WebDriverWait(driver,Duration.ofSeconds(GlobalConstants.LONG_TIMEOUT)).
                until(ExpectedConditions.visibilityOfAllElements(getListElement(driver,locator)));
    }
    public void waitForListElementVisible(WebDriver driver,String locator, String restParameter){
        new WebDriverWait(driver,Duration.ofSeconds(GlobalConstants.LONG_TIMEOUT)).
                until(ExpectedConditions.visibilityOfAllElements
                        (getListElement(driver,castParameter(locator,restParameter))));
    }

    public void waitForElementSelected(WebDriver driver,String locator){
        new WebDriverWait(driver,Duration.ofSeconds(GlobalConstants.LONG_TIMEOUT)).
                until(ExpectedConditions.elementToBeSelected(getXpathLocator(locator)));
    }
    public void waitForElementSelected(WebDriver driver,String locator, String restParameter){
        new WebDriverWait(driver,Duration.ofSeconds(GlobalConstants.LONG_TIMEOUT)).
                until(ExpectedConditions.elementToBeSelected
                        (getXpathLocator(castParameter(locator,restParameter))));
    }

    public void waitForElementClickable(WebDriver driver,String locator){
        new WebDriverWait(driver,Duration.ofSeconds(GlobalConstants.LONG_TIMEOUT)).
                until(ExpectedConditions.elementToBeClickable(getByLocator(locator)));
    }
    public void waitForElementClickable(WebDriver driver,String locator, String...restParameter){
        new WebDriverWait(driver,Duration.ofSeconds(GlobalConstants.LONG_TIMEOUT)).
                until(ExpectedConditions.elementToBeClickable
                        (getByLocator(castParameter(locator,restParameter))));
    }
    public void waitForElementInvisible(WebDriver driver,String locator){
        new WebDriverWait(driver,Duration.ofSeconds(GlobalConstants.LONG_TIMEOUT)).
                until(ExpectedConditions.invisibilityOfElementLocated(getXpathLocator(locator)));
    }
    public void waitForElementInvisible(WebDriver driver,String locator,String restParameter){
        new WebDriverWait(driver,Duration.ofSeconds(GlobalConstants.LONG_TIMEOUT)).
                until(ExpectedConditions.invisibilityOfElementLocated
                        (getXpathLocator(castParameter(locator,restParameter))));
    }
    public void waitForListElementInvisible(WebDriver driver,String locator){
        new WebDriverWait(driver,Duration.ofSeconds(GlobalConstants.LONG_TIMEOUT)).
                until(ExpectedConditions.invisibilityOfAllElements(getListElement(driver,locator)));
    }
    public void waitForListElementInvisible(WebDriver driver,String locator,String restParameter){
        new WebDriverWait(driver,Duration.ofSeconds(GlobalConstants.LONG_TIMEOUT)).
                until(ExpectedConditions.invisibilityOfAllElements
                        (getListElement(driver,castParameter(locator,restParameter))));
    }

    public void waitForElementPresence(WebDriver driver,String locator){
        new WebDriverWait(driver,Duration.ofSeconds(GlobalConstants.LONG_TIMEOUT)).
                until(ExpectedConditions.presenceOfElementLocated(getXpathLocator(locator)));
    }
    public void waitForListElementPresence(WebDriver driver,String locator){
        new WebDriverWait(driver,Duration.ofSeconds(GlobalConstants.LONG_TIMEOUT)).
                until(ExpectedConditions.presenceOfAllElementsLocatedBy(getXpathLocator(locator)));
    }
    public void waitForListElementPresence(WebDriver driver,String locator,String restParameter){
        new WebDriverWait(driver,Duration.ofSeconds(GlobalConstants.LONG_TIMEOUT)).
                until(ExpectedConditions.presenceOfAllElementsLocatedBy
                        (getXpathLocator(castParameter(locator,restParameter))));
    }







    public void sleepInSecond(long timeInSecond){
        try {
            Thread.sleep(timeInSecond * 1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }


    public UserAddressPO openAddressPage(WebDriver driver) {
        waitForElementClickable(driver, UserSideBarUIs.ADDRESS_LINK);
        clickToElement(driver, UserSideBarUIs.ADDRESS_LINK);
        return PageGeneratorManagerNopCommerce.getUserAddressPage(driver);
    }

    public UserRewardPageObject openRewardPage(WebDriver driver) {
        waitForElementClickable(driver, UserSideBarUIs.REWARD_LINK);
        clickToElement(driver, UserSideBarUIs.REWARD_LINK);
        return PageGeneratorManagerNopCommerce.getUserRewardPage(driver);
    }

    public UserOrderPageObject openOrderPage(WebDriver driver) {
        waitForElementClickable(driver, UserSideBarUIs.ORDER_LINK);
        clickToElement(driver, UserSideBarUIs.ORDER_LINK);
        return PageGeneratorManagerNopCommerce.getUserOrderPage(driver);
    }

    public UserCustomerInfoPO openCustomerInfoPage(WebDriver driver) {
        waitForElementClickable(driver, UserSideBarUIs.CUSTOMER_INFO_LINK);
        clickToElement(driver, UserSideBarUIs.CUSTOMER_INFO_LINK);
        return PageGeneratorManagerNopCommerce.getUserCustomerInfoPage(driver);
    }

    public UserChangePasswordPO openChangePasswordPage(WebDriver driver) {
        waitForElementClickable(driver, UserSideBarUIs.CHANGE_PASSWORD_LINK);
        clickToElement(driver, UserSideBarUIs.CHANGE_PASSWORD_LINK);
        return PageGeneratorManagerNopCommerce.getUserChangePasswordPage(driver);
    }

    public UserMyProductReviewPO openMyProductReviewPage(WebDriver driver) {
        waitForElementClickable(driver, UserSideBarUIs.PRODUCT_REVIEW_LINK);
        clickToElement(driver, UserSideBarUIs.PRODUCT_REVIEW_LINK);
        return PageGeneratorManagerNopCommerce.getUserProductReviewPage(driver);
    }

    public void uploadMultipleFiles(WebDriver driver, String ...fileNames){
        String filePath = GlobalConstants.UPLOAD_PATH;
        String fullFileName = "";
        for(String file: fileNames){
            fullFileName = fullFileName + filePath + file + "\n";
        }
        fullFileName = fullFileName.trim();
        getElement(driver, BasePageUIs.UPLOAD_FILE_TYPE).sendKeys(fullFileName);
    }



}


