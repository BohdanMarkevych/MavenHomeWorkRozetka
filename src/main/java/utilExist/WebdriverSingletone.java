package utilExist;

import org.openqa.selenium.WebDriver;

public class WebdriverSingletone {
    private static WebDriver driver;
    private static PropertiesReader propertiesReader = new PropertiesReader();

    public static void setProperties() {
        System.setProperty(propertiesReader.getDriverName(), propertiesReader.getDriverLocation());
    }


    public static void closeDriver() {
        driver.close();
        driver = null;
    }

}
