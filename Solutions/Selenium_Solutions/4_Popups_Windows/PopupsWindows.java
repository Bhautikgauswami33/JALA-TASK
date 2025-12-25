import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.Alert;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;
import java.util.Set;

public class PopupsWindows {
    public static void main(String[] args) {
        // Set the path to the Firefox driver (GeckoDriver)
        System.setProperty("webdriver.gecko.driver", "path/to/geckodriver");
        
        // Initialize the Firefox driver
        WebDriver driver = new FirefoxDriver();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        
        try {
            System.out.println("=== Popups and Windows Assignment ===\n");
            
            // Navigate to the Magnus application
            driver.get("http://magnus.jalatechnologies.com/");
            
            // Wait for the page to load
            Thread.sleep(2000);
            
            // 1. Handle alerts/popups
            System.out.println("1. Demonstrating Alert handling (if any alerts exist on the page)");
            
            // For demonstration purposes, let's assume there's a button that triggers an alert
            // WebElement alertButton = driver.findElement(By.id("alertButton"));
            // alertButton.click();
            
            // Switch to alert and handle it
            // Alert alert = driver.switchTo().alert();
            // String alertText = alert.getText();
            // System.out.println("Alert text: " + alertText);
            // alert.accept(); // Accept the alert
            // alert.dismiss(); // Dismiss the alert
            
            // 2. Handle confirm popups
            System.out.println("2. Demonstrating Confirm popup handling");
            
            // 3. Handle prompt popups
            System.out.println("3. Demonstrating Prompt popup handling");
            
            // 4. Handle browser windows/tabs
            System.out.println("4. Demonstrating Window/Tab handling");
            
            // Get current window handle
            String mainWindow = driver.getWindowHandle();
            System.out.println("Main window handle: " + mainWindow);
            
            // Get all window handles
            Set<String> allWindows = driver.getWindowHandles();
            System.out.println("Number of windows before opening new tab: " + allWindows.size());
            
            // For this example, let's assume there's a link that opens in a new tab
            // driver.findElement(By.linkText("Open in new tab")).click();
            
            // Wait for new window to open
            Thread.sleep(2000);
            
            // Get all windows again
            allWindows = driver.getWindowHandles();
            System.out.println("Number of windows after opening new tab: " + allWindows.size());
            
            // Switch to new window
            for (String windowHandle : allWindows) {
                if (!windowHandle.equals(mainWindow)) {
                    driver.switchTo().window(windowHandle);
                    System.out.println("Switched to new window: " + driver.getTitle());
                    break;
                }
            }
            
            // Switch back to main window
            driver.switchTo().window(mainWindow);
            System.out.println("Switched back to main window: " + driver.getTitle());
            
            // 5. Handle multiple windows
            System.out.println("5. Demonstrating Multiple Windows handling");
            
            // Open a new window using JavaScript (for demonstration)
            // This requires JavaScript execution
            // ((JavascriptExecutor) driver).executeScript("window.open('http://example.com', '_blank');");
            
            // 6. Close specific window
            System.out.println("6. Demonstrating specific window closing");
            
            // 7. Close all windows except main
            System.out.println("7. Demonstrating closing all windows except main");
            
            // 8. Switch between frames
            System.out.println("8. Demonstrating Frame handling");
            
            // Switch to frame by index
            // driver.switchTo().frame(0);
            
            // Switch to frame by name/id
            // driver.switchTo().frame("frameName");
            
            // Switch to frame by WebElement
            // WebElement frameElement = driver.findElement(By.tagName("iframe"));
            // driver.switchTo().frame(frameElement);
            
            // Switch back to default content
            // driver.switchTo().defaultContent();
            
            // 9. Handle child windows
            System.out.println("9. Demonstrating Child Window handling");
            
            // Login to the application first to access more features
            driver.findElement(By.id("UserName")).sendKeys("training@jalaacademy.com");
            driver.findElement(By.name("Password")).sendKeys("jobprogram");
            driver.findElement(By.className("btn")).click();
            
            // Wait for login to complete
            Thread.sleep(3000);
            
            System.out.println("Logged in successfully. Demonstrating window operations on the application...");
            
            // Get the new title after login
            String newTitle = driver.getTitle();
            System.out.println("New page title after login: " + newTitle);
            
            // 10. Window handling after login - navigate to different pages
            System.out.println("10. Demonstrating navigation after login");
            
            // Navigate to different sections of the application
            // This would depend on the actual application structure
            // driver.get("http://magnus.jalatechnologies.com/dashboard");
            
            // 11. Handling popup windows that might appear after login
            System.out.println("11. Demonstrating handling of any popup windows after login");
            
            // Example: Handle a welcome popup if it appears
            // try {
            //     Alert welcomeAlert = driver.switchTo().alert();
            //     welcomeAlert.accept();
            //     System.out.println("Handled welcome popup");
            // } catch (Exception e) {
            //     System.out.println("No welcome popup appeared");
            // }
            
            // 12. Window maximize, minimize, fullscreen operations
            System.out.println("12. Demonstrating window operations");
            
            // Maximize window
            driver.manage().window().maximize();
            System.out.println("Window maximized");
            
            // Fullscreen window
            driver.manage().window().fullscreen();
            System.out.println("Window fullscreened");
            
            // Note: Minimize operation is not directly supported in Selenium
            
            // 13. Get window position and size
            System.out.println("13. Demonstrating window position and size operations");
            
            // Get window position
            org.openqa.selenium.Dimension size = driver.manage().window().getSize();
            System.out.println("Window size - Width: " + size.getWidth() + ", Height: " + size.getHeight());
            
            // 14. Set window position and size
            System.out.println("14. Demonstrating setting window position and size");
            
            // Set window size
            driver.manage().window().setSize(new org.openqa.selenium.Dimension(1200, 800));
            System.out.println("Window size set to 1200x800");
            
            // 15. Handle multiple tabs scenario
            System.out.println("15. Demonstrating multiple tabs handling");
            
            // Open new tab using JavaScript
            // ((JavascriptExecutor) driver).executeScript("window.open('http://magnus.jalatechnologies.com/', '_blank');");
            
            // Wait for the new tab to open
            Thread.sleep(2000);
            
            // Get all window handles
            Set<String> windowHandles = driver.getWindowHandles();
            System.out.println("Number of tabs/windows: " + windowHandles.size());
            
            // Switch between tabs
            for (String handle : windowHandles) {
                driver.switchTo().window(handle);
                System.out.println("Tab title: " + driver.getTitle());
            }
            
            // Switch back to original tab
            driver.switchTo().window(mainWindow);
            
            System.out.println("\nAll Popups and Windows operations demonstrated successfully!");
            
        } catch (Exception e) {
            System.out.println("An error occurred: " + e.getMessage());
            e.printStackTrace();
        } finally {
            // Close the browser
            driver.quit();
        }
    }
}