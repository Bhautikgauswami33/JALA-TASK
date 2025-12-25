// 1. Create an abstract class with abstract and non-abstract methods
abstract class AbstractClass {
    // Non-abstract method
    public void nonAbstractMethod() {
        System.out.println("This is a non-abstract method in abstract class");
    }
    
    // Abstract method (no implementation)
    public abstract void abstractMethod();
    
    // Another non-abstract method
    public void anotherNonAbstractMethod() {
        System.out.println("This is another non-abstract method in abstract class");
    }
}

// 2. Create a sub class for an abstract class
class ChildClass extends AbstractClass {
    // Must implement the abstract method
    @Override
    public void abstractMethod() {
        System.out.println("Implementation of abstract method in child class");
    }
    
    // Method to demonstrate accessing non-abstract methods from abstract class
    public void demonstrateAccess() {
        System.out.println("\nInside child class method:");
        
        // 3. Create an instance for the child class in child class and call abstract methods
        System.out.println("3. Calling abstract method from child class:");
        this.abstractMethod();  // Calling the implemented abstract method
        
        // 4. Create an instance for the child class in child class and call non-abstract methods
        System.out.println("4. Calling non-abstract methods from child class:");
        this.nonAbstractMethod();
        this.anotherNonAbstractMethod();
    }
}

public class JavaAbstractClass {
    public static void main(String[] args) {
        System.out.println("=== Java Abstract Class Assignments ===\n");
        
        // 2. Create a sub class for an abstract class. Create an object in the child class for the abstract class and access the non-abstract methods
        System.out.println("2. Creating object of child class and accessing non-abstract methods:");
        ChildClass childObj = new ChildClass();
        childObj.nonAbstractMethod();         // Accessing non-abstract method
        childObj.anotherNonAbstractMethod();  // Accessing another non-abstract method
        childObj.abstractMethod();            // Accessing implemented abstract method
        
        // Calling the method that demonstrates requirements 3 and 4
        childObj.demonstrateAccess();
        
        // We can also create an instance of the abstract class using the child class
        System.out.println("\nCreating abstract class reference with child class object:");
        AbstractClass abstractRef = new ChildClass();
        abstractRef.nonAbstractMethod();      // Accessing non-abstract method
        abstractRef.abstractMethod();         // Calling the overridden abstract method
    }
}