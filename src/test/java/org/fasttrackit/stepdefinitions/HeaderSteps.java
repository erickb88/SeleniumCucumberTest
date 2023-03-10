package org.fasttrackit.stepdefinitions;

import io.cucumber.java.en.And;
import org.fasttrackit.TestBase;
import org.fasttrackit.webviews.Header;
import org.openqa.selenium.support.PageFactory;

public class HeaderSteps extends TestBase {

    private Header header = PageFactory.initElements(driver, Header.class);
    @And("I search products by {string}")
    public void  iSearchProductsBy(String searchKeyword) {
        header.search(searchKeyword);
    }
}
