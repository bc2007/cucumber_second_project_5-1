package steps;

import cucumber.api.java.Before;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.cucumber.datatable.DataTable;
import org.junit.Assert;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NotFoundException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import pages.SmartBearPage;
import pages.WebOrderPage;
import utils.Driver;
import utils.DropdownHandler;
import utils.PaymentInfoHandler;
import utils.Waiter;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class WebOrderSteps {

    WebDriver driver;
    WebOrderPage webOrderPage;


    @Before
    public void setPage() {
        driver = Driver.getDriver();
        webOrderPage = new WebOrderPage();
    }


    @Then("validate below menu items are displayed")
    public void validate_below_menu_items_are_displayed(DataTable dataTable) {
        List<String> expectedMenuItems = dataTable.asList();

        for (int i = 0; i < expectedMenuItems.size(); i++) {
            Assert.assertEquals(expectedMenuItems.get(i), webOrderPage.menuBarItems.get(i).getText());
        }


    }

    @When("user clicks on {string} button")
    public void userClicksOnButton(String string) {
        switch (string) {
            case "Check All":
                webOrderPage.checkButtons.get(0).click();
                break;
            case "Uncheck All":
                webOrderPage.checkButtons.get(1).click();
                break;
            case "Process":
                webOrderPage.processButton.click();
                break;
            case "Delete Selected":
                Waiter.waitForElementToBeClickable(webOrderPage.deleteAll, 10);
                webOrderPage.deleteAll.click();
                break;
            default:
                throw new NotFoundException();
        }
    }

    @Then("all rows should be {string}")
    public void allRowsShouldBeChecked_UnChecked(String string) {
        switch (string){
            case "checked":
                for (int i = 0; i < webOrderPage.checkboxes.size(); i++) {
                    Assert.assertEquals("true", webOrderPage.checkboxes.get(i).getAttribute("checked"));
                }
                break;
            case "unchecked":
                for (int i = 0; i < webOrderPage.checkboxes.size(); i++) {
                    Assert.assertNotEquals("true", webOrderPage.checkboxes.get(i).getAttribute("checked"));
                }
                break;
            default:
                throw new NotFoundException();
        }

    }


    @When("user clicks on {string} menu item")
    public void userClicksOnMenuItem(String string) {
        switch (string) {
            case "Order":
            webOrderPage.menuBarItems.get(2).click();
            break;
            case "View all orders":
            webOrderPage.menuBarItems.get(0).click();
            break;
            default:
                throw new NotFoundException();
        }
    }

    @And("user selects {string} as product")
    public void userSelectsAsProduct(String string) {
        DropdownHandler.clickOnDropdownOptions(webOrderPage.productDropdown, webOrderPage.productDropdownOptions, string);
    }

    @And("user enters {int} as quantity")
    public void userEntersAsQuantity(int quantity) {
        webOrderPage.quantityInput.sendKeys(Keys.DELETE + "2");
    }

    @And("user enters all {string} information")
    public void userEntersAllInformation(String string) {
        switch (string){
            case "address":
                String[] addressInfo = {"John", "111 N ChicagoAve", "Chicago", "IL", "60706"};
                for (int i = 0; i < addressInfo.length; i++) {
                    webOrderPage.addressInputs.get(i).sendKeys(addressInfo[i]);
                }
                break;
            case "payment":
                String[] paymentInfo = {"1234567891234567", "06/23"};
                PaymentInfoHandler.chooseCardType("Visa");
                for (int i = 0; i < paymentInfo.length; i++) {
                    webOrderPage.paymentInputs.get(i).sendKeys(paymentInfo[i]);
                }
                break;
            default:
                System.out.println("No such information found");
                throw new NotFoundException();

        }
    }

    @Then("user should see their order displayed in the List of All Orders table")
    public void userShouldSeeTheirOrderDisplayedInTheTable() {
        List<List<WebElement>> tableData = webOrderPage.getTableData();
        Assert.assertTrue(tableData.get(0).get(1).getText().equals("John"));
    }

    @And("validate all information entered displayed correct with the order")
    public void validateAllInformationEnteredDisplayedCorrectWithTheOrder() {
        List<List<WebElement>> tableData = webOrderPage.getTableData();
        String date = new SimpleDateFormat("MM/dd/yyyy").format(new Date());
        Object[] expectedInfo = {"", "John", "FamilyAlbum",	"2", date, "111 N ChicagoAve", "Chicago", "IL", "60706",	"Visa",	"1234567891234567", "06/23"};

        for (int i = 1; i < tableData.get(0).size()-1; i++) {
            Assert.assertEquals(expectedInfo[i], tableData.get(0).get(i).getText());
        }
    }

    @Then("validate all orders are deleted from the List of All Orders")
    public void validateAllOrdersAreDeletedFromThe() {
        List<List<WebElement>> tableData = webOrderPage.getTableData();
        Assert.assertTrue(tableData.isEmpty());
    }

    @And("validate user sees {string} message")
    public void validateUserSeesMessage(String string) {
        Assert.assertTrue(webOrderPage.emptyListOfOrderMessage.isDisplayed());
        Assert.assertEquals(string, webOrderPage.emptyListOfOrderMessage.getText());
    }
}