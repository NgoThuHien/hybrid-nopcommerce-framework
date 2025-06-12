package com.jquery.cases;

import commons.BaseTest;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pageObjects.jQuery.HomePO;
import pageObjects.jQuery.PageGenerator;


public class Level_10_Table_Grid extends BaseTest {
    //Declare Variables
    private WebDriver driver;
    private HomePO homepage;


    //Pre-condition
    @Parameters({"browser","url"})
    @BeforeClass
    public void beforeClass(String browserName, String url){
       driver = getBrowser(browserName,url);
       homepage = PageGenerator.getHomePage(driver);



    }
    //Testcases
//    @Test
//    public void User_01_Paging(){
//
//    homepage.openPageByNumber("15");
//        Assert.assertTrue(homepage.isPageNumberActive("15"));
//
//
//    homepage.openPageByNumber("8");
//        Assert.assertTrue(homepage.isPageNumberActive("8"));
//    homepage.openPageByNumber("12");
//        Assert.assertTrue(homepage.isPageNumberActive("12"));
//    homepage.openPageByNumber("1");
//        Assert.assertTrue(homepage.isPageNumberActive("1"));
//
//    }

//    @Test
//    public void User_02_Filtering(){
//        homepage.filterByHeaderName("384187", "Females");
//        homepage.sleepInSecond(2);
//        Assert.assertTrue(homepage.isSelectedRowDisplayed("384187","Afghanistan","407124","791312"));
//        homepage.refreshCurrentPage(driver);
//
//        homepage.filterByHeaderName("Angola","Country");
//        homepage.sleepInSecond(2);
//        homepage.refreshCurrentPage(driver);
//
//        homepage.filterByHeaderName("802948","Males");
//        homepage.sleepInSecond(2);
//        homepage.refreshCurrentPage(driver);
//
//        homepage.filterByHeaderName("1504","Total");
//        homepage.sleepInSecond(2);
//        Assert.assertTrue(homepage.isSelectedRowDisplayed("750","Aruba","756","1504"));
//        homepage.refreshCurrentPage(driver);
//
//    }

//    @Test
//    public void User_03_Delete_Edit(){
//        homepage.openPageByNumber("19");
//
//        homepage.filterByHeaderName("Saudi Arabia","Country");
//        homepage.sleepInSecond(2);
//        homepage.deleteRowByCountry("Saudi Arabia");
//        homepage.refreshCurrentPage(driver);
//
//        homepage.openPageByNumber("19");
//        homepage.filterByHeaderName("Singapore","Country");
//        homepage.editRowByCountry("Singapore");
//    }

    @Test
    public void User_04_Get_All_Value_Of_Column(){
        homepage.getAllValueOfColumn("Country");
    }
//    @Test
//    public void User_05_Action_By_Index(){
//    homepage.openPageUrl(driver,"https://www.jqueryscript.net/demo/jQuery-Dynamic-Data-Grid-Plugin-appendGrid/#google_vignette");
//    homepage.clickToLoadButton();
//
//
//    homepage.enterToTextboxByIndex("Contact Person","3"," Tina Thao Thi");
//    homepage.enterToTextboxByIndex("Company","4","Embassy");
//    homepage.selectFromDropdownByIndex("3", "Hong Kong");
//    homepage.selectCheckboxByInder("2","NPO?", true);
//    homepage.selectCheckboxByInder("1","NPO?", false);
//    homepage.enterToNumberboxByInder("Order Placed","4","123");
//    homepage.selectIcon("2","Remove Current Row");
//
//
//
//    }
    //Post-condition
    @AfterClass
    public void afterClass(){
        //driver.quit();
    }



}
