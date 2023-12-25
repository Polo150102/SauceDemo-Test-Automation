package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class ShoppingCartPage extends BasePage {

    @FindBy(className="title")
    private WebElement titlePage;

    @FindBy(id = "checkout")
    private WebElement continueCheckout;

    @FindBy(className = "cart_item")
    private List<WebElement> listaItemsCarrito;

    @FindBy(css = "[class*='btn'][class*='btn_secondary'][class*='btn_small'][class*='cart_button']")
    private List<WebElement> listaRemoverItem;

    public ShoppingCartPage(WebDriver driver)
    {
        super(driver);
        initElements();
    }

    public String getPageText()
    {
        this.isElementDisplayed(titlePage);
        return this.titlePage.getText();
    }
    public CheckoutPage clickOnCheckout(){
        isElementDisplayed(this.continueCheckout);
        this.continueCheckout.click();

        return new CheckoutPage(this.driver);
    }

    public void removeItem(int num){
        isElementClickable(this.listaRemoverItem.get(num));
        this.listaRemoverItem.get(num).click();
    }

    public boolean isTheShoppingCartEmpty() {
        return this.listaItemsCarrito.size() == 0;
    }

}
