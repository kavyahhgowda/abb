package stepdefinitions;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class UsingExamples {
	WebDriver driver;
	@Given("User should enter the url as {string} in browser")
	public void user_should_enter_the_url_as_in_browser(String url) {
		driver=new ChromeDriver();
		driver.get(url);
	}@When("He enters {string} and {string} in the textbox")
	public void he_enters_and_in_the_textbox(String un, String pwd) {
		driver.findElement(By.id("username")).sendKeys(un);
		driver.findElement(By.name("pwd")).sendKeys(pwd);
	}@And("He clicks on login button")
	public void he_clicks_on_login_button() {
		driver.findElement(By.xpath("//div[text()='Login ']")).click();
	}@Then("Homepage must be displayed")
	public void homepage_must_be_displayed() {
		WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(5));
		wait.until(ExpectedConditions.titleContains("Enter"));
		JavascriptExecutor jse=(JavascriptExecutor) driver;
		String title = (String) jse.executeScript("return document.title");
		System.out.println(title);
		driver.quit();
	}
}
