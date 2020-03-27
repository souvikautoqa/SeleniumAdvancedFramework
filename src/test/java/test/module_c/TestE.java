package test.module_c;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import core.TestBase;

public class TestE extends TestBase {
	 private WebDriver driver;
    @Test
    public void TC009(){
        System.out.println("Test A -- TC001");
        driver.get("https://www.facebook.com/");
    }

    @Test
    public void TC0010(){
    	driver.get("https://www.expedia.com/");
        System.out.println("Test A -- TC002");
    }
}
