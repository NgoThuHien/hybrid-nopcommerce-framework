package pageUIs.nopCommerce.user;

public class BasePageUIs {
    public static final String UPLOAD_FILE_TYPE = "XPATH=//input[@type='file']";
    public static final String FILE_LOADED_BY_FILE_NAME = "XPATH=//p[@class='name' and text()='%s']";
    public static final String UPLOAD_BUTTON = "XPATH=//td/button[@class='btn btn-primary start']";
    public static final String FILE_UPLOADED_SUCCESS_BY_FILE_NAME = "XPATH=//a[text()='%s']";

    public static final String RADIO_BY_ID = "xpath='//input[@id='%s']'";
    public static final String TEXTBOX_BY_ID = "xpath='//input[@id='%s']'";
    public static final String BUTTON_BY_TEXT = "xpath='//button[text()='%s']'";
}
