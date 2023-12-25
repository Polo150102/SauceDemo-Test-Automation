package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage{

    @FindBy(css = "form .form_group #user-name")
    private WebElement usernameInput;

    @FindBy(css = "#password")
    private WebElement pswdInput;

    @FindBy(css="#login-button")
    private WebElement loginBtn;

    public LoginPage(WebDriver driver, String url)
    {
        super(driver);
        this.driver.get(url);
    }

    public void setUsernameInput(String nameUser)
    {
        isElementDisplayed(this.usernameInput);
        this.usernameInput.sendKeys(nameUser);
    }

    public String getUsernameInput()
    {
        isElementDisplayed(this.usernameInput);
        return this.usernameInput.getAttribute("value");
    }

    public void setPswdInput(String pswdInput)
    {
        isElementDisplayed(this.pswdInput);
        this.pswdInput.sendKeys(pswdInput);
    }

    public String getPswdInput()
    {
        isElementDisplayed(this.pswdInput);
        return this.pswdInput.getAttribute("value");
    }
    public InventoryProductsPage clickOnLoginBtn()
    {
        isElementClickable(this.loginBtn);
        this.loginBtn.click();

        return new InventoryProductsPage(this.driver);
    }
}
