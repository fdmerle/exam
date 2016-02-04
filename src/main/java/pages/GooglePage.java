package pages;

import config.DriverObject;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import support.EnterTheStringToWebObject;

/**
 * Created by dmytro_moskalenko2 on 2/1/2016.
 */
public class GooglePage {
    @FindBy(xpath = ".//*[@id='lst-ib']")
    private WebElement searchRequestInputField;
    @FindBy(xpath = ".//*[@id='sblsbb']")
    private WebElement requestSubmitButton;
    @FindBy(xpath = ".//*[@id='pnnext']/span[@class='csb ch']")
    private WebElement nextButtonXpath;
    private DriverObject driver;
    private String elementInSearchResult = ".//*[@id='rso']//h3//a";


    public GooglePage(DriverObject _driver) {
        driver = _driver;

    }

    public DriverObject getDriverObject() {

        return driver;
    }

    public void loadPage() {
        driver.getDriver().get("http://google.com");

    }

    public void sendRequestForSearch(String textToSearch) {
        EnterTheStringToWebObject stringInput = new EnterTheStringToWebObject();
        stringInput.enterValueToTextField(searchRequestInputField, textToSearch);
        requestSubmitButton.click();
        driver.waitTillElementClickable((nextButtonXpath), 10);

    }

    public boolean clickOnProperResult() {
        WebElement searchResult;
        for (int i = 1; i < 10; i++) {
            waitWhileResultPageIsLoaded(Integer.toString(i));
            searchResult = returnResultAccordinglyToSearchCriteria();
            if (searchResult != null) {
                searchResult.click();
                return true;
            }
            nextButtonXpath.click();
        }
        return false;
    }

    private WebElement returnResultAccordinglyToSearchCriteria() {
        for (WebElement item : driver.getDriver().findElements(By.xpath(elementInSearchResult))) {
            if (item.getAttribute("href").equals("http://sourceforge.net/projects/mantisbt/"))
                return item;
        }
        return null;
    }

    private void waitWhileResultPageIsLoaded(String pageNumber){
        String linkToAntherPage=".//*[@id='nav']//td[contains(text(), '"+pageNumber+"')]";
        driver.waitTillElementLoaded(linkToAntherPage, 5);
    }


}
