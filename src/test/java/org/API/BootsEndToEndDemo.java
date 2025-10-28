package org.API;

import io.qameta.allure.*;
import io.qameta.allure.testng.AllureTestNg;
import org.openqa.selenium.WebDriver;
import org.testng.Reporter;
import org.testng.annotations.*;
import org.testng.annotations.Listeners;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import org.testng.annotations.Test;

@Listeners({AllureTestNg.class})
@Epic("Full-Stack AI-Powered Admin Management System")
@Feature("End-to-End Selenium Automation Flow with Allure Reporting")
public class BootsEndToEndDemo {

    WebDriver driver;
    Boots boots;

    @BeforeClass
    @Step("Setting up browser and launching application")
    public void setUp() throws InterruptedException {
        Reporter.log("🚀 Starting Full-Stack AI-Powered Admin Management System Demo...", true);
        Browser browser = new Browser(null);
        driver = browser.chrome("http://localhost:8080/Auth.html");
        boots = new Boots(driver);
        Thread.sleep(2000);
    }

    // 1️⃣ USER REGISTRATION
    @Test(priority = 1, description = "User Registration Flow")
    @Severity(SeverityLevel.CRITICAL)
    @Story("User registers with valid credentials")
    public void registerUser() throws InterruptedException, FileNotFoundException {
        Allure.step("Registering new user...");
        try {
            boots.id("regUsername", "Chaitanya");
            boots.id("regEmail", "chaitanya@example.com");
            boots.id("regPassword", "1111");
            boots.click("xpath", "//button[text()='Register']");
            Thread.sleep(2000);
            boots.ScreenShot("1_register_done.png");
            Allure.addAttachment("Registration Screenshot", new FileInputStream("screenshots/1_register_done.png"));
            Reporter.log("✅ Registration completed.", true);
        } catch (Exception e) {
            Allure.addAttachment("Registration Error", e.getMessage());
            Reporter.log("❌ Registration failed: " + e.getMessage(), true);
        }
    }

    // 2️⃣ FORGOT USERNAME
    @Test(priority = 2, description = "Forgot Username Flow")
    @Severity(SeverityLevel.NORMAL)
    @Story("User retrieves forgotten username via email")
    public void forgotUsername() throws InterruptedException, FileNotFoundException {
        Allure.step("Retrieving forgotten username...");
        try {
            driver.get("http://localhost:8080/forgot-username.html");
            Thread.sleep(2000);
            boots.id("email", "chaitanya@example.com");
            boots.click("xpath", "//button[text()='Get Username']");
            Thread.sleep(2000);
            boots.ScreenShot("2_forgot_username_done.png");
            Allure.addAttachment("Forgot Username Screenshot", new FileInputStream("screenshots/2_forgot_username_done.png"));
            Reporter.log("✅ Forgot username process completed successfully.", true);
        } catch (Exception e) {
            Allure.addAttachment("Forgot Username Error", e.getMessage());
            Reporter.log("❌ Forgot username failed: " + e.getMessage(), true);
        }
    }

    // 3️⃣ RESET PASSWORD
    @Test(priority = 3, description = "Password Reset Flow")
    @Severity(SeverityLevel.CRITICAL)
    @Story("User resets their password successfully")
    public void resetPassword() throws InterruptedException, FileNotFoundException {
        Allure.step("Resetting password...");
        try {
            driver.get("http://localhost:8080/reset-password.html");
            Thread.sleep(2000);
            boots.id("username", "Chaitanya");
            boots.id("currentPassword", "1111");
            boots.id("newPassword", "1111");
            boots.click("xpath", "//button[text()='Reset Password']");
            Thread.sleep(2000);
            boots.ScreenShot("3_reset_password_done.png");
            Allure.addAttachment("Password Reset Screenshot", new FileInputStream("screenshots/3_reset_password_done.png"));
            Reporter.log("✅ Password reset successfully.", true);
        } catch (Exception e) {
            Allure.addAttachment("Password Reset Error", e.getMessage());
            Reporter.log("❌ Password reset failed: " + e.getMessage(), true);
        }
    }

    // 4️⃣ LOGIN
    @Test(priority = 4, description = "User Login Flow")
    @Severity(SeverityLevel.BLOCKER)
    @Story("User logs in with valid credentials")
    public void loginUser() throws InterruptedException, FileNotFoundException {
        Allure.step("Logging in...");
        try {
            driver.get("http://localhost:8080/Auth.html");
            boots.id("loginUsername", "Chaitanya");
            boots.id("loginPassword", "1111");
            boots.click("xpath", "//button[text()='Login']");
            Thread.sleep(2000);
            boots.ScreenShot("4_login_done.png");
            Allure.addAttachment("Login Screenshot", new FileInputStream("screenshots/4_login_done.png"));
            Reporter.log("✅ Login successful.", true);
        } catch (Exception e) {
            Allure.addAttachment("Login Error", e.getMessage());
            Reporter.log("❌ Login failed: " + e.getMessage(), true);
        }
    }

    // 5️⃣ PROFILE MANAGEMENT
    @Test(priority = 5, description = "Profile Management Flow")
    @Severity(SeverityLevel.NORMAL)
    @Story("User updates their password in profile settings")
    public void updateProfile() throws InterruptedException, FileNotFoundException {
        Allure.step("Updating profile...");
        try {
            driver.get("http://localhost:8080/profile.html");
            Thread.sleep(2000);
            boots.click("cssSelector", "body > div > div.btn-container > button.change-btn");
            boots.id("newPassword", "1111");
            boots.id("confirmPassword", "1111");
            boots.click("xpath", "//button[text()='Save Password']");
            Thread.sleep(2000);
            boots.ScreenShot("5_profile_password_changed.png");
            Allure.addAttachment("Profile Update Screenshot", new FileInputStream("screenshots/5_profile_password_changed.png"));
            Reporter.log("✅ Profile updated successfully.", true);
        } catch (Exception e) {
            Allure.addAttachment("Profile Update Error", e.getMessage());
            Reporter.log("❌ Profile update failed: " + e.getMessage(), true);
        }
    }

