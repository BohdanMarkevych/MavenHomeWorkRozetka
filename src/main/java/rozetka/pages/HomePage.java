package rozetka.pages;

import decoratorOne.TextInput;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage {

    @FindBy(xpath = "//input[@name='search']")
    private TextInput textInput;

    public HomePage(WebDriver driver) {
        super(driver);
    }

    public SearchResultPage searchByKeyword(String keyword){
        textInput.sendKeys(keyword, Keys.ENTER);
        return new SearchResultPage(driver);
    }

}
