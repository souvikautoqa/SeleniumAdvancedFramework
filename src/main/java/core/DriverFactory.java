package core;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import java.util.concurrent.TimeUnit;

public class DriverFactory {

    private WebDriver driver;

    public WebDriver getDriver() {
        try{
            String browser = TestConfig.getBrowser();
            if(browser.equalsIgnoreCase("chrome")){
                driver = new ChromeDriver();
            }else if(browser.equalsIgnoreCase("firefox")){
                driver = new FirefoxDriver();
            }
            driver.manage().timeouts().implicitlyWait(Long.parseLong(TestConfig.getProperty("pageLoadTimeOut")), TimeUnit.SECONDS);
            driver.manage().timeouts().implicitlyWait(Long.parseLong(TestConfig.getProperty("implicitWait")), TimeUnit.SECONDS);
            // TO DO -- Set Window Size
        }catch (Exception e){
            // Setup Log
            e.printStackTrace();
        }
        return driver;
    }
}
