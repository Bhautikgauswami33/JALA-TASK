using System;

namespace CSharpProperties
{
    // Employee class with read-only property
    class Employee
    {
        private string _name;
        private int _id;
        
        public Employee(string name, int id)
        {
            _name = name;
            _id = id;
        }
        
        // Read-only property
        public string Name
        {
            get { return _name; }
        }
        
        // Read-write property
        public int Id
        {
            get { return _id; }
            set { _id = value; }
        }
    }
    
    // EmployeeModel class with 5 properties for assignments 3, 4, and 5
    class EmployeeModel
    {
        private int _empId;
        private string _empName;
        private string _emailId;
        private float _salary;
        private bool _isEmployeeActive;
        
        // Properties
        public int EmpId
        {
            get { return _empId; }
            set { _empId = value; }
        }
        
        public string EmpName
        {
            get { return _empName; }
            set { _empName = value; }
        }
        
        public string EmailId
        {
            get { return _emailId; }
            set { _emailId = value; }
        }
        
        public float Salary
        {
            get { return _salary; }
            set { _salary = value; }
        }
        
        public bool IsEmployeeActive
        {
            get { return _isEmployeeActive; }
            set { _isEmployeeActive = value; }
        }
    }
    
    class Properties
    {
        static void Main(string[] args)
        {
            Console.WriteLine("=== C# Properties Assignments ===\n");
            
            // 1. Write a program on illustrating the read-only property by taking as class Employee
            Employee emp = new Employee("John Doe", 101);
            Console.WriteLine($"Employee Name (read-only): {emp.Name}");
            Console.WriteLine($"Employee ID (read-write): {emp.Id}");
            emp.Id = 102; // This is allowed as Id is read-write
            Console.WriteLine($"Employee ID after change: {emp.Id}");
            
            // 2. Write a program on both read and write property using get and set accessories
            // This is demonstrated in the Employee class with both read-only and read-write properties
            
            // 3, 4, 5. Create objects for EmployeeModel and assign values to properties
            // Creating first object
            EmployeeModel emp1 = new EmployeeModel();
            emp1.EmpId = 101;
            emp1.EmpName = "Alice Johnson";
            emp1.EmailId = "alice@company.com";
            emp1.Salary = 50000.50f;
            emp1.IsEmployeeActive = true;
            
            Console.WriteLine("\nFirst Employee Details:");
            Console.WriteLine($"EmpId: {emp1.EmpId}");
            Console.WriteLine($"EmpName: {emp1.EmpName}");
            Console.WriteLine($"EmailId: {emp1.EmailId}");
            Console.WriteLine($"Salary: {emp1.Salary}");
            Console.WriteLine($"IsEmployeeActive: {emp1.IsEmployeeActive}");
            
            // Creating second object with different values
            EmployeeModel emp2 = new EmployeeModel();
            emp2.EmpId = 102;
            emp2.EmpName = "Bob Smith";
            emp2.EmailId = "bob@company.com";
            emp2.Salary = 55000.75f;
            emp2.IsEmployeeActive = false;
            
            Console.WriteLine("\nSecond Employee Details:");
            Console.WriteLine($"EmpId: {emp2.EmpId}");
            Console.WriteLine($"EmpName: {emp2.EmpName}");
            Console.WriteLine($"EmailId: {emp2.EmailId}");
            Console.WriteLine($"Salary: {emp2.Salary}");
            Console.WriteLine($"IsEmployeeActive: {emp2.IsEmployeeActive}");
            
            Console.WriteLine("\nPress any key to exit...");
            Console.ReadKey();
        }
    }
}