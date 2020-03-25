package tests.module_c;

import org.testng.annotations.Test;

import core.TestBase;

public class TestE extends TestBase{
	  @Test
	    public void TC005(){
	    	driver().get("https://google.com");
	        System.out.println("Test C -- TC001");
	    }

	    @Test
	    public void TC006(){
	        System.out.println("Test C -- TC002");
	    }

}
