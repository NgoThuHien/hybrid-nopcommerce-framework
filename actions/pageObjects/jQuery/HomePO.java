package pageObjects.jQuery;

import commons.BasePage;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import pageUIs.jQuery.HomePageUI;
import pageUIs.nopCommerce.user.BasePageUIs;

import java.util.ArrayList;
import java.util.List;

public class HomePO extends BasePage {
   private WebDriver driver;

    public HomePO(WebDriver driver) {
        this.driver = driver;
    }

    public void openPageByNumber(String numberPage) {
       waitForElementClickable(driver, HomePageUI.DYNAMIC_PAGING,numberPage);
       clickToElement(driver,HomePageUI.DYNAMIC_PAGING,numberPage);
    }

    public boolean isPageNumberActive(String number) {
        waitForElementVisible(driver,HomePageUI.DYNAMIC_PAGING,number);
        return getAttributeValue(driver,HomePageUI.DYNAMIC_PAGING,"class",number).
                endsWith("active");

    }

    public void filterByHeaderName(String value, String header) {
        waitForElementVisible(driver,HomePageUI.DYNAMIC_HEADER_TEXT_BOX,header);
        sendKeyToElement(driver,HomePageUI.DYNAMIC_HEADER_TEXT_BOX,value,header);
        sendKeyboardToElement(driver,HomePageUI.DYNAMIC_HEADER_TEXT_BOX, Keys.ENTER,header);
    }

    public boolean isSelectedRowDisplayed(String femaleValue, String countryValue, String maleValue, String totalValue) {
        waitForElementVisible(driver,HomePageUI.SELECTED_ROW,femaleValue,countryValue,maleValue,totalValue);
        return true;
    }

    public void deleteRowByCountry(String countryValue) {
        waitForElementClickable(driver,HomePageUI.DYNAMIC_DELETE_BUTTON_BY_COUNTRY_HEADER,countryValue);
        clickToElement(driver,HomePageUI.DYNAMIC_DELETE_BUTTON_BY_COUNTRY_HEADER,countryValue);
    }

    public void editRowByCountry(String countryValue) {
        waitForElementClickable(driver,HomePageUI.DYNAMIC_EDIT_BUTTON_BY_COUNTRY_HEADER,countryValue);
        clickToElement(driver,HomePageUI.DYNAMIC_EDIT_BUTTON_BY_COUNTRY_HEADER,countryValue);
    }

    public void enterToTextboxByIndex(String headerColumn,String rowNumber, String textSend) {
        int numberColumnInt = getListElement(driver,HomePageUI.DYNAMIC_PRECEDING_SIBLING_COLUMNS,headerColumn).size() + 1;
        String numberColumn = String.valueOf(numberColumnInt);
        sendKeyToElement(driver,HomePageUI.DYNAMIC_CELL_BY_INDEX,textSend,rowNumber,numberColumn);

    }

    public void clickToLoadButton() {
        waitForElementClickable(driver,HomePageUI.LOAD_BUTTON);
        clickToElement(driver,HomePageUI.LOAD_BUTTON);
    }


    public void selectFromDropdownByIndex(String rowNumber, String option){
        selectItemInDropdown(driver,HomePageUI.DYNAMIC_COUNTRY,option,rowNumber);
    }

    public void selectCheckboxByInder(String rowNumber, String column,boolean checkOrUncheck) {
        int columnIndexIn = getListElement(driver,HomePageUI.DYNAMIC_PRECEDING_SIBLING_COLUMNS,column).size() + 1;
        String columnIndex = String.valueOf(columnIndexIn);
        if(checkOrUncheck){
            checkTheCheckboxOrRadio(driver,HomePageUI.DYNAMIC_CELL_BY_INDEX,rowNumber,columnIndex);
        } else{uncheckTheCheckbox(driver,HomePageUI.DYNAMIC_CELL_BY_INDEX,rowNumber,columnIndex);}

    }

    public void enterToNumberboxByInder(String column, String rowNumber, String number1) {
        int columnIndexIn = getListElement(driver,HomePageUI.DYNAMIC_PRECEDING_SIBLING_COLUMNS,column).size() + 1;
        String columnIndex = String.valueOf(columnIndexIn);
        sendKeyToElement(driver,HomePageUI.DYNAMIC_CELL_BY_INDEX,number1,rowNumber,columnIndex);
    }

    public void selectIcon(String rowNumber, String actionItem) {
        waitForElementClickable(driver,HomePageUI.DYNAMIC_ACTION,rowNumber,actionItem);
        clickToElement(driver,HomePageUI.DYNAMIC_ACTION,rowNumber,actionItem);
    }

    public List<String> getAllValueOfColumn(String column) {
        int inColumnIndex = getListElement(driver, HomePageUI.DYNAMIC_PRECEDING_SIBLING_COLUMNS_DEMO, column).size() + 1;
        String columnIndex = String.valueOf(inColumnIndex);

        List<WebElement> allElementValueColumn = getListElement(driver, HomePageUI.DYNAMIC_COLUMN, columnIndex);
        List<String> allValueColum = new ArrayList<String>();
        for (WebElement element : allElementValueColumn) {
            allValueColum.add(element.getText());
            System.out.println(allValueColum);
        }

        return allValueColum;
    }

    public boolean isFileLoadedByname(String fileName) {
        waitForElementVisible(driver, BasePageUIs.FILE_LOADED_BY_FILE_NAME,fileName);
        return isElementDisplayed(driver, BasePageUIs.FILE_LOADED_BY_FILE_NAME,fileName);
    }

    public void clickToUploadButton(WebDriver driver) {
        List<WebElement> loadButtons = getListElement(driver, BasePageUIs.UPLOAD_BUTTON);
        for(WebElement button: loadButtons){
            button.click();
            sleepInSecond(2);
        }
    }

    public boolean isFileLoadedSuccessByname(String fileName) {
        waitForElementVisible(driver,BasePageUIs.FILE_UPLOADED_SUCCESS_BY_FILE_NAME,fileName);
        return isElementDisplayed(driver,BasePageUIs.FILE_UPLOADED_SUCCESS_BY_FILE_NAME,fileName);
    }
}
