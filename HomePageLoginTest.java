package polovniautomobil;

import static org.testng.Assert.assertTrue;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

// Test class for registration functionality on the PolovniAutomobili website
public class HomePageLoginTest extends BaseTestCase {

	// This method runs before each test method
	@BeforeMethod
	public void navigation() {
		// Navigate to the homepage before every test
		driver.navigate().to("https://www.polovniautomobili.com/");
	}

	// This method runs after each test method
	@AfterMethod
	public void deleteCookies() {
		// Clear all cookies after each test to reset the session
		driver.manage().deleteAllCookies();
	}

	// Positive test: Successful registration
	@Test
	public void testLogin() {
		// Open the registration form
		loginPageHome.registrujseClick();

		// Fill out the registration form with valid data
		loginPageHome.emilFieldInput("brucewaynebatman1901@gmail.com");
		loginPageHome.passwordFieldInput("N!k0L@1991");
		loginPageHome.passwordConfirmFieldInput("N!k0L@1991");

		// Accept terms and optional consents
		loginPageHome.prihvatamClickBox();
		loginPageHome.saleConcentCheckbox();
		loginPageHome.buyConcentCheckbox();

		// Submit the form
		loginPageHome.registrujSeButtonClick();

		// Verify that success messages are displayed
		loginPageHome.messageFirstDisplay();
		loginPageHome.messageSecondDisplay();

		// Click the site logo to return to the homepage
		loginPageHome.imgClickLink();
	}

	// Negative test: Invalid email format
	@Test
	public void testLoginWrongEmail() {
		// Open the registration form
		loginPageHome.registrujseClick();

		// Fill out the form with invalid email format (missing @)
		loginPageHome.emilFieldInput("brucewaynebatman1901gmailcom");
		loginPageHome.passwordFieldInput("N!k0L@1991");
		loginPageHome.passwordConfirmFieldInput("N!k0L@1991");

		// Accept terms and optional consents
		loginPageHome.prihvatamClickBox();
		loginPageHome.saleConcentCheckbox();
		loginPageHome.buyConcentCheckbox();

		// Submit the form
		loginPageHome.registrujSeButtonClick();

		// Assert that the email error message is displayed
		assertTrue(loginPageHome.errorMessageEmail(), "Error message for invalid email is not displayed.");
	}

	// Negative test: Password and confirmation do not match
	@Test
	public void testLoginWrongPassword() {
		// Open the registration form
		loginPageHome.registrujseClick();

		// Fill out the form with mismatched passwords
		loginPageHome.emilFieldInput("brucewaynebatman1901a@gmail.com");
		loginPageHome.passwordFieldInput("N!k0L@1991");
		loginPageHome.passwordConfirmFieldInput("N!k0L@1992"); // mismatch

		// Accept terms and optional consents
		loginPageHome.prihvatamClickBox();
		loginPageHome.saleConcentCheckbox();
		loginPageHome.buyConcentCheckbox();

		// Submit the form
		loginPageHome.registrujSeButtonClick();

		// Assert that the password mismatch error message is displayed
		assertTrue(loginPageHome.isPasswordMismatchErrorDisplayed(),
				"Error message for password mismatch is not displayed.");
	}
}
