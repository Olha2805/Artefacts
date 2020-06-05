package test.java.lesson9.po;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class SearchPage {
    private final WebDriver driver;
    private final WebDriverWait wait;
    Logger logger = LogManager.getLogger(HomePage.class);
    private final By searchResults = By.cssSelector("[class='goods-tile__title']");
    private final By searchTypeList = By.cssSelector("[class='menu-categories__link']");
    private final By iPhoneResultCount = By.cssSelector("[class='goods-tile__inner']");
    By brandAcer = By.cssSelector("[for='Acer']");
    By brandApple = By.cssSelector("[for='Apple']");
    By productList = By.cssSelector("[class='goods-tile__inner']");


    public SearchPage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(this.driver, 10);
    }

    public List<WebElement> getSearchList() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(searchResults));
        return driver.findElements(searchResults);
    }

    public int getResultCount() {
        int countOfIPhone = driver.findElements(iPhoneResultCount).size();
        return countOfIPhone;
    }

    public SearchPage selectAcer (){
        WebElement selectBrandAcer = driver.findElement(brandAcer);
        wait.until(ExpectedConditions.elementToBeClickable(brandAcer)).click();
        logger.trace("Acers was find");
        return this;
    }

    public List<WebElement> getProductList (){
        wait.until(ExpectedConditions.visibilityOfElementLocated(productList));
        return driver.findElements(productList);
    }




}
