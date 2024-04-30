package stepdefinitions;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class GoogleSearchPage {
	WebDriver driver;
	@Given("User should be present in google webpage")
	public void user_should_be_present_in_google_webpage() {
		driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.get("https://www.google.com");
	}@When("He searchs the text")
	public void he_searchs_the_text() {
driver.findElement(By.name("q")).sendKeys("Qspiders Basavangudi"+Keys.ENTER);
	}@Then("Search page should be diasplayed")
	public void search_page_should_be_diasplayed() {
		System.out.println(driver.getTitle());
	}

}
