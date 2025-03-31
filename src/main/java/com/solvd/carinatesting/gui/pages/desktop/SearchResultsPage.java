package com.solvd.carinatesting.gui.pages.desktop;

import com.solvd.carinatesting.gui.components.SearchBar;
import com.solvd.carinatesting.gui.pages.common.SearchResultsPageBase;
import com.zebrunner.carina.utils.factory.DeviceType;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.decorator.PageOpeningStrategy;
import com.zebrunner.carina.webdriver.locator.Context;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

import java.util.List;

@DeviceType(pageType = DeviceType.Type.DESKTOP, parentClass = SearchResultsPageBase.class)
public class SearchResultsPage extends SearchResultsPageBase {

    @FindBy(id = "nav-search-bar-form")
    private SearchBar searchBar;

    @FindBy(xpath = "//div [contains (@class, 'result-list') and contains (@class, 'search-results')]")
    private ExtendedWebElement searchResultsContainer;

    @Context(dependsOn = "searchResultsContainer")
    @FindBy(xpath = "div [@role = 'listitem' and contains (@class, 'result-item')]")
    private List<ExtendedWebElement> searchResultList;

    @FindBy(xpath = "//select [contains (@id, 's-result-sort-select')] / option")
    private List<ExtendedWebElement> sortByOptions;

    public SearchResultsPage(WebDriver driver) {
        super(driver);
        setPageOpeningStrategy(PageOpeningStrategy.BY_ELEMENT);
        setUiLoadedMarker(searchResultsContainer);
    }

    @Override
    public ExtendedWebElement getSearchResultsContainer() {
        return searchResultsContainer;
    }

    @Override
    public List<ExtendedWebElement> getSearchResultList() {
        return searchResultList;
    }

    @Override
    public SearchResultsPageBase selectSortBy(String wantedSortBy) {
        for (ExtendedWebElement option : sortByOptions) {
            if (option.getText().equalsIgnoreCase(wantedSortBy)) {
                option.click();
                return initPage(driver, SearchResultsPageBase.class);
            }
        }
        return null;
    }
}