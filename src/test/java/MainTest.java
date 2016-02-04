import config.DriverObject;
import config.FactoryInit;
import org.testng.annotations.BeforeTest;
import pages.GooglePage;

/**
 * Created by dmytro_moskalenko2 on 2/4/2016.
 */
public class MainTest {

    public DriverObject fireFoxDriver;
    public FactoryInit pageFactory;
    public GooglePage googlePage;

    @BeforeTest
    public void driverInit() {
        fireFoxDriver = new DriverObject();
        fireFoxDriver.driverInit();
        pageFactory = new FactoryInit();
        googlePage = pageFactory.googlePageFactoryCreation(fireFoxDriver);
    }


}
