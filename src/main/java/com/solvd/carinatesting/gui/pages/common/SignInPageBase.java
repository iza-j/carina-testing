package com.solvd.carinatesting.gui.pages.common;

import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.gui.AbstractPage;
import org.openqa.selenium.WebDriver;

public abstract class SignInPageBase extends AbstractPage {

    public SignInPageBase(WebDriver driver) {
        super(driver);
    }

    public abstract ExtendedWebElement getEmailTextBox();

    public abstract ExtendedWebElement getContinueButton();

    public abstract ExtendedWebElement getPasswordTextBox();
}