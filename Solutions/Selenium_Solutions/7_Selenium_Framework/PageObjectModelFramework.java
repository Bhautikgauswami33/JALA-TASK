class BasePage {
    public void waitForPageLoad() {
        System.out.println("Waiting for page to load...");
    }
    
    public void verifyPageTitle(String expectedTitle) {
        System.out.println("Verifying page title matches: " + expectedTitle);
    }
    
    public void takeScreenshot(String fileName) {
        System.out.println("Taking screenshot: " + fileName);
    }
}

class LoginPage extends BasePage {
    private String usernameField = "username";
    private String passwordField = "password";
    private String loginButton = "loginBtn";
    private String forgotPasswordLink = "forgotPwd";
    
    public void enterUsername(String username) {
        System.out.println("Entering username: " + username);
    }
    
    public void enterPassword(String password) {
        System.out.println("Entering password: " + password);
    }
    
    public void clickLoginButton() {
        System.out.println("Clicking login button");
    }
    
    public void clickForgotPassword() {
        System.out.println("Clicking forgot password link");
    }
    
    public void loginToApplication(String username, String password) {
        enterUsername(username);
        enterPassword(password);
        clickLoginButton();
    }
}

class DashboardPage extends BasePage {
    private String welcomeMessage = "welcomeMsg";
    private String logoutButton = "logoutBtn";
    private String profileLink = "profileLnk";
    
    public void verifyUserLoggedIn(String username) {
        System.out.println("Verifying user " + username + " is logged in");
    }
    
    public void clickLogout() {
        System.out.println("Clicking logout button");
    }
    
    public void navigateToProfile() {
        System.out.println("Navigating to profile");
    }
}

class Config {
    public static final String BASE_URL = "http://magnus.jalatechnologies.com/";
    public static final String BROWSER = "firefox";
    public static final String USERNAME = "training@jalaacademy.com";
    public static final String PASSWORD = "jobprogram";
    public static final int IMPLICIT_WAIT = 10;
    public static final int EXPLICIT_WAIT = 20;
}

class TestData {
    public static final String VALID_USERNAME = "training@jalaacademy.com";
    public static final String VALID_PASSWORD = "jobprogram";
    public static final String INVALID_USERNAME = "invalid@example.com";
    public static final String INVALID_PASSWORD = "wrongpassword";
    
    public static Object[][] getLoginTestData() {
        return new Object[][] {
            {VALID_USERNAME, VALID_PASSWORD, "Success"},
            {INVALID_USERNAME, VALID_PASSWORD, "Failure"},
            {VALID_USERNAME, INVALID_PASSWORD, "Failure"},
            {"", VALID_PASSWORD, "Failure"},
            {VALID_USERNAME, "", "Failure"},
            {"", "", "Failure"}
        };
    }
}

class SeleniumUtils {
    public static void highlightElement(String element) {
        System.out.println("Highlighting element: " + element);
    }
    
    public static void scrollIntoView(String element) {
        System.out.println("Scrolling to element: " + element);
    }
    
    public static void waitForElementToBeClickable(String element) {
        System.out.println("Waiting for element to be clickable: " + element);
    }
    
    public static void implicitWait(int seconds) {
        System.out.println("Setting implicit wait to: " + seconds + " seconds");
    }
}

public class PageObjectModelFramework {
    public static void main(String[] args) {
        System.out.println("=== Selenium Page Object Model Framework ===\n");
        
        LoginPage loginPage = new LoginPage();
        DashboardPage dashboardPage = new DashboardPage();
        
        System.out.println("Test Scenario 1: Valid Login");
        loginPage.waitForPageLoad();
        loginPage.loginToApplication(TestData.VALID_USERNAME, TestData.VALID_PASSWORD);
        dashboardPage.verifyUserLoggedIn(TestData.VALID_USERNAME);
        System.out.println("Valid login test completed\n");
        
        System.out.println("Test Scenario 2: Invalid Login");
        loginPage.waitForPageLoad();
        loginPage.enterUsername(TestData.INVALID_USERNAME);
        loginPage.enterPassword(TestData.VALID_PASSWORD);
        loginPage.clickLoginButton();
        System.out.println("Invalid login test completed\n");
        
        System.out.println("Test Scenario 3: Empty Credentials");
        loginPage.waitForPageLoad();
        loginPage.enterUsername("");
        loginPage.enterPassword("");
        loginPage.clickLoginButton();
        System.out.println("Empty credentials test completed\n");
        
        System.out.println("Using utility methods:");
        SeleniumUtils.highlightElement("usernameField");
        SeleniumUtils.scrollIntoView("loginButton");
        SeleniumUtils.waitForElementToBeClickable("loginButton");
        SeleniumUtils.implicitWait(Config.IMPLICIT_WAIT);
        
        System.out.println("\nUsing configuration:");
        System.out.println("Base URL: " + Config.BASE_URL);
        System.out.println("Browser: " + Config.BROWSER);
        System.out.println("Username: " + Config.USERNAME);
        
        System.out.println("\nUsing test data:");
        Object[][] testData = TestData.getLoginTestData();
        System.out.println("Total test data sets: " + testData.length);
        for (int i = 0; i < testData.length; i++) {
            System.out.println("Test data set " + (i+1) + ": " + 
                             testData[i][0] + " | " + 
                             testData[i][1] + " | " + 
                             testData[i][2]);
        }
        
        System.out.println("\nDemonstrating page navigation:");
        dashboardPage.clickLogout();
        loginPage.waitForPageLoad();
        loginPage.verifyPageTitle("Login Page");
        
        System.out.println("\nSelenium Page Object Model Framework implementation completed!");
        System.out.println("Benefits of this framework:");
        System.out.println("1. Reusability - Page elements and methods are reusable");
        System.out.println("2. Maintainability - Changes to UI only need to be updated in one place");
        System.out.println("3. Readability - Tests are more readable and structured");
        System.out.println("4. Separation of Concerns - Page elements separated from test logic");
        System.out.println("5. Scalability - Easy to add new pages and test scenarios");
    }
}