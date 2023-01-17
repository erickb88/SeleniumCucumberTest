package org.fasttrackit.search;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class SimpleSearchTest {

    @Test
    public void simpleSearchWithOneKeyword(){
        System.setProperty("webdriver.chrome.driver", "C:\\webdriver\\chromedriver.exe");

        WebDriver driver = new ChromeDriver();

        driver.get("http://testfasttrackit.info/selenium-test/");
        driver.findElement(By.id("search")).sendKeys("vase"+ Keys.ENTER);


    }
}
