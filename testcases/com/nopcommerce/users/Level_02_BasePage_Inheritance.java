package com.nopcommerce.users;

import commons.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.Random;

public class Level_02_BasePage_Inheritance extends BasePage {
    WebDriver driver;
    String firstName, lastName, email, company, password;
    Actions actions;


    @BeforeClass
    public void beforeClass() {
        //driver = new FirefoxDriver();
        driver = new ChromeDriver();
        driver.get("https://demo.nopcommerce.com/");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        firstName = "Testing";
        lastName = "Auto";
        email = "Testing" + emailRandom() + "@email.net";
        company = "Automation";
        password = "1234567";


    }

    @Test
    public void TC_01_Register() {
        waitForElementClickable(driver, "//a[text()='Register']");
        clickToElement(driver,"//a[text()='Register']");

        waitForElementClickable(driver, "//input[@id='gender-male']");
        clickToElement(driver,"//input[@id='gender-male']");
        sendKeyToElement(driver,"//input[@id='FirstName']",firstName);
        sendKeyToElement(driver,"//input[@id='LastName']",lastName);
        sendKeyToElement(driver,"//input[@id='Email']",email);
        sendKeyToElement(driver,"//input[@id='Company']",company);
        sendKeyToElement(driver,"//input[@id='Password']",password);
        sendKeyToElement(driver,"//input[@id='ConfirmPassword']",password);

        clickToElement(driver,"//button[@id='register-button']");

        waitForElementVisible(driver,"//div[@class='result']");
        Assert.assertEquals(getTextElement(driver,"//div[@class='result']"), "Your registration completed");

        clickToElement(driver,"//a[text()='Log out']");
        sleepInSecond(2);

        waitForElementVisible(driver,"//a[text()='Log in']");
        //Assert.assertTrue(isControlDisplayed(driver,"//a[text()='Log in']"));


    }


    @Test
    public void TC_02_Login() {
        clickToElement(driver,"//a[text()='Log in']");
        waitForElementVisible(driver,"//input[@id='Email']");
        sendKeyToElement(driver,"//input[@id='Email']",email);
        sendKeyToElement(driver,"//input[@id='Password']",password);

        clickToElement(driver,"//button[@class='button-1 login-button']");
        waitForElementVisible(driver,"//a[text()='Log out']");

        //Assert.assertTrue(isControlDisplayed(driver,"//a[text()='Log out']"));
    }

    @Test
    public void TC_03_My_Account() {

        clickToElement(driver,"//a[text()='My account']");


        Assert.assertTrue(isControlSelected(driver,"//input[@id='gender-male']"));
        Assert.assertEquals(getAttributeValue(driver,"//input[@id='FirstName']","value"),firstName);
        Assert.assertEquals(getAttributeValue(driver,"//input[@id='LastName']","value"),lastName);
        Assert.assertEquals(getAttributeValue(driver,"//input[@id='Email']","value"),email);
        Assert.assertEquals(getAttributeValue(driver,"//input[@id='Company']","value"),company);

    }

    @AfterClass
    public void afterClass() {
        driver.quit();
    }

    private int emailRandom() {
        return new Random().nextInt(99999);
    }


}
