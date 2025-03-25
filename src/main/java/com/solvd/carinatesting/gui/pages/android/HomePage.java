package com.solvd.carinatesting.gui.pages.android;

import com.solvd.carinatesting.gui.components.SearchBar;
import com.solvd.carinatesting.gui.pages.common.HomePageBase;
import com.zebrunner.carina.utils.factory.DeviceType;
import org.openqa.selenium.WebDriver;

@DeviceType(pageType = DeviceType.Type.ANDROID_PHONE, parentClass = HomePageBase.class)
public class HomePage extends HomePageBase {

    // @FindBy()
    private SearchBar searchBar;

    public HomePage(WebDriver driver) {
        super(driver);
        // (...)
    }

    @Override
    public SearchBar getSearchBar() {
        return searchBar;
    }
}