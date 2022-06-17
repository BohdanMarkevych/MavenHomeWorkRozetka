package rozetka_tests;


import modelExist.SearchFilters;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import rozetka.pages.HomePage;
import rozetka.pages.SearchResultPage;
import rozetka.pages.ShoppingCartPage;

import utilExist.WebdriverMultitone;


import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.io.File;


public class BaseTest {
    public WebDriver getDriver() { return WebdriverMultitone.getMultiDriver(); }
    protected static Logger logger = LogManager.getLogger(BaseTest.class);

    @BeforeTest
    public void set() {
        WebdriverMultitone.setProperties();
        logger.info("Let's start");
    }

    @BeforeMethod
    public void setUpTest() {
        getDriver();
    }

    @AfterMethod
    public void close() {
        WebdriverMultitone.closeMultiDriver();
    }

    public HomePage getHomePage() {
        return new HomePage(getDriver());
    }

    public SearchResultPage getSearchResultPage() {
        return new SearchResultPage(getDriver());
    }

    public ShoppingCartPage getShoppingCartPage() {
        return new ShoppingCartPage(getDriver());
    }

    //@DataProvider(name = "useFilterData", parallel = true)
    @DataProvider(name = "useFilterData")
    public static Object[][] useFilterData() throws JAXBException {
        File file = new File("src\\main\\resources\\searchFilters.xml");
        JAXBContext jaxbContext = JAXBContext.newInstance(SearchFilters.class);
        Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
        SearchFilters searchFilters = (SearchFilters) unmarshaller.unmarshal(file);
        Object[][] searchFiltersArray = searchFilters.getSearchFilterList().stream()
                .map(x -> new Object[]{
                        x.getProductType(), x.getBrand(), x.getAllowedSum()
                }).toArray(Object[][]::new);
        return searchFiltersArray;
    }


}
