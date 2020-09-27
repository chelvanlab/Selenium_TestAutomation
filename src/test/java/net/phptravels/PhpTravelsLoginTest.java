package net.phptravels;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class PhpTravelsLoginTest {

    WebDriver driver;

    @BeforeMethod
    public void setup(){
        System.setProperty("webdriver.gecko.driver","/home/chelvan/SeleniumAutomation/src/main/resources/geckodriver");
        driver = new FirefoxDriver();
        driver.get("https://phptravels.net/admin");
        driver.manage().window().maximize();
    }

    @Test
    public void testLogin() throws InterruptedException {
        driver.findElement(By.name("email")).sendKeys("admin@phptravels.com");
        driver.findElement(By.xpath("//input[@name='password']")).sendKeys("demoadmin");
        driver.findElement(By.xpath(("//*[@type='submit']"))).click();

        Thread.sleep(10000);
        String message = driver.findElement(By.xpath("//*[contains(text(),'Hi Admin!')]")).getText();

        Assert.assertEquals(message,"Hi Admin!");
        driver.findElement(By.xpath("//*[contains(text(),'Logout')]")).click();

    }

    @AfterMethod
    public void tearDwon(){
        driver.quit();
    }
}
