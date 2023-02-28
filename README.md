# cucumber_second_project_5
TEST AUTOMATION FRAMEWORK

The purpose of this project is validation "Smart bear software" functionality

This is Java-Maven-Cucumber TDD Framework. We are using Java as core programming language. 
Maven brings us good folder structure and centralize our dependencies in pom.xml file. 
It is also allowed us to execute a group of test cases with a Maven command.
We also implemented JUnit for annotation and reports,
we are using Selenium as automation tool and bonigarcia WebDriverManager. 

I run my @Smoke and @Regression with using Maven command (mvn test -DCucumber.options="--tags
@Regression" or  mvn test -DCucumber.options="--tags @Smoke") 
The execution of test cases starts from pom.xml file and then move to the Runner class. 
It will update Runner class with given configuration.
With the Tag it gets, it will now go to feature files and execute all the scenarios which have the same Tag.
Scenario steps will be executed with their linked implementation in the “steps” package.
Finally, when the execution is complete, the reports specified in the Runner plugin will be generated.
After the execution is complete, surefire reports will be generated under the target folder

In our framework we implemented Page object model, so we have created separate package for storing all locators
and different classes for each application form. To be able to handle different types of the WebElements we have
our utils class, where we created a lot of useful method, that make our work with assertion easier.

In the Utils package:
    PaymentHandler class: implements the method for test our payment input with different Test Data.
    DropdownHandler class: implements the method for felling out order information
    Waiter class: implements the method for handling synchronization issues 

<img width="1388" alt="Screen Shot 2023-02-27 at 5 50 37 PM" src="https://user-images.githubusercontent.com/116671996/221723551-d003c356-859d-421b-876d-09b8fe0a1665.png">
<img width="1422" alt="Screen Shot 2023-02-27 at 6 01 39 PM" src="https://user-images.githubusercontent.com/116671996/221723716-2a1c1b61-a7b8-42ab-9a91-89f8b9b20bd7.png">
<img width="1398" alt="Screen Shot 2023-02-27 at 6 02 05 PM" src="https://user-images.githubusercontent.com/116671996/221723748-023fb66c-bab1-4268-9908-fc1fa89aa6db.png">
