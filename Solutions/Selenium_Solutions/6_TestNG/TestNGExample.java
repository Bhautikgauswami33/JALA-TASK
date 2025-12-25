import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.AfterClass;
import org.testng.Assert;

public class TestNGExample {
    
    @BeforeClass
    public void setUpClass() {
        System.out.println("=== Setting up test class ===");
        System.out.println("This runs once before all tests in the class");
    }
    
    @BeforeMethod
    public void setUpMethod() {
        System.out.println("Setting up for test method");
        System.out.println("This runs before each test method");
    }
    
    @Test
    public void testLoginFunctionality() {
        System.out.println("Executing test: testLoginFunctionality");
        
        // Simulate login test
        String username = "training@jalaacademy.com";
        String password = "jobprogram";
        
        // Verify credentials are not empty
        Assert.assertNotNull(username, "Username should not be null");
        Assert.assertNotNull(password, "Password should not be null");
        Assert.assertFalse(username.isEmpty(), "Username should not be empty");
        Assert.assertFalse(password.isEmpty(), "Password should not be empty");
        
        System.out.println("Login test passed!");
    }
    
    @Test
    public void testAdditionOperation() {
        System.out.println("Executing test: testAdditionOperation");
        
        int a = 10;
        int b = 5;
        int expected = 15;
        int actual = a + b;
        
        Assert.assertEquals(actual, expected, "Addition operation failed");
        
        System.out.println("Addition test passed!");
    }
    
    @Test
    public void testStringOperations() {
        System.out.println("Executing test: testStringOperations");
        
        String str1 = "Hello";
        String str2 = "Hello";
        String str3 = "World";
        
        // Test string equality
        Assert.assertEquals(str1, str2, "Strings should be equal");
        Assert.assertNotEquals(str1, str3, "Strings should not be equal");
        Assert.assertTrue(str1.equals(str2), "String comparison should return true");
        
        System.out.println("String operations test passed!");
    }
    
    @Test(groups = {"smoke"})
    public void testSmokeScenario() {
        System.out.println("Executing test: testSmokeScenario (part of smoke group)");
        
        boolean smokeTestPassed = true;
        Assert.assertTrue(smokeTestPassed, "Smoke test should pass");
        
        System.out.println("Smoke test passed!");
    }
    
    @Test(expectedExceptions = ArithmeticException.class)
    public void testExceptionHandling() {
        System.out.println("Executing test: testExceptionHandling");
        
        int result = 10 / 0; // This will throw ArithmeticException
        System.out.println("Result: " + result);
    }
    
    @Test(dependsOnMethods = {"testAdditionOperation"})
    public void testDependentMethod() {
        System.out.println("Executing test: testDependentMethod");
        System.out.println("This test depends on testAdditionOperation");
        
        Assert.assertTrue(true, "Dependent test should pass");
        
        System.out.println("Dependent test passed!");
    }
    
    @AfterMethod
    public void tearDownMethod() {
        System.out.println("Tearing down after test method");
        System.out.println("This runs after each test method");
        System.out.println();
    }
    
    @AfterClass
    public void tearDownClass() {
        System.out.println("=== Tearing down test class ===");
        System.out.println("This runs once after all tests in the class");
    }
}