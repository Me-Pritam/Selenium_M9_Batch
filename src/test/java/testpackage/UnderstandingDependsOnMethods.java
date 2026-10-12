package testpackage;

import org.testng.Reporter;
import org.testng.annotations.Test;

public class UnderstandingDependsOnMethods
{

    @Test
    public void logIn()
    {
        Reporter.log("The LogIn is Successful",true);
    }

    @Test(dependsOnMethods = "logIn")
    public void searchProduct()
    {
        Reporter.log("The Desired Product is searched",true);
    }

    @Test(dependsOnMethods = "searchProduct")
    public void goToProductPage()
    {
        Reporter.log("The Product Page is opened",true);
    }

    @Test(dependsOnMethods = "goToProductPage")
    public void AddProductToCart()
    {
        Reporter.log("The Product is added to Cart",true);
    }

    @Test(dependsOnMethods = "AddProductToCart")
    public void goToCart()
    {
        Reporter.log("The Cart Page is opened",true);
    }

    @Test(dependsOnMethods = "goToCart")
    public void changeQuantity()
    {
        Reporter.log("The Quantity is changed",true);
    }

    @Test(dependsOnMethods = "changeQuantity",enabled = false)
    public void purchaseProduct()
    {
        Reporter.log("The Product is purchased",true);
    }
}
