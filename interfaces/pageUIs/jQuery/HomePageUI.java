package pageUIs.jQuery;

public class HomePageUI {
    public static final String DYNAMIC_PAGING = "xpath=//li[@class='qgrd-pagination-page']/a[text()='%s']";
    public static final String DYNAMIC_HEADER_TEXT_BOX = "xpath=//div[text()='%s']/parent::div/following-sibling::input";
    public static final String SELECTED_ROW = "xpath=//td[@data-key='females' and text()='%s']/following-sibling::td[@data-key='country' and text()='%s']/following-sibling::td[@data-key='males' and text()='%s']/following-sibling::td[@data-key='total' and text()='%s']";
    public static final String DYNAMIC_DELETE_BUTTON_BY_COUNTRY_HEADER = "xpath=//td[@data-key='country' and text()='%s']/preceding-sibling::td[@class]/button[contains(@class,'remove')]";
    public static final String DYNAMIC_EDIT_BUTTON_BY_COUNTRY_HEADER = "xpath=//td[@data-key='country' and text()='%s']/preceding-sibling::td[@class]/button[contains(@class,'edit')]";

    public static final String DYNAMIC_PRECEDING_SIBLING_COLUMNS = "xpath=//th[text()='%s']/preceding-sibling::th";
    public static final String DYNAMIC_CELL_BY_INDEX = "xpath=//tr[%s]/td[%s]//input";

    public static final String LOAD_BUTTON = "xpath=//button[@id='load']";
    public static final String DYNAMIC_COUNTRY = "xpath=//tr[%s]/td//select";
    public static final String DYNAMIC_ACTION = "xpath=//tr[%s]//button[@title='%s']";
    public static final String DYNAMIC_PRECEDING_SIBLING_COLUMNS_DEMO = "xpath=//div[text()='%s']/ancestor::th/preceding-sibling::th";
    public static final String DYNAMIC_COLUMN = "xpath=//tr/td[%s]";

    //moi column nen co rieng 1 locator theo nhu thay Dam day. Khong ne ghep tat ca cac locator cua cac column lai voi nhau

}
