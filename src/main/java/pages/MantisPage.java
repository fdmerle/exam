package pages;

import config.DownloadElementObject;
import config.DriverObject;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by dmytro_moskalenko2 on 2/3/2016.
 */
public class MantisPage {


    @FindBy(xpath = ".//*[@id='project-nav']//a[@class='files']")
    private WebElement linkToFiles;
    @FindBy(xpath = ".//*[@id='files_list']//a[@title='Click to enter mantis-stable']")
    private WebElement linkToStableVersion;
    private String downloadableElementXpath = ".//tr[contains(@class,'folder')]";
    private DriverObject driver;

    public MantisPage(DriverObject _driver) {
        driver = _driver;
    }

    public DriverObject getDriverObject() {
        return driver;
    }

    public void navigateToListOfDownloads() {
        clickOnLink(linkToFiles);
        clickOnLink(linkToStableVersion);
    }
    private List<DownloadElementObject> returnListOfVersions() {
        List<DownloadElementObject> listOfElements = new ArrayList<>();
        for (WebElement item : driver.getDriver().findElements(By.xpath(downloadableElementXpath))) {
            DownloadElementObject downloadableElement = new DownloadElementObject();
            downloadableElement.setDownloadsAmount(item.findElement(By.xpath(downloadableElement.getXpathForDownloadAmount())));
            downloadableElement.setModifiedDate(item.findElement(By.xpath(downloadableElement.getXpathForDate())));
            downloadableElement.setParentFolder(item.findElement(By.xpath(downloadableElement.getXpathForName())));
            listOfElements.add(downloadableElement);
        }
        return listOfElements;
    }
    private void clickOnLink(WebElement elementToClick) {
        driver.waitTillElementClickable(elementToClick, 10);
        elementToClick.click();
    }
    public String returnTheVersionWithMostDownload() {
        List<DownloadElementObject> listOfElements = returnListOfVersions();
        Collections.sort(listOfElements);
        return listOfElements.get(0).getParentFolder().getText();
    }
}
