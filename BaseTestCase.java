package polovniautomobil;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

// Base test class to handle common setup and teardown operations
public class BaseTestCase {

	// WebDriver instance used for all test classes that extend this base
	WebDriver driver;

	// Page Object for the login/registration page
	HomePageLogin loginPageHome;

	HomePageAutomobil automobilHomePage;

	// This method runs once before all test methods in the class
	@BeforeTest
	public void initalization() {
		// Initialize Chrome browser
		driver = new ChromeDriver();

		// Maximize the browser window
		driver.manage().window().maximize();

		// Initialize the page object with the WebDriver
		loginPageHome = new HomePageLogin(driver);

		automobilHomePage = new HomePageAutomobil(driver);
	}

	// This method runs once after all test methods in the class have run
	@AfterTest
	public void closeDriver() {
		// Close the browser and end the session
		driver.quit();
	}
}
