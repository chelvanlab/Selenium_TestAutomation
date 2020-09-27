package net.phptravels;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
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
    public void testLogin() {

    }
}
