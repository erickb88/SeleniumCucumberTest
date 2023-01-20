package org.fasttrackit.search;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.MatcherAssert.assertThat;

public class SimpleSearchTest {

    @Test
    public void simpleSearchWithOneKeyword(){
        System.setProperty("webdriver.chrome.driver", "C:\\webdriver\\chromedriver.exe");

        WebDriver driver = new ChromeDriver();

        String searchKeyword = "vase";

        driver.get("http://testfasttrackit.info/selenium-test/");
        driver.findElement(By.id("search")).sendKeys(searchKeyword + Keys.ENTER);
        //driver.findElement(By.xpath("//div[@class='product-info']/div[@class='actions']/button[@class='button btn-cart']")).click();

        System.out.println("Pressed Enter in search field");

        List<WebElement> productNames = driver.findElements(By.cssSelector("h2.product-name a"));

        System.out.println("Stored "+ productNames.size()+ " product names");

        for(WebElement productName : productNames){
            assertThat ("Some of the product names do not contain the searched keyword.",
                    productName.getText(),containsString(searchKeyword.toUpperCase()));
        }



    }
}