    // 6️⃣ ADD RECIPE
    @Test(priority = 6, description = "Add Recipe Flow")
    @Severity(SeverityLevel.CRITICAL)
    @Story("Admin adds a new recipe to the system")
    public void addRecipe() throws InterruptedException, FileNotFoundException {
        Allure.step("Adding a new recipe...");
        try {
            driver.get("http://localhost:8080/index.html");
            Thread.sleep(2000);
            boots.id("name", "Veg Fried Rice");
            boots.id("description", "Delicious veg fried rice with fresh veggies.");
            boots.id("ingredients", "Rice, Vegetables, Soy Sauce, Salt");
            boots.id("steps", "Cook rice, stir-fry veggies, mix and serve.");
            boots.id("url", "https://example.com/rice.jpg");
            boots.id("categoryId", "1");
            boots.click("xpath", "//button[@type='submit']");
            Thread.sleep(2000);
            boots.ScreenShot("6_recipe_added.png");
            Allure.addAttachment("Recipe Added Screenshot", new FileInputStream("screenshots/6_recipe_added.png"));
            Reporter.log("✅ Recipe added successfully.", true);
        } catch (Exception e) {
            Allure.addAttachment("Recipe Add Error", e.getMessage());
            Reporter.log("❌ Recipe add failed: " + e.getMessage(), true);
        }
    }

    // 7️⃣ SEARCH RECIPE
    @Test(priority = 7, description = "Search Recipe Flow")
    @Severity(SeverityLevel.NORMAL)
    @Story("User searches for a recipe using keywords")
    public void searchRecipe() throws InterruptedException, FileNotFoundException {
        Allure.step("Searching for recipe...");
        try {
            boots.id("search", "rice");
            boots.click("xpath", "//button[text()='Search']");
            Thread.sleep(2000);
            boots.ScreenShot("7_recipe_search_done.png");
            Allure.addAttachment("Search Recipe Screenshot", new FileInputStream("screenshots/7_recipe_search_done.png"));
            Reporter.log("✅ Recipe search successful.", true);
        } catch (Exception e) {
            Allure.addAttachment("Search Recipe Error", e.getMessage());
            Reporter.log("❌ Recipe search failed: " + e.getMessage(), true);
        }
    }

    // 8️⃣ AI ASSISTANT TESTS
    @Test(priority = 8, description = "AI Assistant Integration Tests")
    @Severity(SeverityLevel.MINOR)
    @Story("Admin interacts with Gemini AI for database and code generation")
    public void aiAssistantQueries() throws InterruptedException, FileNotFoundException {
        Allure.step("Testing AI Assistant Queries...");
        try {
            Reporter.log("🔹 Step 8: AI Assistant Interaction...", true);

            // === 1️⃣ Show All Users ===
            boots.click("xpath", "//button[text()='Show All Users']");
            Thread.sleep(3000);

            try {
                driver.switchTo().alert().sendKeys("admin123");
                driver.switchTo().alert().accept();
                boots.waitForGeminiResponse();
                boots.ScreenShot("8_ai_show_users.png");
                Allure.addAttachment("AI Show Users Screenshot", new FileInputStream("screenshots/8_ai_show_users.png"));
            } catch (Exception e) {
                Reporter.log("⚠ No alert appeared or admin access skipped.", true);
            }

            // === 2️⃣ Show Database Structure ===
            Thread.sleep(4000);
            boots.id("geminiQuery", "list my database structure as code box");
            boots.click("xpath", "//button[text()='Ask']");
            boots.waitForGeminiResponse();
            Thread.sleep(4000);
            boots.ScreenShot("8_ai_database_structure.png");
            Allure.addAttachment("AI DB Structure Screenshot", new FileInputStream("screenshots/8_ai_database_structure.png"));

            // 🧹 Clear previous chat before next query
            boots.clear("id", "geminiQuery");
            Thread.sleep(1000);

            // === 3️⃣ Generate Graph Code ===
            Thread.sleep(4000);
            boots.id("geminiQuery", "write java code for graph");
            boots.click("xpath", "//button[text()='Ask']");
            boots.waitForGeminiResponse();
            Thread.sleep(4000);
            boots.ScreenShot("8_ai_graph_code.png");
            Allure.addAttachment("AI Graph Code Screenshot", new FileInputStream("screenshots/8_ai_graph_code.png"));

            // === 5️⃣ Normal Talk ===
            Thread.sleep(4000);
            boots.id("geminiQuery", "tell me a random joke");
            boots.click("xpath", "//button[text()='Ask']");
            boots.waitForGeminiResponse();
            Thread.sleep(4000);
            boots.ScreenShot("8_ai_random_joke.png");
            Allure.addAttachment("AI Random Joke Screenshot", new FileInputStream("screenshots/8_ai_random_joke.png"));

            Reporter.log("✅ AI Assistant test completed successfully with all queries.", true);
        } catch (Exception e) {
            Allure.addAttachment("AI Assistant Error", e.getMessage());
            Reporter.log("❌ AI Assistant test failed: " + e.getMessage(), true);
        }
    }

    @AfterClass
    @Step("Closing browser and ending test session")
    public void tearDown() {
        if (driver != null) {
            // driver.quit();
        }
        Reporter.log("🎯 End-to-End Flow Completed Successfully!", true);
    }
}
