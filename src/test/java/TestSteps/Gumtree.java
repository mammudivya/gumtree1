package TestSteps;

import Actions.GumtreeAction;
import Base.ConfigReader;
import Pages.GoogleSearchPage;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import org.openqa.selenium.support.PageFactory;

import static TestSteps.Hooks.driver;

public class Gumtree {


    String url = ConfigReader.user.getProperty("bashUrl");
    String searchTxt=ConfigReader.user.getProperty("Txt");
    String gumtree=ConfigReader.user.getProperty("Gt");


    @Given("^I am on the Google search page$")
    public void i_am_on_the_Google_search_page() throws Throwable {
        PageFactory.initElements(driver,GoogleSearchPage.class);
        GumtreeAction.open(url);
    }


    @Then("^I will search for Cars in London$")
    public void iWillSearchForCarsInLondon() throws Throwable {
        GumtreeAction.search(searchTxt);
    }

    @Then("^I should see all Cars in London links and count the links$")
    public void i_should_see_all_Cars_in_London_links_and_count_the_links() throws Throwable {

        GumtreeAction.displaySearchResults();
    }

    @Then("^I should validate the No of Gumtree links$")
    public void i_should_validate_the_No_of_Gumtree_links() throws Throwable {

    }

    @Then("^I will click only the Cars in London- Gumtree link$")
    public void iWillClickOnlyTheCarsInLondonGumtreeLink() throws Throwable {

        GumtreeAction.clickGumtreeLink(gumtree);
    }
}
