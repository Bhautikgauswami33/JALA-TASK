using System;

namespace CSharpLoops
{
    class Loops
    {
        static void Main(string[] args)
        {
            Console.WriteLine("=== C# For & Foreach Loop Assignments ===\n");
            
            // 1. Write a program in C# Sharp to display n terms of natural number and their sum
            Console.Write("Enter number of natural terms you want: ");
            int n = int.Parse(Console.ReadLine());
            
            int sum = 0;
            Console.Write($"The first {n} natural number is: ");
            for (int i = 1; i <= n; i++)
            {
                Console.Write($"{i} ");
                sum += i;
            }
            Console.WriteLine($"\nThe Sum of Natural Number upto {n} terms: {sum}");
            
            // 2. Write a program in C# Sharp to display the n terms of odd natural number and their sum
            Console.Write("\nInput number of terms: ");
            int n2 = int.Parse(Console.ReadLine());
            
            int sumOdd = 0;
            int count = 0;
            int currentNumber = 1;
            
            Console.Write("The odd numbers are: ");
            while (count < n2)
            {
                if (currentNumber % 2 != 0)
                {
                    Console.Write($"{currentNumber} ");
                    sumOdd += currentNumber;
                    count++;
                }
                currentNumber++;
            }
            Console.WriteLine($"\nThe Sum of odd Natural Number upto {n2} terms: {sumOdd}");
            
            // 3. By using Array write the program using For and Foreach loop in c#
            string[] array = {"JalaTechnologies"};
            
            Console.WriteLine("\nArray printing using for loop:");
            for (int i = 0; i < array.Length; i++)
            {
                Console.WriteLine(array[i]);
            }
            
            Console.WriteLine("\nArray printing using ForEach loop:");
            foreach (string item in array)
            {
                Console.WriteLine(item);
            }
            
            Console.WriteLine("\nPress any key to exit...");
            Console.ReadKey();
        }
    }
}