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
    public void initDriver() throws InterruptedException {
       DriverFactory driverFactory = new DriverFactory();
       driver = driverFactory.getRemoteWebDriver();
       Thread.sleep(10000);
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
