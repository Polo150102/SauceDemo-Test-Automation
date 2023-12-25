package test;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.InventoryProductsPage;
import pages.LoginPage;

public class LogoutTest extends BaseTest{

    //3. Logout: try to log out and check if you are correctly redirected to the login page.
    @Test
    public void testPurchaseAProduct()
    {
        LoginPage paginaLogeo = loginSuccessful();

        InventoryProductsPage inventoryProductsPage = paginaLogeo.clickOnLoginBtn();

        inventoryProductsPage.clickOnMenu();

        inventoryProductsPage.clickOnLogout();

        softAssert.assertEquals(driver.getCurrentUrl(),"https://www.saucedemo.com/","No estás en la página correcta.");
    }


}
