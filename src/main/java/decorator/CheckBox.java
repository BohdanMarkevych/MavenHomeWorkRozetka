package decorator;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebElement;

public class CheckBox extends AbstractElement {
    public static Logger logger = LogManager.getLogger((CheckBox.class).toString());

    public CheckBox(WebElement webElement) {
        super(webElement);
    }

    public void setChecked(boolean shouldBeChecked) {
        if (webElement.isSelected() && !shouldBeChecked) {
            webElement.click();
        } else{
            System.out.println("Element is already checked." + shouldBeChecked);
            logger.info("Element is already checked.");
        }
    }
}
