package testpackage;

import org.testng.Reporter;
import org.testng.annotations.Test;

public class GroupExecutionClass1
{
    @Test(groups="System")
    public void m1()
    {
        Reporter.log("This is M1 Method from Class1",true);
    }

    @Test(groups="System")
    public void m2()
    {
        Reporter.log("This is M2 Method from Class1",true);
    }

    @Test(groups="System")
    public void m3()
    {
        Reporter.log("This is M3 Method from Class1",true);
    }
}
