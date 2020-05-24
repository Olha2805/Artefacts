package test.java.lesson9;

import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import test.java.lesson9.po.HomePage;
import test.java.lesson9.po.SearchPage;
import java.util.List;
import static org.testng.Assert.assertEquals;

public class HWPageObject extends TestBaseSetup {

        HomePage homePage;
        SearchPage searchPage;


        @BeforeMethod
        public void initialize() {
            homePage = new HomePage(driver);
            searchPage = new SearchPage(driver);

        }

        @Test
        public void test1() {
            homePage.open();
            homePage.search("iPhone");

            List<WebElement> resultsOfSearch = searchPage.getSearchList();
            for (WebElement element: resultsOfSearch) {
                int expectedName = 22;
                int actualName = searchPage.getResultCount();
                assertEquals (actualName, expectedName, "Houston, we have a problem with a test");
            }
        }

       @Test
        public void test2() {
            homePage.open();
            //foreach... поитерироваться по элементам списка

           List <WebElement> factList = homePage.actualListOfProductTypes();
           String [] expectedList = homePage.expectListOfProductTypes();
           //   List <String> expectedList = Arrays.asList(homePage.expectListOfProductTypes());
           for (WebElement typesOfProduct: factList) {
               String actualList = typesOfProduct.getText();

               for (String expectedString: expectedList){
                   assertEquals(expectedString, actualList);
               }

           }
        }

}
