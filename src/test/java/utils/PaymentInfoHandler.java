package utils;

import org.openqa.selenium.WebDriver;
import pages.WebOrderPage;

public class PaymentInfoHandler {

    public static WebOrderPage webOrderPage = new WebOrderPage();

    public static void chooseCardType(String string){

        for (int i = 0; i < webOrderPage.cardTypeLabel.size(); i++) {
            if(webOrderPage.cardTypeLabel.get(i).getText().equals(string)) webOrderPage.cardTypeCheckbox.get(i).click();
        }
    }


}
