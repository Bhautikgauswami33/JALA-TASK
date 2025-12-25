"""
Python Packages Implementation
This program demonstrates Python packages and modules
"""

# This would typically be in separate files, but for demonstration we'll define everything here

# Simulating a math_utils package
class MathUtils:
    """A class representing utilities for mathematical operations"""
    
    @staticmethod
    def add(a, b):
        """Add two numbers"""
        return a + b
    
    @staticmethod
    def subtract(a, b):
        """Subtract b from a"""
        return a - b
    
    @staticmethod
    def multiply(a, b):
        """Multiply two numbers"""
        return a * b
    
    @staticmethod
    def divide(a, b):
        """Divide a by b"""
        if b == 0:
            raise ValueError("Cannot divide by zero")
        return a / b
    
    @staticmethod
    def power(base, exponent):
        """Raise base to the power of exponent"""
        return base ** exponent

# Simulating a string_utils package
class StringUtils:
    """A class representing utilities for string operations"""
    
    @staticmethod
    def reverse_string(s):
        """Reverse a string"""
        return s[::-1]
    
    @staticmethod
    def capitalize_words(s):
        """Capitalize the first letter of each word"""
        return ' '.join(word.capitalize() for word in s.split())
    
    @staticmethod
    def count_vowels(s):
        """Count the number of vowels in a string"""
        vowels = 'aeiouAEIOU'
        return sum(1 for char in s if char in vowels)
    
    @staticmethod
    def is_palindrome(s):
        """Check if a string is a palindrome"""
        cleaned = ''.join(char.lower() for char in s if char.isalnum())
        return cleaned == cleaned[::-1]
    
    @staticmethod
    def word_count(s):
        """Count the number of words in a string"""
        return len(s.split())

# Simulating a list_utils package
class ListUtils:
    """A class representing utilities for list operations"""
    
    @staticmethod
    def find_max(lst):
        """Find the maximum value in a list"""
        if not lst:
            return None
        return max(lst)
    
    @staticmethod
    def find_min(lst):
        """Find the minimum value in a list"""
        if not lst:
            return None
        return min(lst)
    
    @staticmethod
    def calculate_average(lst):
        """Calculate the average of a list of numbers"""
        if not lst:
            return None
        return sum(lst) / len(lst)
    
    @staticmethod
    def remove_duplicates(lst):
        """Remove duplicates from a list while preserving order"""
        seen = set()
        result = []
        for item in lst:
            if item not in seen:
                seen.add(item)
                result.append(item)
        return result
    
    @staticmethod
    def flatten_list(nested_list):
        """Flatten a nested list"""
        result = []
        for item in nested_list:
            if isinstance(item, list):
                result.extend(ListUtils.flatten_list(item))
            else:
                result.append(item)
        return result

# Simulating a file_utils package
class FileUtils:
    """A class representing utilities for file operations"""
    
    @staticmethod
    def read_file_lines(filename):
        """Read all lines from a file"""
        try:
            with open(filename, 'r') as file:
                return file.readlines()
        except FileNotFoundError:
            return []
    
    @staticmethod
    def write_list_to_file(lst, filename):
        """Write a list to a file, one item per line"""
        with open(filename, 'w') as file:
            for item in lst:
                file.write(str(item) + '\n')
    
    @staticmethod
    def count_lines_in_file(filename):
        """Count the number of lines in a file"""
        try:
            with open(filename, 'r') as file:
                return sum(1 for line in file)
        except FileNotFoundError:
            return 0

# Simulating a date_utils package
from datetime import datetime, timedelta

class DateUtils:
    """A class representing utilities for date operations"""
    
    @staticmethod
    def get_current_date():
        """Get the current date"""
        return datetime.now().date()
    
    @staticmethod
    def get_current_datetime():
        """Get the current date and time"""
        return datetime.now()
    
    @staticmethod
    def format_date(date_obj, format_string="%Y-%m-%d"):
        """Format a date object as a string"""
        return date_obj.strftime(format_string)
    
    @staticmethod
    def add_days_to_date(date_obj, days):
        """Add days to a date"""
        return date_obj + timedelta(days=days)
    
    @staticmethod
    def days_between_dates(date1, date2):
        """Calculate the number of days between two dates"""
        return abs((date2 - date1).days)

