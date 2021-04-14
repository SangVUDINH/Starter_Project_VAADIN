package com.example.test;

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.openqa.selenium.chrome.ChromeDriver;

import com.vaadin.testbench.IPAddress;
import com.vaadin.testbench.RetryRule;
import com.vaadin.testbench.ScreenshotOnFailureRule;
import com.vaadin.testbench.TestBenchTestCase;


public abstract class AbstractViewTest extends TestBenchTestCase {
	private static final String SERVER_HOST = IPAddress.findSiteLocalAddress();
    private static final int SERVER_PORT = 8080;
    private String route;
    
    protected AbstractViewTest(String route) {
    	this.route = route;
	}
    
    @Rule
    public ScreenshotOnFailureRule rule = new ScreenshotOnFailureRule(this,
            false);
    
    @Rule
	public RetryRule rule2 = new RetryRule(2);

    @Before
    public void setup() throws Exception {
  
//        ChromeOptions options = new ChromeOptions();
//        options.addArguments("--headless", "--disable-gpu");
//   	 	setDriver(new ChromeDriver(options));  
   	 	
   	 	//setDriver(new FirefoxDriver());  
   	 	setDriver(new ChromeDriver());  
        getDriver().get(getURL(route)); // Opens the given URL in the browser

    }

    private static String getURL(String route) {
        return String.format("http://%s:%d/%s", SERVER_HOST, SERVER_PORT, route);
    }
    
    @After
    public void tearDown() throws Exception {
        getDriver().quit();
    }
    
}
