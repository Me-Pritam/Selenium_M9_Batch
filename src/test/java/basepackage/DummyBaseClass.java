package basepackage;

import org.testng.Reporter;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.*;

public class DummyBaseClass
{
    @BeforeSuite
    public void beforeSuite()
    {
        Reporter.log("This is beforeSuite",true);
    }

    @BeforeTest
    public void beforeTest()
    {
        Reporter.log("This is beforeTest",true);
    }

    @BeforeClass
    public void beforeClass()
    {
        Reporter.log("This is beforeClass",true);
    }

    @BeforeMethod
    public void beforeMethod()
    {
        Reporter.log("This is beforeMethod",true);
    }

    @AfterMethod
    public void afterMethod()
    {
        Reporter.log("This is afterMethod",true);
    }

    @AfterClass
    public void afterClass()
    {
        Reporter.log("This is afterClass",true);
    }

    @AfterTest
    public void afterTest()
    {
        Reporter.log("This is afterTest",true);
    }

}
