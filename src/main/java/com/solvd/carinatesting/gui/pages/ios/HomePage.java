package com.solvd.carinatesting.gui.pages.ios;

import com.solvd.carinatesting.gui.components.NavigationToolBar;
import com.solvd.carinatesting.gui.components.SearchBar;
import com.solvd.carinatesting.gui.pages.common.HomePageBase;
import com.zebrunner.carina.utils.factory.DeviceType;
import org.openqa.selenium.WebDriver;

@DeviceType(pageType = DeviceType.Type.IOS_PHONE, parentClass = HomePageBase.class)
public class HomePage extends HomePageBase {

    // @FindBy()
    private SearchBar searchBar;

    // @FindBy()
    private NavigationToolBar navigationToolBar;

    public HomePage(WebDriver driver) {
        super(driver);
        // (...)
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