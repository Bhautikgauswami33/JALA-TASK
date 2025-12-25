import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class WebDriverMethods {
    public static void main(String[] args) {
        // Set the path to the Firefox driver (GeckoDriver)
        System.setProperty("webdriver.gecko.driver", "path/to/geckodriver");
        
        // Initialize the Firefox driver
        WebDriver driver = new FirefoxDriver();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        
        try {
            System.out.println("=== Web Driver Methods Assignment ===\n");
            
            // 1. get() method - Navigate to a URL
            driver.get("http://magnus.jalatechnologies.com/");
            System.out.println("1. Navigated to the application using get() method");
            
            // 2. getCurrentUrl() method - Get current URL
            String currentUrl = driver.getCurrentUrl();
            System.out.println("2. Current URL: " + currentUrl);
            
            // 3. getTitle() method - Get page title
            String title = driver.getTitle();
            System.out.println("3. Page title: " + title);
            
            // 4. findElement() method - Find a single element
            WebElement usernameField = driver.findElement(By.id("UserName"));
            System.out.println("4. Found username field using findElement() method");
            
            // 5. findElements() method - Find multiple elements
            java.util.List<WebElement> allInputs = driver.findElements(By.tagName("input"));
            System.out.println("5. Found " + allInputs.size() + " input elements using findElements() method");
            
            // 6. close() method - Close current browser window
            // driver.close(); // Not using this yet as we need to continue with operations
            
            // 7. quit() method - Close all browser windows (will use at the end)
            
            // 8. navigate().to() method - Navigate to a URL
            driver.navigate().to("http://magnus.jalatechnologies.com/");
            System.out.println("6. Navigated using navigate().to() method");
            
            // 9. navigate().back() method - Go back to previous page
            driver.navigate().back();
            System.out.println("7. Navigated back using navigate().back() method");
            Thread.sleep(1000);
            
            // 10. navigate().forward() method - Go forward to next page
            driver.navigate().forward();
            System.out.println("8. Navigated forward using navigate().forward() method");
            Thread.sleep(1000);
            
            // 11. navigate().refresh() method - Refresh the current page
            driver.navigate().refresh();
            System.out.println("9. Refreshed the page using navigate().refresh() method");
            Thread.sleep(1000);
            
            // 12. getWindowHandle() method - Get handle of current window
            String currentWindow = driver.getWindowHandle();
            System.out.println("10. Current window handle: " + currentWindow);
            
            // 13. getWindowHandles() method - Get handles of all windows
            java.util.Set<String> allWindows = driver.getWindowHandles();
            System.out.println("11. Number of open windows: " + allWindows.size());
            
            // 14. getPageSource() method - Get page source
            String pageSource = driver.getPageSource();
            System.out.println("12. Page source length: " + pageSource.length() + " characters");
            
            // 15. manage().window().maximize() method - Maximize browser window
            driver.manage().window().maximize();
            System.out.println("13. Browser window maximized");
            
            // 16. manage().window().fullscreen() method - Fullscreen browser window
            driver.manage().window().fullscreen();
            System.out.println("14. Browser window fullscreened");
            
            // 17. manage().timeouts().implicitlyWait() method - Set implicit wait
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
            System.out.println("15. Implicit wait set to 10 seconds");
            
            // 18. manage().timeouts().pageLoadTimeout() method - Set page load timeout
            driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
            System.out.println("16. Page load timeout set to 30 seconds");
            
            // 19. manage().timeouts().scriptTimeout() method - Set script timeout
            // This method is deprecated in newer versions of Selenium
            
            // 20. manage().cookies() methods - Handle cookies
            java.util.Set<org.openqa.selenium.Cookie> cookies = driver.manage().getCookies();
            System.out.println("17. Number of cookies: " + cookies.size());
            
            // 21. isDisplayed() method - Check if element is displayed
            boolean isUsernameDisplayed = usernameField.isDisplayed();
            System.out.println("18. Username field is displayed: " + isUsernameDisplayed);
            
            // 22. isEnabled() method - Check if element is enabled
            boolean isUsernameEnabled = usernameField.isEnabled();
            System.out.println("19. Username field is enabled: " + isUsernameEnabled);
            
            // 23. isSelected() method - Check if element is selected (for checkboxes/radio buttons)
            WebElement rememberMeCheckbox = driver.findElement(By.cssSelector("input[type='checkbox']"));
            boolean isCheckboxSelected = rememberMeCheckbox.isSelected();
            System.out.println("20. Remember me checkbox is selected: " + isCheckboxSelected);
            
            // 24. getText() method - Get text of an element
            // Find a label or text element to get text from
            // String labelText = someElement.getText();
            // System.out.println("21. Text content: " + labelText);
            
            // 25. getAttribute() method - Get attribute value of an element
            String placeholder = usernameField.getAttribute("placeholder");
            System.out.println("21. Placeholder attribute: " + placeholder);
            
            // 26. sendKeys() method - Send text to an element
            usernameField.sendKeys("training@jalaacademy.com");
            System.out.println("22. Text sent to username field using sendKeys() method");
            
            // 27. click() method - Click on an element
            rememberMeCheckbox.click();
            System.out.println("23. Checkbox clicked using click() method");
            
            // 28. clear() method - Clear text from an input field
            usernameField.clear();
            System.out.println("24. Text cleared from username field using clear() method");
            
            // 29. submit() method - Submit a form
            usernameField.sendKeys("training@jalaacademy.com");
            driver.findElement(By.name("Password")).sendKeys("jobprogram");
            // driver.findElement(By.id("loginForm")).submit(); // Or submit button
            System.out.println("25. Form data entered");
            
            // 30. switchTo() methods - Switch between windows, frames, alerts
            // driver.switchTo().frame(0); // Switch to frame by index
            // driver.switchTo().window(windowHandle); // Switch to window by handle
            // driver.switchTo().alert(); // Switch to alert
            System.out.println("26. switchTo() methods available for frames, windows, and alerts");
            
            // Perform login
            WebElement loginButton = driver.findElement(By.className("btn"));
            loginButton.click();
            System.out.println("27. Login button clicked");
            
            // Wait for login to complete
            Thread.sleep(3000);
            
            // Verify we're on a different page after login
            String newTitle = driver.getTitle();
            System.out.println("28. New page title after login: " + newTitle);
            
            System.out.println("\nAll Web Driver Methods demonstrated successfully!");
            
        } catch (Exception e) {
            System.out.println("An error occurred: " + e.getMessage());
            e.printStackTrace();
        } finally {
            // Close the browser
            driver.quit();
        }
    }
}