package test.java.lesson9;


import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import test.java.lesson9.po.HomePage;


public class TestSecondParallel extends TestBaseSetup {
    HomePage homePage;


    @BeforeMethod
    public void initialize() {
        homePage = new HomePage(driver);

    }

    @Test
    public void testA() {
        homePage.open();
    }

    @Test
    public void testB() {
        homePage.open();
    }



}
