package testpackage;

import basepackage.DesiredItemPurchasingE2eBase;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

public class PurchasingDesiredItem extends DesiredItemPurchasingE2eBase
{

    @Test
    public void selectDesiredProduct()
    {
        Assert.assertEquals(browserUtils.getUrl(),"https://www.saucedemo.com/inventory.html","The LogIn is unsuccessful");
        Reporter.log("The LogIn is Successful",true);

        inventory.selectDesiredItemByName(desiredProduct);

        Assert.fail("Failed Intentionally");
    }

    @Test(dependsOnMethods = "selectDesiredProduct")
    public void addItemToCart()
    {
        Assert.assertTrue(product.getAddToCartButton().isDisplayed(),"The Cart Button is not displayed");
        Reporter.log("The Cart Button is displayed",true);

        product.clickOnAddToCart();
    }

    @Test(dependsOnMethods = "addItemToCart")
    public void goToCartPage()
    {
        Assert.assertTrue(navBar.getCartIcon().isDisplayed(),"The Cart Icon in NavBar is hidden ");
        Reporter.log("The Cart Icon in NavBar is displayed",true);

        navBar.clickOnCartIcon();
    }

    @Test(dependsOnMethods = "goToCartPage")
    public void checkOutProduct()
    {
        Assert.assertEquals(browserUtils.getUrl(),"https://www.saucedemo.com/cart.html","The Cart Page is not opened");
        Reporter.log("The Cart Page is opened",true);

        cart.clickOnCheckOutButton();
    }
}
