package config;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.net.MalformedURLException;
import java.net.URL;

/**
 * Created by dmytro_moskalenko2 on 2/1/2016.
 */
public class DriverObject {
    private WebDriver driver;

    public void driverInit() {
        try {
            driver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), DesiredCapabilities.firefox());
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
    }

    public WebDriver getDriver() {
        return driver;
    }


    public void waitTillElementLoaded(String locator, int coolDown) {
        WebDriverWait waiter = new WebDriverWait(driver, coolDown);
        waiter.until(ExpectedConditions.presenceOfElementLocated(By.xpath(locator)));

    }

    public void waitTillElementClickable(WebElement locator, int coolDown) {
        WebDriverWait waiter = new WebDriverWait(driver, coolDown);
        waiter.until(ExpectedConditions.elementToBeClickable(locator));

    }

}
