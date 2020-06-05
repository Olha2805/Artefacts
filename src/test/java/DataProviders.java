package test.java;

import org.testng.annotations.DataProvider;

public class DataProviders {
    @DataProvider(name = "usersNames")
    public Object[][] dataProvider(){
        return new Object[][]{
                {"Vova", 15},
                {"Peter", 22},
                {"Vasya", 33}
        };
    }

    @DataProvider(name = "notNames")
    public Object[][] dataProvider1(){
        return new Object[][]{
                {"Vovan", 115},
                {"Peters", 122},
                {"Vasyan", 133}
        };
    }
}
