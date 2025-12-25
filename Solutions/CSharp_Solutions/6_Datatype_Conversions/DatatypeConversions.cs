using System;

namespace CSharpDatatypeConversions
{
    class DatatypeConversions
    {
        static void Main(string[] args)
        {
            Console.WriteLine("=== C# Datatype Conversions Assignments ===\n");
            
            // 1. Write a program to Implicit Type Conversion
            Console.WriteLine("Implicit Type Conversion:");
            int intValue = 53;
            long longValue = intValue; // Implicit conversion from int to long
            Console.WriteLine($"Int value - {intValue}");
            Console.WriteLine($"Long value - {longValue}");
            
            // 2. Write an example of explicit type conversion
            Console.WriteLine("\nExplicit Type Conversion:");
            double doubleValue = 34.7;
            int i = (int)doubleValue; // Explicit conversion
            Console.WriteLine($"Value of I is {i}");
            
            // 3. Write a program of built in type conversion methods
            Console.WriteLine("\nBuilt in Type Conversion Methods:");
            string stringName = "34.6";
            float floatConverted = float.Parse(stringName); // String to float
            int intVal = 337;
            double doubleConverted = intVal; // Int to double
            Console.WriteLine($"string to float - {floatConverted}");
            Console.WriteLine($"int to double - {doubleConverted}");
            
            // 4. Write a program that converts various value types to string type
            Console.WriteLine("\nConverting various value types to string type:");
            int intVal2 = 75;
            float floatVal = 43.09f;
            string intToString = intVal2.ToString();
            string floatToString = floatVal.ToString();
            Console.WriteLine($"int.ToString() - {intToString}");
            Console.WriteLine($"float.ToString() - {floatToString}");
            
            Console.WriteLine("\nPress any key to exit...");
            Console.ReadKey();
        }
    }
}