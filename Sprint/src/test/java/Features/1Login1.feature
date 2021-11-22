Feature: Test Google Homepage
Scenario: logging in into e-learning

Given E-learning login page is launched
When User enters Username and Password
Then click login
And E-page is opened 
Then close the Browser

Scenario: Validate personal agenda page

Given user is logged in and naviated to home page
Then click on the Personal Agenda
And verify the page
Then Quit the browser
