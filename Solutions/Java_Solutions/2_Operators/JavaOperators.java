public class JavaOperators {
    public static void main(String[] args) {
        System.out.println("=== Java Operators Assignments ===\n");
        
        // 1. Arithmetic Operators
        int a = 15;
        int b = 4;
        
        System.out.println("Arithmetic Operators:");
        System.out.println("a = " + a + ", b = " + b);
        System.out.println("Addition (a + b): " + (a + b));
        System.out.println("Subtraction (a - b): " + (a - b));
        System.out.println("Multiplication (a * b): " + (a * b));
        System.out.println("Division (a / b): " + (a / b));
        System.out.println("Modulus (a % b): " + (a % b));
        System.out.println("Unary Plus (+a): " + (+a));
        System.out.println("Unary Minus (-a): " + (-a));
        System.out.println();
        
        // 2. Relational Operators
        System.out.println("Relational Operators:");
        System.out.println("a > b: " + (a > b));
        System.out.println("a < b: " + (a < b));
        System.out.println("a >= b: " + (a >= b));
        System.out.println("a <= b: " + (a <= b));
        System.out.println("a == b: " + (a == b));
        System.out.println("a != b: " + (a != b));
        System.out.println();
        
        // 3. Logical Operators
        boolean x = true;
        boolean y = false;
        
        System.out.println("Logical Operators:");
        System.out.println("x && y: " + (x && y));
        System.out.println("x || y: " + (x || y));
        System.out.println("!x: " + (!x));
        System.out.println("!y: " + (!y));
        System.out.println();
        
        // 4. Assignment Operators
        int c = 10;
        System.out.println("Assignment Operators:");
        System.out.println("Initial value of c: " + c);
        c += 5;
        System.out.println("c += 5: " + c);
        c -= 3;
        System.out.println("c -= 3: " + c);
        c *= 2;
        System.out.println("c *= 2: " + c);
        c /= 4;
        System.out.println("c /= 4: " + c);
        c %= 3;
        System.out.println("c %= 3: " + c);
        System.out.println();
        
        // 5. Increment and Decrement Operators
        int d = 5;
        System.out.println("Increment and Decrement Operators:");
        System.out.println("Initial value of d: " + d);
        System.out.println("Post-increment d++: " + d++);
        System.out.println("Value after post-increment: " + d);
        System.out.println("Pre-increment ++d: " + ++d);
        System.out.println("Value after pre-increment: " + d);
        System.out.println("Post-decrement d--: " + d--);
        System.out.println("Value after post-decrement: " + d);
        System.out.println("Pre-decrement --d: " + --d);
        System.out.println("Value after pre-decrement: " + d);
        System.out.println();
        
        // 6. Ternary Operator
        int num1 = 10;
        int num2 = 20;
        int max = (num1 > num2) ? num1 : num2;
        System.out.println("Ternary Operator:");
        System.out.println("Greater of " + num1 + " and " + num2 + " is: " + max);
        System.out.println();
        
        // 7. Bitwise Operators
        int p = 8;  // Binary: 1000
        int q = 3;  // Binary: 0011
        
        System.out.println("Bitwise Operators:");
        System.out.println("p = " + p + " (binary: " + Integer.toBinaryString(p) + ")");
        System.out.println("q = " + q + " (binary: " + Integer.toBinaryString(q) + ")");
        System.out.println("p & q (AND): " + (p & q) + " (binary: " + Integer.toBinaryString(p & q) + ")");
        System.out.println("p | q (OR): " + (p | q) + " (binary: " + Integer.toBinaryString(p | q) + ")");
        System.out.println("p ^ q (XOR): " + (p ^ q) + " (binary: " + Integer.toBinaryString(p ^ q) + ")");
        System.out.println("~p (NOT): " + (~p) + " (binary: " + Integer.toBinaryString(~p) + ")");
        System.out.println("p << 1 (Left Shift): " + (p << 1) + " (binary: " + Integer.toBinaryString(p << 1) + ")");
        System.out.println("p >> 1 (Right Shift): " + (p >> 1) + " (binary: " + Integer.toBinaryString(p >> 1) + ")");
        System.out.println();
        
        // 8. Operator Precedence Example
        int result = 10 + 5 * 2 - 8 / 4;
        System.out.println("Operator Precedence Example:");
        System.out.println("10 + 5 * 2 - 8 / 4 = " + result);
        System.out.println("(Multiplication and division happen first, then addition and subtraction)");
        System.out.println();
        
        // 9. Complex Expression
        int complexResult = ((a + b) * 2) - (c / d);
        System.out.println("Complex Expression:");
        System.out.println("((a + b) * 2) - (c / d) = ((" + a + " + " + b + ") * 2) - (" + c + " / " + d + ") = " + complexResult);
        System.out.println();
        
        System.out.println("Task completed: Java operators demonstration");
    }
}