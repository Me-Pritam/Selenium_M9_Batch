package basepackage;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import pompackage.*;
import utilitypackage.ActionsUtility;
import utilitypackage.BrowserUtility;
import utilitypackage.PropertyFileUtility;

public class ParallelMethodBaseClass
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

//    public WebDriver driver;

    @BeforeMethod
    public void loadConfiguration()
    {
        try
        {

            browser = PropertyFileUtility.getData("browser");
            username = PropertyFileUtility.getData("username");
            password = PropertyFileUtility.getData("password");
            url = PropertyFileUtility.getData("url");
            desiredProduct = PropertyFileUtility.getData("desiredProduct");

        }
        catch (Exception e)
        {
            e.printStackTrace();
        }

    }

    @BeforeMethod(dependsOnMethods = "loadConfiguration")
    public void performParallelOperation()
    {
        browserUtils = new BrowserUtility();

        browserUtils.openBrowser(browser);
        browserUtils.maximizeBrowser();
        browserUtils.waitForPageLoad(10);
        browserUtils.openUrl(url);
        browserUtils.waitForElement(10);

//        driver = browserUtils.getDriver();


        login = new LogInPagePOM(browserUtils.getDriver());
        navBar = new NavBarPOM(browserUtils.getDriver());
        inventory = new InventoryPagePOM(browserUtils.getDriver());
        product = new ProductPagePOM(browserUtils.getDriver());

        login.performLogIn(username,password);


    }
}
