package com.solvd.carinatesting;

import com.solvd.carinatesting.gui.pages.common.HomePageBase;
import com.solvd.carinatesting.gui.pages.common.SearchResultsPageBase;
import com.zebrunner.carina.core.IAbstractTest;
import com.zebrunner.carina.core.registrar.ownership.MethodOwner;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class AmazonWebTest implements IAbstractTest {

    @Test(description = "Select a category from the search bar dropdown.", enabled = true)
    @MethodOwner(owner = "iza-j")
    public void testSelectCategory() {
        HomePageBase homePage = initPage(getDriver(), HomePageBase.class);
        homePage.open();
        homePage.assertPageOpened();

        String wantedCategory = "books";
        String selectedCategory = homePage.getSearchBar().selectCategory(wantedCategory);
        Assert.assertEquals(selectedCategory.toLowerCase(), wantedCategory.toLowerCase());
    }

    @Test(description = "Search for an item described in the search textbox.", enabled = true)
    @MethodOwner(owner = "iza-j")
    public void testSearchFor() {
        HomePageBase homePage = initPage(getDriver(), HomePageBase.class);
        homePage.open();
        homePage.assertPageOpened();

        String wantedItem = "pratchett";
        SearchResultsPageBase searchResultsPage = homePage.getSearchBar().searchFor(wantedItem);
        searchResultsPage.assertPageOpened();
        Assert.assertNotNull(searchResultsPage.getSearchResultsContainer().getText());

//        List<ExtendedWebElement> searchResultsList = searchResultsPage.getSearchResultList();
//        for (int i = 0; i < searchResultsList.size(); i++) {
//            System.out.println("--------------------------- item no. " + i + " ---------------------------");
//            System.out.println(searchResultsList.get(i).getText());
//        }
    }

    @Test(description = "Sort items in the search results page.", enabled = true)
    @MethodOwner(owner = "iza-j")
    public void testSortBy() {
        HomePageBase homePage = initPage(getDriver(), HomePageBase.class);
        homePage.open();
        homePage.assertPageOpened();

        SearchResultsPageBase searchResultsPage = homePage.getSearchBar().searchFor("design patterns");
        searchResultsPage.assertPageOpened();

        SearchResultsPageBase searchResultsPage2 = searchResultsPage.selectSortBy("Price: Low to High");
        searchResultsPage2.assertPageOpened();
        Assert.assertTrue(searchResultsPage2.getCurrentUrl().contains("&s=price-asc-rank"));
    }
}