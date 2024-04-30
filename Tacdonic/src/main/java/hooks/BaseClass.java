package hooks;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.actitime.generic.FileLib;
import com.actitime.pom.HomePage;
import com.actitime.pom.LoginPage;

import io.cucumber.java.After;
import io.cucumber.java.Before;

public class BaseClass {
	public static WebDriver driver;
	@Before(order=1)
public void openBrowser() throws IOException {
	driver=new ChromeDriver();
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
	FileLib f=new FileLib();
	String url = f.getPropertyData("url");
	driver.get(url);
}	@Before(order=2)
public void login() throws IOException {
	LoginPage l=new LoginPage(driver);
	FileLib f=new FileLib();
	String un = f.getPropertyData("username");
	String pwd = f.getPropertyData("password");
	l.setLogin(un,pwd);
}	@After(order=2)
public void logout() {
	HomePage h=new HomePage(driver);
	h.setLogout();
}	@After(order=1)
public void closeBrowser() {
	driver.manage().window().minimize();
	driver.quit();
}
}