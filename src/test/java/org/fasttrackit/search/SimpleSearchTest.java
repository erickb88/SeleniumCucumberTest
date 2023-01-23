package org.fasttrackit.search;

import org.fasttrackit.AppConfig;
import org.fasttrackit.TestBase;
import org.fasttrackit.webviews.Header;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import java.util.List;
import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.MatcherAssert.assertThat;

public class SimpleSearchTest extends TestBase {

    @Test
    public void simpleSearchWithOneKeyword(){

        driver.get(AppConfig.getSiteUrl());

        Header header = PageFactory.initElements(driver, Header.class);

        String searchKeyword = "vase";

        header.search(searchKeyword);
        //header.getSearchField().sendKeys(searchKeyword + Keys.ENTER);
        //driver.findElement(By.id("search")).sendKeys(searchKeyword + Keys.ENTER);


        System.out.println("Pressed Enter in search field");

        List<WebElement> productNames = driver.findElements(By.cssSelector("h2.product-name a"));

        System.out.println("Stored "+ productNames.size()+ " product names");

        for(WebElement productName : productNames){
            assertThat ("Some of the product names do not contain the searched keyword.",
                    productName.getText(),containsString(searchKeyword.toUpperCase()));
        }



    }
}
