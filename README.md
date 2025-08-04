# 🧪 Automation Exercise – E2E Test Project

This project automates an end-to-end user journey on [Automation Exercise](https://automationexercise.com) using:
- Selenium WebDriver  
- TestNG  
- Page Object Model (POM)  
- JSON-based test data  
- WebDriverManager & Extent Reports

---

## 📌 Scenario Overview (Given / When / Then)

**Given**  
The user is registered and logged in.

**When**  
- They search and add two products to the cart  
- Complete the checkout with shipping and payment info  
- Submit a query via the Contact Us form  
- Log out and try to access a restricted page

**Then**  
- ✅ Correct product details and total prices are shown  
- ✅ Order confirmation is received  
- ✅ Support query confirmation is displayed  
- ✅ User is redirected to Login page after logout

---

📁 Project Structure
src/test/java/
├── pages/         # Page classes
├── tests/         # Test classes
├── base/          # Base setup and driver management
├── utilities/     # Helpers, DataProviders, Assertions
└── resources/     # JSON test data


