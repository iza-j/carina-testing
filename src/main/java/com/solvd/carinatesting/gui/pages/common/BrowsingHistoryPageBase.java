package com.solvd.carinatesting.gui.pages.common;

import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.gui.AbstractPage;
import org.openqa.selenium.WebDriver;

import java.util.List;

public abstract class BrowsingHistoryPageBase extends AbstractPage {

    public BrowsingHistoryPageBase(WebDriver driver) {
        super(driver);
    }

    public abstract ExtendedWebElement getItemsGrid();

    public abstract List<ExtendedWebElement> getRemoveSingleItemButtons();

    public abstract ExtendedWebElement getSettingsButton();

    public abstract ExtendedWebElement getRemoveAllItemsButton();

    public abstract ExtendedWebElement getMoreSettingsHyperlink();

    public abstract ExtendedWebElement getBrowsingHistoryToggle();

    public abstract ExtendedWebElement getBrowsingHistoryDisabledMessage();

    public abstract ExtendedWebElement getBrowsingHistoryPausedMessage();

    public abstract ExtendedWebElement getNoViewedItemsMessage();
}