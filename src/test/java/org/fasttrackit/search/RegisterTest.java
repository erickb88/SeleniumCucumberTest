package org.fasttrackit;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class RegisterTest {

    @Test
    public void successfulRegisterWithAllDetails() {
        System.setProperty("webdriver.chrome.driver", "C:\\webdriver\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        driver.get("http://testfasttrackit.info/selenium-test/");

        driver.findElement(By.linkText("ACCOUNT")).click();
        driver.findElement(By.linkText("Register")).click();

        driver.findElement(By.id("firstname")).sendKeys("Flaviu");
        driver.findElement(By.id("middlename")).sendKeys("G");
        driver.findElement(By.id("lastname")).sendKeys("Ratiu");
        driver.findElement(By.name("email")).sendKeys("test@example.com");
        driver.findElement(By.name("password")).sendKeys("passw0rd");
        driver.findElement(By.name("confirmation")).sendKeys("passw0rd");
        driver.findElement(By.className("checkbox")).click();
        driver.findElement(By.xpath("//button[@title='Register']")).click();




    }
}
