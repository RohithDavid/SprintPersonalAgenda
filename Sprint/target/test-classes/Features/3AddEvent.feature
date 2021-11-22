Feature: Add Event to the Calender
 
 Scenario: Adding event and validating with month, week, day options
 Given Login with credentials and click Red icon
 Then click on any date
 And give event details and click add
 Then Verify event details
 And quit this Browser
 
 Scenario: To view added events all together
 Given Login with credentials and click Red__icon
 When click on agenda_list
 Then All saved events can be seen
 And you can close the window
 