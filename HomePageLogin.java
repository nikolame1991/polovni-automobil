package polovniautomobil;

import static org.testng.Assert.assertTrue;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePageLogin {

	WebDriver driver;
	WebDriverWait wait;

	// Page elements (locators)

	// "Registruj se" button in the top header
	@FindBy(xpath = "//*[@id=\"top_header\"]/div[2]/div[2]/div/div/a[6]")
	WebElement clickRegistruj;

	// Email input field
	@FindBy(xpath = "//*[@id=\"email\"]")
	WebElement inputFieldEmail;

	// Password input field
	@FindBy(xpath = "//*[@id=\"password_first\"]")
	WebElement inputFieldPassword;

	// Confirm password input field
	@FindBy(xpath = "//*[@id=\"password_second\"]")
	WebElement inputFieldPasswordConfirm;

	// "I accept Terms of Service" checkbox
	@FindBy(xpath = "//*[@id=\"tos\"]")
	WebElement checkBoxClickPrihvatamU;

	// Easy Sale consent checkbox
	@FindBy(xpath = "//*[@id=\"easySaleConsent\"]")
	WebElement checkBoxEasySaleConsent;

	// Easy Buy consent checkbox
	@FindBy(xpath = "//*[@id=\"easyBuyConsent\"]")
	WebElement checkBoxEaseBuyConsent;

	// "Register" button
	@FindBy(xpath = "/html/body/div[1]/div/div/div/div/div/div/div[1]/form/div[10]/button")
	WebElement clickButtonRegistrujSe;

	// First success message after registration
	@FindBy(xpath = "/html/body/div/div/div/div/div/p[1]")
	WebElement firstMessageDisplayed;

	// Second message after registration
	@FindBy(xpath = "/html/body/div/div/div/div/div/p[2]")
	WebElement secondMessageDisplayed;

	// Logo image that links back to home page
	@FindBy(xpath = "/html/body/div/div/a/img")
	WebElement clickImgLink;

	// Error message for email input
	@FindBy(xpath = "//*[@id=\"register_email_error\"]")
	WebElement messageErrorEmail;

	// Error message when password and confirm password do not match
	@FindBy(xpath = "/html/body/div[1]/div/div/div/div/div/div/div[1]/form/div[3]/div[1]")
	WebElement messageErrorPasswordAndConfirm;

	// Constructor
	public HomePageLogin(WebDriver driver) {
		this.driver = driver;
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		PageFactory.initElements(driver, this);
	}

	// Click the "Register" link to open the registration form
	public void registrujseClick() {
		wait.until(ExpectedConditions.elementToBeClickable(clickRegistruj)).click();
	}

	// Enter email into the email field
	public void emilFieldInput(String email) {
		wait.until(ExpectedConditions.visibilityOf(inputFieldEmail));
		inputFieldEmail.sendKeys(email);
	}

	// Enter password into the password field
	public void passwordFieldInput(String password) {
		wait.until(ExpectedConditions.visibilityOf(inputFieldPassword));
		inputFieldPassword.sendKeys(password);
	}

	// Enter password confirmation
	public void passwordConfirmFieldInput(String passwordConfirm) {
		wait.until(ExpectedConditions.visibilityOf(inputFieldPasswordConfirm));
		inputFieldPasswordConfirm.sendKeys(passwordConfirm);
	}

	// Click on the "I accept Terms of Service" checkbox
	public void prihvatamClickBox() {
		wait.until(ExpectedConditions.elementToBeClickable(checkBoxClickPrihvatamU)).click();
	}

	// Click on the Easy Sale consent checkbox
	public void saleConcentCheckbox() {
		wait.until(ExpectedConditions.elementToBeClickable(checkBoxEasySaleConsent)).click();
	}

	// Click on the Easy Buy consent checkbox
	public void buyConcentCheckbox() {
		wait.until(ExpectedConditions.elementToBeClickable(checkBoxEaseBuyConsent)).click();
	}

	// Click on the "Register" button to submit the form
	public void registrujSeButtonClick() {
		wait.until(ExpectedConditions.elementToBeClickable(clickButtonRegistrujSe)).click();
	}

	// Verify that the first registration success message is visible
	public void messageFirstDisplay() {
		WebElement mainFirstTitle = wait
				.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div/div/div/div/div/p[1]")));

		boolean isVisible = mainFirstTitle.isDisplayed();
		System.out.println("Success message is visible: " + isVisible);
		assertTrue(isVisible, "The message 'Hvala na registraciji!' is not visible.");
	}

	// Return true if the second registration message is visible
	public boolean messageSecondDisplay() {
		return wait
				.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div/div/div/div/div/p[2]")))
				.isDisplayed();
	}

	// Click on the home page logo to return to the homepage
	public void imgClickLink() {
		wait.until(ExpectedConditions.elementToBeClickable(clickImgLink)).click();
	}

	// Check if the error message for email input is visible
	public boolean errorMessageEmail() {
		WebElement errorEmail = wait
				.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"register_email_error\"]")));
		return errorEmail.isDisplayed();
	}

	// Check if the password mismatch error message is displayed
	public boolean isPasswordMismatchErrorDisplayed() {
		WebElement errorMessage = wait.until(ExpectedConditions.visibilityOfElementLocated(
				By.xpath("/html/body/div[1]/div/div/div/div/div/div/div[1]/form/div[3]/div[1]")));
		return errorMessage.isDisplayed();
	}
}
