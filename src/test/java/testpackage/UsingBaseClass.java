package testpackage;

import basepackage.DummyBaseClass;
import org.testng.Reporter;
import org.testng.annotations.Test;

public class UsingBaseClass extends DummyBaseClass
{
    @Test
    public void testMethod1()
    {
        Reporter.log("This is a Test method 1",true);
    }

    @Test
    public void testMethod2()
    {
        Reporter.log("This is a Test method 2",true);
    }
}
