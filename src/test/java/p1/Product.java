package p1;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

public class Product {
	WebDriver driver;
	
	@Given("Enter the Usename and password")
	public void enter_the_Usename_and_password() {
		System.setProperty("webdriver.chrome.driver","src\\test\\resources\\chromedriver.exe");
		driver= new ChromeDriver();
		
		driver.get("https://10.232.237.143/TestMeApp/fetchcat.htm");
		  driver.findElement(By.id("details-button")).click();
		  driver.findElement(By.id("proceed-link")).click();
		  driver.findElement(By.linkText("SignIn")).click();
		  driver.findElement(By.name("userName")).sendKeys("Lalitha");
		  driver.findElement(By.name("password")).sendKeys("Password123");
		  driver.findElement(By.name("Login")).click();
		  System.out.println("Successfull Login");
	}
	    
	
	@And("select the category")
	public void select_the_category() {
		 driver.findElement(By.linkText("All Categories")).click();
	}

	@Then("select the product add to the cart")
	public void select_the_product_add_to_the_cart() {
		driver.findElement(By.linkText("Electronics")).click();
		driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
		 driver.findElement(By.linkText("Travel Kit")).click();
		driver.findElement(By.linkText("Add to cart")).click();
		
		System.out.println("Successfully added item to cart");
	}



}
