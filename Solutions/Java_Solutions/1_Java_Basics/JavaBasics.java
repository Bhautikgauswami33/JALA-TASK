public class JavaBasics {
    public static void main(String[] args) {
        System.out.println("=== Java Basics Assignments ===\n");
        
        // 1. Declare variables of different data types
        int empID = 101;
        String empName = "John Doe";
        double salary = 50000.50;
        char grade = 'A';
        boolean isActive = true;
        
        System.out.println("Employee Details:");
        System.out.println("ID: " + empID);
        System.out.println("Name: " + empName);
        System.out.println("Salary: $" + salary);
        System.out.println("Grade: " + grade);
        System.out.println("Active: " + isActive);
        
        // 2. Check if a number is odd or even
        int number = 15;
        if (number % 2 == 0) {
            System.out.println("\n" + number + " is even");
        } else {
            System.out.println("\n" + number + " is odd");
        }
        
        // 3. Swap two numbers
        int a = 10;
        int b = 20;
        System.out.println("\nBefore swapping: a = " + a + ", b = " + b);
        
        // Swapping without temporary variable
        a = a + b;
        b = a - b;
        a = a - b;
        
        System.out.println("After swapping: a = " + a + ", b = " + b);
        
        // 4. Basic arithmetic operations
        int x = 15;
        int y = 4;
        
        System.out.println("\nArithmetic operations with " + x + " and " + y + ":");
        System.out.println("Addition: " + (x + y));
        System.out.println("Subtraction: " + (x - y));
        System.out.println("Multiplication: " + (x * y));
        System.out.println("Division: " + (x / y));
        System.out.println("Modulus: " + (x % y));
        
        // 5. Using different operators
        System.out.println("\nRelational operations:");
        System.out.println(x + " > " + y + ": " + (x > y));
        System.out.println(x + " < " + y + ": " + (x < y));
        System.out.println(x + " == " + y + ": " + (x == y));
        
        System.out.println("\nLogical operations:");
        boolean p = true;
        boolean q = false;
        System.out.println("p && q: " + (p && q));
        System.out.println("p || q: " + (p || q));
        System.out.println("!p: " + (!p));
        
        System.out.println("\nTask completed: Java basics demonstration");
    }
}