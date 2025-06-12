package commons;

import org.bouncycastle.pqc.crypto.util.PQCOtherInfoGenerator;

public class GlobalConstants {
//System infor
    public static final String PROJECT_PATH = System.getProperty("user.dir");
    public static final String OS_NAME = System.getProperty("os.name");
    public static final String SEPARATOR = System.getProperty("file.separator");

    //App infor User
    public static final String DEV_USER_URL="https://demo.nopcommerce.com/login";
    public static final String STAGING_USER_URL="";
    public static final String PROD_USER_URL="";

    //App infor Admin
    public static final String DEV_ADMIN_URL="https://admin-demo.nopcommerce.com/login";
    public static final String STAGING_ADMIN_URL="";
    public static final String PROD_ADMIN_URL= "";
    public static final String ADMIN_USER_NAME= "";
    public static final String ADMIN_USER_PASSWORD="";

    //Wait info
    public static final long SHORT_TIMEOUT= 10;
    public static final long LONG_TIMEOUT= 30;

    //Download Upload files
    public static final String UPLOAD_PATH = PROJECT_PATH + SEPARATOR + "uploadFiles" + SEPARATOR;
    public static final String DOWNLOAD_PATH = PROJECT_PATH + SEPARATOR + "downloadFiles" + SEPARATOR;

    //Retry case failed
    public static final int RETRY_NUMBER = 3;
    //Browser Logs/Extension
    public static final String BROWSER_LOG_PATH = PROJECT_PATH + SEPARATOR + "browserLogs" + SEPARATOR;
    public static final String BROWSER_EXTENSION_PATH = PROJECT_PATH + SEPARATOR + "browserExtensions" + SEPARATOR;

    //HTML report folder
    public static final String REPORTING_PATH = PROJECT_PATH + SEPARATOR + "htmlReportNG" + SEPARATOR;
    public static final String EXTENT_PATH = PROJECT_PATH + SEPARATOR + "htmlExtent" + SEPARATOR;
    public static final String ALLURE_PATH = PROJECT_PATH + SEPARATOR + "htmlAllure" + SEPARATOR;

    //Data test/environment
    public static final String DATA_TEST_PATH = PROJECT_PATH + SEPARATOR + "dataTest" + SEPARATOR;
    public static final String ENVIRONMENT_CONFIG_PATH = PROJECT_PATH + SEPARATOR + "environmentConfig" + SEPARATOR;




}
