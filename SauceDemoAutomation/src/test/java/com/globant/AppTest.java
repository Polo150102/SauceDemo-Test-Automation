package com.globant;

import com.sun.nio.file.ExtendedOpenOption;
import io.netty.util.Timeout;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;

public class AppTest {

    private WebDriver driver = new ChromeDriver();

    private WebElement usernameInput;
    private WebElement pswdInput;
    private WebElement loginBtn;

    //a. Implicit Wait:
    @Test
    public void testImplicitWaitLogin()
    {
        driver.get("https://www.saucedemo.com/");

        //Set an implicit wait for 10 seconds using the WebDriver instance.
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        //Find the necessary elements using the locators and perform actions like sending keys to the username and password fields.
        usernameInput = driver.findElement(By.cssSelector("form .form_group #user-name"));
        usernameInput.sendKeys("standard_user");

        pswdInput = driver.findElement(By.cssSelector("#password"));
        pswdInput.sendKeys("secret_sauce");
        //Click on the login button.
        loginBtn = driver.findElement(By.cssSelector("#login-button"));
        loginBtn.click();
        //Observe how the implicit wait handles the delay between element searches and actions.


        if(driver.getCurrentUrl().equals("https://www.saucedemo.com/inventory.html"))
        {
            System.out.println("Login successful!");
        }
        else{
            System.out.println("Login failed!");
        }

        driver.close();
    }

    //b. Explicit Wait with Expected Conditions:
    @Test
    public void testExplicitWaitLogin()
    {
        driver.get("https://www.saucedemo.com/");
        //Set an explicit wait using the WebDriverWait class.
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));

        //Implement a wait condition for the visibility of the username input field.
        usernameInput = wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("form .form_group #user-name")));
        wait.until(ExpectedConditions.visibilityOf(usernameInput));

        //Once the element is visible, send keys to the username field.
        Assert.assertTrue(usernameInput.isDisplayed());
        usernameInput.sendKeys("error_user");

        //Implement a wait condition for the visibility of the password input field.
        pswdInput = wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("#password")));
        wait.until(ExpectedConditions.visibilityOf(pswdInput));

        //Once the element is    visible, send keys to the password field.
        Assert.assertTrue(pswdInput.isDisplayed());
        pswdInput.sendKeys("secret_sauce");
        //Implement a wait condition for the element to be clickable for the login button.
        loginBtn = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("#login-button")));
        //Once the button is clickable, click on it.
        Assert.assertTrue(loginBtn.isEnabled());
        loginBtn.click();

        //Observe how the explicit wait waits for the specific conditions before performing actions.

        if(driver.getCurrentUrl().equals("https://www.saucedemo.com/inventory.html"))
        {
            System.out.println("Login successful!");
        }
        else{
            System.out.println("Login failed!");
        }

        //driver.close();
    }

    //c. Fluent Wait
    @Test
    public void testFluentWaitLogin()
    {
        driver.get("https://www.saucedemo.com/");
        //Implement a fluent wait using the Wait and FluentWait classes.
        //Customize the wait conditions and polling interval according to the web page behavior..
        Wait<WebDriver> wait = new FluentWait<>(driver)
                .withTimeout(Duration.ofSeconds(30))
                .pollingEvery(Duration.ofSeconds(5))
                .ignoring(NoSuchElementException.class);

        //Use fluent wait to wait for the presence of the username input field.
        usernameInput = wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("form .form_group #user-name")));

        //Once the element is present, send keys to the username field.
        Assert.assertTrue(usernameInput.isDisplayed());
        usernameInput.sendKeys("visual_user");

        //Use fluent wait to wait for the presence of the password input field.
        pswdInput = wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("#password")));

        //Once the element is present, send keys to the password field.
        Assert.assertTrue(pswdInput.isDisplayed());
        pswdInput.sendKeys("secret_sauce");

        //Use fluent wait to wait for the element to be clickable for the login button.
        loginBtn = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("#login-button")));

        //Once the button is clickable, click on it.
        loginBtn.isEnabled();
        loginBtn.click();

        //Observe how fluent wait provides flexibility in setting up wait conditions.

        if(driver.getCurrentUrl().equals("https://www.saucedemo.com/inventory.html"))
        {
            System.out.println("Login successful!");
        }
        else{
            System.out.println("Login failed!");
        }

        driver.quit();

    }
}
