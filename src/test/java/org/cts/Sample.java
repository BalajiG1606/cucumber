package org.cts;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import junit.framework.Assert;

public class Sample {

	static WebDriver driver;

	@Given("User should launch browser")
		public void use_should_launch_browser_and_url() throws InterruptedException {
			
			System.setProperty("webdriver.chrome.driver", "C:\\Users\\Balaji\\eclipse-workspace\\Seleniumfirstday\\drivers\\chromedriver.exe");
			 driver = new ChromeDriver();
			driver.get("http://www.demo.guru99.com/telecom/");
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(15000, TimeUnit.SECONDS);
			driver.findElement(By.xpath("(//a[text()='Add Customer'])[1]")).click();
}

	@Given("User click add custmer link")
	public void user_click_add_custmer_link() {
		driver.findElement(By.xpath("(//a[text()='Add Customer'])[1]")).click();
		WebDriverWait w = new WebDriverWait(driver, 100);
		w.until(ExpectedConditions.elementToBeClickable(By.xpath("(//a[text()='Add Customer'])[1]"))).click();

	}

	@When("User provide valid details")
	public void user_provide_valid_details() {
		driver.manage().timeouts().implicitlyWait(15000, TimeUnit.SECONDS);
		driver.findElement(By.xpath("//label[text()='Done']")).click();
		driver.findElement(By.id("fname")).sendKeys("balaji");
		driver.findElement(By.id("lname")).sendKeys("gopalakrishnan");
		driver.findElement(By.id("email")).sendKeys("gbalaji1606@gmail.com");
		driver.findElement(By.xpath("//textarea[@name ='addr']")).sendKeys("chennai");
		driver.findElement(By.id("telephoneno")).sendKeys("1243433433");
driver.findElement(By.xpath("//input[@name='submit']")).click();	
}

	@Then("To verify customer id is displayed")
	public void to_verify_customer_id_is_displayed() {
		Assert.assertTrue(driver.findElement(By.xpath("//*[@id=\"main\"]/div/div/table/tbody/tr[1]/td[2]")).isDisplayed());
		

	}

}
