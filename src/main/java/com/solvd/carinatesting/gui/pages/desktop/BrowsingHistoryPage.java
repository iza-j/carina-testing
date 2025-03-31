package com.solvd.carinatesting.gui.pages.desktop;

import com.solvd.carinatesting.gui.pages.common.BrowsingHistoryPageBase;
import com.zebrunner.carina.utils.factory.DeviceType;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.decorator.PageOpeningStrategy;
import com.zebrunner.carina.webdriver.locator.Context;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

import java.util.List;

@DeviceType(pageType = DeviceType.Type.DESKTOP, parentClass = BrowsingHistoryPageBase.class)
public class BrowsingHistoryPage extends BrowsingHistoryPageBase {

    @FindBy(css = ".p13n-ybh-grid")
    private ExtendedWebElement itemsGrid;

    @Context(dependsOn = "itemsGrid")
    @FindBy(xpath = "descendant::input [@type = 'submit' and @class = 'a-button-input']")
    private List<ExtendedWebElement> removeSingleItemButtons;

    @FindBy(xpath = "//a [@data-mix-operations = 'showSettingsDisclosure']")
    private ExtendedWebElement settingsButton;

    @FindBy(xpath = "//div [contains (@id, 'popover')] / descendant::span [contains (text(), 'Remove items')] / preceding-sibling::input")
    private ExtendedWebElement removeAllItemsButton;

    @FindBy(xpath = "//a [@data-mix-operations = 'showMoreSettingsPage']")
    private ExtendedWebElement moreSettingsHyperlink;

    @FindBy(xpath = "//div [contains (@id, 'popover')] / descendant::a [contains (@class, 'switch-control')]")
    private ExtendedWebElement browsingHistoryToggle;

    @FindBy(id = "browsingHistoryDisabledMessage")
    private ExtendedWebElement browsingHistoryDisabledMessage;

    @FindBy(id = "browsingHistoryPausedMessage")
    private ExtendedWebElement browsingHistoryPausedMessage;

    @FindBy(xpath = "//span [contains (text(), 'You have no recently viewed items.')]")
    private ExtendedWebElement noViewedItemsMessage;

    public BrowsingHistoryPage(WebDriver driver) {
        super(driver);
        setPageOpeningStrategy(PageOpeningStrategy.BY_ELEMENT);
        setUiLoadedMarker(itemsGrid);
    }

    @Override
    public ExtendedWebElement getItemsGrid() {
        return itemsGrid;
    }

    @Override
    public List<ExtendedWebElement> getRemoveSingleItemButtons() {
        return removeSingleItemButtons;
    }

    @Override
    public ExtendedWebElement getSettingsButton() {
        return settingsButton;
    }

    @Override
    public ExtendedWebElement getRemoveAllItemsButton() {
        return removeAllItemsButton;
    }

    @Override
    public ExtendedWebElement getMoreSettingsHyperlink() {
        return moreSettingsHyperlink;
    }

    @Override
    public ExtendedWebElement getBrowsingHistoryToggle() {
        return browsingHistoryToggle;
    }

    @Override
    public ExtendedWebElement getBrowsingHistoryDisabledMessage() {
        return browsingHistoryDisabledMessage;
    }

    @Override
    public ExtendedWebElement getBrowsingHistoryPausedMessage() {
        return browsingHistoryPausedMessage;
    }

    @Override
    public ExtendedWebElement getNoViewedItemsMessage() {
        return noViewedItemsMessage;
    }
}