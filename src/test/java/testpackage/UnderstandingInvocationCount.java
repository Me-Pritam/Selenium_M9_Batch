package testpackage;

import org.testng.Reporter;
import org.testng.annotations.Test;

public class UnderstandingInvocationCount
{


    @Test(invocationCount = 5)
    public void actionMethod()
    {
         Reporter.log("Action is performed",true);
    }
}
