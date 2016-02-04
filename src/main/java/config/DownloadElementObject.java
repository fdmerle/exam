package config;

import org.openqa.selenium.WebElement;

/**
 * Created by dmytro_moskalenko2 on 2/3/2016.
 */
public class DownloadElementObject implements Comparable<DownloadElementObject> {

    private WebElement parentFolder;
    private WebElement modifiedDate;
    private WebElement downloadsAmount;
    private String xpathForDownloadAmount = "td[@headers='files_downloads_h']";
    private String xpathForDate = "td[@headers='files_date_h']";
    private String xpathForName = "th[@headers='files_name_h']";

    public String getXpathForDate() {
        return xpathForDate;
    }

    public String getXpathForDownloadAmount() {
        return xpathForDownloadAmount;
    }

    public String getXpathForName() {
        return xpathForName;
    }

    public void setDownloadsAmount(WebElement downloadsAmount) {
        this.downloadsAmount = downloadsAmount;
    }

    public void setModifiedDate(WebElement modifiedDate) {
        this.modifiedDate = modifiedDate;
    }

    public void setParentFolder(WebElement parentFolder) {
        this.parentFolder = parentFolder;
    }

    public WebElement getDownloadsAmount() {
        return downloadsAmount;
    }

    public WebElement getModifiedDate() {
        return modifiedDate;
    }

    public WebElement getParentFolder() {
        return parentFolder;
    }

    @Override
    public int compareTo(DownloadElementObject o) {

        int value1 = Integer.parseInt(downloadsAmount.getText().replaceAll(",", ""));
        int value2 = Integer.parseInt(o.getDownloadsAmount().getText().replaceAll(",", ""));
        if (value1 < value2) return 1;
        else if (value2 < value1) return -1;
        return 0;

    }
}
