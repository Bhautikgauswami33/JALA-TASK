using System;

namespace CSharpBasics
{
    class Basics
    {
        static void Main(string[] args)
        {
            Console.WriteLine("=== C# Basics Assignments ===\n");
            
            // 1. Declare a variable of data type int with name empID
            int empID;
            
            // 2. Declare a variable of data type string with name empName
            string empName;
            
            // 3. Assign a value 5 for the empId variable and print the value of empId on console
            empID = 5;
            Console.WriteLine($"Value of empID: {empID}");
            
            // 4. Assign a value "Puja" for the empName variable and print the value of empName on console
            empName = "Puja";
            Console.WriteLine($"Value of empName: {empName}");
            
            // 5. Write a program to check whether it is odd or even
            Console.Write("\nEnter a number to check if it's odd or even: ");
            int number = int.Parse(Console.ReadLine());
            if (number % 2 == 0)
            {
                Console.WriteLine($"{number} is even");
            }
            else
            {
                Console.WriteLine($"{number} is odd");
            }
            
            // 6. Write a program to swap 2 numbers
            Console.Write("\nEnter first number: ");
            int num1 = int.Parse(Console.ReadLine());
            Console.Write("Enter second number: ");
            int num2 = int.Parse(Console.ReadLine());
            
            Console.WriteLine($"Before swapping: num1 = {num1}, num2 = {num2}");
            
            // Swapping without temporary variable
            num1 = num1 + num2;
            num2 = num1 - num2;
            num1 = num1 - num2;
            
            Console.WriteLine($"After swapping: num1 = {num1}, num2 = {num2}");
            
            Console.WriteLine("\nPress any key to exit...");
            Console.ReadKey();
        }
    }
}