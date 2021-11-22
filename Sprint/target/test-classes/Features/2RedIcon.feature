Feature: Funtionality of Red Coloured Icon

Scenario: To validate the function of "<,>,today" buttons with month selected
Given User is logged in and directed to personal agenda page
When User Clicks on Red colured icon 
Then Current running month is displayed 
And Click on > button 
Then Succeeding month is displayed
And Click on today
Then again Current running month is displayed
And Click on < button
Then Preceeding month is displayed
Then Close the  browser



Scenario: To validate the function of "<,>,today" buttons with week selected
Given User is Logged in and directed to Personal Agenda page
When User Clicks on red colured icon and clicks on week,today options 
Then Current running week is displayed 
And click on > button 
Then Succeeding week is displayed
And click on today
Then again Current running week is displayed
And click on < button
Then Preceeding week is displayed
Then close the  browser



Scenario: To validate the function of "<,>,today" buttons with day selected
Given User is logged in and Directed to personal agenda Page
When User Clicks on red colured icon and clicks on day option
Then Current running day is displayed which is highlighted
And click on > buttoN 
Then Succeeding day is displayed
And click on todaY
Then again Current running day is displayed
And click on < buttoN
Then Preceeding day is displayed
Then close the  Browser