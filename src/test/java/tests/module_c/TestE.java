package tests.module_c;

import core.TestBase;
import org.testng.annotations.Test;

public class TestE extends TestBase {

    @Test(groups = {"web"})
    public void TC001() {
        System.out.println("Test E -- TC001");

        driver().get("https://toolsqa.com");
    }

    @Test
    public void TC002(){

        System.out.println("Test E -- TC002");
        driver().get("https://singaporeairlines.com");
    }
}