def main():
    print("=== Python Packages Assignments ===\n")
    
    # 1. Math utilities package
    print("1. Math utilities package:")
    math_ops = MathUtils()
    print(f"Addition: {math_ops.add(10, 5)}")
    print(f"Subtraction: {math_ops.subtract(10, 5)}")
    print(f"Multiplication: {math_ops.multiply(10, 5)}")
    print(f"Division: {math_ops.divide(10, 5)}")
    print(f"Power: {math_ops.power(2, 3)}")
    print()
    
    # 2. String utilities package
    print("2. String utilities package:")
    str_ops = StringUtils()
    test_string = "hello world"
    print(f"Original: {test_string}")
    print(f"Reversed: {str_ops.reverse_string(test_string)}")
    print(f"Capitalized: {str_ops.capitalize_words(test_string)}")
    print(f"Vowel count: {str_ops.count_vowels(test_string)}")
    print(f"Is palindrome: {str_ops.is_palindrome('racecar')}")
    print(f"Word count: {str_ops.word_count(test_string)}")
    print()
    
    # 3. List utilities package
    print("3. List utilities package:")
    list_ops = ListUtils()
    test_list = [1, 2, 3, 2, 4, 5, 1]
    print(f"Original list: {test_list}")
    print(f"Max: {list_ops.find_max(test_list)}")
    print(f"Min: {list_ops.find_min(test_list)}")
    print(f"Average: {list_ops.calculate_average(test_list)}")
    print(f"Without duplicates: {list_ops.remove_duplicates(test_list)}")
    
    nested_list = [1, [2, 3], [4, [5, 6]], 7]
    print(f"Nested list: {nested_list}")
    print(f"Flattened: {list_ops.flatten_list(nested_list)}")
    print()
    
    # 4. File utilities package
    print("4. File utilities package:")
    file_ops = FileUtils()
    
    # Write a test list to a file
    test_data = ["apple", "banana", "cherry", "date"]
    file_ops.write_list_to_file(test_data, "test_file.txt")
    print(f"Test data written to file")
    
    # Read the file back
    lines = file_ops.read_file_lines("test_file.txt")
    print(f"Lines read from file: {lines}")
    
    # Count lines
    line_count = file_ops.count_lines_in_file("test_file.txt")
    print(f"Number of lines in file: {line_count}")
    print()
    
    # 5. Date utilities package
    print("5. Date utilities package:")
    date_ops = DateUtils()
    current_date = date_ops.get_current_date()
    current_datetime = date_ops.get_current_datetime()
    
    print(f"Current date: {current_date}")
    print(f"Current datetime: {current_datetime}")
    print(f"Formatted date: {date_ops.format_date(current_date)}")
    print(f"Date after adding 5 days: {date_ops.add_days_to_date(current_date, 5)}")
    
    future_date = date_ops.add_days_to_date(current_date, 10)
    days_diff = date_ops.days_between_dates(current_date, future_date)
    print(f"Days between current and future date: {days_diff}")
    print()
    
    # 6. Creating a package-like structure
    print("6. Package-like structure demonstration:")
    
    # Importing from our simulated packages
    # In a real package structure, we would have separate files and directories
    # like math_utils/__init__.py, string_utils/__init__.py, etc.
    
    # Simulating package imports
    print("Simulating package imports:")
    print(f"Using math utils: {MathUtils.multiply(7, 8)}")
    print(f"Using string utils: {StringUtils.reverse_string('Python')}")
    print(f"Using list utils: {ListUtils.calculate_average([1, 2, 3, 4, 5])}")
    print()
    
    # 7. Package initialization and __init__.py concept
    print("7. Package initialization concept:")
    
    # This demonstrates what would be in an __init__.py file
    # In a real package, __init__.py would contain initialization code
    # and could expose specific classes/functions
    
    # For example, if we had a package with __init__.py that exposes these functions:
    def package_summary():
        """Summary of the package functionality"""
        return {
            "math_utils": ["add", "subtract", "multiply", "divide", "power"],
            "string_utils": ["reverse_string", "capitalize_words", "count_vowels", "is_palindrome", "word_count"],
            "list_utils": ["find_max", "find_min", "calculate_average", "remove_duplicates", "flatten_list"],
            "file_utils": ["read_file_lines", "write_list_to_file", "count_lines_in_file"],
            "date_utils": ["get_current_date", "get_current_datetime", "format_date", "add_days_to_date", "days_between_dates"]
        }
    
    print("Package contains the following utilities:")
    summary = package_summary()
    for package, functions in summary.items():
        print(f"  {package}: {', '.join(functions)}")
    print()
    
    # 8. Package with submodules
    print("8. Package with submodules concept:")
    
    # Simulating a more complex package structure
    class Geometry:
        """Geometry submodule"""
        
        class TwoDimensional:
            """2D shapes"""
            
            @staticmethod
            def rectangle_area(length, width):
                return length * width
            
            @staticmethod
            def circle_area(radius):
                return 3.14159 * radius ** 2
        
        class ThreeDimensional:
            """3D shapes"""
            
            @staticmethod
            def cube_volume(side):
                return side ** 3
            
            @staticmethod
            def sphere_volume(radius):
                return (4/3) * 3.14159 * radius ** 3
    
    # Using the submodule structure
    print(f"Rectangle area: {Geometry.TwoDimensional.rectangle_area(5, 3)}")
    print(f"Circle area: {Geometry.TwoDimensional.circle_area(4)}")
    print(f"Cube volume: {Geometry.ThreeDimensional.cube_volume(3)}")
    print(f"Sphere volume: {Geometry.ThreeDimensional.sphere_volume(2)}")
    print()
    
    # 9. Package with configuration
    print("9. Package with configuration:")
    
    class ConfigurablePackage:
        """A package that can be configured"""
        
        def __init__(self, config=None):
            self.config = config or {"precision": 2, "default_multiplier": 1}
        
        def calculate(self, value):
            """Calculate using package configuration"""
            result = value * self.config["default_multiplier"]
            return round(result, self.config["precision"])
    
    # Create package instances with different configurations
    package1 = ConfigurablePackage()
    package2 = ConfigurablePackage({"precision": 3, "default_multiplier": 2.5})
    
    print(f"Default config result: {package1.calculate(10.555)}")
    print(f"Custom config result: {package2.calculate(10.555)}")
    print()
    
    # 10. Package with error handling
    print("10. Package with error handling:")
    
    try:
        result = MathUtils.divide(10, 0)
    except ValueError as e:
        print(f"Caught expected error: {e}")
    
    print("\nTask completed: Python packages demonstration")

if __name__ == "__main__":
    main()