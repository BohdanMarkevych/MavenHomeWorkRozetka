package rozetka_tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import rozetka.pages.HomePage;
import rozetka.pages.SearchResultPage;


import javax.xml.bind.JAXBException;

public class AddToCartTest extends BaseTest {

    private static final long DEFAULT_WAITING_TIME = 500;

    @Test(dataProvider = "useFilterData")
    public void verifyThatCartContainsBillThatIsLessThanSpecifiedSum(String type, String brand, int sum) throws JAXBException, InterruptedException {

            HomePage homePage = getHomePage();
            homePage.implicitWait(DEFAULT_WAITING_TIME);
            SearchResultPage searchResultPage = homePage.searchByKeyword(type);
            searchResultPage.searchBrandByKeyword(brand);
            searchResultPage.implicitWait(DEFAULT_WAITING_TIME);
            searchResultPage.filterBrandInCheckBox();
            searchResultPage.implicitWait(DEFAULT_WAITING_TIME);
            searchResultPage.clickSortProductOptionButton();
            searchResultPage.implicitWait(DEFAULT_WAITING_TIME);
            searchResultPage.filterProductByPriceInOptionList();
            searchResultPage.implicitWait(DEFAULT_WAITING_TIME);
            searchResultPage.addFirstProductToCart();
            searchResultPage.implicitWait(DEFAULT_WAITING_TIME);
            searchResultPage.clickCartButton();
            searchResultPage.waitForVisibilityOfElement(20, getShoppingCartPage().getCartReceiptIcon());
            Assert.assertTrue(getShoppingCartPage().getSumInCart() < sum);

        }

    }

