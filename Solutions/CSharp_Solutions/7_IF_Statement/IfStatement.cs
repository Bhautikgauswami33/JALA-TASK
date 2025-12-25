using System;

namespace CSharpIfStatement
{
    class IfStatement
    {
        static void Main(string[] args)
        {
            Console.WriteLine("=== C# IF Statement Assignments ===\n");
            
            // 1. Write a C# Sharp program to check whether a given number is positive or negative
            Console.Write("Enter a number to check if it's positive or negative: ");
            int number = int.Parse(Console.ReadLine());
            
            if (number > 0)
            {
                Console.WriteLine($"{number} is a positive number");
            }
            else if (number < 0)
            {
                Console.WriteLine($"{number} is a negative number");
            }
            else
            {
                Console.WriteLine($"{number} is zero (neither positive nor negative)");
            }
            
            // 2. Write a C# Sharp program to find whether a given year is a leap year or not
            Console.Write("\nEnter a year to check if it's a leap year: ");
            int year = int.Parse(Console.ReadLine());
            
            bool isLeapYear = (year % 4 == 0 && year % 100 != 0) || (year % 400 == 0);
            
            if (isLeapYear)
            {
                Console.WriteLine($"{year} is leap year");
            }
            else
            {
                Console.WriteLine($"{year} is not a leap year");
            }
            
            // 3. Write a C# Sharp program to check whether an alphabet is a vowel or consonant
            Console.Write("\nEnter any alphabet: ");
            char alphabet = Console.ReadKey().KeyChar;
            Console.WriteLine(); // New line
            
            if (char.IsLetter(alphabet))
            {
                char lowerAlphabet = char.ToLower(alphabet);
                if (lowerAlphabet == 'a' || lowerAlphabet == 'e' || lowerAlphabet == 'i' || 
                    lowerAlphabet == 'o' || lowerAlphabet == 'u')
                {
                    Console.WriteLine("The alphabet is a vowel.");
                }
                else
                {
                    Console.WriteLine("The alphabet is a consonant.");
                }
            }
            else
            {
                Console.WriteLine("The input is not an alphabet.");
            }
            
            Console.WriteLine("\nPress any key to exit...");
            Console.ReadKey();
        }
    }
}