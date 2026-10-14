package utilitypackage;

import org.openqa.selenium.InvalidArgumentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.time.Duration;

public class BrowserUtility
{
    ThreadLocal<WebDriver> tlDriver = new ThreadLocal<>();

    public void openBrowser(String browser)
    {
        switch (browser.toLowerCase())
        {
            case "chrome":

                tlDriver.set(new ChromeDriver());
                break;

            case "firefox":

                tlDriver.set(new FirefoxDriver());
                break;

            case "edge":

                tlDriver.set(new EdgeDriver());
                break;

            default: throw new InvalidArgumentException("Wrong Brower Name");
        }
    }

    public WebDriver getDriver()
    {
        return tlDriver.get();
    }

    public void openUrl(String url)
    {
        getDriver().get(url);
    }

    public void maximizeBrowser()
    {
        getDriver().manage().window().maximize();
    }

    public void waitForPageLoad(int time)
    {
        getDriver().manage().timeouts().pageLoadTimeout(Duration.ofSeconds(time));
    }

    public void waitForElement(int time)
    {
        getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(time));
    }

    public String getUrl()
    {
        return getDriver().getCurrentUrl();
    }

    public void closeBrowser()
    {
        if (getDriver()!=null)
        {
            getDriver().close();
        }

        tlDriver.remove();
    }
}
