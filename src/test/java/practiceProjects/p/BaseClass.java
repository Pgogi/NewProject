package practiceProjects.p;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeMethod;

import practiceProjects1.Browser;

import org.testng.annotations.AfterMethod;


public class BaseClass {
	
	public WebDriver driver;
	
	@BeforeMethod
	public void setup() {
		
		driver = Browser.StartApplication(driver, "Chrome", "https://automationexercise.com/login");
		System.out.println("Chrome launched successfully");
	}
	
	@AfterMethod
	public void teardown() {
		Browser.quitting(driver);
		System.out.println("browser closed successfully");
		
	}

}
