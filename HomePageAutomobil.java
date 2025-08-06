package polovniautomobil;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePageAutomobil {
	WebDriver driver;
	WebDriverWait wait;

	// Dropdown za izbor marke vozila (npr. Audi, BMW, Opel...)
	@FindBy(xpath = "//*[@id=\"brand\"]")
	WebElement brandDropdown;

	// Dropdown za izbor modela u okviru izabrane marke (npr. A3, Corsa, X5...)
	@FindBy(xpath = "//*[@id=\"model\"]")
	WebElement modelDropDown;

	// Dropdown za vrstu goriva (dizel, benzin, hibrid...) — trenutno ne koristiš u
	// testu
	@FindBy(xpath = "//*[@id=\"search-form\"]/div/form/div[1]/div[1]/div/div[8]/div/p/span")
	WebElement fuelDropDown;

	// Dugme "Pretraga" koje pokreće filtriranje oglasa
	@FindBy(xpath = "//*[@id=\"submit_1\"]")
	WebElement clickButtonPretraga;

	// Konstruktor stranice, inicijalizuje WebDriver i WebDriverWait
	public HomePageAutomobil(WebDriver driver) {
		this.driver = driver;
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		PageFactory.initElements(driver, this);
	}

	// Metoda za izbor marke automobila iz padajuće liste
	public void selectMarka(String marka) {
		Select select = new Select(brandDropdown);
		select.selectByVisibleText(marka);
	}

	// Metoda za izbor modela automobila u okviru prethodno izabrane marke
	public void selectModel(String model) {
		// Sačekaj da se dropdown za model aktivira (postane enable)
		wait.until(driver -> modelDropDown.isEnabled());

		// Sačekaj da se pojavi konkretna opcija u dropdown-u
		wait.until(driver -> {
			Select select = new Select(modelDropDown);
			return select.getOptions().stream().anyMatch(option -> option.getText().equals(model));
		});

		// Selektuj model
		Select select = new Select(modelDropDown);
		select.selectByVisibleText(model);
	}

	// Klikni na dugme "Pretraga"
	public void buttonClick() {
		wait.until(ExpectedConditions.elementToBeClickable(clickButtonPretraga)).click();
	}
}
