package com.solvd.carinatesting.gui.pages.common;

import com.solvd.carinatesting.gui.components.SearchBar;
import com.zebrunner.carina.webdriver.gui.AbstractPage;
import org.openqa.selenium.WebDriver;

public abstract class HomePageBase extends AbstractPage {

    public HomePageBase(WebDriver driver) {
        super(driver);
    }

    public abstract SearchBar getSearchBar();
}