using System;

namespace CSharpMethods
{
    class Methods
    {
        // Static method
        static void StaticMethod()
        {
            Console.WriteLine("This is a static method.");
        }
        
        // Instance method
        void InstanceMethod()
        {
            Console.WriteLine("This is an instance method.");
        }
        
        // Calculator method to calculate sum and product
        static void Calculator(int a, int b)
        {
            int sum = a + b;
            int product = a * b;
            Console.WriteLine($"sum = {sum} and product = {product}");
        }
        
        // Method using parameter arrays
        static void PrintNumbers(params int[] numbers)
        {
            foreach(int num in numbers)
            {
                Console.Write($"{num} ");
            }
            Console.WriteLine();
        }
        
        // Method to print even numbers
        static void PrintEvenNumbers(int count)
        {
            for(int i = 1; i <= count; i++)
            {
                Console.Write($"{i * 2} ");
            }
            Console.WriteLine();
        }
        
        static void Main(string[] args)
        {
            Console.WriteLine("=== C# Methods Assignments ===\n");
            
            // 1. Write a program using WriteLine(Boolean) method in c#
            bool booleanValue = true;
            Console.WriteLine($"Boolean value: {booleanValue}");
            
            // 2. Write a program on static and instance methods in c#
            StaticMethod(); // Calling static method
            
            Methods obj = new Methods(); // Creating instance
            obj.InstanceMethod(); // Calling instance method
            
            // 3. Write a method of Calculator and print sum and product in c#
            Console.Write("Enter first number: ");
            int a = int.Parse(Console.ReadLine());
            Console.Write("Enter second number: ");
            int b = int.Parse(Console.ReadLine());
            Calculator(a, b);
            
            // 4. Write a program using parameter arrays and print output in console in c#
            Console.WriteLine("Using parameter arrays:");
            PrintNumbers(1, 2, 3, 4, 5);
            
            // 5. Write a program to print entered number of even numbers in c#
            Console.Write("\nEnter number of even numbers to print: ");
            int evenCount = int.Parse(Console.ReadLine());
            Console.Write("Even numbers: ");
            PrintEvenNumbers(evenCount);
            
            Console.WriteLine("\nPress any key to exit...");
            Console.ReadKey();
        }
    }
}