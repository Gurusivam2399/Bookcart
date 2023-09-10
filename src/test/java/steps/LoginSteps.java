package steps;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;

import driverin.DriverInstances;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class LoginSteps extends DriverInstances {
	

	@Given("user click on the login link")
	public void userClickOnTheLoginLink() {
		driver.findElement(By.xpath("//span[text()='Login']")).click();
	}

	@Given("user enter the name as guru")
	public void userEnterTheNameAsGuru() {
		driver.findElement(By.cssSelector("input[formcontrolname='username']")).sendKeys("gurusivam23");
	}

	@Given("user enter the password as pass123")
	public void userEnterThePasswordAsPass123() {
		driver.findElement(By.cssSelector("input[formcontrolname='password']")).sendKeys("Gurusivam23");
	}

	@When("user click the login button")
	public void userClickTheLoginButton() {
		driver.findElement(By.cssSelector("button[color='primary']")).click();
	}

	@Then("login should be success")
	public void loginShouldBeSuccess() {
		WebElement userele = driver.findElement(By.xpath("//button[contains(@class,'mat-focus-indicator mat-menu-trigger')]//span[1]"));	
		wait.until(ExpectedConditions.visibilityOf(userele));
		
	}

	@Given("user enter the name as guruss")
	public void userEnterTheNameAsGuruss() {
		driver.findElement(By.cssSelector("input[formcontrolname='username']")).sendKeys("gurusivam");
	}
	@Given("user enter the password as fail123")
	public void userEnterThePasswordAsFail123() {
		driver.findElement(By.cssSelector("input[formcontrolname='password']")).sendKeys("Guru 23");
	}
	@Then("login should be fail")
	public void loginShouldBeFail() {
		String text = driver.findElement(By.cssSelector("mat-error[role='alert']")).getText();
		System.out.println(text);
		Assert.assertEquals(text,"Username or Password is incorrect.");
		

	}
	

}
