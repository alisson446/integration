package integration;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;


public class TestFunctional {
	private static WebDriver driver;
	private static final String URL = "http://localhost:9090/integration/index.html";
		  
	@Before
	  public void setUp() {
	    driver = new FirefoxDriver();
	    driver.manage().window().setPosition(new Point(150, 100));
	  }
	    
	  @After
	  public void tearDown() {
	    driver.close();
	  }

	@Test
	public void testaLoginDevMedia() {
		driver.navigate().to(URL);
		
		WebElement element = driver.findElement(By.name("botaoTest"));
		element.click();
		WebElement desc = driver.findElement(By.name("descriTest"));
		desc.sendKeys("Teste");
		
		
	
	
	}

}
