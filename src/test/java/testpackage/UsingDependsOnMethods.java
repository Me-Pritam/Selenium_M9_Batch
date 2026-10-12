package testpackage;

import org.testng.Reporter;
import org.testng.annotations.Test;

public class UsingDependsOnMethods
{
    @Test
    public void logIn()
    {
        Reporter.log("LogIn is Successful",true);
    }

    @Test(dependsOnMethods = "logIn",priority = -1)
    public void friendRequest()
    {
        Reporter.log("Friend Request is successful",true);
    }

    @Test(dependsOnMethods = {"logIn","friendRequest"},enabled = false)
    public void notification()
    {
        Reporter.log("Notification is received",true);
    }
}
