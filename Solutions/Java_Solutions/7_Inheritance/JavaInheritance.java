// Super class A
class A {
    // Instance variable for A
    int aValue = 10;
    
    // 2 specific methods for class A
    public void methodA1() {
        System.out.println("Method A1 in class A");
    }
    
    public void methodA2() {
        System.out.println("Method A2 in class A");
    }
    
    // Override method (to be overridden in subclasses)
    public void overrideMethod() {
        System.out.println("Override method in class A");
    }
}

// Sub class B of A
class B extends A {
    // Instance variable for B
    int bValue = 20;
    
    // 2 specific methods for class B
    public void methodB1() {
        System.out.println("Method B1 in class B");
    }
    
    public void methodB2() {
        System.out.println("Method B2 in class B");
    }
    
    // Override method from class A
    @Override
    public void overrideMethod() {
        System.out.println("Override method in class B");
    }
}

// Sub class C of B
class C extends B {
    // Instance variable for C
    int cValue = 30;
    
    // 2 specific methods for class C
    public void methodC1() {
        System.out.println("Method C1 in class C");
    }
    
    public void methodC2() {
        System.out.println("Method C2 in class C");
    }
    
    // Override method from class B (and A)
    @Override
    public void overrideMethod() {
        System.out.println("Override method in class C");
    }
}

public class JavaInheritance {
    public static void main(String[] args) {
        System.out.println("=== Java Inheritance Assignments ===\n");
        
        // Create an object for each class A, B and C in main method
        A objA = new A();
        B objB = new B();
        C objC = new C();
        
        // Call every method of each class using its own object/instance
        System.out.println("1. Calling methods using own objects:");
        
        System.out.println("\nMethods of class A:");
        objA.methodA1();
        objA.methodA2();
        objA.overrideMethod();
        
        System.out.println("\nMethods of class B:");
        objB.methodA1();  // Inherited from A
        objB.methodA2();  // Inherited from A
        objB.methodB1();
        objB.methodB2();
        objB.overrideMethod();  // Overridden method
        
        System.out.println("\nMethods of class C:");
        objC.methodA1();  // Inherited from A
        objC.methodA2();  // Inherited from A
        objC.methodB1();  // Inherited from B
        objC.methodB2();  // Inherited from B
        objC.methodC1();
        objC.methodC2();
        objC.overrideMethod();  // Overridden method
        
        // Call an overridden method with super class reference to B and C class's objects
        System.out.println("\n2. Calling overridden method with super class reference:");
        A refB = new B();  // Super class reference to B object
        A refC = new C();  // Super class reference to C object
        
        refB.overrideMethod();  // Calls B's version (Runtime Polymorphism)
        refC.overrideMethod();  // Calls C's version (Runtime Polymorphism)
        
        // Runtime Polymorphism with Data Members/Instance variables
        System.out.println("\n3. Runtime Polymorphism with Data Members:");
        System.out.println("Value of aValue through A reference to A object: " + objA.aValue);
        System.out.println("Value of aValue through A reference to B object: " + refB.aValue);
        System.out.println("Value of aValue through A reference to C object: " + refC.aValue);
        
        // Note: For data members, there is no runtime polymorphism in Java
        // The variable that gets accessed is determined by the reference type, not the object type
        System.out.println("\nNote: For data members, the value depends on reference type, not object type");
        System.out.println("refB (type A) has aValue: " + refB.aValue);
        System.out.println("refC (type A) has aValue: " + refC.aValue);
    }
}