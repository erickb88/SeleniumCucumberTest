package org.fasttrackit.stepdefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.fasttrackit.TestBase;
import org.fasttrackit.webviews.ProductsGrid;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

public class ProductsGridSteps extends TestBase {
    private ProductsGrid productsGrid = PageFactory.initElements(driver, ProductsGrid.class);

    @When("I select the option {string} in the Sort by list")
    public void iSelectTheOptionInTheSortByList(String sortCriteria) {
        productsGrid.getSortByList().selectByVisibleText(sortCriteria);

    }

    @And("I sort the products in {string} order")
    public void iSortTheProductsInOrder(String sortDirection) {
        String classAttribute;
        if(sortDirection.equals("descending")){
            classAttribute = "--asc";
        } else {
            classAttribute = "--desc";
        }
        if (productsGrid.getSortButton().getAttribute("class").contains(classAttribute)) {
            productsGrid.getSortButton().click();
        }
    }


    @Then("the products are ordered by price in {string} order")
    public void theProductsAreOrderedByPriceInOrder(String sortDirection) {
        List<Double> prices = new ArrayList<>();

        for(WebElement priceContainer: productsGrid.getProductPrices()){
            String priceText = priceContainer.getText();

            double price = Double.parseDouble(priceText.split(" ")[0].replace(",","."));
            prices.add(price);
        }
        assertThat("No prices could be extracted",prices,hasSize(greaterThan(0)));
        List<Double> sortedPrices = new ArrayList<>(prices);

        Comparator<Double> comparator;
        if(sortDirection.equals("ascending")){
            comparator = Comparator.naturalOrder();
        } else {
            comparator = Comparator.reverseOrder();
        }
        sortedPrices.sort(comparator);
        assertThat("Products are not ordered correctly", prices, equalTo(sortedPrices));
    }
}


