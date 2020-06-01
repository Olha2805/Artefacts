package test.java.lesson9;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import test.java.utils.Screenshot;

import java.net.MalformedURLException;
import java.net.URL;

public class TestBaseSetup {
    WebDriver driver;
    Screenshot screenshot;

    @BeforeMethod
    public void beforeMethod(){
        screenshot = new Screenshot(driver);
       System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
        ChromeOptions optionsCH = new ChromeOptions();
        optionsCH.addArguments("--disable-notifications");
        optionsCH.addArguments("--window-size=1300,1080");
        FirefoxOptions optionsFF = new FirefoxOptions();
        //driver = new ChromeDriver();
        /*try {
            driver = new RemoteWebDriver(new URL("http://ec2-18-222-204-253.us-east-2.compute.amazonaws.com:4444/wd/hub"), optionsCH);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }*/
        screenshot = new Screenshot(driver);
    }

    @AfterMethod
    public void afterMethod() { // ITestResult result
       // screenshot.getScreenshot(result);
        driver.quit();
    }
}