import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;
import java.time.Duration;

public class SeleniumLocators {
    public static void main(String[] args) {
        // Set the path to the Firefox driver (GeckoDriver)
        // Note: This assumes geckodriver.exe is in the PATH or system property is set
        System.setProperty("webdriver.gecko.driver", "path/to/geckodriver");
        
        // Initialize the Firefox driver
        WebDriver driver = new FirefoxDriver();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        
        try {
            // Navigate to the Magnus application login page
            driver.get("http://magnus.jalatechnologies.com/");
            
            // Wait for the page to load
            Thread.sleep(2000);
            
            System.out.println("=== Selenium Locators Assignment ===\n");
            
            // 1. Identify elements using different locators
            // ID locator
            WebElement usernameField = driver.findElement(By.id("UserName"));
            System.out.println("Found username field using ID locator");
            
            // Name locator
            WebElement passwordField = driver.findElement(By.name("Password"));
            System.out.println("Found password field using Name locator");
            
            // Class name locator
            WebElement loginButton = driver.findElement(By.className("btn"));
            System.out.println("Found login button using Class Name locator");
            
            // CSS Selector locator
            WebElement rememberMeCheckbox = driver.findElement(By.cssSelector("input[type='checkbox']"));
            System.out.println("Found remember me checkbox using CSS Selector locator");
            
            // XPath locator
            WebElement loginForm = driver.findElement(By.xpath("//form[@id='loginForm']"));
            System.out.println("Found login form using XPath locator");
            
            // Link text locator (if there's a link)
            // WebElement forgotPasswordLink = driver.findElement(By.linkText("Forgot Password?"));
            
            // Partial link text locator (if there's a link)
            // WebElement helpLink = driver.findElement(By.partialLinkText("Help"));
            
            // Tag name locator
            WebElement inputFields = driver.findElement(By.tagName("input"));
            System.out.println("Found input field using Tag Name locator");
            
            // 2. Write 5 automation scripts for login page of the Magnus application
            System.out.println("\n--- Running 5 Login Scripts ---");
            
            // Script 1: Valid login
            System.out.println("Script 1: Valid login");
            driver.get("http://magnus.jalatechnologies.com/");
            Thread.sleep(2000);
            driver.findElement(By.id("UserName")).sendKeys("training@jalaacademy.com");
            driver.findElement(By.name("Password")).sendKeys("jobprogram");
            driver.findElement(By.className("btn")).click();
            Thread.sleep(3000);
            System.out.println("Valid login completed");
            
            // Go back to login page for next script
            driver.get("http://magnus.jalatechnologies.com/");
            Thread.sleep(2000);
            
            // Script 2: Invalid login
            System.out.println("Script 2: Invalid login");
            driver.findElement(By.id("UserName")).sendKeys("invalid@example.com");
            driver.findElement(By.name("Password")).sendKeys("wrongpassword");
            driver.findElement(By.className("btn")).click();
            Thread.sleep(3000);
            System.out.println("Invalid login completed - error message should appear");
            
            // Go back to login page for next script
            driver.get("http://magnus.jalatechnologies.com/");
            Thread.sleep(2000);
            
            // Script 3: Empty credentials
            System.out.println("Script 3: Empty credentials");
            driver.findElement(By.id("UserName")).clear();
            driver.findElement(By.name("Password")).clear();
            driver.findElement(By.className("btn")).click();
            Thread.sleep(3000);
            System.out.println("Empty credentials login attempt completed");
            
            // Go back to login page for next script
            driver.get("http://magnus.jalatechnologies.com/");
            Thread.sleep(2000);
            
            // Script 4: Only username entered
            System.out.println("Script 4: Only username entered");
            driver.findElement(By.id("UserName")).sendKeys("training@jalaacademy.com");
            driver.findElement(By.name("Password")).clear();
            driver.findElement(By.className("btn")).click();
            Thread.sleep(3000);
            System.out.println("Username only login attempt completed");
            
            // Go back to login page for next script
            driver.get("http://magnus.jalatechnologies.com/");
            Thread.sleep(2000);
            
            // Script 5: Only password entered
            System.out.println("Script 5: Only password entered");
            driver.findElement(By.id("UserName")).clear();
            driver.findElement(By.name("Password")).sendKeys("jobprogram");
            driver.findElement(By.className("btn")).click();
            Thread.sleep(3000);
            System.out.println("Password only login attempt completed");
            
            System.out.println("\nAll 5 automation scripts completed successfully!");
            
        } catch (Exception e) {
            System.out.println("An error occurred: " + e.getMessage());
            e.printStackTrace();
        } finally {
            // Close the browser
            driver.quit();
        }
    }
}