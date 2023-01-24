package org.fasttrackit.webviews;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class ProductsGrid {
    @FindBy(css = "h2.product-name a")
    private List<WebElement> productNames;
    @FindBy(className = "price")
    private List<WebElement> productPrices;
    @FindBy(xpath="//select[@title='Sort By']")
    private WebElement sortByList;

    @FindBy(className = "sort-by-switcher")
    private WebElement sortButton;



    public List<WebElement> getProductNames() {
        return productNames;
    }

    public Select getSortByList() {
        return new Select(sortByList);
    }

    public WebElement getSortButton() {
        return sortButton;
    }

    public List<WebElement> getProductPrices() {
        return productPrices;
    }
}
