package util;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class WebdriverSingletone {
    private static WebDriver driver;
    private static PropertiesReader propertiesReader = new PropertiesReader();

    public static void setProperties() {
        System.setProperty(propertiesReader.getDriverName(), propertiesReader.getDriverLocation());
    }


    /*public static WebDriver getDriver(){
        if (driver != null){ return driver;}
       else {
            driver = new ChromeDriver();
            driver.manage().window().maximize();
            driver.get(propertiesReader.getURL());
        }
        return driver;
    }*/

    public static void closeDriver() {
        driver.close();
        driver = null;
    }

}
