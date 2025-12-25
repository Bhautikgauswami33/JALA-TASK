public class JavaMethodOverloading {
    // 1. Two methods with the same name but different number of parameters of same type
    public int add(int a, int b) {
        System.out.println("Adding 2 numbers: " + a + " + " + b);
        return a + b;
    }
    
    public int add(int a, int b, int c) {
        System.out.println("Adding 3 numbers: " + a + " + " + b + " + " + c);
        return a + b + c;
    }
    
    // 2. Two methods with the same name but different number of parameters of different data type
    public String concatenate(String str1, int num) {
        System.out.println("Concatenating String and int: " + str1 + " and " + num);
        return str1 + num;
    }
    
    public String concatenate(String str1, int num, double d) {
        System.out.println("Concatenating String, int and double: " + str1 + ", " + num + " and " + d);
        return str1 + num + d;
    }
    
    // 4. Two methods with the same name and same number of parameters of different type
    public void display(int num) {
        System.out.println("Displaying integer: " + num);
    }
    
    public void display(String str) {
        System.out.println("Displaying string: " + str);
    }
    
    // 5. Two methods with the same name, number of parameters and data type but different return Type
    // NOTE: This is NOT allowed in Java. The following would cause a compilation error:
    // public int multiply(int a, int b) { return a * b; }
    // public String multiply(int a, int b) { return String.valueOf(a * b); }
    // The above would cause: "Duplicate method multiply(int, int) in type JavaMethodOverloading"
    
    // Instead, we'll demonstrate what's possible - different return types with different parameters
    public int multiply(int a, int b) {
        System.out.println("Multiplying integers: " + a + " * " + b);
        return a * b;
    }
    
    public double multiply(double a, double b) {
        System.out.println("Multiplying doubles: " + a + " * " + b);
        return a * b;
    }
    
    public static void main(String[] args) {
        System.out.println("=== Java Method Overloading Assignments ===\n");
        
        JavaMethodOverloading obj = new JavaMethodOverloading();
        
        // 1. Call methods with same name but different number of parameters of same type
        System.out.println("1. Same name, different number of parameters (same type):");
        int result1 = obj.add(5, 10);
        System.out.println("Result: " + result1);
        int result2 = obj.add(5, 10, 15);
        System.out.println("Result: " + result2);
        
        // 2. Call methods with same name but different number of parameters of different data type
        System.out.println("\n2. Same name, different number of parameters (different types):");
        String result3 = obj.concatenate("Hello", 123);
        System.out.println("Result: " + result3);
        String result4 = obj.concatenate("Hello", 123, 45.67);
        System.out.println("Result: " + result4);
        
        // Note about requirement 3: Two methods with the same name and same number of parameters of same type
        // This is NOT allowed in Java. The following would cause a compilation error:
        System.out.println("\n3. Same name, same number of parameters (same type) - NOT ALLOWED:");
        System.out.println("This would cause a compilation error in Java.");
        System.out.println("Example that would NOT work:");
        System.out.println("// public void method(int a) { }");
        System.out.println("// public void method(int b) { } // Compilation error!");
        
        // 4. Call methods with same name and same number of parameters of different type
        System.out.println("\n4. Same name, same number of parameters (different types):");
        obj.display(42);
        obj.display("Hello World");
        
        // 5. Different return types with different parameters (since same parameters with different return types isn't allowed)
        System.out.println("\n5. Same name, same number of parameters (different types) with different return types:");
        int intResult = obj.multiply(5, 6);
        System.out.println("Integer multiplication result: " + intResult);
        double doubleResult = obj.multiply(5.5, 6.2);
        System.out.println("Double multiplication result: " + doubleResult);
        
        System.out.println("\nNote: Java does not allow method overloading based only on return type.");
        System.out.println("Two methods with the same name, same parameter types and different return types are not allowed.");
    }
}