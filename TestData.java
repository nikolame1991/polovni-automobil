package polovniautomobil;

import org.testng.annotations.DataProvider;

/**
 * This class provides test data for login functionality on the Polovni
 * Automobili website using TestNG's @DataProvider annotation.
 */
public class TestData {

	// Correct test credentials that can be used for validation
	public String correctEmail = "brucewaynebatman1901@gmail.com";
	public String correctPassword = "N!k0L@1991";
	public String correctPasswordConfirm = "N!k0L@1991";

	/**
	 * DataProvider method that supplies multiple sets of test data for
	 * login-related tests. Each object array contains: [0] - email [1] - password
	 * [2] - password confirmation
	 *
	 * @return Object[][] - multiple sets of login credentials
	 */
	@DataProvider(name = "HomePageLoginTest")
	public Object[][] loginPolovniAutomobili() {
		return new Object[][] { { "brucewaynebatman1901@gmail.com", "N!k0L@1991", "N!k0L@1991" }, // Valid credentials
				{ "nikola@gmail.com", "nikola1991", "nikola1991" } // Example of another test set
		};
	}
}
