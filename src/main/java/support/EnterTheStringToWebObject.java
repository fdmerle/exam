package support;

import org.openqa.selenium.WebElement;

/**
 * Created by dmytro_moskalenko2 on 2/1/2016.
 */
public class EnterTheStringToWebObject {
    private Boolean successOfEnter = false;

    public boolean enterValueToTextField(WebElement textDestination, String textToEnter) {
        int i;

        String forCheckEnteringText="";
        textDestination.sendKeys(textToEnter);

        for (i = 0; i < 10; i++) {
            forCheckEnteringText = textDestination.getText();
            if (forCheckEnteringText.equals(textToEnter)){
                return true;
            }

        }
        return false;


    }


}
