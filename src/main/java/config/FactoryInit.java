package config;

import org.openqa.selenium.support.PageFactory;
import pages.GooglePage;
import pages.MantisPage;

/**
 * Created by dmytro_moskalenko2 on 2/1/2016.
 */
public class FactoryInit {

   public GooglePage googlePageFactoryCreation(DriverObject driver){
       GooglePage googleExemplar= new GooglePage(driver);
       PageFactory.initElements(googleExemplar.getDriverObject().getDriver(), googleExemplar);
       return googleExemplar;
   }

    public MantisPage mantisPageFactoryCreation(DriverObject driver){
        MantisPage mantisPageExemplar = new MantisPage(driver);
        PageFactory.initElements(mantisPageExemplar.getDriverObject().getDriver(), mantisPageExemplar);
        return mantisPageExemplar;

    }


}
