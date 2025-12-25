using System;

namespace CSharpStaticInstanceMembers
{
    class MyClass
    {
        // Static variable
        public static int staticVariable = 100;
        
        // Instance variable
        public int instanceVariable;
        
        // Static constructor
        static MyClass()
        {
            Console.WriteLine("Static constructor called.");
        }
        
        // Instance constructor
        public MyClass(int value)
        {
            instanceVariable = value;
            Console.WriteLine($"Instance constructor called with value: {value}");
        }
        
        // Static method
        public static void StaticMethod()
        {
            Console.WriteLine("This is a static method.");
        }
        
        // Instance method
        public void InstanceMethod()
        {
            Console.WriteLine($"This is an instance method. Instance variable: {instanceVariable}");
        }
    }
    
    class StaticInstanceMembers
    {
        static void Main(string[] args)
        {
            Console.WriteLine("=== C# Static & Instance Members Assignments ===\n");
            
            // 1. Define a static variable and access that through class name
            Console.WriteLine($"Static variable accessed through class name: {MyClass.staticVariable}");
            
            // 2. Define a static method and access that through a instance (This is actually incorrect - static methods are accessed through class name)
            // However, to demonstrate the concept, we'll call the static method using the class name
            MyClass.StaticMethod();
            
            // 3. Define a static and instance variable constructors and invoke the instance constructor
            MyClass obj = new MyClass(50);
            Console.WriteLine($"Instance variable: {obj.instanceVariable}");
            
            // 4. Define a static variable and change within the class
            Console.WriteLine($"Before change: {MyClass.staticVariable}");
            MyClass.staticVariable = 200;
            Console.WriteLine($"After change: {MyClass.staticVariable}");
            
            // Creating another instance to show static variable is shared
            MyClass obj2 = new MyClass(75);
            Console.WriteLine($"Static variable from second instance: {MyClass.staticVariable}");
            
            Console.WriteLine("\nPress any key to exit...");
            Console.ReadKey();
        }
    }
}