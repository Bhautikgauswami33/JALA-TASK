// Parent class for demonstrating super keyword
class ParentClass {
    int parentField = 100;
    String parentText = "Parent Class";
    
    // Constructor for parent class
    public ParentClass() {
        System.out.println("Parent class constructor called");
    }
    
    // Parameterized constructor for parent class
    public ParentClass(String text) {
        this.parentText = text;
        System.out.println("Parent class parameterized constructor called with: " + text);
    }
    
    // Method in parent class
    public void parentMethod() {
        System.out.println("Method in Parent class");
    }
}

// Child class to demonstrate this and super keywords
class ChildClass extends ParentClass {
    int childField = 200;
    String childText = "Child Class";
    
    // Default constructor
    public ChildClass() {
        super(); // 5. Call constructor of the parent class using super()
        System.out.println("Child class constructor called");
    }
    
    // Parameterized constructor
    public ChildClass(String text) {
        this(); // 4. Call argument constructor of current class using this()
        this.childText = text;
        System.out.println("Child class parameterized constructor called with: " + text);
    }
    
    // Another constructor to demonstrate this()
    public ChildClass(int value) {
        this("Default Text"); // 3. Call constructor of the current class using this()
        this.childField = value;
        System.out.println("Child class constructor with int called, field set to: " + value);
    }
    
    // Method to print current class fields using this
    public void printCurrentFields() {
        System.out.println("\n1. Fields of current class using 'this':");
        System.out.println("this.childField: " + this.childField);
        System.out.println("this.childText: " + this.childText);
    }
    
    // Method to print parent class fields using super
    public void printParentFields() {
        System.out.println("\n2. Fields of parent class using 'super':");
        System.out.println("super.parentField: " + super.parentField);
        System.out.println("super.parentText: " + super.parentText);
    }
    
    // Method demonstrating this() in method (not constructor)
    public void demonstrateThisInMethod() {
        System.out.println("\n6. Using this and super in methods:");
        this.printCurrentFields();  // Calling current class method using this
        super.parentMethod();       // Calling parent class method using super
    }
    
    // Method to print all fields without using this explicitly (implicit this)
    public void printAllFields() {
        System.out.println("\n1. Fields without using object (implicit this):");
        System.out.println("childField: " + childField);      // Implicit this.childField
        System.out.println("childText: " + childText);        // Implicit this.childText
        System.out.println("parentField: " + parentField);    // Implicit super.parentField
        System.out.println("parentText: " + parentText);      // Implicit super.parentText
    }
}

public class JavaThisSuper {
    public static void main(String[] args) {
        System.out.println("=== Java This and Super Assignments ===\n");
        
        // Create object to demonstrate default constructor
        System.out.println("Creating child object with default constructor:");
        ChildClass child1 = new ChildClass();
        
        // Print fields using this and super
        child1.printCurrentFields();
        child1.printParentFields();
        child1.printAllFields();
        
        // Demonstrate this() and super() in methods
        child1.demonstrateThisInMethod();
        
        // Create object with parameterized constructor to demonstrate this() in constructor
        System.out.println("\nCreating child object with parameterized constructor:");
        ChildClass child2 = new ChildClass("Custom Text");
        
        // Create object with int constructor to demonstrate constructor chaining
        System.out.println("\nCreating child object with int constructor:");
        ChildClass child3 = new ChildClass(300);
    }
}