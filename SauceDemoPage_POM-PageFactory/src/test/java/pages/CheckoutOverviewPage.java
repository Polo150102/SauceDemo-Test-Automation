package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CheckoutOverviewPage extends BasePage {

    @FindBy(css="#finish")
    private WebElement finishBox;

    public CheckoutOverviewPage(WebDriver driver)
    {
        super(driver);
    }

    public CheckoutCompletePage clickOnFinish()
    {
        isElementClickable(this.finishBox);
        finishBox.click();

        return new CheckoutCompletePage(this.driver);
    }

}
