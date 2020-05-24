package test.java.lesson9.po;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

public class ContactPage {
    public Logger logger = LogManager.getLogger(ContactPage.class);
    private final WebDriver driver;
    private final WebDriverWait wait;
    private final By qAndABn = By.cssSelector("[href='https://rozetka.com.ua/faq/']");

    public ContactPage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(this.driver, 10);
    }

    public ContactPage clickFaq() {
        wait.until(ExpectedConditions.elementToBeClickable(qAndABn));
        driver.findElement(qAndABn).click();
        return this;
    }
}
