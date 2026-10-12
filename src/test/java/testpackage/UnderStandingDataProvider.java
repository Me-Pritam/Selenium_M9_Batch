package testpackage;

import org.testng.Reporter;
import org.testng.annotations.Test;

public class UnderStandingDataProvider
{
    @Test(dataProviderClass = dataproviderpackage.DataStorage.class,dataProvider ="ExcelDataProvider")
    public void testMethod(String product, String price)
    {
        Reporter.log(product+" ---> "+price,true);
    }
}
