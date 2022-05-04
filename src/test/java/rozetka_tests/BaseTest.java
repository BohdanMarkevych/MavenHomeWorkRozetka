package rozetka_tests;

import model.SearchFilter;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import rozetka.pages.HomePage;
import rozetka.pages.SearchResultPage;
import rozetka.pages.ShoppingCartPage;
import util.PropertiesReader;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.io.File;


public class BaseTest {

    PropertiesReader pr = new PropertiesReader();
    WebDriver driver;

    @BeforeTest
    public void profileSetUp() {
        System.setProperty(pr.getDriverName(), pr.getDriverLocation());
    }

    @BeforeMethod
    public void testSetup() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get(pr.getURL());
    }

    @AfterMethod
    public void tearDown() {
        driver.close();
    }


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


}
