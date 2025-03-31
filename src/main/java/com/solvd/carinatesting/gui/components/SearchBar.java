package com.solvd.carinatesting.gui.components;

import com.solvd.carinatesting.gui.pages.common.SearchResultsPageBase;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.gui.AbstractUIObject;
import com.zebrunner.carina.webdriver.locator.Context;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class SearchBar extends AbstractUIObject {

    @FindBy(id = "searchDropdownBox")
    private ExtendedWebElement searchDropdown;

    @Context(dependsOn = "searchDropdown")
    @FindBy(tagName = "option")
    private List<ExtendedWebElement> searchDropdownOptions;

    @FindBy(id = "twotabsearchtextbox")
    private ExtendedWebElement searchTextBox;

    @FindBy(id = "nav-search-submit-button")
    private ExtendedWebElement searchSubmitButton;

    public SearchBar(WebDriver driver, SearchContext sc) {
        super(driver, sc);
    }

    public String selectCategory(String wantedCategory) {
        searchDropdown.click();
        for (ExtendedWebElement option : searchDropdownOptions) {
            if (option.getText().equalsIgnoreCase(wantedCategory)) {
                option.click();
                return option.getText();
            }
        }
        return null;
    }

    public SearchResultsPageBase searchFor(String item) {
        searchTextBox.type(item);
        searchSubmitButton.click();
        return initPage(driver, SearchResultsPageBase.class);
    }
}