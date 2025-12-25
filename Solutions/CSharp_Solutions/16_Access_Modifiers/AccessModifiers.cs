using System;

namespace CSharpAccessModifiers
{
    // Public class
    public class Student
    {
        // Public members - accessible from anywhere
        public int StudentId;
        public string StudentName;
        
        public Student(int id, string name)
        {
            StudentId = id;
            StudentName = name;
        }
        
        public void DisplayStudentInfo()
        {
            Console.WriteLine($"StudentId: {StudentId}");
            Console.WriteLine($"StudentName: {StudentName}");
        }
    }
    
    // Base class to demonstrate protected access modifier
    class BaseClass
    {
        protected int x;
        
        public BaseClass(int value)
        {
            x = value;
        }
        
        public void DisplayX()
        {
            Console.WriteLine($"Value of x: {x}");
        }
    }
    
    // Derived class to access protected member
    class DerivedClass : BaseClass
    {
        public DerivedClass(int value) : base(value)
        {
        }
        
        public void AccessProtected()
        {
            // Accessing protected member from base class
            Console.WriteLine($"Accessing protected member x from derived class: {x}");
        }
    }
    
    // Class with private members
    class PrivateExample
    {
        private int privateValue = 42;
        private string privateString = "Private";
        
        public void AccessPrivateMembers()
        {
            // Accessing private members within the same class
            Console.WriteLine($"Private value: {privateValue}");
            Console.WriteLine($"Private string: {privateString}");
        }
    }
    
    // Default access modifier example (internal by default)
    class DefaultAccessExample
    {
        // By default, class members are private
        int defaultField; // This is private by default
        string defaultString = "Default";
        
        public DefaultAccessExample(int value)
        {
            defaultField = value;
        }
        
        public void DisplayDefault()
        {
            Console.WriteLine($"Default field: {defaultField}");
            Console.WriteLine($"Default string: {defaultString}");
        }
    }
    
    class AccessModifiers
    {
        static void Main(string[] args)
        {
            Console.WriteLine("=== C# Access Modifiers Assignments ===\n");
            
            // 1. Write a program to show the use of public Access Modifier in c#
            Student student = new Student(101, "santhi");
            Console.WriteLine("Public Access Modifier:");
            Console.WriteLine($"Studentid: {student.StudentId}");
            Console.WriteLine($"StudentName: {student.StudentName}");
            
            // 2. Write a program on protected access modifier using one method
            DerivedClass derived = new DerivedClass(10);
            Console.WriteLine("\nProtected Access Modifier:");
            derived.DisplayX();
            derived.AccessProtected();
            
            // 3. Write a program on private access modifier in c#
            PrivateExample privateEx = new PrivateExample();
            Console.WriteLine("\nPrivate Access Modifier:");
            privateEx.AccessPrivateMembers();
            
            // 4. Write a program on default access modifier in c#
            DefaultAccessExample defaultEx = new DefaultAccessExample(5);
            Console.WriteLine("\nDefault Access Modifier:");
            defaultEx.DisplayDefault();
            
            Console.WriteLine("\nPress any key to exit...");
            Console.ReadKey();
        }
    }
}