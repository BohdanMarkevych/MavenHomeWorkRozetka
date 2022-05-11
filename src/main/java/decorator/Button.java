package decorator;

import org.openqa.selenium.ElementClickInterceptedException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import util.WebdriverMultitone;

import java.time.Duration;

public class Button extends AbstractElement {

    public Button(WebElement webElement) {
        super(webElement);
    }

        public void click() {
            try {
                webElement.click();
            } catch (ElementClickInterceptedException e){
                new WebDriverWait(WebdriverMultitone.getMultiDriver(), Duration.ofSeconds(60)).until(ExpectedConditions.elementToBeClickable(webElement));
            }
    }
}
