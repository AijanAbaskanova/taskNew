Feature: Google search
  @googleSearch
  Scenario: Make a search at Google
    Given user navigates to www.google.com
    And user inserts the name of coffee machine in search line
    And user clicks the search button
    And user should see more than ten results regarding the related search
    Then user should see MVideo.ru in the search result page
