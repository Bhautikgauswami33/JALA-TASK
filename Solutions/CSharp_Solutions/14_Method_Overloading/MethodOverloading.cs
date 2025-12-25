using System;

namespace CSharpMethodOverloading
{
    class Calculator
    {
        // 1. Overloading by changing the Number of parameters
        public int Sum(int a, int b)
        {
            return a + b;
        }
        
        public int Sum(int a, int b, int c)
        {
            return a + b + c;
        }
        
        // 3. Function Sum() that accepts values as a parameter and print their addition
        public void Sum(params int[] numbers)
        {
            int result = 0;
            foreach(int num in numbers)
            {
                result += num;
            }
            Console.WriteLine($"Sum of provided numbers: {result}");
        }
        
        // 4. Function Division() that accepts multiple values as a parameter and print their divisor
        public void Division(int dividend, int divisor)
        {
            if (divisor != 0)
            {
                int result = dividend / divisor;
                Console.WriteLine($"Division of {dividend} by {divisor} = {result}");
            }
            else
            {
                Console.WriteLine("Cannot divide by zero!");
            }
        }
        
        // Overloaded Division method
        public void Division(double dividend, double divisor)
        {
            if (divisor != 0)
            {
                double result = dividend / divisor;
                Console.WriteLine($"Division of {dividend} by {divisor} = {result}");
            }
            else
            {
                Console.WriteLine("Cannot divide by zero!");
            }
        }
    }
    
    class MathOperations
    {
        // 2. Changing the order of parameters using method overloading
        public void Display(string name, int age)
        {
            Console.WriteLine($"Name: {name}, Age: {age}");
        }
        
        public void Display(int age, string name)
        {
            Console.WriteLine($"Age: {age}, Name: {name}");
        }
    }
    
    class MethodOverloading
    {
        static void Main(string[] args)
        {
            Console.WriteLine("=== C# Method Overloading Assignments ===\n");
            
            Calculator calc = new Calculator();
            
            // 1. Overloading by changing the Number of parameters
            Console.WriteLine($"Sum(5, 3) = {calc.Sum(5, 3)}");
            Console.WriteLine($"Sum(5, 3, 2) = {calc.Sum(5, 3, 2)}");
            
            // 3. Function Sum() that accepts values as a parameter and print their addition
            calc.Sum(1, 2, 3, 4, 5);
            calc.Sum(10, 20, 30);
            
            // 4. Function Division() that accepts multiple values as a parameter and print their divisor
            calc.Division(10, 2);
            calc.Division(15.5, 3.0);
            
            // 2. Changing the order of parameters using method overloading
            MathOperations mathOps = new MathOperations();
            mathOps.Display("John", 25);
            mathOps.Display(30, "Jane");
            
            Console.WriteLine("\nPress any key to exit...");
            Console.ReadKey();
        }
    }
}