package test;
import org.testng.annotations.Test;
import pages.*;

public class RemovingElementsShoppingCartTest extends BaseTest{

    //2. Removing elements of the shopping cart: Add 3 different elements to the shopping cart,
    // enter the cart page, remove them, and check the shopping cart is empty.
    @Test
    public void testRemovingElementsShoppingCart(){

        LoginPage paginaLogeo = loginSuccessful();

        InventoryProductsPage inventoryProductsPage = paginaLogeo.clickOnLoginBtn();

        inventoryProductsPage.clickOnAddToCart(2);
        inventoryProductsPage.clickOnAddToCart(5);

        InventoryDetailsPage inventoryDetailsPage = inventoryProductsPage.clickOnNameProduct(3);
        inventoryDetailsPage.clickOnAddToCart();

        inventoryProductsPage = inventoryDetailsPage.clickOnBackToProducts();

        ShoppingCartPage shoppingCartPage = inventoryProductsPage.goToCart();

        softAssert.assertEquals(shoppingCartPage.getPageText(),"Your Cart");

        shoppingCartPage.removeItem(0);
        shoppingCartPage.removeItem(0);
        shoppingCartPage.removeItem(0);

        softAssert.assertTrue(shoppingCartPage.isTheShoppingCartEmpty(),"El carrito de compra no esta vacio.");

    }
}
