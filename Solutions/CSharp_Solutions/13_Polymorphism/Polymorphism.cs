using System;

namespace CSharpPolymorphism
{
    // Base class for runtime polymorphism example
    class Shape
    {
        public virtual void Draw()
        {
            Console.WriteLine("Drawing a shape...");
        }
    }
    
    // Derived class 1
    class Circle : Shape
    {
        public override void Draw()
        {
            Console.WriteLine("Drawing a circle...");
        }
    }
    
    // Derived class 2
    class Rectangle : Shape
    {
        public override void Draw()
        {
            Console.WriteLine("Drawing a rectangle...");
        }
    }
    
    // Class for method overloading examples
    class Calculator
    {
        // 1. Method with same name but different number of parameters
        public int Add(int a, int b)
        {
            return a + b;
        }
        
        public int Add(int a, int b, int c)
        {
            return a + b + c;
        }
        
        // 4. Function overloading by changing data types of parameters
        public int Add(int a, int b)
        {
            return a + b;
        }
        
        public double Add(double a, double b)
        {
            return a + b;
        }
        
        // 5. Function overloading by changing order of parameters
        public void Display(string name, int age)
        {
            Console.WriteLine($"Name: {name}, Age: {age}");
        }
        
        public void Display(int age, string name)
        {
            Console.WriteLine($"Age: {age}, Name: {name}");
        }
    }
    
    class Polymorphism
    {
        static void Main(string[] args)
        {
            Console.WriteLine("=== C# Polymorphism Assignments ===\n");
            
            // 1. Write a program on A class has two methods with the same name "Add" but with different input parameters
            Calculator calc = new Calculator();
            Console.WriteLine($"Add(5, 3) = {calc.Add(5, 3)}");
            Console.WriteLine($"Add(5, 3, 2) = {calc.Add(5, 3, 2)}");
            
            // 4. Demonstrate function overloading by changing data types of parameters
            Console.WriteLine($"Add(5.5, 3.2) = {calc.Add(5.5, 3.2)}");
            
            // 5. Demonstrate function overloading by changing order of parameters
            calc.Display("John", 25);
            calc.Display(30, "Jane");
            
            Console.WriteLine();
            
            // 2. Write a program on Runtime polymorphism in c#
            Shape shape; // Base class reference
            
            shape = new Circle(); // Derived class object
            shape.Draw(); // Calls Circle's Draw method
            
            shape = new Rectangle(); // Derived class object
            shape.Draw(); // Calls Rectangle's Draw method
            
            // 3. Write a program on taking one method with same but different signature in the methods
            // This is demonstrated by method overloading above (same method name, different signatures)
            Console.WriteLine("Method overloading examples shown above with different parameter counts and types");
            
            Console.WriteLine("\nPress any key to exit...");
            Console.ReadKey();
        }
    }
}