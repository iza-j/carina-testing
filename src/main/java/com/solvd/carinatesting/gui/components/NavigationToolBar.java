package com.solvd.carinatesting.gui.components;

import com.solvd.carinatesting.gui.pages.common.SignInPageBase;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.gui.AbstractUIObject;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class NavigationToolBar extends AbstractUIObject {

    @FindBy(css = "#nav-link-accountList > button")
    private ExtendedWebElement signInFlyout;

    @FindBy(xpath = "//div [@id = 'nav-flyout-ya-signin'] / a")
    private ExtendedWebElement signInButton;

    public NavigationToolBar(WebDriver driver, SearchContext sc) {
        super(driver, sc);
    }

    public SignInPageBase goToSignInPage() {
        signInFlyout.hover();
        signInButton.click();
        return initPage(driver, SignInPageBase.class);
    }
}