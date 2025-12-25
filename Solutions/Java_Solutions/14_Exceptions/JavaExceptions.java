import java.io.*;
import java.sql.SQLException;

// Custom exception class for requirement 6
class CustomException extends Exception {
    public CustomException(String message) {
        super(message);
    }
}

public class JavaExceptions {
    // Method that throws exception for requirement 3
    public static void methodThatThrowsException() throws IOException {
        throw new IOException("Exception thrown from method");
    }
    
    // Method that demonstrates multiple exceptions
    public static void demonstrateMultipleExceptions(int choice) throws CustomException {
        switch(choice) {
            case 1:
                // ArithmeticException
                int result = 10 / 0;
                break;
            case 2:
                // ArrayIndexOutOfBoundsException
                int[] arr = {1, 2, 3};
                int val = arr[5];
                break;
            case 3:
                // NumberFormatException
                int num = Integer.parseInt("abc");
                break;
            case 4:
                // NullPointerException
                String str = null;
                int length = str.length();
                break;
            case 5:
                // StringIndexOutOfBoundsException
                String text = "Hello";
                char ch = text.charAt(10);
                break;
            case 6:
                // Custom exception
                throw new CustomException("This is a custom exception");
            default:
                System.out.println("No exception thrown");
        }
    }
    
    public static void main(String[] args) {
        System.out.println("=== Java Exceptions Assignments ===\n");
        
        // 1. Generate Arithmetic Exception without exception handling
        System.out.println("1. Arithmetic Exception without handling:");
        try {
            int result = 10 / 0; // This would crash the program without try-catch
        } catch(ArithmeticException e) {
            System.out.println("Caught: " + e.getMessage());
        }
        
        // 2. Handle the Arithmetic exception using try-catch block
        System.out.println("\n2. Arithmetic Exception with try-catch:");
        try {
            int result = 20 / 0;
        } catch(ArithmeticException e) {
            System.out.println("ArithmeticException caught: " + e.getMessage());
        }
        
        // 3. Call method that throws exception without try block in a separate method
        System.out.println("\n3. Calling method that throws exception:");
        try {
            methodThatThrowsException();
        } catch(IOException e) {
            System.out.println("IOException caught: " + e.getMessage());
        }
        
        // 4. Program with multiple catch blocks
        System.out.println("\n4. Multiple catch blocks:");
        try {
            int[] arr = new int[5];
            arr[10] = 5; // This will cause ArrayIndexOutOfBoundsException
        } catch(ArithmeticException e) {
            System.out.println("ArithmeticException: " + e.getMessage());
        } catch(ArrayIndexOutOfBoundsException e) {
            System.out.println("ArrayIndexOutOfBoundsException: " + e.getMessage());
        } catch(Exception e) {
            System.out.println("General Exception: " + e.getMessage());
        }
        
        // 5. Throw exception with own message
        System.out.println("\n5. Exception with custom message:");
        try {
            throw new IllegalArgumentException("This is my own custom message");
        } catch(IllegalArgumentException e) {
            System.out.println("Caught with custom message: " + e.getMessage());
        }
        
        // 6. Create and use own exception
        System.out.println("\n6. Custom exception:");
        try {
            throw new CustomException("This is a custom exception message");
        } catch(CustomException e) {
            System.out.println("Custom exception caught: " + e.getMessage());
        }
        
        // 7. Program with finally block
        System.out.println("\n7. Finally block:");
        try {
            int result = 15 / 3;
            System.out.println("Division result: " + result);
        } catch(ArithmeticException e) {
            System.out.println("Exception: " + e.getMessage());
        } finally {
            System.out.println("This is the finally block - always executes");
        }
        
        // Demonstrate various exceptions
        System.out.println("\nDemonstrating various exceptions:");
        
        // 8. ArithmeticException
        System.out.println("\n8. ArithmeticException:");
        try {
            int result = 100 / 0;
        } catch(ArithmeticException e) {
            System.out.println("ArithmeticException: " + e.getMessage());
        }
        
        // 9. ArrayIndexOutOfBoundsException
        System.out.println("\n9. ArrayIndexOutOfBoundsException:");
        try {
            int[] arr = {1, 2, 3};
            System.out.println(arr[5]);
        } catch(ArrayIndexOutOfBoundsException e) {
            System.out.println("ArrayIndexOutOfBoundsException: " + e.getMessage());
        }
        
        // 11. FileNotFoundException
        System.out.println("\n11. FileNotFoundException:");
        try {
            File file = new File("nonexistent.txt");
            FileReader fr = new FileReader(file);
        } catch(FileNotFoundException e) {
            System.out.println("FileNotFoundException: " + e.getMessage());
        }
        
        // 12. IOException
        System.out.println("\n12. IOException:");
        try {
            throw new IOException("Simulated IOException");
        } catch(IOException e) {
            System.out.println("IOException: " + e.getMessage());
        }
        
        // 15. NullPointerException
        System.out.println("\n15. NullPointerException:");
        try {
            String str = null;
            System.out.println(str.length());
        } catch(NullPointerException e) {
            System.out.println("NullPointerException: " + e.getMessage());
        }
        
        // 16. NumberFormatException
        System.out.println("\n16. NumberFormatException:");
        try {
            int num = Integer.parseInt("not_a_number");
        } catch(NumberFormatException e) {
            System.out.println("NumberFormatException: " + e.getMessage());
        }
        
        // 17. StringIndexOutOfBoundsException
        System.out.println("\n17. StringIndexOutOfBoundsException:");
        try {
            String text = "Hello";
            char ch = text.charAt(10);
        } catch(StringIndexOutOfBoundsException e) {
            System.out.println("StringIndexOutOfBoundsException: " + e.getMessage());
        }
        
        // 18. SQLException
        System.out.println("\n18. SQLException:");
        try {
            throw new SQLException("Simulated SQL Exception");
        } catch(SQLException e) {
            System.out.println("SQLException: " + e.getMessage());
        }
        
        System.out.println("\nAll exception handling examples completed!");
    }
}