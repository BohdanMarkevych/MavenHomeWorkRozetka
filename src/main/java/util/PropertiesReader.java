package util;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class PropertiesReader {

        Properties properties = new Properties();

        public PropertiesReader() {
            FileInputStream fis;
            try {
                fis = new FileInputStream("src/main/resources/config.properties");
                properties.load(fis);
                fis.close();

            } catch (IOException e) {
                e.printStackTrace();

            }
        }

    public String getURL() {
        String URL = properties.getProperty("URL");
        return URL;
    }

    public String getDriverName() {
        String driverName = properties.getProperty("CHROME_DRIVER_NAME");
        return driverName;
    }

    public String getDriverLocation() {
        String driverLocation = properties.getProperty("CHROME_DRIVER_LOCATION");
        return driverLocation;
    }

}
