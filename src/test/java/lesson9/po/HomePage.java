package test.java.lesson9.po;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.util.List;

public class HomePage {
    private final WebDriver driver;
    private final WebDriverWait wait;
    private String searchStr;
    String popupStrSelect = "[class='popup-css lang-switcher-popup sprite-side']";
    By search = By.cssSelector("[name='search']");
    //By iPhone = By.xpath("//div[@class='g-i-tile-i-title clearfix']/a[contains(text(), '" + searchStr + "')]");
    By popup = By.cssSelector(popupStrSelect);
    By popupClose = By.cssSelector(popupStrSelect + " [class='popup-close']");
    By contactBtn = By.cssSelector("[href='https://rozetka.com.ua/contacts/']");
    private final By typesList = By.cssSelector("[class='menu-categories__link']");
    private final By qaLinks = By.cssSelector("[name='slider-block-active']");
    By registration = By.cssSelector("[class='header-topline__user-link link-dashed']");
    By bottomRegistration = By.cssSelector("[class='auth-modal__register-link']");
    By nameRegCell = By.cssSelector("[formcontrolname='name']");
    By mailRegCell = By.cssSelector("[formcontrolname='username']");
    By passwordRegCell = By.cssSelector("[type='password']");
    By tapToBottomReg = By.cssSelector("[type='submit']");
    By nameError = By.cssSelector("[class='form__row js-name validation_type_error']");
    Logger logger = LogManager.getLogger(HomePage.class);
    By tapToLaptopsAndComputers = By.cssSelector("[href='https://rozetka.com.ua/computers-notebooks/c80253/']");
    By tapToLaptop = By.cssSelector("[title='Ноутбуки']");
    By brandAcer = By.cssSelector("[for='Acer']");
    By brandList = By.cssSelector("[class='goods-tile__inner']");


    public HomePage(WebDriver driver) {
        logger.trace("Home Page initialized");
        this.driver = driver;
        wait = new WebDriverWait(this.driver, 10);
    }


    public HomePage open() {
        driver.get("https://rozetka.com.ua/");
        logger.debug("URL: " + driver.getCurrentUrl());
        return this;
    }

    public HomePage search(String searchStr) {
        this.searchStr = searchStr;
        By searchResultItem = By.xpath("//span[contains(text(), '" + searchStr + "')]");
        WebElement searchEl = driver.findElement(search);
        wait.until(ExpectedConditions.elementToBeClickable(searchEl));
        if( driver.findElements(popup).size() > 0 ) {
            driver.findElement(popupClose).click();
        }
        searchEl.sendKeys(this.searchStr);
        searchEl.sendKeys(Keys.ENTER);
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(searchResultItem)));
        return this;
    }

    public HomePage clickContacts() {
        wait.until(ExpectedConditions.elementToBeClickable(contactBtn));
        driver.findElement(contactBtn).click();
        return this;
    }

    public List<WebElement> actualListOfProductTypes() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(typesList));
        return driver.findElements(typesList);
    }

    public String[] expectListOfProductTypes() {
        String[] expectList = {
                "Ноутбуки и компьютеры",
                "Смартфоны, ТВ и электроника",
                "Бытовая техника",
                "Товары для дома",
                "Инструменты и автотовары",
                "Сантехника и ремонт",
                "Дача, сад и огород",
                "Спорт и увлечения",
                "Одежда, обувь и украшения",
                "Красота и здоровье",
                "Детские товары",
                "Канцтовары и книги",
                "Алкогольные напитки и продукты",
                "Товары для бизнеса",
                "Услуги и сервисы",
                "Продовольственные наборы"
        };
        return expectList;
    }

     public HomePage tapToCheckIn () {
         WebElement tapToRegistrationBottom = driver.findElement(registration);
         wait.until(ExpectedConditions.elementToBeClickable(tapToRegistrationBottom)).click();   // click to check-in
         return this;
    }

    public HomePage tapToReg (){

            WebElement tapToBottomRegistration = driver.findElement(bottomRegistration);
            wait.until(ExpectedConditions.elementToBeClickable(tapToBottomRegistration)).click();    // click to registration bottom
            return this;
    }

    public HomePage tapToRegCell(){
        WebElement tapToFirstRegistrationCell = driver.findElement(nameRegCell);
        wait.until(ExpectedConditions.elementToBeClickable(nameRegCell)).click();   // tap to cell for a name input
            return this;
    }

    public HomePage writeName(){
        WebElement tupToFirstRegistrationCell1 = driver.findElement(nameRegCell);
        wait.until(ExpectedConditions.elementToBeClickable(nameRegCell)).click();   // tup to cell for a name input
        tupToFirstRegistrationCell1.sendKeys("блаблабла");
        return this;
    }

    public HomePage tapToMailCell () {

        WebElement tapToSecondRegistrationCell = driver.findElement(mailRegCell);
        wait.until(ExpectedConditions.elementToBeClickable(mailRegCell)).click();   // tap to cell for a mail input
    return this;
    }

    public HomePage tapToPasswordCell () {

        WebElement tupToThirdRegistrationSell = driver.findElement(passwordRegCell);
        wait.until(ExpectedConditions.elementToBeClickable(passwordRegCell)).click();   //tup to cell for a password input
    return this;
    }

    public HomePage tapToUltimateRegistration () {
        WebElement tupToReg = driver.findElement(tapToBottomReg);
        wait.until(ExpectedConditions.elementToBeClickable(tapToBottomReg)).click();    // tup to registration bottom
    return this;
    }

    public HomePage selectLaptopsAndComputers (){
        WebElement selectLaptopsAndComputers = driver.findElement(tapToLaptopsAndComputers);
        wait.until(ExpectedConditions.elementToBeClickable(tapToLaptopsAndComputers)).click();
        return this;
    }

    public HomePage selectLaptops (){
        WebElement selectLaptop = driver.findElement(tapToLaptop);
        wait.until(ExpectedConditions.elementToBeClickable(tapToLaptop)).click();
        return this;
    }

    public HomePage alternativeWay (){
        driver.get("https://rozetka.com.ua/notebooks/c80004/");
        logger.debug("URL: " + driver.getCurrentUrl());
        return this;
    }

    public HomePage selectAcer (){
        WebElement selectBrandAcer = driver.findElement(brandAcer);
        wait.until(ExpectedConditions.elementToBeClickable(brandAcer)).click();
        return this;
    }

    public List<WebElement> getBrandsList (){
        wait.until(ExpectedConditions.visibilityOfElementLocated(brandList));
        return driver.findElements(By.linkText(String.valueOf(brandList)));
    }

}
