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

    @FindBy(xpath = "//ul[@class='checkbox-filter']/descendant::a[@_ngcontent-rz-client-c137][1]")
    private WebElement checkBoxBrandElement;

    @FindBy(xpath = "//div[@class='goods-tile__inner']/descendant::app-buy-button[@extclass='goods-tile__buy-button']")
    private List<WebElement> AddProductToCartButtonList;

    @FindBy(xpath = "//div[@class='goods-tile__inner']/descendant::app-buy-button[@extclass='goods-tile__buy-button'][1]")
    private WebElement AddProductToCartPanel;



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
        waitReadyStatementOfElement(40, getSidebarSearchInput());
        sidebarSearchInput.sendKeys(keyword, Keys.ENTER);
    }

    public WebElement getSortProductButton() {
        return sortProductButton;
    }

    public void filterBrandInCheckBox(){
        waitForPageLoadComplete(50);
        //waitReadyStatementOfElement(40, checkBoxBrandElement);
        checkBoxBrandList.get(0).click();
    }


    public void clickSortProductOptionButton(){
        waitReadyStatementOfElement(40, getSortProductButton());
        sortProductButton.click();
    }

    public void filterProductByPriceInOptionList(){
        waitForPageLoadComplete(50);
        sortProductButtonOptionsList.get(0).click();
    }



    public void addFirstProductToCart(){
        waitForPageLoadComplete(50);
        waitReadyStatementOfElement(40, AddProductToCartPanel);
        AddProductToCartButtonList.get(0).click();
    }


    public void clickCartButton(){
        cartButton.click();
    }

}
