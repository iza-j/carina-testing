package com.solvd.carinatesting;

import com.solvd.carinatesting.gui.pages.common.BrowsingHistoryPageBase;
import com.solvd.carinatesting.gui.pages.common.HomePageBase;
import com.solvd.carinatesting.gui.pages.common.SearchResultsPageBase;
import com.solvd.carinatesting.gui.pages.common.SignInPageBase;
import com.zebrunner.carina.core.IAbstractTest;
import com.zebrunner.carina.core.registrar.ownership.MethodOwner;
import com.zebrunner.carina.dataprovider.IAbstractDataProvider;
import com.zebrunner.carina.dataprovider.annotations.CsvDataSourceParameters;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.lang.invoke.MethodHandles;
import java.time.Duration;

public class AmazonWebTest implements IAbstractTest, IAbstractDataProvider {

    private static final Logger LOGGER = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());

    @Test(description = "Select a category from the search bar dropdown.")
    @MethodOwner(owner = "iza-j")
    public void selectCategoryTest() {
        HomePageBase homePage = initPage(getDriver(), HomePageBase.class);
        homePage.open();
        homePage.assertPageOpened();

        String wantedCategory = "books";
        String selectedCategory = homePage.getSearchBar().selectCategory(wantedCategory);
        Assert.assertEquals(selectedCategory.toLowerCase(), wantedCategory.toLowerCase(), "Category is incorrect.");
    }

    @Test(description = "Search for an item described in the search textbox.")
    @MethodOwner(owner = "iza-j")
    public void searchForItemTest() {
        HomePageBase homePage = initPage(getDriver(), HomePageBase.class);
        homePage.open();
        homePage.assertPageOpened();

        String wantedItem = "pratchett";
        SearchResultsPageBase searchResultsPage = homePage.getSearchBar().searchFor(wantedItem);
        searchResultsPage.assertPageOpened();
        Assert.assertNotNull(searchResultsPage.getSearchResultsContainer().getText(), "There's no text in search results container.");
    }

    @Test(description = "Sort items in the search results page.")
    @MethodOwner(owner = "iza-j")
    public void sortSearchResultsTest() {
        HomePageBase homePage = initPage(getDriver(), HomePageBase.class);
        homePage.open();
        homePage.assertPageOpened();

        SearchResultsPageBase searchResultsPage = homePage.getSearchBar().searchFor("design patterns");
        searchResultsPage.assertPageOpened();

        SearchResultsPageBase searchResultsPage2 = searchResultsPage.selectSortBy("Price: Low to High");
        searchResultsPage2.assertPageOpened();
        Assert.assertTrue(searchResultsPage2.getCurrentUrl().contains("&s=price-asc-rank"), "Unable to identify sorting parameter in URL.");
    }

    // path = csv file path located in src/test/resources
    // dsUid = name of column with data-source unique identifiers
    // dsArgs = names of columns containing test values
    @Test(description = "Log in, remove items from browsing history, and turn browsing history off.", dataProvider = "DataProvider")
    @MethodOwner(owner = "iza-j")
    @CsvDataSourceParameters(path = "web/credentials.csv", dsUid = "website", dsArgs = "test_email,test_password")
    public void clearBrowsingHistoryTest(String test_email, String test_password) throws InterruptedException {
        HomePageBase homePage = initPage(getDriver(), HomePageBase.class);
        homePage.open();
        homePage.assertPageOpened();

        SignInPageBase signInPageEmail = homePage.getNavigationToolBar().goToSignInPage();
        signInPageEmail.assertPageOpened();
        signInPageEmail.getEmailTextBox().type(test_email);
        signInPageEmail.getContinueButton().click();

        SignInPageBase signInPagePassword = initPage(getDriver(), SignInPageBase.class);
        signInPagePassword.assertPageOpened();
        signInPagePassword.getPasswordTextBox().type(test_password);
        signInPagePassword.getContinueButton().click();

        HomePageBase homePageLoggedIn = initPage(getDriver(), HomePageBase.class);
        homePageLoggedIn.assertPageOpened();
        homePageLoggedIn.openURL("https://www.amazon.com/Effective-Java-Joshua-Bloch/dp/0134685997");
        homePageLoggedIn.assertPageOpened();

        homePageLoggedIn.openURL("https://www.amazon.com/gp/history");
        BrowsingHistoryPageBase historyPage = initPage(getDriver(), BrowsingHistoryPageBase.class);
        historyPage.assertPageOpened();

        SoftAssert soft = new SoftAssert();
        soft.assertTrue(historyPage.getItemsGrid().getText().contains("Effective Java"), "Browsing history doesn't contain a test item.");
        soft.assertFalse(historyPage.getBrowsingHistoryDisabledMessage().isDisplayed(), "Browsing history had been already disabled.");
        soft.assertFalse(historyPage.getBrowsingHistoryPausedMessage().isDisplayed(), "Browsing history had been already paused.");

        historyPage.getSettingsButton().click();
        historyPage.getRemoveAllItemsButton().hover();
        Thread.sleep(300);
        historyPage.getRemoveAllItemsButton().click();
        historyPage.getMoreSettingsHyperlink().click();
        historyPage.getBrowsingHistoryToggle().click();

        WebDriverWait wait = new WebDriverWait(this.getDriver(), Duration.ofMillis(5000));
        wait.until(ExpectedConditions.visibilityOf(historyPage.getBrowsingHistoryDisabledMessage()));
        soft.assertTrue(historyPage.getBrowsingHistoryDisabledMessage().isDisplayed(), "Browsing history couldn't be disabled.");
        wait.until(ExpectedConditions.visibilityOf(historyPage.getNoViewedItemsMessage()));
        soft.assertFalse(historyPage.getItemsGrid().getText().contains("Effective Java"), "Browsing history contains removed item.");
        soft.assertAll();
    }
}