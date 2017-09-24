Feature: Google Search (Cars in London - Gumtree).
  Scenario: Search Cars in London in Google search page
    Given I am on the Google search page
    Then I will search for Cars in London
    Then I should see all Cars in London links and count the links
    Then I should validate the No of Gumtree links
    Then I will click only the Cars in London- Gumtree link
