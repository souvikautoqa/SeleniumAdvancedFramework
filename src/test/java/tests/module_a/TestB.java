package tests.module_a;

import core.TestBase;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

public class TestB extends TestBase {
	private WebDriver driver;
    @Test
    public void TC001(){
    	driver.get("https://www.sap.com/");
        System.out.println("Test B -- TC001");
    }

    @Test
    public void TC002(){
        System.out.println("Test B -- TC002");
    }


}
