package tests.module_a;

import core.TestBase;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

public class TestA extends TestBase {
    private WebDriver driver;
    @Test
    public void TC001(){
    	driver.get("https://www.yahoo.com/");
        System.out.println("Test A -- TC001");
    }

    @Test
    public void TC002(){
    	driver.get("https://www.google.com/");
        System.out.println("Test A -- TC002");
    }


}
