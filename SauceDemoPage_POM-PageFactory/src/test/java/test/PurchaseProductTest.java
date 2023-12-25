package test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.*;

import java.util.ArrayList;
import java.util.List;

public class PurchaseProductTest extends BaseTest{
    //1. Purchase a product: Follow the complete buy flow of the page, selecting a random product,
    // adding it to the cart, adding the personal data,
    // and checking that you are successfully arriving at the “Thank you for your purchase” page.
    @Test
    public void testPurchaseAProduct()
    {
        LoginPage paginaLogeo = loginSuccessful();

        InventoryProductsPage invProductsPage = paginaLogeo.clickOnLoginBtn();

        softAssert.assertEquals(invProductsPage.getPageText(),"Products");

        invProductsPage.clickOnAddToCartRandomly();

        InventoryDetailsPage inventoryDetailsPage = invProductsPage.clickOnNameProductRandomly();

        inventoryDetailsPage.clickOnAddToCart();
        ShoppingCartPage shoppingCartPage = inventoryDetailsPage.goToCart();

        softAssert.assertEquals(shoppingCartPage.getPageText(),"Your Cart");

        CheckoutPage checkoutPage = shoppingCartPage.clickOnCheckout();

        checkoutPage.setFirstNameInput("Alejandro");
        checkoutPage.setLastNameInput("Andrade Noa");
        checkoutPage.setPostalCodeInput("15054");

        CheckoutOverviewPage checkoutOverviewPage = checkoutPage.clickOnContinue();


        CheckoutCompletePage checkoutCompletePage = checkoutOverviewPage.clickOnFinish();

        softAssert.assertEquals(checkoutCompletePage.getTitlePage(),"Checkout: Complete!");
        softAssert.assertEquals(checkoutCompletePage.getCompleteText(),"Thank you for your order!");
    }
}
