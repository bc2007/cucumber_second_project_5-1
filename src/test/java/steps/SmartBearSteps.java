package steps;

import cucumber.api.java.Before;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import pages.SmartBearPage;
import utils.Driver;

import java.util.List;

public class SmartBearSteps {

        WebDriver driver;
        SmartBearPage smartBearPage;



    @Before
    public void setPage(){
        driver = Driver.getDriver();
        smartBearPage = new SmartBearPage();

    }

    @Given("user is on {string}")
    public void user_is_on(String string) {
        driver.get(string);
        Assert.assertEquals(string, driver.getCurrentUrl());
    }

    @When("user enters username as {string}")
    public void user_enters_username_as(String string) {
        smartBearPage.loginInput.sendKeys(string);
    }

    @When("user enters password as {string}")
    public void user_enters_password_as(String string) {
       smartBearPage.passwordInput.sendKeys(string);
    }

    @When("user clicks on Login button")
    public void user_clicks_on_Login_button() {
        smartBearPage.loginButton.click();
    }

    @Then("user should see {string} message")
    public void user_should_see_message(String string) {
        Assert.assertEquals(string, smartBearPage.errorMessage.getText());
    }

    @Then("user should be routed to {string}")
    public void userShouldBeRoutedTo(String string) {
        Assert.assertEquals(string, driver.getCurrentUrl());
    }


}
