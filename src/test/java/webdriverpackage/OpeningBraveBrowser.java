package webdriverpackage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class OpeningBraveBrowser
{
    public static void main(String[] args) {

        try
        {
            ChromeOptions options = new ChromeOptions();

//            options.setBinary("C:\\Program Files\\BraveSoftware\\Brave-Browser\\Application\\brave.exe");

            options.setBinary("C:\\Users\\User\\AppData\\Local\\Programs\\Opera\\opera.exe");

            WebDriver driver = new ChromeDriver(options);
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }

    }
}
