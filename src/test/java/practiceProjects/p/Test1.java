package practiceProjects.p;


import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import listeners.TestListener;
import practiceProjects1.BaseClass;
import practiceProjects1.Login;
import practiceProjects1.addToCart; 


@Listeners(TestListener.class)
public class Test1 extends BaseClass {

	@Test(dataProvider ="LoginData")
	public void LoginPage(String username, String password, boolean isValid) {
		//driver.get("https://automationexercise.com/login");
		Login page = new Login(driver);

		page.entreUserName(username);
		page.enterPass(password);
		page.Submit();

		if(isValid) {
			boolean successVisible = page.isLoginSuccess();
			Assert.assertTrue(successVisible, "Expected successful login, but failed.");
			System.out.println("Login successfull for: "+ username);
			
			addToCart carting = new addToCart(driver);

			carting.clickCart();
			System.out.println("Entered click cart option");

			carting.clickHere();
			System.out.println("Clicked on here option");

			carting.addProduct();
			System.out.println("Product selected");

			carting.addedCart();
			System.out.println("Product added in cart");

			//		carting.clickArrow();

			carting.clickcart1();
			System.out.println("Selected cart one more time");
			carting.increaseQuantity("3");
			carting.clickcartAgain();
			carting.veiwCart();
			
			int unit =  carting.getUnitPrice();
			int total = carting.getTotalPrice();
			System.out.println("Unit price of the priduct: " +unit);
			System.out.println("Total price of the product: "+ total);
			
			Assert.assertEquals(total, unit * 4, "cart total mismatch with quantity x unit price!");
			System.out.println("Price validation passed for quantut 4.");
		}
		else {
			boolean errorVisible =  page.isLoginErrorVisible();
			Assert.assertTrue(errorVisible, "Expected login failure, but login succeeded.");
			System.out.println("Login fails as epected for: "+ username);
		}
		
		}

	@DataProvider(name="LoginData", parallel=false)

	public Object [][] LoginData(){
		return new Object[][] {
			  // Valid
			{"invaliduser1@gmail.com", "wrongpass1", false},           // Invalid
			{"prabhakargogi543@gmail.com", "Prabhu@17091989", true},
			{"invaliduser2@gmail.com", "wrongpass2", false}			//invalid
		};
	}

	

	
}

