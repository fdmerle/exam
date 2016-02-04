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
import java.util.concurrent.TimeUnit;

/**
 * Created by dmytro_moskalenko2 on 2/1/2016.
 */
public class DriverObject {
    private WebDriver driver;

    public void driverInit(){


        try {
            driver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), DesiredCapabilities.firefox());
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
    }

    public void setDriver(WebDriver _driver) {

        driver = _driver;
    }
    public WebDriver getDriver() {
        return driver;
    }
    public boolean isControlExistOnPage(By locator, int timeout) {
        boolean flag = true;
        driver.manage().timeouts().implicitlyWait(timeout, TimeUnit.MILLISECONDS);
        if (driver.findElements(locator).isEmpty()) {
            flag = false;
        }
        driver.manage().timeouts().implicitlyWait(3000, TimeUnit.MILLISECONDS);
        return flag;
    }

    public void waitTillElementLoaded(String locator, int coolDown) {
        WebDriverWait waiter = new WebDriverWait(driver, coolDown);
        waiter.until(ExpectedConditions.presenceOfElementLocated(By.xpath(locator)));

    }

    public void  waitTillElementClickable(WebElement locator, int coolDown) {
        WebDriverWait waiter = new WebDriverWait(driver, coolDown);
        waiter.until(ExpectedConditions.elementToBeClickable(locator));

    }

}
