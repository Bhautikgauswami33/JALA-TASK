public class JavaStatic {
    // 1. 2 static variables
    static int staticVar1 = 100;
    static String staticVar2 = "Static Variable";
    
    // 1. 2 instance variables
    int instanceVar1 = 200;
    String instanceVar2 = "Instance Variable";
    
    public static void main(String[] args) {
        System.out.println("=== Java Static Assignments ===\n");
        
        // 6. Print all the static, instance variables in main method
        System.out.println("6. Static variables in main method:");
        System.out.println("staticVar1: " + staticVar1);
        System.out.println("staticVar2: " + staticVar2);
        
        // Creating an instance to access instance variables
        JavaStatic obj = new JavaStatic();
        System.out.println("Instance variables in main method:");
        System.out.println("instanceVar1: " + obj.instanceVar1);
        System.out.println("instanceVar2: " + obj.instanceVar2);
        
        // 7. Call static methods and instance methods in main method
        System.out.println("\n7. Calling static and instance methods in main method:");
        staticMethod1();
        staticMethod2();
        
        obj.instanceMethod1();
        obj.instanceMethod2();
        
        // Testing other requirements
        System.out.println("\nTesting other requirements:");
        printInstanceInStatic();
        obj.printStaticInInstance();
        obj.callStaticInInstance();
        callInstanceInStatic();
    }
    
    // 1. 2 static methods
    public static void staticMethod1() {
        System.out.println("Static Method 1 called");
    }
    
    public static void staticMethod2() {
        System.out.println("Static Method 2 called");
    }
    
    // 1. 2 instance methods
    public void instanceMethod1() {
        System.out.println("Instance Method 1 called");
    }
    
    public void instanceMethod2() {
        System.out.println("Instance Method 2 called");
    }
    
    // 2. Print instance variables in static methods
    public static void printInstanceInStatic() {
        JavaStatic obj = new JavaStatic(); // Need to create an instance to access instance variables
        System.out.println("2. Instance variables accessed in static method:");
        System.out.println("instanceVar1: " + obj.instanceVar1);
        System.out.println("instanceVar2: " + obj.instanceVar2);
    }
    
    // 3. Print static variables in Instance methods
    public void printStaticInInstance() {
        System.out.println("3. Static variables accessed in instance method:");
        System.out.println("staticVar1: " + staticVar1);
        System.out.println("staticVar2: " + staticVar2);
    }
    
    // 4. Call instance methods in static methods
    public static void callInstanceInStatic() {
        JavaStatic obj = new JavaStatic(); // Create an instance to call instance methods
        System.out.println("4. Calling instance methods from static method:");
        obj.instanceMethod1();
        obj.instanceMethod2();
    }
    
    // 5. Call static methods in instance methods
    public void callStaticInInstance() {
        System.out.println("5. Calling static methods from instance method:");
        staticMethod1();
        staticMethod2();
    }
}