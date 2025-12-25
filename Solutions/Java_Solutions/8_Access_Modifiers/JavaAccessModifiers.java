class PrivateClass {
    private String privateField = "This is a private field";
    private int privateNumber = 100;
    
    private void privateMethod() {
        System.out.println("This is a private method");
        System.out.println("Private field value: " + privateField);
        System.out.println("Private number value: " + privateNumber);
    }
    
    public void accessPrivateMembers() {
        privateMethod();
    }
}

class SubClass extends PrivateClass {
    public void tryAccessPrivate() {
        System.out.println("\nTrying to access private members from subclass:");
        System.out.println("Cannot access private members from subclass");
        
        accessPrivateMembers();
    }
}

class DefaultClass {
    String defaultField = "This is a default field";
    int defaultNumber = 200;
    
    void defaultMethod() {
        System.out.println("This is a default method");
        System.out.println("Default field value: " + defaultField);
        System.out.println("Default number value: " + defaultNumber);
    }
}

class ProtectedClass {
    protected String protectedField = "This is a protected field";
    protected int protectedNumber = 300;
    
    protected void protectedMethod() {
        System.out.println("This is a protected method");
        System.out.println("Protected field value: " + protectedField);
        System.out.println("Protected number value: " + protectedNumber);
    }
}

class ProtectedSubClass extends ProtectedClass {
    public void accessProtected() {
        System.out.println("\nAccessing protected members from subclass:");
        System.out.println("Protected field: " + protectedField);
        System.out.println("Protected number: " + protectedNumber);
        protectedMethod();
    }
}

class PublicClass {
    public String publicField = "This is a public field";
    public int publicNumber = 400;
    
    public void publicMethod() {
        System.out.println("This is a public method");
        System.out.println("Public field value: " + publicField);
        System.out.println("Public number value: " + publicNumber);
    }
}

public class JavaAccessModifiers {
    public static void main(String[] args) {
        System.out.println("=== Java Access Modifiers Assignments ===\n");
        
        System.out.println("1. Private fields and methods:");
        PrivateClass privateObj = new PrivateClass();
        
        privateObj.accessPrivateMembers();
        
        SubClass subObj = new SubClass();
        subObj.tryAccessPrivate();
        
        System.out.println("\n2. Default fields and methods:");
        DefaultClass defaultObj = new DefaultClass();
        System.out.println("Default field: " + defaultObj.defaultField);
        System.out.println("Default number: " + defaultObj.defaultNumber);
        defaultObj.defaultMethod();
        
        System.out.println("\n3. Protected fields and methods:");
        ProtectedClass protectedObj = new ProtectedClass();
        
        ProtectedSubClass subProtected = new ProtectedSubClass();
        subProtected.accessProtected();
        
        System.out.println("\n4. Public fields and methods:");
        PublicClass publicObj = new PublicClass();
        System.out.println("Public field: " + publicObj.publicField);
        System.out.println("Public number: " + publicObj.publicNumber);
        publicObj.publicMethod();
    }
}