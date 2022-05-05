package util;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class WebdriverMultitone {
    private static ThreadLocal<WebDriver> driver = new ThreadLocal<WebDriver>();
    private static PropertiesReader propertiesReader = new PropertiesReader();


    public static void closeMultiDriver() {
        try{
            if(driver != null){
                driver.get().quit();
            }
        }catch (Exception e){
            System.err.println("Cant close Webdriver");

        }finally {
            driver.remove();
        }
    }

    public static WebDriver getMultiDriver() {
        if(driver.get()!=null){
            return driver.get();
        }
        WebDriver instance;
        instance = new ChromeDriver(){
            {manage().window().maximize();
                get(propertiesReader.getURL());
            }
        };

        driver.set(instance);
        return driver.get();
    }
}
