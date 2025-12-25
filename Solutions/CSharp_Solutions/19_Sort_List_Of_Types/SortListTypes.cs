using System;
using System.Collections.Generic;
using System.Linq;

namespace CSharpSortListTypes
{
    // Employee class with properties EmpId, EmpName, EmpSalary and DeptId
    class Employee
    {
        public int EmpId { get; set; }
        public string EmpName { get; set; }
        public double EmpSalary { get; set; }
        public int DeptId { get; set; }
        
        public Employee(int empId, string empName, double empSalary, int deptId)
        {
            EmpId = empId;
            EmpName = empName;
            EmpSalary = empSalary;
            DeptId = deptId;
        }
        
        public override string ToString()
        {
            return $"EmpId: {EmpId}, EmpName: {EmpName}, EmpSalary: {EmpSalary}, DeptId: {DeptId}";
        }
    }
    
    class SortListTypes
    {
        static void Main(string[] args)
        {
            Console.WriteLine("=== C# Sort a List Of Types Assignments ===\n");
            
            // Create a list of employee objects and add 10 employee objects
            List<Employee> employeeList = new List<Employee>();
            
            // Adding 10 employees with at least two objects having same property values
            employeeList.Add(new Employee(1, "John", 5000, 1));
            employeeList.Add(new Employee(2, "Jane", 6000, 2));
            employeeList.Add(new Employee(3, "Kishore", 7000, 3)); // Kishore with salary 7000, dept 3
            employeeList.Add(new Employee(4, "Bob", 4000, 4));
            employeeList.Add(new Employee(5, "Alice", 8000, 2)); // Same dept as Jane
            employeeList.Add(new Employee(6, "Kishore", 3000, 5)); // Same name as #3, different salary/dept
            employeeList.Add(new Employee(7, "Tom", 1000, 2)); // Same dept as Jane and Alice
            employeeList.Add(new Employee(8, "Sara", 1000, 6)); // Same salary as Tom
            employeeList.Add(new Employee(9, "Kishore", 1000, 2)); // Same name as #3 & #6, same salary as Tom & Sara, same dept as Jane & Alice
            employeeList.Add(new Employee(10, "Mike", 1000, 7)); // Same salary as Tom, Sara
            
            Console.WriteLine("Original Employee List:");
            foreach (Employee emp in employeeList)
            {
                Console.WriteLine($"  {emp}");
            }
            Console.WriteLine();
            
            // 1. Check whether 'Kishore' employee is present in the list using select method with lambda expression
            Console.WriteLine("1. Employees with name 'Kishore':");
            var kishoreEmployees = employeeList.Where(emp => emp.EmpName == "Kishore").ToList();
            foreach (Employee emp in kishoreEmployees)
            {
                Console.WriteLine($"  {emp}");
            }
            
            // 2. Check whether empid = 4 employee is present in the list using select method with lambda expression
            Console.WriteLine("\n2. Employee with EmpId = 4:");
            var empId4 = employeeList.Where(emp => emp.EmpId == 4).ToList();
            foreach (Employee emp in empId4)
            {
                Console.WriteLine($"  {emp}");
            }
            
            // 3. Check whether deptid = 2 employee is present in the list using select method with lambda expression
            Console.WriteLine("\n3. Employees with DeptId = 2:");
            var deptId2 = employeeList.Where(emp => emp.DeptId == 2).ToList();
            foreach (Employee emp in deptId2)
            {
                Console.WriteLine($"  {emp}");
            }
            
            // 4. Create another employee list and copy the above list to this newly created employee list
            List<Employee> copiedList = new List<Employee>(employeeList);
            Console.WriteLine($"\n4. Copied list has {copiedList.Count} employees");
            
            // 5. Create another employee list and copy the above list with empname having Kishore
            List<Employee> kishoreList = employeeList.Where(emp => emp.EmpName == "Kishore").ToList();
            Console.WriteLine($"\n5. List with employees named 'Kishore' has {kishoreList.Count} employees:");
            foreach (Employee emp in kishoreList)
            {
                Console.WriteLine($"  {emp}");
            }
            
            // 6. Create another employee list and copy the above list with empsalary greater than 2000
            List<Employee> highSalaryList = employeeList.Where(emp => emp.EmpSalary > 2000).ToList();
            Console.WriteLine($"\n6. List with employees having salary > 2000 has {highSalaryList.Count} employees:");
            foreach (Employee emp in highSalaryList)
            {
                Console.WriteLine($"  {emp}");
            }
            
            // 7. Check whether deptid=4 employee is present in the list using select method with lambda expression
            Console.WriteLine("\n7. Employees with DeptId = 4:");
            var deptId4 = employeeList.Where(emp => emp.DeptId == 4).ToList();
            foreach (Employee emp in deptId4)
            {
                Console.WriteLine($"  {emp}");
            }
            
            // 8. Check whether deptid =4 employee is present in the list using contains method with lambda expression
            Console.WriteLine($"\n8. Contains employee with DeptId = 4: {employeeList.Any(emp => emp.DeptId == 4)}");
            
            // 9. Print the distinct employee name count in the list using Distinct method with lambda expression
            var distinctNames = employeeList.Select(emp => emp.EmpName).Distinct().ToList();
            Console.WriteLine($"\n9. Distinct employee names count: {distinctNames.Count}");
            Console.WriteLine("Distinct employee names:");
            foreach (string name in distinctNames)
            {
                Console.WriteLine($"  {name}");
            }
            
            // 10. Create an integer array with 5 elements and convert this integer array into integer list using ToList()
            int[] intArray = { 10, 20, 30, 40, 50 };
            List<int> intList = intArray.ToList();
            Console.WriteLine($"\n10. Integer array converted to list: [{string.Join(", ", intList)}]");
            
            // 11. Get the first employee in the employee list using First() method
            Employee firstEmployee = employeeList.First();
            Console.WriteLine($"\n11. First employee using First(): {firstEmployee}");
            
            // 12. Get the first employee in the employee list using FirstOrDefault() method
            Employee firstOrDefaultEmployee = employeeList.FirstOrDefault();
            Console.WriteLine($"\n12. First employee using FirstOrDefault(): {firstOrDefaultEmployee}");
            
            // 13. Get the first employee in the employee list using Single() method
            // Note: Single() would throw an exception since we have multiple employees
            // So we'll demonstrate with a list that has only one element
            var singleEmployeeList = employeeList.Where(emp => emp.EmpId == 1).ToList();
            Employee singleEmployee = singleEmployeeList.Single();
            Console.WriteLine($"\n13. Single employee using Single(): {singleEmployee}");
            
            // 14. Get the first employee in the employee list using SingleOrDefault() method
            Employee singleOrDefaultEmployee = singleEmployeeList.SingleOrDefault();
            Console.WriteLine($"\n14. Single employee using SingleOrDefault(): {singleOrDefaultEmployee}");
            
            // 15. Sort the employee list by EmpID using OrderBy() method
            var sortedByEmpId = employeeList.OrderBy(emp => emp.EmpId).ToList();
            Console.WriteLine("\n15. Employees sorted by EmpId:");
            foreach (Employee emp in sortedByEmpId)
            {
                Console.WriteLine($"  {emp}");
            }
            
            // 16. Sort the employee list by EmpName using OrderBy() method
            var sortedByEmpName = employeeList.OrderBy(emp => emp.EmpName).ToList();
            Console.WriteLine("\n16. Employees sorted by EmpName:");
            foreach (Employee emp in sortedByEmpName)
            {
                Console.WriteLine($"  {emp}");
            }
            
            // 17. Sort the employee list by EmpName and then reverse by empid using Sort() method
            var nameThenReverseIdList = new List<Employee>(employeeList);
            nameThenReverseIdList.Sort((x, y) => 
            {
                int nameComparison = x.EmpName.CompareTo(y.EmpName);
                if (nameComparison != 0)
                    return nameComparison;
                return y.EmpId.CompareTo(x.EmpId); // Reverse order for EmpId
            });
            
            Console.WriteLine("\n17. Employees sorted by EmpName then reverse by EmpId:");
            foreach (Employee emp in nameThenReverseIdList)
            {
                Console.WriteLine($"  {emp}");
            }
            
            Console.WriteLine("\nPress any key to exit...");
            Console.ReadKey();
        }
    }
}