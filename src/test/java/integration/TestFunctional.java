package integration;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class TestFunctional {
	private static WebDriver driver;
		  
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
		public void excluir() throws InterruptedException{
			driver.get("http://localhost:8080/integration/index.html");
			Thread.sleep(500);
			
			WebElement element = driver.findElement(By.id("excluir_45"));
			element.click();
			
			Thread.sleep(500);
			
			WebElement del = driver.findElement(By.id("dell"));
			del.click();
		}

	
	@Test
	public void editar() throws InterruptedException {
		driver.get("http://localhost:8080/integration/index.html");
		Thread.sleep(1000);
		
		WebElement element = driver.findElement(By.id("editar_5"));
		element.click();
		
		Thread.sleep(1500);
		
		WebElement desc = driver.findElement(By.name("descriTest"));
		desc.sendKeys(" editavel");
		WebElement Selectbox = driver.findElement(By.id("slc"));
	    Selectbox.click();
	    WebElement Selectbox2 = driver.findElement(By.id("slc2"));
	    Selectbox2.click();
	    WebElement Selectbox3 = driver.findElement(By.id("slc3"));
	    Selectbox3.click();
		WebElement conta = driver.findElement(By.name("contaTest"));
		conta.sendKeys("Conta Editável");
		
		WebElement submit = driver.findElement(By.id("cadastrar"));
		submit.click();	
		
	}
	
	@Test
	public void cadastrar() throws InterruptedException {
		driver.get("http://localhost:8080/integration/index.html");
		
		WebElement element = driver.findElement(By.name("botaoTest"));
		element.click();
		
		Thread.sleep(1500);
		
		WebElement cdg = driver.findElement(By.name("codigoTest"));
		cdg.sendKeys("12");
		WebElement desc = driver.findElement(By.name("descriTest"));
		desc.sendKeys("Teste descrição");
		WebElement Selectbox = driver.findElement(By.id("slctwo"));
	    Selectbox.click();
	    WebElement Selectbox2 = driver.findElement(By.id("slc2two"));
	    Selectbox2.click();
	    WebElement Selectbox3 = driver.findElement(By.id("slc3two"));
	    Selectbox3.click();
		WebElement conta = driver.findElement(By.name("contaTest"));
		conta.sendKeys("Conta ");
		WebElement apend = driver.findElement(By.id("apendTest"));
		apend.sendKeys("5");
		
		WebElement submit = driver.findElement(By.id("cadastrar"));
		submit.click();	
	
	}
	
	

}
