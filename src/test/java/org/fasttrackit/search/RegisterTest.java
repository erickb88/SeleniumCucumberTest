package org.fasttrackit.search;

import org.fasttrackit.AppConfig;
import org.fasttrackit.TestBase;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.assertThat;

public class RegisterTest extends TestBase {

    @Test
    public void successfulRegisterWithAllDetails() {

        driver.get(AppConfig.getSiteUrl());

        driver.findElement(By.linkText("ACCOUNT")).click();
        driver.findElement(By.linkText("Register")).click();

        driver.findElement(By.id("firstname")).sendKeys("Flaviu");
        driver.findElement(By.id("middlename")).sendKeys("E");
        driver.findElement(By.id("lastname")).sendKeys("Ratiu");
        driver.findElement(By.name("email")).sendKeys("test2@example.com");
        driver.findElement(By.name("password")).sendKeys("passw0rd");
        driver.findElement(By.name("confirmation")).sendKeys("passw0rd");
        driver.findElement(By.className("checkbox")).click();
        driver.findElement(By.xpath("//button[@title='Register']")).click();

        WebElement successMessageContainer = driver.findElement(By.className("success-msg"));

        assertThat("Confirmation message not displayed.", successMessageContainer, notNullValue());
        assertThat("Unexpected confirmation message.", successMessageContainer.getText(),
                containsString("Thank you for registering with Madison Island."));






    }
}
