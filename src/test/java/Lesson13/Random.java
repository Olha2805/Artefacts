package test.java.Lesson13;

import org.openqa.selenium.WebElement;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Random {
    public static void main(String[] args) {
        Set <Integer> set = new HashSet<>();
        /*List <WebElements> el = driver.findElementsBy();
        */
        int min = 5;
        int max = 10;
            for (int i = 0; i < 100000; i++) {
            int rand = (int) (Math.random() * (max + 1 - min) + min);
            set.add(rand);
        }

            for (Integer el: set) System.out.println(el);


    }
}
