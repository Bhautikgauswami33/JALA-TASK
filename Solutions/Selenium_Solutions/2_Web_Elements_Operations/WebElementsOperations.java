import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;
import java.util.List;

public class WebElementsOperations {
    public static void main(String[] args) {
        // Set the path to the Firefox driver (GeckoDriver)
        System.setProperty("webdriver.gecko.driver", "path/to/geckodriver");
        
        // Initialize the Firefox driver
        WebDriver driver = new FirefoxDriver();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        
        try {
            // Navigate to the Magnus application
            driver.get("http://magnus.jalatechnologies.com/");
            
            // Wait for the page to load
            Thread.sleep(2000);
            
            System.out.println("=== Operations on Web Elements Assignment ===\n");
            
            // TEXT BOX OPERATIONS
            System.out.println("--- Text Box Operations ---");
            
            // 1. How to Type in text box using Selenium Web Driver
            WebElement usernameField = driver.findElement(By.id("UserName"));
            usernameField.sendKeys("training@jalaacademy.com");
            System.out.println("1. Typed text in username field");
            
            // 2. How to get a Text Box value using Selenium Web Driver
            String enteredText = usernameField.getAttribute("value");
            System.out.println("2. Text box value: " + enteredText);
            
            // 3. How to read the placeholder value of a Text Box using getAttribute() method
            String placeholder = usernameField.getAttribute("placeholder");
            System.out.println("3. Placeholder value: " + placeholder);
            
            // 4. Deleting/clear text from the Text Box
            usernameField.clear();
            System.out.println("4. Text cleared from username field");
            
            // Type text again for further operations
            usernameField.sendKeys("testuser@example.com");
            
            // 5. Check if Text Box is enabled/disabled
            boolean isUsernameEnabled = usernameField.isEnabled();
            System.out.println("5. Username field enabled: " + isUsernameEnabled);
            
            // RADIO BUTTON / CHECK BOX OPERATIONS
            System.out.println("\n--- Radio Button / Check Box Operations ---");
            
            // Assuming there are radio buttons or checkboxes on the page
            // For demonstration, we'll use the password field as a text box example
            WebElement passwordField = driver.findElement(By.name("Password"));
            passwordField.sendKeys("jobprogram");
            
            // Find a checkbox (remember me checkbox)
            WebElement rememberMeCheckbox = driver.findElement(By.cssSelector("input[type='checkbox']"));
            
            // 1. Check if Radio Button/Checkbox is selected
            boolean isCheckboxSelected = rememberMeCheckbox.isSelected();
            System.out.println("1. Checkbox selected: " + isCheckboxSelected);
            
            // 2. Check if Radio Button/Checkbox is enabled
            boolean isCheckboxEnabled = rememberMeCheckbox.isEnabled();
            System.out.println("2. Checkbox enabled: " + isCheckboxEnabled);
            
            // 3. Select the checkbox
            if (!isCheckboxSelected) {
                rememberMeCheckbox.click();
                System.out.println("3. Checkbox selected");
            }
            
            // DROPDOWN/LIST BOX/COMBO BOX OPERATIONS
            System.out.println("\n--- Dropdown Operations (Example) ---");
            
            // For this example, let's assume there's a dropdown on a different page
            // Navigate to a page that has dropdowns
            driver.get("http://magnus.jalatechnologies.com/");
            
            // 1. Print all the options available in the dropdown
            // This is an example - actual dropdowns may be on different pages
            System.out.println("1. Dropdown operations would be performed on actual dropdown elements");
            
            // 2. Print first selected option from a dropdown
            System.out.println("2. Would print first selected option from dropdown");
            
            // 3. Select an option by value from a dropdown
            System.out.println("3. Would select option by value");
            
            // 4. Select an option by visible text from a dropdown
            System.out.println("4. Would select option by visible text");
            
            // 5. Select an option by index from a dropdown
            System.out.println("5. Would select option by index");
            
            // LINK OPERATIONS
            System.out.println("\n--- Link Operations ---");
            
            // 1. Clicking a link using link Text
            // Find all links on the page
            List<WebElement> allLinks = driver.findElements(By.tagName("a"));
            System.out.println("1. Found " + allLinks.size() + " links on the page");
            
            // 2. Find a specific link and click it (example)
            // WebElement specificLink = driver.findElement(By.linkText("Specific Link Text"));
            // specificLink.click();
            
            // 3. Clicking a link using partialLinkText
            // WebElement partialLink = driver.findElement(By.partialLinkText("Part of Link Text"));
            // partialLink.click();
            
            // 4. Clicking on an image link
            // WebElement imageLink = driver.findElement(By.cssSelector("img[alt='Image Alt Text']"));
            // imageLink.click();
            
            // XPATH OPERATIONS
            System.out.println("\n--- XPath Operations ---");
            
            // 1. Write an xpath for id, name, className
            WebElement elementById = driver.findElement(By.xpath("//*[@id='UserName']"));
            System.out.println("1. Found element by ID using XPath");
            
            WebElement elementByName = driver.findElement(By.xpath("//input[@name='Password']"));
            System.out.println("2. Found element by name using XPath");
            
            WebElement elementByClass = driver.findElement(By.xpath("//button[@class='btn']"));
            System.out.println("3. Found element by class using XPath");
            
            // 2. How to find an element that contains a specific text using contains()
            WebElement elementWithText = driver.findElement(By.xpath("//div[contains(text(), 'Login')]"));
            System.out.println("4. Found element containing text using contains()");
            
            // 3. How to find an element using text()
            // WebElement elementByText = driver.findElement(By.xpath("//label[text()='Username']"));
            // System.out.println("5. Found element by exact text");
            
            // 4. How to find an element that starts-with()
            // WebElement elementStartsWith = driver.findElement(By.xpath("//input[starts-with(@id, 'User')]"));
            // System.out.println("6. Found element using starts-with()");
            
            // 5. XPath to select following-sibling and preceding
            // WebElement followingSibling = driver.findElement(By.xpath("//input[@id='UserName']/following-sibling::input"));
            // System.out.println("7. Found following sibling element");
            
            // 6. XPath to select an element using ancestor, child, parent and descendent
            // WebElement childElement = driver.findElement(By.xpath("//form[@id='loginForm']//input[@type='text']"));
            // System.out.println("8. Found child element using XPath");
            
            // 7. XPath using OR and AND
            WebElement orAndXpath = driver.findElement(By.xpath("//input[@id='UserName' or @name='Password']"));
            System.out.println("9. Found element using OR in XPath");
            
            // LOGIN OPERATIONS
            System.out.println("\n--- Login Operations ---");
            
            // Clear and enter credentials
            usernameField.clear();
            usernameField.sendKeys("training@jalaacademy.com");
            
            passwordField.clear();
            passwordField.sendKeys("jobprogram");
            
            // Click login button
            WebElement loginButton = driver.findElement(By.className("btn"));
            loginButton.click();
            
            // Wait for login to complete
            Thread.sleep(3000);
            
            System.out.println("Login operations completed successfully!");
            
        } catch (Exception e) {
            System.out.println("An error occurred: " + e.getMessage());
            e.printStackTrace();
        } finally {
            // Close the browser
            driver.quit();
        }
    }
}