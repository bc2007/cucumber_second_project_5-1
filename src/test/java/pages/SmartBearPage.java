package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.Driver;

import java.util.ArrayList;
import java.util.List;

public class SmartBearPage {

    public SmartBearPage(){
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(css = "input[type='text']")
    public WebElement loginInput;

    @FindBy(css = "input[type='password']")
    public WebElement passwordInput;

    @FindBy(className = "button")
    public WebElement loginButton;

    @FindBy(className = "error")
    public WebElement errorMessage;
    @FindBy(css = "table[class='SampleTable'] tr>th")
    public List<WebElement> tableHeader;



}
