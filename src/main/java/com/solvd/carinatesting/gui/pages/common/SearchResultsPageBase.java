package com.solvd.carinatesting.gui.pages.common;

import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.gui.AbstractPage;
import org.openqa.selenium.WebDriver;

import java.util.List;

public abstract class SearchResultsPageBase extends AbstractPage {

    public SearchResultsPageBase(WebDriver driver) {
        super(driver);
    }

    public abstract ExtendedWebElement getSearchResultsContainer();

    public abstract List<ExtendedWebElement> getSearchResultList();

    public abstract SearchResultsPageBase selectSortBy(String wantedSortBy);
}