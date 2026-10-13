package basepackage;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import pompackage.*;
import utilitypackage.ActionsUtility;
import utilitypackage.BrowserUtility;
import utilitypackage.PropertyFileUtility;

public class DesiredItemPurchasingE2eBase
{
    public String browser;
    public String url;
    public String username;
    public String password;
    public String desiredProduct;

    public LogInPagePOM login;
    public NavBarPOM navBar;
    public InventoryPagePOM inventory;
    public ProductPagePOM product;
    public CartPagePOM cart;

    public BrowserUtility browserUtils;
    public ActionsUtility actions;

    @BeforeTest
    public void loadConfiguration()
    {
        try
        {

            browser = PropertyFileUtility.getData("browser");
            username = PropertyFileUtility.getData("username");
            password = PropertyFileUtility.getData("password");
            url = PropertyFileUtility.getData("url");
            desiredProduct = PropertyFileUtility.getData("desiredProduct");

            browserUtils = new BrowserUtility();

        }
        catch (Exception e)
        {
            e.printStackTrace();
        }

    }

    @BeforeClass
    public void doConfiguration()
    {
        browserUtils.openBrowser(browser);
        browserUtils.maximizeBrowser();
        browserUtils.waitForPageLoad(10);
        browserUtils.openUrl(url);
        browserUtils.waitForElement(10);
    }
}
