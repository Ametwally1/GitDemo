# Tidy Gherkon link: shorturl.at/CEH56 
#https://chrome.google.com/webstore/detail/tidy-gherkin/nobemmencanophcnicjhfhnjiimegjeo/related?hl=en-GB
#Background useful article "shorturl.at/jxNUY"    , background and hooks can't be used together  either ... or

#Scenario outline benefits: they allow you to define a set of steps that are executed multiple times, with different input values each time. 
#This can save time and effort when you have multiple test cases that follow the same basic steps, but with different input values.
#to do this just rename the Scenario name from Scnario to Scenario outline and at the end Examples: <>||
# this regular expression is more dynamically  (.+)   old one is \"([^\"]*)\" 




Feature: place the order for products
@PlaceOrder
Scenario Outline: Search Experience for product search in both home and offers page

Given User is on GreenCart landing page
When User searched with Shortname <Name> and extracted actual name of product
And Added 3 iteam of the selected product to cart
Then User proceeds to checkout and validate the <Name> items in checkout page 
And Veify user has ability to enter promo code and place the order

Examples:
| Name |
| Tom  |

