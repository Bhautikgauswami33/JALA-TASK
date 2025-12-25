using System;

namespace CSharpDataTypes
{
    class DataTypes
    {
        static void Main(string[] args)
        {
            Console.WriteLine("=== C# Built In Data Types Assignments ===\n");
            
            // 1. Declare a value as int datatype and print in the output
            int intValue = 42;
            Console.WriteLine($"Int value: {intValue}");
            
            // 2. Write a program in boolean type and print in console
            bool boolValue = true;
            Console.WriteLine($"Boolean value: {boolValue}");
            
            // 3. Write a program on converting Float to Decimal type and print in console
            float floatValue = 123.45f;
            decimal decimalValue = (decimal)floatValue;
            Console.WriteLine($"Float value: {floatValue}");
            Console.WriteLine($"Converted to Decimal: {decimalValue}");
            
            // 4. Write a C# Sharp program that takes two numbers as input and perform an operation (+, -,*,x,/) on them and displays the result
            Console.Write("Enter first number: ");
            double num1 = double.Parse(Console.ReadLine());
            Console.Write("Enter second number: ");
            double num2 = double.Parse(Console.ReadLine());
            
            Console.WriteLine($"{num1} + {num2} = {num1 + num2}");
            Console.WriteLine($"{num1} - {num2} = {num1 - num2}");
            Console.WriteLine($"{num1} * {num2} = {num1 * num2}");
            if (num2 != 0)
            {
                Console.WriteLine($"{num1} / {num2} = {num1 / num2}");
                Console.WriteLine($"{num1} % {num2} = {num1 % num2}");
            }
            else
            {
                Console.WriteLine($"{num1} / {num2} = Cannot divide by zero");
                Console.WriteLine($"{num1} % {num2} = Cannot divide by zero");
            }
            
            // 5. Write a C# Sharp program that takes three letters as input and display them in Reverse Order
            Console.Write("\nEnter first letter: ");
            char letter1 = Console.ReadKey().KeyChar;
            Console.WriteLine(); // New line after.ReadKey()
            Console.Write("Enter second letter: ");
            char letter2 = Console.ReadKey().KeyChar;
            Console.WriteLine();
            Console.Write("Enter third letter: ");
            char letter3 = Console.ReadKey().KeyChar;
            Console.WriteLine();
            
            Console.WriteLine($"Original: {letter1} {letter2} {letter3}");
            Console.WriteLine($"Reverse: {letter3} {letter2} {letter1}");
            
            // 6. Write a C# Sharp program that takes a character as input and check the input (lowercase) is a vowel, a digit, or any other symbol
            Console.Write("\nEnter a character: ");
            char inputChar = Console.ReadKey().KeyChar;
            Console.WriteLine();
            
            if (char.IsDigit(inputChar))
            {
                Console.WriteLine("It is a digit");
            }
            else if (char.IsLetter(inputChar))
            {
                if (char.IsLower(inputChar))
                {
                    char lowerChar = char.ToLower(inputChar);
                    if (lowerChar == 'a' || lowerChar == 'e' || lowerChar == 'i' || lowerChar == 'o' || lowerChar == 'u')
                    {
                        Console.WriteLine("It is a lowercase vowel");
                    }
                    else
                    {
                        Console.WriteLine("It is a lowercase consonant");
                    }
                }
                else
                {
                    Console.WriteLine("It is an uppercase letter");
                }
            }
            else
            {
                Console.WriteLine("It is a symbol");
            }
            
            Console.WriteLine("\nPress any key to exit...");
            Console.ReadKey();
        }
    }
}