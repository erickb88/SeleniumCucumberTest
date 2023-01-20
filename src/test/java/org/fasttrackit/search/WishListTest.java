package org.fasttrackit.search;

import org.fasttrackit.AppConfig;
import org.fasttrackit.TestBase;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.hamcrest.MatcherAssert.assertThat;

public class WishListTest extends TestBase {

    @Test
    public void addToWishListAsAnonymousUser() {

        driver.get(AppConfig.getSiteUrl());

        driver.findElement(By.linkText("SALE")).click();
        driver.findElement(By.linkText("VIEW DETAILS")).click();
        driver.findElement(By.linkText("Add to Wishlist")).click();

        WebElement pageTitleContainer = driver.findElement(By.cssSelector(".page-title h1"));

        assertThat("Page title not displayed.", pageTitleContainer, notNullValue());
        assertThat("User hasn't been redirected to the login/register page", pageTitleContainer.getText(),
                containsString("LOGIN OR CREATE AN ACCOUNT"));




    }
}
