package rozetka_tests;

import listeners.TestListener;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import rozetka.pages.HomePage;
import rozetka.pages.SearchResultPage;


@Listeners({TestListener.class})
public class AddToCartTest extends BaseTest {

    private static final long DEFAULT_WAITING_TIME = 800;


    @Test(dataProvider = "useFilterData")
    public void verifyThatCartContainsBillThatIsLessThanSpecifiedSum(String type, String brand, int sum) {
        logger.info("The test started");
        HomePage homePage = getHomePage();
        homePage.implicitWait(DEFAULT_WAITING_TIME);
        SearchResultPage searchResultPage = homePage.searchByKeyword(type);
        searchResultPage.searchBrandByKeyword(brand);
        searchResultPage.implicitWait(DEFAULT_WAITING_TIME);
        searchResultPage.filterBrandInCheckBox();
        searchResultPage.implicitWait(DEFAULT_WAITING_TIME);
        searchResultPage.clickSortProductOptionButton();
        searchResultPage.filterProductByPriceInOptionList();
        searchResultPage.implicitWait(DEFAULT_WAITING_TIME);
        searchResultPage.addFirstProductToCart();
        searchResultPage.implicitWait(DEFAULT_WAITING_TIME);
        searchResultPage.clickCartButton();
        searchResultPage.waitForVisibilityOfElement(20, getShoppingCartPage().getCartReceiptIcon());
        Assert.assertTrue(getShoppingCartPage().getSumInCart() < sum);
        logger.info("The test finished");
    }

}

