using System;
using System.Collections.Generic;
using System.Linq;

namespace CSharpListCollection
{
    // Student class for assignment 17-20
    class Student
    {
        public string Name { get; set; }
        public int Id { get; set; }
        
        public Student(string name, int id)
        {
            Name = name;
            Id = id;
        }
        
        public override string ToString()
        {
            return $"Student: {Name}, ID: {Id}";
        }
    }
    
    class ListCollection
    {
        static void Main(string[] args)
        {
            Console.WriteLine("=== C# List Collection Assignments ===\n");
            
            // 1. Write any 5 Properties of List
            Console.WriteLine("1. Five Properties of List:");
            Console.WriteLine("- Count: Gets the number of elements");
            Console.WriteLine("- Capacity: Gets or sets the total number of elements");
            Console.WriteLine("- Item[index]: Gets or sets the element at the specified index");
            Console.WriteLine("- IsReadOnly: Gets a value indicating whether the list is read-only");
            Console.WriteLine("- IsFixedSize: Gets a value indicating whether the list has a fixed size");
            
            // 2. Write any 5 methods of List
            Console.WriteLine("\n2. Five Methods of List:");
            Console.WriteLine("- Add(): Adds an object to the end of the list");
            Console.WriteLine("- Remove(): Removes the first occurrence of a specific object");
            Console.WriteLine("- Contains(): Determines whether an element is in the list");
            Console.WriteLine("- Clear(): Removes all elements from the list");
            Console.WriteLine("- IndexOf(): Searches for the specified object and returns the index");
            
            // 3. Create an integer list and add any 5 integers to this list
            List<int> intList = new List<int>();
            intList.Add(10);
            intList.Add(20);
            intList.Add(30);
            intList.Add(40);
            intList.Add(50);
            
            // 4. Print the integer elements in the above list using for loop
            Console.WriteLine("\n3 & 4. Integer list elements using for loop:");
            for (int i = 0; i < intList.Count; i++)
            {
                Console.Write($"{intList[i]} ");
            }
            Console.WriteLine();
            
            // 5. Print the integer elements in the above list using foreach loop
            Console.WriteLine("\n5. Integer list elements using foreach loop:");
            foreach (int num in intList)
            {
                Console.Write($"{num} ");
            }
            Console.WriteLine();
            
            // 6. Create a string list and add any 5 strings to this list
            List<string> stringList = new List<string>();
            stringList.Add("John");
            stringList.Add("Jane");
            stringList.Add("Kishore");
            stringList.Add("Bob");
            stringList.Add("Alice");
            
            // 7. Print the string elements in the above list using for loop
            Console.WriteLine("\n6 & 7. String list elements using for loop:");
            for (int i = 0; i < stringList.Count; i++)
            {
                Console.Write($"{stringList[i]} ");
            }
            Console.WriteLine();
            
            // 8. Print the string elements in the above list using foreach loop
            Console.WriteLine("\n8. String list elements using foreach loop:");
            foreach (string str in stringList)
            {
                Console.Write($"{str} ");
            }
            Console.WriteLine();
            
            // 9. Count the elements in the list and print on the console
            Console.WriteLine($"\n9. Count of elements in string list: {stringList.Count}");
            
            // 10. Clear all the elements in the list using clear method
            List<string> tempStringList = new List<string>(stringList); // Copy for demonstration
            Console.WriteLine($"\nBefore clear: {tempStringList.Count} elements");
            tempStringList.Clear();
            Console.WriteLine($"10. After clear: {tempStringList.Count} elements");
            
            // 11. Check whether 'Kishore' is present in the string list using exists method
            bool exists = stringList.Exists(x => x == "Kishore");
            Console.WriteLine($"\n11. 'Kishore' exists in list: {exists}");
            
            // 12. Check whether 'Kishore' is present in the string list using Find method
            string found = stringList.Find(x => x == "Kishore");
            Console.WriteLine($"12. Find 'Kishore': {(found != null ? found : "Not found")}");
            
            // 13. Check whether 'Kishore' is present in the string list using contains method
            bool contains = stringList.Contains("Kishore");
            Console.WriteLine($"13. Contains 'Kishore': {contains}");
            
            // 14. Insert an element into the list using Insert method
            List<string> insertList = new List<string>(stringList);
            insertList.Insert(1, "InsertedName");
            Console.WriteLine($"\n14. After inserting 'InsertedName' at index 1: {string.Join(", ", insertList)}");
            
            // 15. Reverse the list using reverse method
            List<string> reverseList = new List<string>(stringList);
            reverseList.Reverse();
            Console.WriteLine($"15. Reversed list: {string.Join(", ", reverseList)}");
            
            // 16. Remove an element at index 3 using RemoveAt method
            List<string> removeList = new List<string>(stringList);
            removeList.RemoveAt(3);
            Console.WriteLine($"16. After removing element at index 3: {string.Join(", ", removeList)}");
            
            // 17-20. Create a list with student class and add student objects
            List<Student> studentList = new List<Student>();
            
            // 18. Add 10 Student objects to the list
            studentList.Add(new Student("John", 1));
            studentList.Add(new Student("Jane", 2));
            studentList.Add(new Student("Kishore", 3));
            studentList.Add(new Student("Bob", 4));
            studentList.Add(new Student("Alice", 5));
            studentList.Add(new Student("Kishore", 6)); // Same name as #3
            studentList.Add(new Student("Tom", 7));
            studentList.Add(new Student("Sara", 8));
            studentList.Add(new Student("Mike", 9));
            studentList.Add(new Student("Kishore", 10)); // Same name as #3 and #6
            
            Console.WriteLine($"\n17-19. Student list count: {studentList.Count}");
            Console.WriteLine("Students in the list:");
            foreach (Student student in studentList)
            {
                Console.WriteLine($"  {student}");
            }
            
            // 20. Clear all the elements in the student list using clear method
            studentList.Clear();
            Console.WriteLine($"\n20. After clearing student list: {studentList.Count} students");
            
            Console.WriteLine("\nPress any key to exit...");
            Console.ReadKey();
        }
    }
}