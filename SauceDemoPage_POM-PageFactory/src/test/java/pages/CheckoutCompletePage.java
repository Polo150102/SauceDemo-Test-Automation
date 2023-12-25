package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CheckoutCompletePage extends BasePage {

    @FindBy(css = "#header_container > div.header_secondary_container > span")
    private WebElement titlePage;

    @FindBy(css = "#checkout_complete_container > h2")
    private WebElement completeText;

    public CheckoutCompletePage(WebDriver driver)
    {
        super(driver);
    }

    public String getTitlePage()
    {
        this.isElementDisplayed(this.titlePage);
        return this.titlePage.getText();
    }

    public String getCompleteText()
    {
        this.isElementDisplayed(this.completeText);
        return this.completeText.getText();
    }

}
