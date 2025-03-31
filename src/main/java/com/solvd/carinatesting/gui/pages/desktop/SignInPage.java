package com.solvd.carinatesting.gui.pages.desktop;

import com.solvd.carinatesting.gui.pages.common.SignInPageBase;
import com.zebrunner.carina.utils.factory.DeviceType;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.decorator.PageOpeningStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

@DeviceType(pageType = DeviceType.Type.DESKTOP, parentClass = SignInPageBase.class)
public class SignInPage extends SignInPageBase {

    @FindBy(id = "ap_email")
    private ExtendedWebElement emailTextBox;

    @FindBy(xpath = "//span [contains (@class, 'button-primary')]")
    private ExtendedWebElement continueButton;

    @FindBy(id = "ap_password")
    private ExtendedWebElement passwordTextBox;

    public SignInPage(WebDriver driver) {
        super(driver);
        setPageOpeningStrategy(PageOpeningStrategy.BY_ELEMENT);
        setUiLoadedMarker(continueButton);
    }

    @Override
    public ExtendedWebElement getEmailTextBox() {
        return emailTextBox;
    }

    @Override
    public ExtendedWebElement getContinueButton() {
        return continueButton;
    }

    @Override
    public ExtendedWebElement getPasswordTextBox() {
        return passwordTextBox;
    }
}