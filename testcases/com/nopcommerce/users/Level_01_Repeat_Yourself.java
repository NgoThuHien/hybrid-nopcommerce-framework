package com.nopcommerce.users;

import com.beust.ah.A;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.Random;

public class Level_01_Repeat_Yourself {
    WebDriver driver;
    String firstName, lastName, email, company, password;

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
        driver.findElement(By.xpath("//a[text()='Register']")).click();

        driver.findElement(By.xpath("//input[@id='gender-male']")).click();
        driver.findElement(By.xpath("//input[@id='FirstName']")).sendKeys(firstName);
        driver.findElement(By.xpath("//input[@id='LastName']")).sendKeys(lastName);
        driver.findElement(By.xpath("//input[@id='Email']")).sendKeys(email);
        driver.findElement(By.xpath("//input[@id='Company']")).sendKeys(company);
        driver.findElement(By.xpath("//input[@id='Password']")).sendKeys(password);
        driver.findElement(By.xpath("//input[@id='ConfirmPassword']")).sendKeys(password);


        driver.findElement(By.xpath("//button[@id='register-button']")).click();

        Assert.assertEquals(driver.findElement(By.xpath(
                "//div[@class='result']")).getText(), "Your registration completed");

        driver.findElement(By.xpath("//a[text()='Log out']")).click();

        Assert.assertTrue(driver.findElement(By.xpath("//a[text()='Log in']")).isDisplayed());

    }


    @Test
    public void TC_02_Login() {
        driver.findElement(By.xpath("//a[text()='Log in']")).click();

        driver.findElement(By.xpath("//input[@id='Email']")).sendKeys(email);
        driver.findElement(By.xpath("//input[@id='Password']")).sendKeys(password);

        driver.findElement(By.xpath("//button[@class='button-1 login-button']")).click();

        Assert.assertTrue(driver.findElement(By.xpath("//a[text()='Log out']")).isDisplayed());
    }

    @Test
    public void TC_03_My_Account() {
        driver.findElement(By.xpath("//a[text()='My account']")).click();

        Assert.assertTrue(driver.findElement(By.xpath("//input[@id='gender-male']")).isSelected());
        Assert.assertEquals(driver.findElement(By.xpath(
                "//input[@id='FirstName']")).getDomAttribute("value"), firstName);
        Assert.assertEquals(driver.findElement(By.xpath(
                "//input[@id='LastName']")).getDomAttribute("value"), lastName);
        Assert.assertEquals(driver.findElement(By.xpath(
                "//input[@id='Email']")).getDomAttribute("value"), email);
        Assert.assertEquals(driver.findElement(By.xpath(
                "//input[@id='Company']")).getDomAttribute("value"), company);

    }

    @AfterClass
    public void afterClass() {
        driver.quit();
    }

    private int emailRandom() {
        return new Random().nextInt(99999);
    }


}
