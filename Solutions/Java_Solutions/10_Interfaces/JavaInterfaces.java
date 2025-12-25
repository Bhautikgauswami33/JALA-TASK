// 1. Create an interface with only one method
interface SingleMethodInterface {
    void singleMethod();
}

// 8. Create a PUBLIC interface with fields and methods (using package-private access)
interface PublicInterface {
    int PUBLIC_FIELD = 100;  // public, static, and final by default
    String TEXT = "Hello from interface";
    
    void interfaceMethod();
}

// Implementation of single method interface
class SingleMethodImpl implements SingleMethodInterface {
    public void singleMethod() {
        System.out.println("Single method implemented in class");
    }
}

// 2. Create an interface with two methods
interface TwoMethodsInterface {
    void methodOne();
    void methodTwo();
}

// Implementation class that implements only one method (this will cause compilation error)
// abstract class TwoMethodsPartialImpl implements TwoMethodsInterface {
//     public void methodOne() {
//         System.out.println("Only one method implemented");
//     }
//     // methodTwo() is not implemented, so class must be abstract
// }

// Complete implementation of two methods interface
class TwoMethodsImpl implements TwoMethodsInterface {
    public void methodOne() {
        System.out.println("Method one implemented");
    }
    
    public void methodTwo() {
        System.out.println("Method two implemented");
    }
}

// 4. Create two interfaces with one method each
interface FirstInterface {
    void firstMethod();
}

interface SecondInterface {
    void secondMethod();
}

// Implement both interfaces in one class
class BothInterfacesImpl implements FirstInterface, SecondInterface {
    public void firstMethod() {
        System.out.println("First interface method implemented");
    }
    
    public void secondMethod() {
        System.out.println("Second interface method implemented");
    }
}

// 5. Create two interfaces with the same method
interface SameMethodInterface1 {
    void sameMethod();
}

interface SameMethodInterface2 {
    void sameMethod();
}

// Implement both interfaces with same method
class SameMethodImpl implements SameMethodInterface1, SameMethodInterface2 {
    public void sameMethod() {
        System.out.println("Same method implemented for both interfaces");
    }
}

// 6. Create an interface with a default method
interface DefaultMethodInterface {
    default void defaultMethod() {
        System.out.println("Default method implementation in interface");
    }
    
    void abstractMethod();
}

class DefaultMethodImpl implements DefaultMethodInterface {
    public void abstractMethod() {
        System.out.println("Abstract method implemented in class");
    }
    // Note: defaultMethod() doesn't need to be implemented
}

// 7. Create an interface and inherit it from the other interface
interface ParentInterface {
    void parentMethod();
}

interface ChildInterface extends ParentInterface {
    void childMethod();
}

class InheritedInterfaceImpl implements ChildInterface {
    public void parentMethod() {
        System.out.println("Parent interface method implemented");
    }
    
    public void childMethod() {
        System.out.println("Child interface method implemented");
    }
}

// 8. Create a PUBLIC interface with fields and methods

class PublicInterfaceImpl implements PublicInterface {
    public void interfaceMethod() {
        System.out.println("Public interface method implemented");
    }
    
    // Access the interface constants
    public int getPublicField() {
        return PUBLIC_FIELD;
    }
    
    public String getText() {
        return TEXT;
    }
}

public class JavaInterfaces {
    public static void main(String[] args) {
        System.out.println("=== Java Interfaces Assignments ===\n");
        
        // 1. Call the method implemented from single method interface
        System.out.println("1. Single method interface:");
        SingleMethodImpl singleImpl = new SingleMethodImpl();
        singleImpl.singleMethod();
        
        // 2. Call the method implemented from two methods interface
        System.out.println("\n2. Two methods interface (both implemented):");
        TwoMethodsImpl twoImpl = new TwoMethodsImpl();
        twoImpl.methodOne();
        twoImpl.methodTwo();
        
        // 3. Use Interface instances to call the implemented method
        System.out.println("\n3. Using interface reference:");
        SingleMethodInterface interfaceRef = new SingleMethodImpl();
        interfaceRef.singleMethod();
        
        // 4. Implement two interfaces in one class
        System.out.println("\n4. Two interfaces in one class:");
        BothInterfacesImpl bothImpl = new BothInterfacesImpl();
        bothImpl.firstMethod();
        bothImpl.secondMethod();
        
        // 5. Two interfaces with same method
        System.out.println("\n5. Two interfaces with same method:");
        SameMethodImpl sameImpl = new SameMethodImpl();
        sameImpl.sameMethod();
        
        // 6. Default method interface
        System.out.println("\n6. Default method interface:");
        DefaultMethodImpl defaultImpl = new DefaultMethodImpl();
        defaultImpl.abstractMethod();
        defaultImpl.defaultMethod();  // Using default implementation
        
        // 7. Inherited interface
        System.out.println("\n7. Inherited interface:");
        InheritedInterfaceImpl inheritedImpl = new InheritedInterfaceImpl();
        inheritedImpl.parentMethod();
        inheritedImpl.childMethod();
        
        // 8. Public interface with fields
        System.out.println("\n8. Public interface with fields:");
        PublicInterfaceImpl publicImpl = new PublicInterfaceImpl();
        System.out.println("Public field value: " + publicImpl.getPublicField());
        System.out.println("Public text: " + publicImpl.getText());
        publicImpl.interfaceMethod();
        
        // 11. Static final variable in interface
        System.out.println("\n11. Static final variable in interface:");
        System.out.println("Static final variable (PUBLIC_FIELD): " + publicImpl.getPublicField());
    }
}