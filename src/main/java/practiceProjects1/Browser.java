package practiceProjects1;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Browser {

	public static WebDriver StartApplication(WebDriver driver, String browser, String url) {
	
		if(browser.equals("Chrome")) {
			driver = new ChromeDriver();
			System.out.println("Selected the chrome browser");
		}
		else if(browser.equals("Firefox")) {
			driver = new FirefoxDriver();
			System.out.println("Firefox selected");
		}
		else {
			System.out.println("System does not support this browser");
		}
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get(url);
		return driver;
	}
	
	public static void quitting(WebDriver driver) {
	
		if(driver != null) {
			driver.quit();
		}
	}
}
