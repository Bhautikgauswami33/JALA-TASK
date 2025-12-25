using System;

namespace CSharpOperators
{
    class Operators
    {
        static void Main(string[] args)
        {
            Console.WriteLine("=== C# Operators Assignments ===\n");
            
            // 1. Write the program to demonstrate the working of Binary Arithmetic Operators
            Console.WriteLine("Binary Arithmetic Operators:");
            Console.Write("Enter first number (a): ");
            int a = int.Parse(Console.ReadLine());
            Console.Write("Enter second number (b): ");
            int b = int.Parse(Console.ReadLine());
            
            Console.WriteLine($"Addition Operator: {a + b}");
            Console.WriteLine($"Subtraction Operator: {a - b}");
            Console.WriteLine($"Multiplication Operator: {a * b}");
            if (b != 0)
            {
                Console.WriteLine($"Division Operator: {a / b}");
                Console.WriteLine($"Modulo Operator: {a % b}");
            }
            else
            {
                Console.WriteLine("Division Operator: Cannot divide by zero");
                Console.WriteLine("Modulo Operator: Cannot divide by zero");
            }
            
            // 2. Write the program to demonstrate the working of Unary Arithmetic Operators
            Console.WriteLine("\nUnary Arithmetic Operators:");
            int x = 10;
            int res;
            
            res = x++; // a++: first assign x to res, then increment x
            Console.WriteLine($"x is {x} and res is {res}");
            
            x = 10; // reset
            res = ++x; // ++a: first increment x, then assign to res
            Console.WriteLine($"x is {x} and res is {res}");
            
            x = 10; // reset
            res = x--; // a--: first assign x to res, then decrement x
            Console.WriteLine($"x is {x} and res is {res}");
            
            x = 10; // reset
            res = --x; // --a: first decrement x, then assign to res
            Console.WriteLine($"x is {x} and res is {res}");
            
            // 3. Write the program to demonstrate the working of Relational Operators
            Console.WriteLine("\nRelational Operators:");
            Console.Write("Enter first number (a): ");
            int a2 = int.Parse(Console.ReadLine());
            Console.Write("Enter second number (b): ");
            int b2 = int.Parse(Console.ReadLine());
            
            Console.WriteLine($"Equal to Operator: {a2 == b2}");
            Console.WriteLine($"Greater than Operator: {a2 > b2}");
            Console.WriteLine($"Less than Operator: {a2 < b2}");
            Console.WriteLine($"Greater than or Equal to: {a2 >= b2}");
            Console.WriteLine($"Lesser than or Equal to: {a2 <= b2}");
            Console.WriteLine($"Not Equal to Operator: {a2 != b2}");
            
            Console.WriteLine("\nPress any key to exit...");
            Console.ReadKey();
        }
    }
}