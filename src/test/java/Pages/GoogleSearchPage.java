package Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

import static org.openqa.selenium.By.name;

public class GoogleSearchPage
{

    @FindBy(name="q")
    public static WebElement searchWindow;

    @FindBy(id="resultStats")
    private static WebElement waitResults;

    @FindBy(xpath = "//*[@id='rso']//h3/a")
    public static List<WebElement> searchResults;


}
