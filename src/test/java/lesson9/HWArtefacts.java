package test.java.lesson9;

import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import test.java.lesson9.po.HomePage;

import java.util.List;

import static org.testng.Assert.assertEquals;
import static org.testng.AssertJUnit.assertTrue;

public class HWArtefacts extends TestBaseSetup {
    HomePage homePage;


    @BeforeMethod
    public void initialize() {
        homePage = new HomePage(driver);
    }


    @DataProvider (name="brandsList")
    public static Object[][] getBrandList(){
           return new Object[][]{
               {"Acer"},
               {"Apple"},
               {"Asus"}
        };
    }

    @Test (dataProvider = "brandsList")
    public void brandTestAcer (){
        homePage.alternativeWay()
        .selectAcer();

        List<WebElement> actualList = homePage.getBrandsList();

        for (WebElement element: actualList) {
            String expectedWord = getBrandList().toString();
            assertTrue (actualList.contains(expectedWord));
        }

    }

}
