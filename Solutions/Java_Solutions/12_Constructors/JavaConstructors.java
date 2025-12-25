// Parent class with different types of constructors
class ParentConstructor {
    private String parentName;
    private int parentAge;
    
    // Default constructor
    public ParentConstructor() {
        this.parentName = "Default Parent";
        this.parentAge = 0;
        System.out.println("Parent default constructor called");
    }
    
    // One argument constructor
    public ParentConstructor(String name) {
        this.parentName = name;
        this.parentAge = 0;
        System.out.println("Parent one-argument constructor called with name: " + name);
    }
    
    // Two argument constructor
    public ParentConstructor(String name, int age) {
        this.parentName = name;
        this.parentAge = age;
        System.out.println("Parent two-argument constructor called with name: " + name + ", age: " + age);
    }
    
    public void displayParentInfo() {
        System.out.println("Parent: " + parentName + ", Age: " + parentAge);
    }
}

// Child class to demonstrate calling parent constructors
class ChildConstructor extends ParentConstructor {
    private String childName;
    private int childAge;
    
    // Default constructor calling parent constructor
    public ChildConstructor() {
        super(); // Calls parent default constructor
        this.childName = "Default Child";
        this.childAge = 0;
        System.out.println("Child default constructor called");
    }
    
    // One argument constructor calling parent constructor
    public ChildConstructor(String name) {
        super(name); // Calls parent one-argument constructor
        this.childName = name;
        this.childAge = 0;
        System.out.println("Child one-argument constructor called with name: " + name);
    }
    
    // Two argument constructor calling parent constructor with two arguments
    public ChildConstructor(String name, int age) {
        super(name, age); // Calls parent two-argument constructor
        this.childName = name;
        this.childAge = age;
        System.out.println("Child two-argument constructor called with name: " + name + ", age: " + age);
    }
    
    // Demonstrating different access modifiers for constructors
    public ChildConstructor(String name, int age, boolean publicAccess) {
        super(name, age);
        this.childName = name;
        this.childAge = age;
        System.out.println("Public constructor called");
    }
    
    protected ChildConstructor(String name, int age, boolean protectedAccess, boolean isProtected) {
        super(name);
        this.childName = name + " (Protected)";
        this.childAge = age;
        System.out.println("Protected constructor called");
    }
    
    /* default */ ChildConstructor(String name, int age, boolean defaultAccess, boolean isDefault, boolean dummy) {
        super();
        this.childName = name + " (Default)";
        this.childAge = age;
        System.out.println("Default (package-private) constructor called");
    }
    
    private ChildConstructor(String name, int age, boolean privateAccess, boolean isPrivate, boolean dummy1, boolean dummy2) {
        super();
        this.childName = name + " (Private)";
        this.childAge = age;
        System.out.println("Private constructor called");
    }
    
    public void displayChildInfo() {
        System.out.println("Child: " + childName + ", Age: " + childAge);
    }
}

public class JavaConstructors {
    public static void main(String[] args) {
        System.out.println("=== Java Constructors Assignments ===\n");
        
        // 1. Instantiate the class to call all the constructors of that class from a main class
        System.out.println("1. Calling different constructors:");
        
        // Default constructor
        System.out.println("\nCalling default constructor:");
        ChildConstructor obj1 = new ChildConstructor();
        obj1.displayParentInfo();
        obj1.displayChildInfo();
        
        // One argument constructor
        System.out.println("\nCalling one-argument constructor:");
        ChildConstructor obj2 = new ChildConstructor("John");
        obj2.displayParentInfo();
        obj2.displayChildInfo();
        
        // Two argument constructor
        System.out.println("\nCalling two-argument constructor:");
        ChildConstructor obj3 = new ChildConstructor("Jane", 25);
        obj3.displayParentInfo();
        obj3.displayChildInfo();
        
        // 2. Call the constructors of super class from a child class (already demonstrated above)
        System.out.println("\n2. Demonstrating that parent constructors are called from child constructors");
        
        // 3. Demonstrating access modifiers for constructors
        System.out.println("\n3. Different access modifier constructors:");
        ChildConstructor publicObj = new ChildConstructor("Public", 30, true);
        ChildConstructor protectedObj = new ChildConstructor("Protected", 35, true, true);
        ChildConstructor defaultObj = new ChildConstructor("Default", 40, true, true, true);
        ChildConstructor privateObj = new ChildConstructor("Private", 45, true, true, true, true);
        
        // 4. About constructors with return type - this is not possible in Java
        System.out.println("\n4. Constructors cannot have return types in Java");
        System.out.println("The following would be invalid syntax:");
        System.out.println("// public int Constructor() { } // This is invalid");
        System.out.println("// public String Constructor() { } // This is also invalid");
        System.out.println("Constructors in Java cannot have return types, not even void.");
        
        // 5. Try to call the constructor multiple times with the same object
        System.out.println("\n5. Trying to call constructor multiple times with same object:");
        System.out.println("This is not possible in Java. Once an object is created,");
        System.out.println("you cannot call its constructor again on the same object.");
        System.out.println("The following would cause a compilation error:");
        System.out.println("// obj1.ChildConstructor(); // This is invalid syntax");
        System.out.println("Instead, you need to create a new object:");
        
        ChildConstructor newObj = new ChildConstructor("New Object", 20);
        newObj.displayChildInfo();
    }
}