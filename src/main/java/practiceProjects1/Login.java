package practiceProjects1;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Login {

	WebDriver driver;

	public Login(WebDriver driver) {

		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	//locators
	@FindBy(xpath="//input[@data-qa=\"login-email\"]") WebElement username;

	@FindBy(xpath="//input[@data-qa=\"login-password\"]") WebElement password;
	
	@FindBy(xpath="//button[@data-qa=\"login-button\"]") WebElement submit;

	//login message
	@FindBy(xpath="//a[contains(text(),' Logout')]") WebElement logoutButton;
	
	//error message
	@FindBy(xpath="//p[contains(text(),'incorrect')]") WebElement loginErrorMessage;
	
	
	//Methods
	public void entreUserName(String uname) {
		username.clear();
		username.sendKeys(uname);
		System.out.println("User name entered");
	}
	
	public void enterPass(String pass) {
		password.clear();
		password.sendKeys(pass);
		System.out.println("Password entered");
	}
	public void Submit() {
		submit.click();
		System.out.println("Logged in successfully");
	}
	
	public boolean isLoginSuccess() {
		try {
			Thread.sleep(2000);
			return logoutButton.isDisplayed();
		}
		catch(Exception e) {
			return false;
		}
	}
	
	public boolean  isLoginErrorVisible() {
		try {
			Thread.sleep(1000); // Wait for error message to appear
			return loginErrorMessage.isDisplayed();
		} catch (Exception e) {
			return false;
		}
	}
	
}
