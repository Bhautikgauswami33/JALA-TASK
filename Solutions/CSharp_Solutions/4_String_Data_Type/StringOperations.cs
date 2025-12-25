using System;

namespace CSharpStringOperations
{
    class StringOperations
    {
        static void Main(string[] args)
        {
            Console.WriteLine("=== C# String Data Type Assignments ===\n");
            
            // 1. Write a Program to Reverse a String without using Reverse function
            Console.Write("Enter a String: ");
            string inputString = Console.ReadLine();
            string reversedString = ReverseString(inputString);
            Console.WriteLine($"Reverse String is: {reversedString}");
            
            // 2. Write a program in C# Sharp to find the length of a string without using library function
            string testString = "Jalatechnologies";
            int length = GetStringLength(testString);
            Console.WriteLine($"Input: {testString}");
            Console.WriteLine($"Output: {length}");
            
            // 3. Write a Program to calculate the length of the string using Length property
            string str = "INDIA";
            int strLength = str.Length;
            Console.WriteLine($"Given String: {str}");
            Console.WriteLine($"The Length of the First String is: {strLength}");
            
            // 4. Write a Program to Replace String in String using Replace function
            string originalSentence = "Sun Rises in the West";
            string modifiedSentence = originalSentence.Replace("West", "East");
            Console.WriteLine($"Sentence Before Replacing: {originalSentence}");
            Console.WriteLine($"Sentence After Replacing: {modifiedSentence}");
            
            // 5. Write a Program to Convert Upper case to Lower Case using ToLower method
            string upperCaseString = "JALA";
            string lowerCaseString = upperCaseString.ToLower();
            Console.WriteLine($"Enter the String in Uppercase: {upperCaseString}");
            Console.WriteLine($"String in Lowercase: {lowerCaseString}");
            
            // 6. Write a program in C# Sharp to find maximum occurring character in a string
            string text = "Welcome to india";
            char maxChar = FindMaxOccurringChar(text);
            Console.WriteLine($"Input string: {text}");
            Console.WriteLine($"The highest frequency character is: '{maxChar}'");
            
            // 7. Write a program in C# Sharp to sort a string array in ascending order
            string inputForSort = "this is a string";
            string sortedString = SortStringCharacters(inputForSort);
            Console.WriteLine($"Input string: {inputForSort}");
            Console.WriteLine($"After sorting the string appears like: {sortedString}");
            
            Console.WriteLine("\nPress any key to exit...");
            Console.ReadKey();
        }
        
        // Helper method to reverse a string
        static string ReverseString(string str)
        {
            char[] charArray = str.ToCharArray();
            Array.Reverse(charArray);
            return new string(charArray);
        }
        
        // Helper method to get string length without using Length property
        static int GetStringLength(string str)
        {
            int count = 0;
            foreach(char c in str)
            {
                count++;
            }
            return count;
        }
        
        // Helper method to find maximum occurring character
        static char FindMaxOccurringChar(string str)
        {
            int[] count = new int[256]; // ASCII characters
            int max = -1; 
            char result = ' ';
            
            for (int i = 0; i < str.Length; i++)
            {
                count[str[i]]++;
            }
            
            for (int i = 0; i < str.Length; i++)
            {
                if (max < count[str[i]])
                {
                    max = count[str[i]];
                    result = str[i];
                }
            }
            
            return result;
        }
        
        // Helper method to sort string characters in ascending order
        static string SortStringCharacters(string str)
        {
            char[] charArray = str.Replace(" ", "").ToCharArray(); // Remove spaces
            Array.Sort(charArray);
            string result = "";
            foreach(char c in charArray)
            {
                result += c + " ";
            }
            return result.Trim();
        }
    }
}