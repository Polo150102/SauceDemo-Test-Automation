package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import test.BaseTest;

import java.time.Duration;
import java.util.List;
import java.util.Random;

public class BasePage {

    WebDriver driver;
    WebDriverWait explicitWait;

    public BasePage(WebDriver driver)
    {
        this.driver = driver;
        initElements();
        explicitWait = new WebDriverWait(driver, Duration.ofSeconds(20));
    }

    protected void isElementDisplayed(WebElement element)
    {
        explicitWait.until(ExpectedConditions.visibilityOf(element));
    }

    protected void isElementClickable(WebElement element)
    {
        explicitWait.until(ExpectedConditions.elementToBeClickable(element));
    }

    protected void isListElementsVisible(List<WebElement> lstElement)
    {
        List<WebElement> listaElementos = explicitWait.until(ExpectedConditions.visibilityOfAllElements(lstElement));
    }

    protected static int generarNumeroAleatorio(int min, int max) {
        Random random = new Random();
        return random.nextInt((max - min) + 1) + min;
    }

    protected void initElements() {
        PageFactory.initElements(driver, this);
    }

}
