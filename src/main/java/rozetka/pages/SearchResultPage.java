package rozetka.pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class SearchResultPage extends BasePage {

    @FindBy(xpath = "//input[@_ngcontent-rz-client-c135]")
    private WebElement sidebarSearchInput;

    @FindBy(xpath = "//ul[@class='checkbox-filter']/descendant::a[@_ngcontent-rz-client-c137]")
    private List<WebElement> checkBoxBrandList;

    @FindBy(xpath = "//div[@class='goods-tile__inner']/descendant::app-buy-button[@extclass='goods-tile__buy-button']")
    private List<WebElement> AddProductToCartButtonList;

    @FindBy(xpath = "//select[@_ngcontent-rz-client-c184]")
    private WebElement sortProductButton;

    @FindBy(xpath = "//option[@class='ng-star-inserted']")
    private List<WebElement> sortProductButtonOptionsList;

    @FindBy(xpath = "//rz-cart/button[@type='button']")
    private WebElement cartButton;

    public WebElement getSidebarSearchInput() {
        return sidebarSearchInput;
    }

    public SearchResultPage(WebDriver driver) {
        super(driver);
    }

    public void searchBrandByKeyword(String keyword){
        sidebarSearchInput.clear();
        sidebarSearchInput.sendKeys(keyword, Keys.ENTER);
    }

    public void filterBrandInCheckBox(){
        checkBoxBrandList.get(0).click();
    }

    public void clickSortProductButton(){
        sortProductButton.click();
    }

    public void filterProductByPrice(){
        sortProductButtonOptionsList.get(0).click();
    }

    public void addFirstProductToCart(){
        AddProductToCartButtonList.get(0).click();
    }

    public void clickCartButton(){
        cartButton.click();
    }

}
