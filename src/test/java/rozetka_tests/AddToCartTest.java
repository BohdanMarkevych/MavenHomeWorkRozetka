package rozetka_tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import rozetka.pages.HomePage;
import rozetka.pages.SearchResultPage;


import static util.XMLToObject.useSearchFilter;

public class AddToCartTest extends BaseTest {

    private static final long DEFAULT_WAITING_TIME = 90;

   @Test
   public void verifyThatCartContainsBillThatIsLessThanSpecifiedSum() {
       HomePage homePage = getHomePage();
       SearchResultPage searchResultPage = homePage.searchByKeyword(useSearchFilter().getProductType());
       searchResultPage.implicitWait(DEFAULT_WAITING_TIME);
       searchResultPage.searchBrandByKeyword(useSearchFilter().getBrand());
       searchResultPage.implicitWait(DEFAULT_WAITING_TIME);
       searchResultPage.filterBrandInCheckBox();
       searchResultPage.implicitWait(DEFAULT_WAITING_TIME);
       searchResultPage.clickSortProductButton();
       searchResultPage.implicitWait(DEFAULT_WAITING_TIME);
       searchResultPage.filterProductByPrice();
       searchResultPage.implicitWait(DEFAULT_WAITING_TIME);
       searchResultPage.addFirstProductToCart();
       searchResultPage.implicitWait(DEFAULT_WAITING_TIME);
       searchResultPage.clickCartButton();
       searchResultPage.waitForVisibilityOfElement(20, getShoppingCartPage().getCartReceiptIcon());
       Assert.assertTrue(getShoppingCartPage().getSumInCart() < useSearchFilter().getAllowedSum());
   }

}
