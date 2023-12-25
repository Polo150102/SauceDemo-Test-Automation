package test;
//You are automating the  https://www.saucedemo.com/ web application.

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.asserts.SoftAssert;
import pages.LoginPage;

//1. Purchase a product: Follow the complete buy flow of the page, selecting a random product,
// adding it to the cart, adding the personal data,
// and checking that you are successfully arriving at the “Thank you for your purchase” page.
//2. Removing elements of the shopping cart: Add 3 different elements to the shopping cart,
// enter the cart page, remove them, and check the shopping cart is empty.
//3. Logout: try to log out and check if you are correctly redirected to the login page.
//
//For this implementation, follow the rules described next:
//1. Page Object Model should be correctly implemented,
// reusing certain elements and defining base pages as needed for common methods and elements.
//2. Page factory is required.
//3. Before annotations should be used to manage preconditions,
// any other required annotations can be implemented as needed.
public class BaseTest {
    WebDriver driver = null;

    SoftAssert softAssert = null;

    @BeforeTest
    public void beforeTest()
    {
        driver = new ChromeDriver();
        softAssert = new SoftAssert();
    }

    @AfterTest
    public void afterTest()
    {
        softAssert.assertAll();
        //driver.close();
    }

    public LoginPage getLoginPage(){
        return new LoginPage(driver,"https://www.saucedemo.com/");
    }


    protected LoginPage loginSuccessful()
    {
        LoginPage loginPage = getLoginPage();

        loginPage.setUsernameInput("performance_glitch_user");

        softAssert.assertTrue(loginPage.getUsernameInput().contains("performance_glitch_user"),"Nombre de usuario incorrecto.");

        loginPage.setPswdInput("secret_sauce");
        softAssert.assertTrue(loginPage.getPswdInput().contains("secret_sauce"),"Contraseña incorrecta.");

        return loginPage;
    }

}
