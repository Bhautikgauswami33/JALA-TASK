using System;

namespace CSharpClassIntroduction
{
    // Employee class for assignment 1
    class Employee
    {
        public string name;
        public int id;
        public string department;
        
        // Constructor
        public Employee(string name, int id, string department)
        {
            this.name = name;
            this.id = id;
            this.department = department;
        }
        
        // Method to display employee details
        public void DisplayDetails()
        {
            Console.WriteLine($"Employee Name: {name}, ID: {id}, Department: {department}");
        }
    }
    
    // Employee class with overloaded constructors for assignment 2
    class EmployeeOverloaded
    {
        public string name;
        public int id;
        public string department;
        
        // Default constructor
        public EmployeeOverloaded()
        {
            name = "Unknown";
            id = 0;
            department = "Unknown";
        }
        
        // Parameterized constructor
        public EmployeeOverloaded(string name, int id)
        {
            this.name = name;
            this.id = id;
            this.department = "General";
        }
        
        // Another parameterized constructor
        public EmployeeOverloaded(string name, int id, string department)
        {
            this.name = name;
            this.id = id;
            this.department = department;
        }
        
        public void DisplayDetails()
        {
            Console.WriteLine($"Employee Name: {name}, ID: {id}, Department: {department}");
        }
    }
    
    // Car class for assignments 3 and 4
    class Car
    {
        // Three class members
        public string color;
        public int maxSpeed;
        public string model;
        
        // Two fields
        private string manufacturer;
        private int year;
        
        // One method
        public void DisplayCarInfo()
        {
            Console.WriteLine($"Car: {manufacturer} {model}, Color: {color}, Max Speed: {maxSpeed} km/h, Year: {year}");
        }
        
        // Constructor
        public Car(string color, int maxSpeed, string model, string manufacturer, int year)
        {
            this.color = color;
            this.maxSpeed = maxSpeed;
            this.model = model;
            this.manufacturer = manufacturer;
            this.year = year;
        }
    }
    
    class ClassIntroduction
    {
        static void Main(string[] args)
        {
            Console.WriteLine("=== C# Class - Introduction Assignments ===\n");
            
            // 1. Construct a class using any methods for employee details using its parameters and print Output
            Employee emp1 = new Employee("John Doe", 101, "IT");
            emp1.DisplayDetails();
            
            // 2. Write a program using overloading class constructor
            EmployeeOverloaded emp2 = new EmployeeOverloaded();
            EmployeeOverloaded emp3 = new EmployeeOverloaded("Jane Smith", 102);
            EmployeeOverloaded emp4 = new EmployeeOverloaded("Bob Johnson", 103, "HR");
            
            Console.WriteLine("\nOverloaded constructors:");
            emp2.DisplayDetails();
            emp3.DisplayDetails();
            emp4.DisplayDetails();
            
            // 3 & 4. Create a Car class with members and create an object called myObj
            Car myObj = new Car("Red", 200, "Sedan", "Toyota", 2022);
            Console.WriteLine($"\nCar color: {myObj.color}");
            Console.WriteLine($"Car maxSpeed: {myObj.maxSpeed}");
            myObj.DisplayCarInfo();
            
            // 5. Write a program on creating multiple objects of one class
            Console.WriteLine("\nCreating multiple Car objects:");
            Car car1 = new Car("Blue", 180, "Hatchback", "Honda", 2021);
            Car car2 = new Car("Black", 250, "SUV", "BMW", 2023);
            Car car3 = new Car("White", 150, "Sedan", "Hyundai", 2020);
            
            car1.DisplayCarInfo();
            car2.DisplayCarInfo();
            car3.DisplayCarInfo();
            
            Console.WriteLine("\nPress any key to exit...");
            Console.ReadKey();
        }
    }
}