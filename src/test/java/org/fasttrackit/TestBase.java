package org.fasttrackit;

import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;

public class TestBase {

    protected WebDriver driver = DriverFactory.getDriver();
    @Before
    public void setup(){

        String browser = System.getProperty("browser","chrome");
        driver = DriverFactory.initDriver(browser);


    }
    @After
    public void tearDown(){
        //driver.quit();
    }
    public void openHomepage(){
        driver.get(AppConfig.getSiteUrl());
    }

}
