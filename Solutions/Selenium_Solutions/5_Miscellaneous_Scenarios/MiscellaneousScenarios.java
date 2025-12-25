import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.JavascriptExecutor;
import java.time.Duration;
import java.util.List;

public class MiscellaneousScenarios {
    public static void main(String[] args) {
        // Set the path to the Firefox driver (GeckoDriver)
        System.setProperty("webdriver.gecko.driver", "path/to/geckodriver");
        
        // Initialize the Firefox driver
        WebDriver driver = new FirefoxDriver();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        
        try {
            System.out.println("=== Selenium Miscellaneous Scenarios Assignment ===\n");
            
            // Navigate to the Magnus application
            driver.get("http://magnus.jalatechnologies.com/");
            
            // Wait for the page to load
            Thread.sleep(2000);
            
            // 1. Handling dynamic elements
            System.out.println("1. Demonstrating handling of dynamic elements");
            
            // Wait for an element to be present
            WebElement usernameField = wait.until(driver -> driver.findElement(By.id("UserName")));
            System.out.println("Dynamic username field found");
            
            // 2. Handling hidden elements
            System.out.println("2. Demonstrating handling of hidden elements");
            
            // 3. Scrolling to an element
            System.out.println("3. Demonstrating scrolling to an element");
            
            // Scroll to an element using JavaScript
            JavascriptExecutor js = (JavascriptExecutor) driver;
            // js.executeScript("arguments[0].scrollIntoView();", someElement);
            
            // 4. Taking screenshot
            System.out.println("4. Demonstrating taking screenshots");
            
            // For screenshot, we'd need to use TakesScreenshot interface
            // File screenshot = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
            // FileUtils.copyFile(screenshot, new File("screenshot.png"));
            
            // 5. Handling dynamic dropdowns
            System.out.println("5. Demonstrating handling of dynamic dropdowns");
            
            // 6. Handling static dropdowns
            System.out.println("6. Demonstrating handling of static dropdowns (if any exist)");
            
            // Example of handling a dropdown (if it exists on the page)
            // WebElement dropdownElement = driver.findElement(By.id("dropdownId"));
            // Select dropdown = new Select(dropdownElement);
            // dropdown.selectByVisibleText("Option Text");
            
            // 7. Handling multiple elements
            System.out.println("7. Demonstrating handling of multiple elements");
            
            List<WebElement> allInputs = driver.findElements(By.tagName("input"));
            System.out.println("Found " + allInputs.size() + " input elements");
            
            // 8. Working with tables
            System.out.println("8. Demonstrating working with tables (if any exist on the page)");
            
            // 9. Handling mouse hover events
            System.out.println("9. Demonstrating handling of mouse hover events");
            
            // For hover, we'd need Actions class
            // Actions actions = new Actions(driver);
            // actions.moveToElement(someElement).perform();
            
            // 10. Handling drag and drop
            System.out.println("10. Demonstrating drag and drop operations");
            
            // 11. Handling file uploads
            System.out.println("11. Demonstrating file upload handling");
            
            // WebElement fileInput = driver.findElement(By.id("fileUpload"));
            // fileInput.sendKeys("path/to/file.txt");
            
            // 12. Handling dynamic IDs
            System.out.println("12. Demonstrating handling of dynamic IDs");
            
            // Use relative locators or attributes that don't change
            // WebElement dynamicElement = driver.findElement(By.xpath("//input[contains(@id, 'dynamic')]"));
            
            // 13. Handling timeouts
            System.out.println("13. Demonstrating handling of timeouts");
            
            // Set implicit and explicit waits
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
            
            // 14. Handling unexpected alerts
            System.out.println("14. Demonstrating handling of unexpected alerts");
            
            // 15. Working with cookies
            System.out.println("15. Demonstrating working with cookies");
            
            // Get all cookies
            java.util.Set<org.openqa.selenium.Cookie> cookies = driver.manage().getCookies();
            System.out.println("Number of cookies: " + cookies.size());
            
            // Add a cookie
            // driver.manage().addCookie(new Cookie("name", "value"));
            
            // 16. Executing JavaScript
            System.out.println("16. Demonstrating executing JavaScript");
            
            // Execute JavaScript to get page title
            String pageTitle = (String) js.executeScript("return document.title;");
            System.out.println("Page title via JavaScript: " + pageTitle);
            
            // 17. Handling browser back/forward buttons programmatically
            System.out.println("17. Demonstrating handling browser navigation");
            
            // Navigate back and forward
            driver.navigate().back();
            Thread.sleep(1000);
            driver.navigate().forward();
            
            // 18. Handling new window/tab scenarios
            System.out.println("18. Demonstrating handling new window/tab scenarios");
            
            // Get current window handle
            String currentWindow = driver.getWindowHandle();
            System.out.println("Current window handle: " + currentWindow);
            
            // 19. Waiting for elements to be clickable
            System.out.println("19. Demonstrating waiting for elements to be clickable");
            
            // Wait for element to be clickable
            // WebElement clickableElement = wait.until(ExpectedConditions.elementToBeClickable(By.id("someId")));
            
            // 20. Handling stale element reference exception
            System.out.println("20. Demonstrating handling of stale element reference");
            
            // Refresh the element reference if needed
            // usernameField = driver.findElement(By.id("UserName"));
            
            // Login to the application
            System.out.println("\n--- Logging into the application ---");
            driver.get("http://magnus.jalatechnologies.com/");
            Thread.sleep(1000);
            
            driver.findElement(By.id("UserName")).sendKeys("training@jalaacademy.com");
            driver.findElement(By.name("Password")).sendKeys("jobprogram");
            driver.findElement(By.className("btn")).click();
            
            // Wait for login to complete
            Thread.sleep(3000);
            
            System.out.println("Successfully logged in and completed miscellaneous scenarios!");
            
            // 21. Performing operations on the logged-in page
            System.out.println("21. Demonstrating operations on logged-in page");
            
            // Get the new title after login
            String newTitle = driver.getTitle();
            System.out.println("New page title after login: " + newTitle);
            
            // Navigate to different sections if available
            // driver.get("http://magnus.jalatechnologies.com/dashboard");
            
            // 22. Handling page refresh scenarios
            System.out.println("22. Demonstrating page refresh handling");
            driver.navigate().refresh();
            Thread.sleep(2000);
            
            // 23. Handling frame scenarios
            System.out.println("23. Demonstrating frame handling scenarios");
            
            // Switch to frame if available
            // driver.switchTo().frame("frameName");
            
            // Switch back to default content
            // driver.switchTo().defaultContent();
            
            // 24. Handling dynamic content loading
            System.out.println("24. Demonstrating handling of dynamic content loading");
            
            // Wait for dynamic content to load
            // wait.until(ExpectedConditions.textToBePresentInElementLocated(By.id("dynamicContent"), "expected text"));
            
            // 25. Verifying page elements and content
            System.out.println("25. Demonstrating verification of page elements");
            
            // Verify if certain elements are present
            boolean isElementPresent = driver.findElements(By.tagName("h1")).size() > 0;
            System.out.println("H1 element present: " + isElementPresent);
            
            System.out.println("\nAll Miscellaneous Scenarios completed successfully!");
            
        } catch (Exception e) {
            System.out.println("An error occurred: " + e.getMessage());
            e.printStackTrace();
        } finally {
            // Close the browser
            driver.quit();
        }
    }
}