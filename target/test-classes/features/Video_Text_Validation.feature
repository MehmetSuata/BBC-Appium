
Feature:BBC Test UI

  Background:
    Given user successfully logs in to BBC News app

@bbc
Scenario: Tap on Video Tab and validate “BBC News Channel” text then scroll down and validate “Copyright © 2018 BBC”
Given user is on the Open the BBC News app and navigate to the Video Tab.
Then user validates "BBC News Channel" text at landing page and "Copyright © 2018 BBC" at the footer is displayed.




@bbc
Scenario Outline: Click on Search icon then search for “England” or select from the More Topics.Verify the Navigation bar text
Given user wants to search for a certain category and clicks on search icon and should see options
Then user clicks on option "<topic>" to filter and should see selected category at the top nav text:

  Examples:Search Categories
    | topic   |
    | England |
#    | UK      |

@bbc
Scenario:Navigate back to the home page and Verify the Home page text
Given user successfully lands on the selected "England"
Then user should be able to navigate back to the Homepage and verify the HomePage text "Top Stories"