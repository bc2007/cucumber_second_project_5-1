package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.Driver;

import java.util.ArrayList;
import java.util.List;

public class WebOrderPage {

    public WebOrderPage(){
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(css = "#ctl00_menu a")
    public List<WebElement> menuBarItems;

    @FindBy(css = "p[class='CheckUncheck']>a")
    public  List<WebElement> checkButtons;

    @FindBy(css = "input[type='checkbox']")
    public  List<WebElement> checkboxes;

    @FindBy(css = "select[id*='ddlProduct']")
    public WebElement productDropdown;

    @FindBy(css = "select[id*='ddlProduct']>option")
    public List<WebElement> productDropdownOptions;

    @FindBy(css = "input[id*='txtQuantity']")
    public WebElement quantityInput;

    @FindBy(xpath = "//ol[2]/li/input")
    public List<WebElement> addressInputs;

    @FindBy(xpath = "//ol[3]/li/input")
    public List<WebElement> paymentInputs;

    @FindBy(css = "table[id*='cardList'] td>label")
    public List<WebElement> cardTypeLabel;

    @FindBy(css = "table[id*='cardList'] td>input")
    public List<WebElement> cardTypeCheckbox;

    @FindBy(css = "a[id*='InsertButton']")
    public WebElement processButton;

    @FindBy(css = "table[class='SampleTable'] tr")
    public List<WebElement> tableRows;

    public List<List<WebElement>> getTableData(){

        List<List<WebElement>> tableData = new ArrayList<>();

        for (int i = 2; i <= tableRows.size(); i++) {
            tableData.add(Driver.getDriver().findElements(By.cssSelector("table[class='SampleTable'] tr:nth-child(" + i + ")>td")));
        }
        return tableData;
    }

    @FindBy(css = "input[id*='btnDelete']")
    public WebElement deleteAll;

    @FindBy(css = "div[id*='Message']")
    public WebElement emptyListOfOrderMessage;



}
