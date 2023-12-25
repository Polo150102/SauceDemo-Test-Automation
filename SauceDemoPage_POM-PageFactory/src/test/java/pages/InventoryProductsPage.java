package pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.ArrayList;
import java.util.List;

public class InventoryProductsPage extends BasePage{

    @FindBy(className = "title")
    private WebElement pageTitle;

    @FindBy(css="#react-burger-menu-btn")
    private WebElement btnMenu;

    @FindBy(id = "logout_sidebar_link")
    private WebElement btnLogout;

    @FindBy(css = ".inventory_item_name")
    private List<WebElement> lstProductos = new ArrayList<>();

    @FindBy(css = "#add-to-cart-sauce-labs-backpack")
    private WebElement btnAddToCartProduct1;

    @FindBy(css = "#add-to-cart-sauce-labs-bike-light")
    private WebElement btnAddToCartProduct2;

    @FindBy(css = "#add-to-cart-sauce-labs-bolt-t-shirt")
    private WebElement btnAddToCartProduct3;
    @FindBy(css = "#add-to-cart-sauce-labs-fleece-jacket")
    private WebElement btnAddToCartProduct4;
    @FindBy(css = "#add-to-cart-sauce-labs-onesie")
    private WebElement btnAddToCartProduct5;
    @FindBy(css = "#add-to-cart-test\\.allthethings\\(\\)-t-shirt-\\(red\\)")
    private WebElement btnAddToCartProduct6;

    @FindBy(className="shopping_cart_link")
    private WebElement myCartOption;

    public InventoryProductsPage(WebDriver driver)
    {
        super(driver);
        initElements();
    }

    public String getPageText()
    {
        this.isElementDisplayed(this.pageTitle);
        return this.pageTitle.getText();
    }

    public int chooseProductRandomly()
    {
        isListElementsVisible(this.lstProductos);

        int numProductAleatorio = generarNumeroAleatorio(0,this.lstProductos.size()-1);

        return numProductAleatorio;
    }

    public void clickOnAddToCartRandomly()
    {
        int numProducto = chooseProductRandomly();

        switch(numProducto)
        {
            case 1:
                isElementDisplayed(this.btnAddToCartProduct1);
                this.btnAddToCartProduct1.click();
                break;
            case 2:
                isElementDisplayed(btnAddToCartProduct2);
                btnAddToCartProduct2.click();
                break;
            case 3:
                isElementDisplayed(this.btnAddToCartProduct3);
                this.btnAddToCartProduct3.click();
                break;
            case 4:
                isElementDisplayed(this.btnAddToCartProduct4);
                this.btnAddToCartProduct4.click();
                break;
            case 5:
                isElementDisplayed(this.btnAddToCartProduct5);
                this.btnAddToCartProduct5.click();
                break;
            case 6:
                isElementDisplayed(this.btnAddToCartProduct6);
                this.btnAddToCartProduct6.click();
                break;
        }

    }

    public void clickOnAddToCart(int numProducto){
        switch(numProducto)
        {
            case 1:
                isElementDisplayed(this.btnAddToCartProduct1);
                this.btnAddToCartProduct1.click();
                break;
            case 2:
                isElementDisplayed(btnAddToCartProduct2);
                btnAddToCartProduct2.click();
                break;
            case 3:
                isElementDisplayed(this.btnAddToCartProduct3);
                this.btnAddToCartProduct3.click();
                break;
            case 4:
                isElementDisplayed(this.btnAddToCartProduct4);
                this.btnAddToCartProduct4.click();
                break;
            case 5:
                isElementDisplayed(this.btnAddToCartProduct5);
                this.btnAddToCartProduct5.click();
                break;
            case 6:
                isElementDisplayed(this.btnAddToCartProduct6);
                this.btnAddToCartProduct6.click();
                break;
        }
    }

    public InventoryDetailsPage clickOnNameProductRandomly()
    {
        int numProducto = chooseProductRandomly();
        isElementClickable(this.lstProductos.get(numProducto));
        this.lstProductos.get(numProducto).click();

        return new InventoryDetailsPage(driver);
    }

    public InventoryDetailsPage clickOnNameProduct(int numProducto)
    {
        isElementClickable(this.lstProductos.get(numProducto));
        this.lstProductos.get(numProducto).click();

        return new InventoryDetailsPage(driver);
    }

    public void clickOnMenu()
    {
        isElementClickable(this.btnMenu);
        this.btnMenu.click();
    }

    public void clickOnLogout(){
        isElementClickable(this.btnLogout);
        this.btnLogout.click();
    }

    public ShoppingCartPage goToCart()
    {
        isElementDisplayed(this.myCartOption);
        this.myCartOption.click();

        return new ShoppingCartPage(driver);
    }
}
