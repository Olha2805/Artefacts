package test.java.lesson9;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import test.java.lesson9.po.HomePage;
import static org.testng.Assert.assertTrue;

public class HWSeleniumPart2 extends TestBaseSetup {
    HomePage homePage;

    @BeforeMethod
    public void initialize() {
        homePage = new HomePage(driver);

    }
    @Test
    public void registrationWithoutAnything() {
        homePage.open()
                .tapToCheckIn()
                .tapToReg()
                .tapToRegCell()         //First test point
                .tapToMailCell()        //Second Test Point
                .tapToPasswordCell()    //Third Test Point
                .tapToUltimateRegistration();
        boolean expectedName = driver.getPageSource().contains(" Введите свое имя на кириллице ");
        boolean expectedMail = driver.getPageSource().contains(" Введите свою эл. почту ");
        boolean expectedPassword = driver.getPageSource().contains(" Пароль должен быть не менее 6 символов, содержать цифры и латинские буквы, в том числе заглавные, и не должен совпадать с именем и эл. почтой ");
        assertTrue(expectedName&&expectedMail&&expectedPassword, "Name or(and) email or(and) password were entered");
    }


   @Test
    public void registrationWithOneParametr() {
       homePage.open()
               .tapToCheckIn()
               .tapToReg()
               .writeName()             //First test point
               .tapToMailCell()        //Second Test Point
               .tapToPasswordCell()    //Third Test Point
               .tapToUltimateRegistration();

        String actua1lName = String.valueOf(homePage.writeName().getClass());
        String expected1Name = "ng-dirty ng-valid ng-touched";
        String actual1Mail = String.valueOf(homePage.tapToMailCell().getClass());
        String expected1Mail = "ng-pristine ng-invalid ng-touched";
        String actual1Password = String.valueOf(homePage.tapToPasswordCell().getClass());
        String expected1Password = "ng-pristine ng-invalid ng-touched";
        assertTrue(expected1Name.contains(actua1lName) &&
                        expected1Mail.contains(actual1Mail)&&
                        expected1Password.contains(actual1Password),
                "You should to enter text just in one cell");
    }

}
