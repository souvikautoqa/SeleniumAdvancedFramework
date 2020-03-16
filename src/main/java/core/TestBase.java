package core;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;

public class TestBase {

    private WebDriver driver;

    @BeforeSuite
    public void initSuite(){
        TestConfig.loadProperties();
    }

    @BeforeClass
    public void initDriver(){
       DriverFactory driverFactory = new DriverFactory();
       driver = driverFactory.getRemoteWebDriver();
    }

    @AfterClass
    public void tearDown(){
        if(driver!=null){
           driver.quit();
        }
    }

    public WebDriver driver(){
        return driver;
    }

}
