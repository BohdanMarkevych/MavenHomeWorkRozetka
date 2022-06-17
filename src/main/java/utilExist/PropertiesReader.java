package utilExist;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class PropertiesReader {


    final static String RPOPERTIES_PATH = "src/main/resources/config.properties";
    protected static Logger log = LogManager.getLogger(PropertiesReader.class);
    Properties properties = new Properties();


    public PropertiesReader() {
        FileInputStream fis;
        try {
            fis = new FileInputStream(RPOPERTIES_PATH);
            properties.load(fis);
            fis.close();
            log.info("Reading of properties file is correct");

        } catch (IOException e) {
            e.printStackTrace();
            log.error("ERROR: Properties file isn't found");
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
