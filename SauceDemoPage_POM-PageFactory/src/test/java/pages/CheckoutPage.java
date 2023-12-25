package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CheckoutPage extends BasePage {

    @FindBy(css="#first-name")
    WebElement firstNameInput;

    @FindBy(css="#last-name")
    WebElement lastNameInput;

    @FindBy(css="#postal-code")
    WebElement postalCodeInput;

    @FindBy(css="#continue")
    WebElement continueBox;

    public CheckoutPage(WebDriver driver)
    {
        super(driver);
    }

    public void setFirstNameInput(String nameText){
        isElementDisplayed(this.firstNameInput);
        this.firstNameInput.sendKeys(nameText);
    }

    public void setLastNameInput(String lastNameText)
    {
        isElementDisplayed(this.lastNameInput);
        this.lastNameInput.sendKeys(lastNameText);
    }

    public void setPostalCodeInput(String postalCodeText)
    {
        isElementDisplayed(this.postalCodeInput);
        this.postalCodeInput.sendKeys(postalCodeText);
    }

    public CheckoutOverviewPage clickOnContinue()
    {
        isElementClickable(this.continueBox);
        continueBox.click();

        return new CheckoutOverviewPage(this.driver);
    }


}
