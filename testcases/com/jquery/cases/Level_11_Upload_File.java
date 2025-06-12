package com.jquery.cases;

import commons.BaseTest;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pageObjects.jQuery.HomePO;
import pageObjects.jQuery.PageGenerator;


public class Level_11_Upload_File extends BaseTest {
    //Declare Variables
    private WebDriver driver;
    private HomePO homepage;
    String ammie,andreea,steve;


    //Pre-condition
    @Parameters({"browser","url"})
    @BeforeClass
    public void beforeClass(String browserName, String url){
       driver = getBrowser(browserName,url);
       homepage = PageGenerator.getHomePage(driver);
        ammie = "ammie.jpg";
        andreea = "andreea.jpg";
        steve = "steve.jpg";




    }
    //Testcases
    @Test
    public void User_01_Upload_01(){
        //upload 1 laanf 1 file
//        homepage.uploadMultipleFiles(driver,ammie);
//        homepage.sleepInSecond(3);
//        homepage.refreshCurrentPage(driver);
        //upload 1 lan 3 files
        homepage.uploadMultipleFiles(driver,ammie,andreea,steve);
        homepage.sleepInSecond(3);
        //Verify sau khi upload
        Assert.assertTrue(homepage.isFileLoadedByname(ammie));
        Assert.assertTrue(homepage.isFileLoadedByname(andreea));
        Assert.assertTrue( homepage.isFileLoadedByname(steve));




        //Click upload button
        homepage.clickToUploadButton(driver);

        //verify upload successfully
        Assert.assertTrue(homepage.isFileLoadedSuccessByname(ammie));
        Assert.assertTrue(homepage.isFileLoadedSuccessByname(andreea));
        Assert.assertTrue( homepage.isFileLoadedSuccessByname(steve));

    }

    @Test
    public void User_02_Filtering(){
    }




    //Post-condition
    @AfterClass
    public void afterClass(){
        //driver.quit();
    }



}
