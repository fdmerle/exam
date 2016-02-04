package support;

import org.openqa.selenium.WebElement;

/**
 * Created by dmytro_moskalenko2 on 2/1/2016.
 */
public class EnterTheStringToWebObject {
    private Boolean successOfEnter = false;

    public void enterValueToTextField(WebElement textDestination, String textToEnter) {
        int timeForWaiting = 10, i;

        String tmp;
        textDestination.sendKeys(textToEnter);

        for (i = 0; i < 10; i++) {
            tmp = textDestination.getText();
        }



    }


}
