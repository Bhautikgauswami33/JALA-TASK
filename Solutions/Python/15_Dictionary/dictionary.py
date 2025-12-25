"""
Python Dictionary Implementation
This program demonstrates dictionary operations in Python
"""

def main():
    print("=== Python Dictionary Assignments ===\n")
    
    # 1. Creating and initializing dictionaries
    print("1. Creating and initializing dictionaries:")
    student = {
        "name": "John Doe",
        "age": 20,
        "grade": "A",
        "subjects": ["Math", "Science", "English"]
    }
    
    empty_dict = {}
    dict_constructor = dict(a=1, b=2, c=3)
    
    print(f"Student dictionary: {student}")
    print(f"Empty dictionary: {empty_dict}")
    print(f"Constructor dictionary: {dict_constructor}")
    print()
    
    # 2. Accessing dictionary values
    print("2. Accessing dictionary values:")
    print(f"Student name: {student['name']}")
    print(f"Student age: {student.get('age')}")
    print(f"Student phone (default): {student.get('phone', 'Not found')}")
    print()
    
    # 3. Adding and modifying dictionary items
    print("3. Adding and modifying dictionary items:")
    student["phone"] = "123-456-7890"  # Add new key-value pair
    student["age"] = 21  # Modify existing value
    print(f"After adding phone and updating age: {student}")
    print()
    
    # 4. Dictionary methods - keys, values, items
    print("4. Dictionary methods - keys, values, items:")
    print(f"Keys: {list(student.keys())}")
    print(f"Values: {list(student.values())}")
    print(f"Items: {list(student.items())}")
    print()
    
    # 5. Dictionary membership
    print("5. Dictionary membership:")
    print(f"'name' in student: {'name' in student}")
    print(f"'height' in student: {'height' in student}")
    print()
    
    # 6. Removing items from dictionary
    print("6. Removing items from dictionary:")
    removed_value = student.pop("grade")  # Remove and return value
    print(f"After popping 'grade' ({removed_value}): {student}")
    
    student["grade"] = "A"  # Add it back
    last_item = student.popitem()  # Remove and return last item
    print(f"After popping last item {last_item}: {student}")
    
    student.update({"grade": "A", "city": "New York"})  # Add multiple items
    print(f"After update: {student}")
    print()
    
    # 7. Nested dictionaries
    print("7. Nested dictionaries:")
    company = {
        "employee1": {
            "name": "Alice",
            "department": "IT",
            "salary": 50000
        },
        "employee2": {
            "name": "Bob",
            "department": "HR",
            "salary": 45000
        }
    }
    print("Company structure:")
    for emp_id, details in company.items():
        print(f"  {emp_id}: {details}")
    
    print(f"Bob's department: {company['employee2']['department']}")
    print()
    
    # 8. Dictionary comprehension
    print("8. Dictionary comprehension:")
    squares = {x: x**2 for x in range(1, 6)}
    print(f"Squares dictionary: {squares}")
    
    # Conditional dictionary comprehension
    even_squares = {x: x**2 for x in range(1, 11) if x % 2 == 0}
    print(f"Even squares: {even_squares}")
    print()
    
    # 9. Iterating through dictionaries
    print("9. Iterating through dictionaries:")
    print("Iterating through keys:")
    for key in student:
        print(f"  {key}: {student[key]}")
    
    print("Iterating through values:")
    for value in student.values():
        print(f"  {value}")
    
    print("Iterating through items:")
    for key, value in student.items():
        print(f"  {key} = {value}")
    print()
    
    # 10. Dictionary methods and operations
    print("10. Dictionary methods and operations:")
    
    # Copying dictionaries
    student_copy = student.copy()
    print(f"Copy of student: {student_copy}")
    
    # Creating dictionary with default values
    keys = ["name", "age", "city"]
    default_dict = dict.fromkeys(keys, "Unknown")
    print(f"Dictionary with default values: {default_dict}")
    
    # Set default value if key doesn't exist
    student.setdefault("country", "USA")
    print(f"After setdefault for 'country': {student}")
    print()
    
    # 11. Merging dictionaries (Python 3.9+)
    print("11. Merging dictionaries:")
    personal_info = {"hobby": "reading", "language": "Python"}
    merged = student | personal_info
    print(f"Merged dictionary: {merged}")
    
    # Update using another dictionary
    student.update(personal_info)
    print(f"After update: {student}")
    print()
    
    # 12. Practical examples with dictionaries
    print("12. Practical examples with dictionaries:")
    
    # Counting occurrences
    text = "hello world"
    char_count = {}
    for char in text:
        char_count[char] = char_count.get(char, 0) + 1
    print(f"Character count in '{text}': {char_count}")
    
    # Converting two lists to dictionary
    keys = ["name", "age", "grade"]
    values = ["Charlie", 22, "B"]
    converted_dict = dict(zip(keys, values))
    print(f"Converted from lists: {converted_dict}")
    
    # Dictionary as a switch-case replacement
    def get_day_name(day_num):
        switch = {
            1: "Monday",
            2: "Tuesday",
            3: "Wednesday",
            4: "Thursday",
            5: "Friday",
            6: "Saturday",
            7: "Sunday"
        }
        return switch.get(day_num, "Invalid day")
    
    print(f"Day 3 is: {get_day_name(3)}")
    print()
    
    print("Task completed: Python dictionaries demonstration")

if __name__ == "__main__":
    main()