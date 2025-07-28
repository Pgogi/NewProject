package practiceProjects1;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class addToCart {

	WebDriver driver;
	WebDriverWait wait;
	
	public addToCart(WebDriver driver) {
		this.driver = driver;
		 wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		PageFactory.initElements(driver, this);
	}
	
	//Locators finding
	@FindBy(xpath="//a[text()=' Cart']") WebElement click1;
	
	@FindBy(xpath="//a[u='here']") WebElement click2;
	
	@FindBy(xpath="//div[@class='productinfo text-center']//a[@data-product-id='2']") WebElement click3;
	
	@FindBy(linkText="View Cart") WebElement click4;
	
	@FindBy(xpath="//a[contains(text(),'Men Tshirt')]") WebElement click5;
	
	@FindBy(xpath = "//input[@id='quantity']") WebElement quantityInput;
	
	@FindBy(xpath="//button[contains(normalize-space(), 'Add to cart')]") WebElement click6;
	
	@FindBy(xpath="//u[text()='View Cart']") WebElement click7;
	
	@FindBy(xpath="//td[@class='cart_price']/p") WebElement unitPrice;
	
	@FindBy(xpath="//td[@class='cart_total']/p") WebElement totalPrice;
	
	//methods
	public void clickCart() {
		wait.until(ExpectedConditions.elementToBeClickable(click1)).click();
		System.out.println("Clicked on cart option");
	}
	
	public void clickHere() {
		wait.until(ExpectedConditions.elementToBeClickable(click2)).click();
		System.out.println("Clicked on here option");
	}
	
	public void addProduct() {
		click3.click();
		System.out.println("Selected one product");
	}
	
	//click on continue shopping
	public void addedCart() {
		wait.until(ExpectedConditions.elementToBeClickable(click4)).click();
		System.out.println("Product added to the cart");
	}
	
	public void clickcart1() {
		click5.click();
		System.out.println("Clicked on Men Tshirt");
	}
	
	public void increaseQuantity(String qty) {
		
	    quantityInput.clear();               // Clear default value "1"
	    quantityInput.sendKeys(qty);        // Set desired quantity
	    System.out.println("Quantity set to: " + qty);
	}
	public void clickcartAgain() {
		wait.until(ExpectedConditions.elementToBeClickable(click6)).click();
		System.out.println("Few more quantities added");
	}
	
	public void veiwCart() {
		click7.click();
	}
	
	public int getUnitPrice() {
		String priceText = unitPrice.getText().replaceAll("[^0-9]", "");
		return Integer.parseInt(priceText);
	}
	
	public int getTotalPrice() {
		String totalText = totalPrice.getText().replaceAll("[^0-9]", "");
		return Integer.parseInt(totalText);
	}
}
