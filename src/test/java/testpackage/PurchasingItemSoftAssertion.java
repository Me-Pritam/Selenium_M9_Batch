package testpackage;

import basepackage.DesiredItemPurchasingE2eBase;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class PurchasingItemSoftAssertion extends DesiredItemPurchasingE2eBase
{

    @Test
    public void purchaseDesiredItem()
    {
        SoftAssert sAssert = new SoftAssert();


        sAssert.assertEquals(browserUtils.getUrl(),"https://www.saucedemo.com/inventory.html","The LogIn is unsuccessful");
        Reporter.log("The LogIn is Successful",true);


        inventory.selectDesiredItemByName(desiredProduct);

        sAssert.assertFalse(product.getAddToCartButton().isDisplayed(),"The Cart Button is not displayed");
        Reporter.log("The Cart Button is displayed",true);

        product.clickOnAddToCart();

        sAssert.assertFalse(navBar.getCartIcon().isDisplayed(),"The Cart Icon in NavBar is hidden ");
        Reporter.log("The Cart Icon in NavBar is displayed",true);

        navBar.clickOnCartIcon();

        sAssert.assertNotEquals(browserUtils.getUrl(),"https://www.saucedemo.com/cart.html","The Cart Page is not opened");
        Reporter.log("The Cart Page is opened",true);

        cart.clickOnCheckOutButton();

        sAssert.assertAll();

    }
}
