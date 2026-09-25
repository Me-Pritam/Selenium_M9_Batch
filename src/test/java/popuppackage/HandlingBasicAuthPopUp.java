package popuppackage;

import org.openqa.selenium.Credentials;
import org.openqa.selenium.HasAuthentication;
import org.openqa.selenium.UsernameAndPassword;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.function.Supplier;

public class HandlingBasicAuthPopUp
{
    public static void main(String[] args) {

        try
        {
            WebDriver driver = new ChromeDriver();

            driver.manage().window().maximize();

            driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));

            HasAuthentication authentication = (HasAuthentication)driver;

            authentication.register(new Supplier<Credentials>(){

                @Override
                public Credentials get()
                {
                    return new UsernameAndPassword("admin","vinothqa");
                }

            });

            driver.get("https://vinothqaacademy.com/basic-auth-demo/protected/");
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }

    }
}
