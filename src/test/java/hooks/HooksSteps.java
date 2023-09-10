package hooks;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import driverin.DriverInstances;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.BeforeStep;
import io.cucumber.java.Scenario;
import io.cucumber.java.Status;

public class HooksSteps extends DriverInstances {
	
	@BeforeStep
	public void beforesteps(Scenario scenario) {
		String id = scenario.getId();
		System.out.println(id);
		byte[] screenshotAs = driver.getScreenshotAs(OutputType.BYTES);
		scenario.attach(screenshotAs,"image/png","taking screenshot");
	}
	

	@Before
	public void beforescenario(Scenario scenario) {
		System.getProperty("webdrivrer.chrome.driver","./drivers/chromedriver.exe");
		driver = new ChromeDriver();
		wait = new WebDriverWait(driver,Duration.ofSeconds(10));
		driver.get("https://bookcart.azurewebsites.net");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		
		String name = scenario.getName();
		System.out.println("scenario name: "+name );
	}
	
	@After("@cleanup")
	public void cleanupdata(Scenario scenario) {
		driver.findElement(By.xpath("(//button[contains(@class,'mat-focus-indicator mat-icon-button')]/following-sibling::button)[1]")).click();
		driver.findElement(By.xpath("//div[@class='ng-star-inserted']//button[1]")).click();
		String text = driver.findElement(By.tagName("mat-card-title")).getText();
		Assert.assertEquals(text,"Shopping cart is empty");
		byte[] screenshotAs = driver.getScreenshotAs(OutputType.BYTES);
		scenario.attach(screenshotAs,"image/png","taking screenshot");
		driver.quit();
	}
	
	@After(order = 1)
	public void afterscenario(Scenario scenario) {
		boolean failed = scenario.isFailed();
		System.out.println("is failed:  "+failed);
		if (failed) {
		byte[] screenshotAs = driver.getScreenshotAs(OutputType.BYTES);
		scenario.attach(screenshotAs,"image/png","taking screenshot");
		
		}
		driver.quit();
		
		Status status = scenario.getStatus();
		System.out.println("Result : " +status);
	}

}
