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
public class ActitimeLogin {
	WebDriver driver;
	@Given("User should enter {string} in browser")
	public void user_should_enter_in_browser(String url) {
	driver=new ChromeDriver();
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
	driver.get(url);
	}@When("He enters valid {string} as username and {string} as password")
	public void he_enters_valid_as_username_and_as_password(String un, String pwd) {
		driver.findElement(By.id("username")).sendKeys(un);
		driver.findElement(By.name("pwd")).sendKeys(pwd);
	}@And("Clicks on login button")
	public void clicks_on_login_button() {
		driver.findElement(By.xpath("//div[text()='Login ']")).click();
	}	@Then("Home page should be displayed")
	public void home_page_should_be_displayed() {
		WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(5));
		wait.until(ExpectedConditions.titleContains("Enter"));
		JavascriptExecutor jse=(JavascriptExecutor) driver;
		String title = (String) jse.executeScript("return document.title");
		System.out.println(title);
	}
}
