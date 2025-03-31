package com.solvd.carinatesting.gui.pages.desktop;

import com.solvd.carinatesting.gui.components.NavigationToolBar;
import com.solvd.carinatesting.gui.components.SearchBar;
import com.solvd.carinatesting.gui.pages.common.HomePageBase;
import com.zebrunner.carina.utils.factory.DeviceType;
import com.zebrunner.carina.webdriver.decorator.PageOpeningStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

@DeviceType(pageType = DeviceType.Type.DESKTOP, parentClass = HomePageBase.class)
public class HomePage extends HomePageBase {

    @FindBy(id = "nav-search-bar-form")
    private SearchBar searchBar;

    @FindBy(id = "nav-tools")
    private NavigationToolBar navigationToolBar;

    public HomePage(WebDriver driver) {
        super(driver);
        // https://zebrunner.github.io/carina/automation/web/#page-opening-strategy
        setPageOpeningStrategy(PageOpeningStrategy.BY_ELEMENT);
        setUiLoadedMarker(searchBar);
    }

    @Override
    public SearchBar getSearchBar() {
        return searchBar;
    }

    @Override
    public NavigationToolBar getNavigationToolBar() {
        return navigationToolBar;
    }
}