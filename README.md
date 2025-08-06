# Polovni Automobili – Selenium Test Automation

Selenium Java automation tests for [PolovniAutomobili.com](https://www.polovniautomobili.com/) using Page Object Model (POM) and TestNG framework. Includes registration tests, brand/model filter functionality, and custom error analysis.

---

## 🛠 Tech Stack

- Java
- Selenium WebDriver
- TestNG
- Page Object Model (POM)
- Git

---

## 📄 Description

This automation project covers two main functionalities of the PolovniAutomobili.com website:

### 🔹 Registration Tests

- ✅ Positive test – successful registration
- ❌ Negative test – invalid email format
- ❌ Negative test – password mismatch

### 🔹 Car Search Filter Test

- Select brand "Audi"
- Select model "A3"
- Click "Pretraga" button

⚠️ **Note:** Due to frequent DOM changes on the live website, some locators (e.g., `#submit_1`) may throw `NoSuchElementException`. These are intentionally left in the project and commented with analysis, to demonstrate debugging and QA thinking process.

---

## 📂 Project Structure

src/polovniautomobil/
│
├── BaseTestCase.java # WebDriver setup
├── HomePageLogin.java # Registration Page Object
├── HomePageLoginTest.java # Registration test cases
├── HomePageAutomobil.java # Car filter Page Object
├── HomePageAutomobilTest.java # Car search test
├── TestData.java # DataProvider for registration


---

## 🧠 Notes

Some elements, especially on the search page, behave dynamically or inconsistently (e.g., model dropdown depending on selected brand). These issues are captured in the test logic and documented to highlight the QA process of investigation and problem solving.

---

## ▶️ How to Run

1. Clone this repository
2. Open the project in your IDE (Eclipse / IntelliJ / VS Code)
3. Make sure you have ChromeDriver installed and configured
4. Run any `@Test` method with TestNG

---

## 👤 Author

**Nikola Medan**  
📍 Novi Sad, Serbia  
🔗 [LinkedIn](https://www.linkedin.com/in/nikola-medan-99a923124)

