package scripts;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import pages.BasePage;
import pages.CarvanaHomePage;
import pages.CarvanaSearchCarPage;
import utils.ConfigReader;
import utils.Driver;

public class BasePageTest {

    WebDriver driver;
    BasePage basePage;
    CarvanaHomePage carvanaHomePage;
    CarvanaSearchCarPage carvanaSearchCarPage;

    @BeforeMethod
    public void setUp(){
        driver = Driver.getDriver();
        basePage = new BasePage();
        driver.get(ConfigReader.getProp("url"));

    }
    @AfterMethod
    public void tearDown(){
        Driver.quitDriver();
    }
}
