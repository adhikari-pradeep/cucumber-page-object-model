Feature: To create a new travel quote

As a customer
I want to apply for a travel insurance quote
So that I can get my insurance policy

@RunMe
Scenario: Create a Travel Quote for a single trip

Given I am a customer
When I try to get a single trip travel quote
Then I should be able to generate the quote successfully