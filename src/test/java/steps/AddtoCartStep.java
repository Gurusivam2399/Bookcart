package steps;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;

import driverin.DriverInstances;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class AddtoCartStep extends DriverInstances {
	
	
	@Given("user should login {string} and {string}")
	public void userShouldLoginAnd(String username, String password) {
		driver.findElement(By.xpath("//span[text()='Login']")).click();
		driver.findElement(By.cssSelector("input[formcontrolname='username']")).sendKeys(username);
		driver.findElement(By.cssSelector("input[formcontrolname='password']")).sendKeys(password);
		driver.findElement(By.cssSelector("button[color='primary']")).click();
		WebElement userele = driver.findElement(By.xpath("//button[contains(@class,'mat-focus-indicator mat-menu-trigger')]//span[1]"));	
		wait.until(ExpectedConditions.visibilityOf(userele));
			   
	}
	
	@Given("user search the {string}")
	public void userSearchThe(String book) {
		driver.findElement(By.cssSelector("input[type='search']")).sendKeys(book);
		WebElement searchoption = driver.findElement(By.cssSelector("span.mat-option-text"));
		WebElement option = wait.until(ExpectedConditions.visibilityOf(searchoption));
		option.click();
	}
	
	@When("user add the book to the cart")
	public void userAddTheBookToTheCart() {
		WebElement addtocart = driver.findElement(By.cssSelector("button[color='primary']"));
		wait.until(ExpectedConditions.visibilityOf(addtocart)).click();
	   
	}
	@Then("the cart badge should be update")
	public void theCartBadgeShouldBeUpdate() {
		WebElement snackbar = driver.findElement(By.tagName("snack-bar-container"));
		wait.until(ExpectedConditions.visibilityOf(snackbar));
		wait.until(ExpectedConditions.invisibilityOf(snackbar));
		String cartnum = driver.findElement(By.cssSelector("#mat-badge-content-0")).getText();
		System.out.println("no.of book add to cart : "+cartnum);
		Assert.assertEquals(Integer.parseInt(cartnum)>0,true);
	    
	   
	}

}
