package testpackage;

import basepackage.ParallelMethodBaseClass;
import org.testng.annotations.Test;

public class ParallelMethodAddBagAndLightToCart extends ParallelMethodBaseClass
{
    @Test
    public void addBagToCart()
    {
        inventory.selectDesiredItemByName("Sauce Labs Backpack");
        product.clickOnAddToCart();
    }

    @Test
    public void addLightToCart()
    {
        inventory.selectDesiredItemByName("Sauce Labs Bike Light");
        product.clickOnAddToCart();
    }
}
