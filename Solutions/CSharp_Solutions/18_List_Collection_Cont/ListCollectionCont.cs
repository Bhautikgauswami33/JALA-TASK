using System;
using System.Data;
using System.Collections;

namespace CSharpListCollectionCont
{
    class ListCollectionCont
    {
        static void Main(string[] args)
        {
            Console.WriteLine("=== C# List Collection Continued Assignments ===\n");
            
            // 1. Create a datatable object
            DataTable dataTable1 = new DataTable();
            Console.WriteLine("1. Created a DataTable object");
            
            // 2. Create a datatable object with a name by using constructor
            DataTable dataTable2 = new DataTable("EmployeeTable");
            Console.WriteLine($"2. Created a DataTable object with name: {dataTable2.TableName}");
            
            // 3. Write any 10 properties of DataTable
            Console.WriteLine("\n3. Ten Properties of DataTable:");
            Console.WriteLine("- TableName: Gets or sets the name of the DataTable");
            Console.WriteLine("- DataSet: Gets the DataSet to which this table belongs");
            Console.WriteLine("- Columns: Gets the collection of columns that belong to this table");
            Console.WriteLine("- Rows: Gets the collection of rows that belong to this table");
            Console.WriteLine("- Constraints: Gets the collection of constraint objects");
            Console.WriteLine("- PrimaryKey: Gets or sets an array of columns that function as primary keys");
            Console.WriteLine("- HasErrors: Gets a value indicating whether there are errors in any of the rows");
            Console.WriteLine("- DefaultView: Gets a customized view of the table");
            Console.WriteLine("- MinimumCapacity: Gets or sets the initial starting size of the DataTable");
            Console.WriteLine("- RemotingFormat: Gets or sets the serialization format");
            
            // 4. Write any 10 methods of DataTable
            Console.WriteLine("\n4. Ten Methods of DataTable:");
            Console.WriteLine("- NewRow(): Creates a new DataRow with the same schema as the table");
            Console.WriteLine("- AcceptChanges(): Commits all the changes made to the table");
            Console.WriteLine("- Clear(): Clears the DataTable of all data");
            Console.WriteLine("- Clone(): Creates an empty clone of the table");
            Console.WriteLine("- Copy(): Creates a copy of the DataTable");
            Console.WriteLine("- GetChanges(): Gets a copy of the DataTable containing all changes");
            Console.WriteLine("- ImportRow(): Imports the DataRow into the current DataTable");
            Console.WriteLine("- Merge(): Merges the specified DataTable with the current one");
            Console.WriteLine("- RejectChanges(): Rolls back all changes that have been made");
            Console.WriteLine("- Select(): Gets an array of all DataRow objects matching the filter");
            
            // 5. Add 4 columns to this data table object using columns.add() method
            dataTable2.Columns.Add("EmpId", typeof(int));
            dataTable2.Columns.Add("EmpName", typeof(string));
            dataTable2.Columns.Add("EmpSalary", typeof(double));
            dataTable2.Columns.Add("Department", typeof(string));
            Console.WriteLine("\n5. Added 4 columns to DataTable: EmpId, EmpName, EmpSalary, Department");
            
            // 6. Add 5 records to this datatable object using Rows.Add() method
            dataTable2.Rows.Add(1, "John", 50000.0, "IT");
            dataTable2.Rows.Add(2, "Jane", 55000.0, "HR");
            dataTable2.Rows.Add(3, "Kishore", 60000.0, "Finance");
            dataTable2.Rows.Add(4, "Bob", 45000.0, "IT");
            dataTable2.Rows.Add(5, "Alice", 65000.0, "Marketing");
            Console.WriteLine("6. Added 5 records to DataTable");
            
            // 7. Print the EmpId column of this datatable using for loop
            Console.WriteLine("\n7. EmpId column using for loop:");
            for (int i = 0; i < dataTable2.Rows.Count; i++)
            {
                Console.WriteLine($"  {dataTable2.Rows[i]["EmpId"]}");
            }
            
            // 8. Print the EmpId column of this datatable using foreach loop
            Console.WriteLine("\n8. EmpId column using foreach loop:");
            foreach (DataRow row in dataTable2.Rows)
            {
                Console.WriteLine($"  {row["EmpId"]}");
            }
            
            // 9. Print the EmpId column of this datatable using DataRow property
            Console.WriteLine("\n9. EmpId column using DataRow property:");
            for (int i = 0; i < dataTable2.Rows.Count; i++)
            {
                DataRow row = dataTable2.Rows[i];
                Console.WriteLine($"  {row["EmpId"]}");
            }
            
            // 10. Create another datatable with 5 columns and 4 records
            DataTable dataTable3 = new DataTable("DepartmentTable");
            dataTable3.Columns.Add("DeptId", typeof(int));
            dataTable3.Columns.Add("DeptName", typeof(string));
            dataTable3.Columns.Add("Location", typeof(string));
            dataTable3.Columns.Add("HeadCount", typeof(int));
            dataTable3.Columns.Add("Budget", typeof(double));
            
            dataTable3.Rows.Add(1, "IT", "Building A", 25, 500000.0);
            dataTable3.Rows.Add(2, "HR", "Building B", 10, 200000.0);
            dataTable3.Rows.Add(3, "Finance", "Building C", 15, 300000.0);
            dataTable3.Rows.Add(4, "Marketing", "Building D", 12, 250000.0);
            
            Console.WriteLine("\n10. Created another DataTable with 5 columns and 4 records");
            Console.WriteLine("   Columns: DeptId, DeptName, Location, HeadCount, Budget");
            
            // 11. Create a DataSet object
            DataSet dataSet1 = new DataSet();
            Console.WriteLine("\n11. Created a DataSet object");
            
            // 12. Create a DataSet object with name 'MyDataSet' using its constructor
            DataSet myDataSet = new DataSet("MyDataSet");
            Console.WriteLine($"12. Created a DataSet object with name: {myDataSet.DataSetName}");
            
            // 13. Add above two datatables to MyDataSet using Tables.Add() method
            myDataSet.Tables.Add(dataTable2);
            myDataSet.Tables.Add(dataTable3);
            Console.WriteLine($"13. Added {myDataSet.Tables.Count} DataTables to MyDataSet");
            
            // 14. Write any 3 Properties of ArrayList
            Console.WriteLine("\n14. Three Properties of ArrayList:");
            Console.WriteLine("- Count: Gets the number of elements in the ArrayList");
            Console.WriteLine("- Capacity: Gets or sets the number of elements that the ArrayList can contain");
            Console.WriteLine("- IsFixedSize: Gets a value indicating whether the ArrayList has a fixed size");
            
            // 15. Write any 3 methods of ArrayList
            Console.WriteLine("\n15. Three Methods of ArrayList:");
            Console.WriteLine("- Add(): Adds an object to the end of the ArrayList");
            Console.WriteLine("- Remove(): Removes the first occurrence of a specific object");
            Console.WriteLine("- Clear(): Removes all elements from the ArrayList");
            
            // 16. Difference between Array and ArrayList
            Console.WriteLine("\n16. Difference between Array and ArrayList:");
            Console.WriteLine("- Array: Fixed size, defined at creation time");
            Console.WriteLine("- ArrayList: Dynamic size, can grow or shrink as needed");
            Console.WriteLine("- Array: Type-safe, all elements must be of the same type");
            Console.WriteLine("- ArrayList: Not type-safe, can store any type of object");
            
            // 17. Create an ArrayList and add 3 string elements
            ArrayList arrayList = new ArrayList();
            arrayList.Add("One");
            arrayList.Add("Two");
            arrayList.Add("Three");
            Console.WriteLine("\n17. Created ArrayList with elements: One, Two, Three");
            
            // 18. Print the above arraylist element using for and foreach loop
            Console.WriteLine("\n18. ArrayList elements using for loop:");
            for (int i = 0; i < arrayList.Count; i++)
            {
                Console.WriteLine($"  {arrayList[i]}");
            }
            
            Console.WriteLine("\n   ArrayList elements using foreach loop:");
            foreach (object item in arrayList)
            {
                Console.WriteLine($"  {item}");
            }
            
            // 19. Remove all the elements in the ArrayList using Clear method
            Console.WriteLine($"\nBefore clear: {arrayList.Count} elements");
            arrayList.Clear();
            Console.WriteLine($"19. After clear: {arrayList.Count} elements");
            
            // 20. Reverse all the elements in the ArrayList using Reverse method
            ArrayList reverseList = new ArrayList();
            reverseList.Add("First");
            reverseList.Add("Second");
            reverseList.Add("Third");
            Console.WriteLine($"\nBefore reverse: {reverseList[0]}, {reverseList[1]}, {reverseList[2]}");
            reverseList.Reverse();
            Console.WriteLine($"20. After reverse: {reverseList[0]}, {reverseList[1]}, {reverseList[2]}");
            
            // 21. Sort all the elements in the ArrayList using Sort method
            ArrayList sortList = new ArrayList();
            sortList.Add("Zebra");
            sortList.Add("Apple");
            sortList.Add("Mango");
            Console.WriteLine($"\nBefore sort: {sortList[0]}, {sortList[1]}, {sortList[2]}");
            sortList.Sort();
            Console.WriteLine($"21. After sort: {sortList[0]}, {sortList[1]}, {sortList[2]}");
            
            Console.WriteLine("\nPress any key to exit...");
            Console.ReadKey();
        }
    }
}