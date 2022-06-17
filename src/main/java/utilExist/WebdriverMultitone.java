package utilExist;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class WebdriverMultitone {
    private static ThreadLocal<WebDriver> driver = new ThreadLocal<WebDriver>();
    private static PropertiesReader pr = new PropertiesReader();


    public static WebDriver getMultiDriver() {
        if(driver.get()!=null){
            return driver.get();
        }
        WebDriver instance;
        instance = new ChromeDriver(){
            {manage().window().maximize();
                get(pr.getURL());
            }
        };

        driver.set(instance);
        return driver.get();
    }

    public static void setProperties() {
        System.setProperty(pr.getDriverName(), pr.getDriverLocation());
    }

    public static void closeMultiDriver() {
        try{
            if(driver != null){
                driver.get().quit();
            }
        }catch (Exception e){
            System.err.println("Webdriver isn't closed");

        }finally {
            driver.remove();
        }
    }
}
