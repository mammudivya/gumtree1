package TestSteps;

import Base.ConfigReader;
import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.ScreenshotException;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Hooks {

    public static WebDriver driver;
    public static WebDriverWait wait;
    String browser= ConfigReader.user.getProperty("browser");

    @Before
    public void openBrowser()
    {

        switch (browser)
        {
            case "Chrome":
                System.setProperty("webdriver.chrome.driver","src/test/Resources/Drivers/chromedriver.exe");
                driver=new ChromeDriver();
                break;
           case "Firefox":
                System.setProperty("webdriver.gecko.driver","src/test/Resources/Drivers/geckodriver.exe");
                driver=new FirefoxDriver();
                break;

        }

        driver.manage().deleteAllCookies();
        driver.manage().window().maximize();
    }

    @After
    public void closeBroser(Scenario scenario)
    {
        if(scenario.isFailed())
        {
            try {
                scenario.write("Current Page Title :"+driver.getTitle());
                byte[] screenshot=((TakesScreenshot)driver).getScreenshotAs(OutputType.BYTES);
                scenario.embed(screenshot,"image/png");
            }catch(ScreenshotException e)
            {
                e.getMessage();
            }
        }
       // driver.close();
    }


}
