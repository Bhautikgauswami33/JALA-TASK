using System;

namespace CSharpConsoleOperations
{
    class ConsoleOperations
    {
        static void Main(string[] args)
        {
            Console.WriteLine("=== C# Reading and Writing Console Assignments ===\n");
            
            // 1. Create any value called EmpName and print that value in the output
            string EmpName = "John";
            Console.WriteLine($"EmpName: {EmpName}");
            
            // 2. Declare a variable name of any datatype and read the name in the output
            Console.Write("Enter your name: ");
            string name = Console.ReadLine();
            Console.WriteLine($"You entered: {name}");
            
            // 3. Enter your name and from WriteLine function and print the output
            Console.Write("Enter your name again: ");
            string inputName = Console.ReadLine();
            Console.WriteLine($"Hello {inputName}!");
            
            // 4. Declare 2 strings as input and concatenate with another string with both strings
            Console.Write("Enter first name: ");
            string firstName = Console.ReadLine();
            Console.Write("Enter last name: ");
            string lastName = Console.ReadLine();
            string result = "Hello " + firstName + " " + lastName;
            Console.WriteLine(result);
            
            // 5. Write a program by taking two integer values and return the value by adding in the Output
            Console.Write("Enter first integer: ");
            int firstInt = int.Parse(Console.ReadLine());
            Console.Write("Enter second integer: ");
            int secondInt = int.Parse(Console.ReadLine());
            int sum = firstInt + secondInt;
            Console.WriteLine($"Sum of {firstInt} and {secondInt} is: {sum}");
            
            // 6. Write a program to enter password by converting it to char array into string print the Output
            Console.Write("Enter password: ");
            string password = Console.ReadLine();
            char[] passwordArray = password.ToCharArray();
            string convertedPassword = new string(passwordArray);
            Console.WriteLine($"Password: {convertedPassword}");
            
            Console.WriteLine("\nPress any key to exit...");
            Console.ReadKey();
        }
    }
}