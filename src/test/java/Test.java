import org.testng.Assert;
import pages.MantisPage;

/**
 * Created by dmytro_moskalenko2 on 2/2/2016.
 */
public class Test extends MainTest {

    @org.testng.annotations.Test
    public void testRunner() {

        googlePage.loadPage();
        googlePage.sendRequestForSearch("mantis");
        googlePage.clickOnProperResult();
        MantisPage mantisPage = pageFactory.mantisPageFactoryCreation(googlePage.getDriverObject());
        mantisPage.navigateToListOfDownloads();
        mantisPage.returnTheVersionWithMostDownload();
        Assert.assertEquals(mantisPage.returnTheVersionWithMostDownload(), "1.2.19");

    }
}
