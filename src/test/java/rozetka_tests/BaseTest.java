package rozetka_tests;

import model.SearchFilter;
import model.SearchFilters;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import rozetka.pages.HomePage;
import rozetka.pages.SearchResultPage;
import rozetka.pages.ShoppingCartPage;
import util.PropertiesReader;
import util.WebdriverSingletone;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.io.File;


public class BaseTest {

    PropertiesReader pr = new PropertiesReader();
    WebDriver driver;

    /*@BeforeTest
    public void profileSetUp() {
        System.setProperty(pr.getDriverName(), pr.getDriverLocation());
    }*/

    @BeforeTest
    public void profileSetUp() { WebdriverSingletone.setProperties(); }

    @BeforeMethod
    public void testSetup() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get(pr.getURL());
    }

    /*@BeforeMethod
    public void testSetup() {
        WebdriverSingletone.setChromeDriver();
    }*/


    /*@BeforeMethod
    public void testSetup() { WebdriverSingletone.getDriver(); }*/

    @AfterMethod
    public void tearDown() {
        driver.close();
    }

    /*@AfterMethod
    public void tearDown() {
        WebdriverSingletone.closeDriver();
    }*/

    public WebDriver getDriver() {
        return driver;
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

    @DataProvider(name = "useFilterData", parallel = true)
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
