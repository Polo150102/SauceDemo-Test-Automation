package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class InventoryDetailsPage extends BasePage{

    @FindBy(css = "[class*='btn_primary'][class*='btn_small'][class*='btn_inventory']")
    private WebElement btnAddToCart;

    @FindBy(className="shopping_cart_link")
    private WebElement myCartOption;

    @FindBy(css="#back-to-products")
    private WebElement btnBackToProducts;

    public InventoryDetailsPage(WebDriver driver){
        super(driver);
    }

    public void getPageText()
    {

    }
    public void clickOnAddToCart()
    {
        isElementClickable(this.btnAddToCart);
        this.btnAddToCart.click();
    }

    public ShoppingCartPage goToCart()
    {
        isElementDisplayed(this.myCartOption);
        this.myCartOption.click();

        return new ShoppingCartPage(driver);
    }


    public InventoryProductsPage clickOnBackToProducts(){
        isElementClickable(this.btnBackToProducts);
        this.btnBackToProducts.click();

        return new InventoryProductsPage(driver);
    }

}
