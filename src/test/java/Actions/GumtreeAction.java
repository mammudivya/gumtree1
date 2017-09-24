package Actions;

import Pages.GoogleSearchPage;
import TestSteps.Hooks;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebElement;

public class GumtreeAction extends Hooks {

    private static Logger LOG = LogManager.getLogger(GumtreeAction.class);

    public static void open(String url)
    {
        LOG.info("Navigating to Google.com:"+url);
        driver.get(url);
    }

    public static void search(String txt)
    {
        LOG.info("GOOGLE SEARCH_PAGE : Enter the Text :"+txt);
        GoogleSearchPage.searchWindow.sendKeys(txt);
        GoogleSearchPage.searchWindow.submit();
        LOG.info("GOOGLE SEARCH_PAGE : Click the Submit Button");
    }

    public static void displaySearchResults()
    {
        // System.out.println(" :"+GoogleSearchPage.searchResults.size());
        LOG.info("GOOGLE SEARCH_PAGE : Total Search Results = "+GoogleSearchPage.searchResults.size());
        //System.out.println("---------------------------------------------");
        LOG.info("-------------------------------------------------------");
        for (WebElement Results : GoogleSearchPage.searchResults)
        {
            //System.out.println(Results.getAttribute("href"));

            LOG.info("GOOGLE SEARCH_PAGE : Result Link :"+Results.getAttribute("href"));
        }
        LOG.info("-------------------------------------------------------");
    }

    public static void clickGumtreeLink(String gm)
    {
        //String parentHandle = driver.getWindowHandle();
        for(int i=0;i<GoogleSearchPage.searchResults.size();i++)
            if(GoogleSearchPage.searchResults.get(i).getAttribute("href").contains(gm))
            {
                GoogleSearchPage.searchResults.get(i).click();
                break;
            }

        for (String winHandle : driver.getWindowHandles()) {
            driver.switchTo().window(winHandle);
            //System.out.println("Gumtree Title :"+driver.getTitle());
            LOG.info("GUMTREE Title :"+driver.getTitle());
            driver.close();

        }
    }

}
