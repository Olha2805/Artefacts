package test.java.lesson9;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.w3c.dom.Text;
import test.java.lesson9.po.ContactPage;
import test.java.lesson9.po.FaqPage;
import test.java.lesson9.po.HomePage;
import test.java.lesson9.po.SearchPage;

import java.sql.SQLOutput;
import java.util.List;

import static org.testng.Assert.assertEquals;
import static org.testng.AssertJUnit.assertTrue;

public class HWRandom extends TestBaseSetup {
    Logger logger = LogManager.getLogger(HomePage.class);
    WebDriverWait wait;
    HomePage homePage;
    ContactPage contactPage;
    FaqPage faqPage;
    SearchPage searchPage;
   // By goodsList = By.xpath("//input[contains(@onclick,'goods-tile__inner')]/..");
    By goodsList = By.cssSelector("[class='goods-tile__inner']");


    @BeforeMethod
    public void initialize() {
        homePage = new HomePage(driver);
        contactPage = new ContactPage(driver);
        faqPage = new FaqPage(driver);
        searchPage = new SearchPage(driver);
    }


    @Test
    public void brandTest (){
        String[] productList = {
                "Acer",
                "Apple",
                "Asus",
                "Dell",
                "Dream Machines",
                "HP",
                "Lenovo",
                "MSI",
                "Microsoft",
                "Prestigio",
                "Razer",
                "Xiaomi",
                "Alien",
                "Chuwi",
                "Digma",
                "Durabook",
                "Epic",
                "Fujitsu",
                "Fujitsu-siemens",
                "Gigabyte",
                "Google",
                "Jumper",
                "Mediacom",
                "Medion",
                "Medion" };
        int max = productList.length - 1;
        int min = 0;

        for (int i = 0; i < 1; i++) {
        int rand = (int)(Math.random() * (max - min + 1)) + min;
        logger.info("rand is " + rand);
        String number = productList[rand];
        logger.info("rand is " + number);
        homePage.alternativeWay();
        logger.debug("number is " + number);
        By brand = By.cssSelector("[for='"+ number + "']");
        logger.trace("CssSelector is " + brand);

        driver.findElement(brand).click();
        logger.info("click done");

        List <WebElement> actualList = driver.findElements(goodsList);
        logger.info("Actual List size is  " + actualList.size());

        for (WebElement actualRes: actualList) {

            String actual = actualRes.getText().toLowerCase();
            logger.info("Actual is" + actual);

            String expectedRes = number.toLowerCase();

            assertTrue(actual.contains(expectedRes));
         }
        }

    }

}


