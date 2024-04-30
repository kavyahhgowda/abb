package stepdefinitions;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.actitime.pom.HomePage;
import com.actitime.pom.TaskListPage;

import hooks.BaseClass;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.java.eo.Se;

public class CreateCustomer {
	WebDriver driver = BaseClass.driver;
	TaskListPage t;

	@Given("User should be present in home page")
	public void user_should_be_present_in_home_page() {
		String expectedTitle = "actiTIME - Enter Time-Track";
		String actualTitle = driver.getTitle();
		Assert.assertEquals(actualTitle, expectedTitle);
	}

	@When("He Clicks on task tab")
	public void he_clicks_on_task_tab() {
		HomePage h = new HomePage(driver);
		h.setTaskTab();
	}

	@Then("The title should be {string}")
	public void the_title_should_be(String expectedTitle) {
		String actualTitle = driver.getTitle();
		Assert.assertEquals(actualTitle, expectedTitle);
	}

	@When("he clicks on add new button")
	public void he_clicks_on_add_new_button() throws InterruptedException {
		Thread.sleep(2000);
		t = new TaskListPage(driver);
		Thread.sleep(2000);
		t.getAddNewBtn().click();
	}

	@And("he clicks on new customer button")
	public void he_clicks_on_new_customer_button() throws InterruptedException {
		Thread.sleep(2000);
		t.getNewCustomerOption().click();
	}

	@Then("create new customer popup should be displayed")
	public void create_new_customer_popup_should_be_displayed() {
		boolean res = t.getCreateCustomerPopup().isDisplayed();
		Assert.assertTrue(res, "create new customer popup is not displayed");
	}

	@When("he enters the customer name as {string}")
	public void he_enters_the_customer_name_as(String cusName) {
		t.getEnterCustomerNameTbx().sendKeys(cusName);
	}

	@And("he enters the description as {string}")
	public void he_enters_the_description_as(String cusDesc) {
		t.getCustomerDescriptionTbx().sendKeys(cusDesc);
	}

	@And("he selects our company in the dropdown")
	public void he_selects_our_company_in_the_dropdown() throws InterruptedException {
		Thread.sleep(2000);
		t.getSelectDD().click();
	
		Thread.sleep(2000);
		t.getOurCompanyOption().click();
	}
	@When("he clicks on create customer button")
	public void he_clicks_on_create_customer_button() throws InterruptedException {
		Thread.sleep(2000);
		t.getCreateCustomerBtn().click();
	}
	@Then("Customer should be created as {string}")
	public void customer_should_be_created_as(String expectedName) throws InterruptedException {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		WebElement ele = t.getVerifyCustomerName();
		wait.until(ExpectedConditions.textToBePresentInElement(ele, expectedName));
		String actualName = ele.getText();
		Assert.assertEquals(actualName, expectedName);
	}

}
