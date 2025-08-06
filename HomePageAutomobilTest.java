package polovniautomobil;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

/**
 * This test class performs a basic test on the homepage of the Polovni
 * Automobili website by selecting a car brand and model.
 * 
 * It extends the BaseTestCase class where WebDriver setup is defined.
 */
public class HomePageAutomobilTest extends BaseTestCase {

	/**
	 * This method runs before each test method. It navigates to the homepage of
	 * Polovni Automobili.
	 */
	@BeforeMethod
	public void navigation() {
		driver.navigate().to("https://www.polovniautomobili.com/");
	}

	/**
	 * This method runs after each test method. It deletes all cookies to ensure a
	 * clean session for each test.
	 */
	@AfterMethod
	public void deleteCookies() {
		driver.manage().deleteAllCookies();
	}

	/**
	 * Test case: 1. Selects the car brand "Audi". 2. Selects the model "A3". 3.
	 * Clicks the "Search" button.
	 * 
	 * Expected result: The search results page should open showing vehicles
	 * matching the selected brand and model.
	 */
	@Test
	public void testBrandMarka() {
		automobilHomePage.selectMarka("Audi"); // Select brand
		automobilHomePage.selectModel("A3"); // Select model
		automobilHomePage.buttonClick(); // Click the "Search" button
	}
}
