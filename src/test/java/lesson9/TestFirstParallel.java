package test.java.lesson9;

import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import test.java.lesson9.po.ContactPage;
import test.java.lesson9.po.FaqPage;
import test.java.lesson9.po.HomePage;

import java.util.List;

import static org.testng.Assert.assertEquals;

public class TestFirstParallel extends TestBaseSetup {
    HomePage homePage;


    @BeforeMethod
    public void initialize() {
        homePage = new HomePage(driver);

    }

    @Test
    public void testA() {
        homePage.open();
    }

}
