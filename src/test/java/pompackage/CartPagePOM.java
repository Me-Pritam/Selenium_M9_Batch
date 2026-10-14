package pompackage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class CartPagePOM
{
    @FindBy(xpath = "//div[@class='cart_item']")
    private List<WebElement> allProductCards;

    @FindBy(xpath = "//button[@name='continue-shopping']")
    private WebElement continueShoppingButton;

    @FindBy(xpath = "//button[text()='Checkout']")
    private WebElement checkOutButton;

    public CartPagePOM(WebDriver driver)
    {
        PageFactory.initElements(driver,this);
    }

    public List<WebElement> getAllProductCards() {
        return allProductCards;
    }

    public WebElement getContinueShoppingButton() {
        return continueShoppingButton;
    }

    public WebElement getCheckOutButton() {
        return checkOutButton;
    }

    public int getProductCountInCart()
    {
        return getAllProductCards().size();
    }

    public void removeDesiredProductFromCart(String desiredProductName)
    {
        for(WebElement actualProductName : getAllProductCards())
        {
            if (actualProductName.getText().equals(desiredProductName))
            {
                actualProductName.findElement(By.xpath("./descendant::button[@class='btn btn_secondary btn_small cart_button']"))
                        .click();

                break;
            }
        }
    }

    public void clickOnContinueButton()
    {
        continueShoppingButton.click();
    }

    public void clickOnCheckOutButton()
    {
        checkOutButton.click();
    }
}
