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
import test.java.lesson9.po.ContactPage;
import test.java.lesson9.po.FaqPage;
import test.java.lesson9.po.HomePage;
import test.java.lesson9.po.SearchPage;

import java.sql.SQLOutput;
import java.util.List;

import static org.testng.Assert.assertEquals;
import static org.testng.AssertJUnit.assertTrue;

public class HWArtefacts extends TestBaseSetup {
    Logger logger = LogManager.getLogger(HomePage.class);
    WebDriverWait wait;
    HomePage homePage;
    ContactPage contactPage;
    FaqPage faqPage;
    SearchPage searchPage;
    By goodsList = By.cssSelector("[class='goods-tile__inner']");

    @BeforeMethod
    public void initialize() {
        homePage = new HomePage(driver);
        contactPage = new ContactPage(driver);
        faqPage = new FaqPage(driver);
        searchPage = new SearchPage(driver);
    }

    @DataProvider (name = "nameOfBrands")
    public Object[][] getBrandList(){
           return new Object[][]{
               {"Acer"},
               {"Apple"},
               {"Asus"}
        };
    }

    @Test (dataProvider = "nameOfBrands")
        public void brandTest (String number){
        homePage.alternativeWay();
        logger.debug("number is " + number);
            By brands = By.cssSelector("[for='"+ number + "']");
            logger.trace("CssSelector is " + brands);
            wait.until(ExpectedConditions.elementToBeClickable(brands));

            driver.findElement(brands).click();
            wait.until(ExpectedConditions.visibilityOfElementLocated(goodsList));
            logger.info("wait done");

            List<WebElement> actualList = driver.findElements(goodsList);
            logger.info("Actual List size is  " + actualList.size());

            for (WebElement actualArray: actualList) {

                wait.until(ExpectedConditions.visibilityOfElementLocated(goodsList));
                logger.debug("actual list length is: " + actualArray.getSize());
                System.out.println("done");

                String actualRes = actualArray.getText().toLowerCase();
                logger.info("ActualRes done" );

                String expectedRes = number.toLowerCase();
                logger.debug("expected is " + expectedRes);

                System.out.println("we are expecting " + expectedRes + " in string "+ actualRes);
                assertTrue(actualRes.contains(expectedRes));
            }


        }

    }


