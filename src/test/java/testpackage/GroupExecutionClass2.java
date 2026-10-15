package testpackage;

import org.testng.Reporter;
import org.testng.annotations.Test;

public class GroupExecutionClass2
{
    @Test(groups = "Integration")
    public void m4()
    {
        Reporter.log("This is M4 Method from Class2",true);
    }

    @Test(groups = {"Integration","System"})
    public void m5()
    {
        Reporter.log("This is M5 Method from Class2",true);
    }

    @Test(groups = "Integration")
    public void m6()
    {
        Reporter.log("This is M6 Method from Class2",true);
    }
}
