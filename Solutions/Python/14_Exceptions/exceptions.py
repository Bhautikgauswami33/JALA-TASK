"""
Python Exceptions Implementation
This program demonstrates exception handling in Python
"""

def main():
    print("=== Python Exceptions Assignments ===\n")
    
    # 1. Basic try-except block
    print("1. Basic try-except block:")
    try:
        result = 10 / 0
    except ZeroDivisionError:
        print("Caught a ZeroDivisionError: Cannot divide by zero!")
    print()
    
    # 2. Multiple except blocks
    print("2. Multiple except blocks:")
    test_values = [10, 0, "hello"]
    
    for val in test_values:
        try:
            result = 10 / val
            print(f"10 / {val} = {result}")
        except ZeroDivisionError:
            print(f"Cannot divide by zero: 10 / {val}")
        except TypeError:
            print(f"Cannot divide by string: 10 / {val}")
    print()
    
    # 3. Catching multiple exceptions in one block
    print("3. Catching multiple exceptions in one block:")
    test_cases = [10, 0, "abc", [1, 2, 3]]
    
    for case in test_cases:
        try:
            result = 10 / case
            print(f"Result: {result}")
        except (TypeError, ZeroDivisionError) as e:
            print(f"Exception caught: {type(e).__name__} - {e}")
    print()
    
    # 4. Using else clause
    print("4. Using else clause:")
    for val in [5, 0]:
        try:
            result = 10 / val
        except ZeroDivisionError:
            print(f"Cannot divide by {val}")
        else:
            print(f"10 / {val} = {result} (executed when no exception occurs)")
    print()
    
    # 5. Using finally clause
    print("5. Using finally clause:")
    for val in [2, 0]:
        try:
            result = 10 / val
            print(f"10 / {val} = {result}")
        except ZeroDivisionError:
            print(f"Cannot divide by {val}")
        finally:
            print(f"Cleanup operations for division by {val}")
    print()
    
    # 6. Raising exceptions
    print("6. Raising exceptions:")
    def validate_age(age):
        if age < 0:
            raise ValueError("Age cannot be negative")
        if age > 150:
            raise ValueError("Age seems unrealistic")
        return True
    
    test_ages = [25, -5, 200]
    for age in test_ages:
        try:
            validate_age(age)
            print(f"Age {age} is valid")
        except ValueError as e:
            print(f"Invalid age {age}: {e}")
    print()
    
    # 7. Creating custom exceptions
    print("7. Creating custom exceptions:")
    class CustomError(Exception):
        """Custom exception class"""
        def __init__(self, message, error_code=None):
            super().__init__(message)
            self.error_code = error_code
    
    def check_temperature(temp):
        if temp < -273.15:
            raise CustomError(f"Temperature {temp}°C is below absolute zero!", "TEMP_BELOW_ABSOLUTE_ZERO")
        elif temp > 1000:
            raise CustomError(f"Temperature {temp}°C is extremely high!", "TEMP_TOO_HIGH")
    
    test_temps = [25, -300, 1500]
    for temp in test_temps:
        try:
            check_temperature(temp)
            print(f"Temperature {temp}°C is valid")
        except CustomError as e:
            print(f"Custom error for {temp}°C: {e} (Code: {e.error_code})")
    print()
    
    # 8. Exception hierarchy and catching base exceptions
    print("8. Exception hierarchy and catching base exceptions:")
    test_operations = [
        lambda: 10 / 0,  # ZeroDivisionError
        lambda: int("abc"),  # ValueError
        lambda: [1, 2, 3][10],  # IndexError
        lambda: {"a": 1}["b"]  # KeyError
    ]
    
    for i, operation in enumerate(test_operations, 1):
        try:
            result = operation()
            print(f"Operation {i} succeeded: {result}")
        except LookupError as e:  # Catches IndexError and KeyError
            print(f"Operation {i} failed with LookupError: {e}")
        except ArithmeticError as e:  # Catches ZeroDivisionError
            print(f"Operation {i} failed with ArithmeticError: {e}")
        except ValueError as e:
            print(f"Operation {i} failed with ValueError: {e}")
    print()
    
    # 9. Using raise without arguments (re-raising)
    print("9. Using raise without arguments (re-raising):")
    def process_number(num):
        try:
            if num < 0:
                raise ValueError("Negative number not allowed")
            return num * 2
        except ValueError as e:
            print(f"Processing error: {e}")
            # Log the error and re-raise
            raise  # Re-raises the same exception
    
    try:
        result = process_number(-5)
    except ValueError as e:
        print(f"Caught re-raised exception: {e}")
    print()
    
    # 10. Assertion errors
    print("10. Assertion errors:")
    def calculate_average(numbers):
        assert len(numbers) > 0, "List cannot be empty"
        assert all(isinstance(n, (int, float)) for n in numbers), "All items must be numbers"
        return sum(numbers) / len(numbers)
    
    test_lists = [[1, 2, 3, 4, 5], [], [1, 2, "three", 4]]
    
    for lst in test_lists:
        try:
            avg = calculate_average(lst)
            print(f"Average of {lst}: {avg}")
        except AssertionError as e:
            print(f"Assertion failed for {lst}: {e}")
    print()
    
    # 11. Practical example: File operations with exception handling
    print("11. Practical example: File operations with exception handling:")
    import os
    
    def safe_file_operation(filename, operation="read"):
        try:
            if operation == "read":
                with open(filename, 'r') as file:
                    content = file.read()
                    print(f"Successfully read {len(content)} characters from {filename}")
                    return content
            elif operation == "write":
                with open(filename, 'w') as file:
                    file.write("Sample content for testing")
                    print(f"Successfully wrote to {filename}")
        except FileNotFoundError:
            print(f"Error: File {filename} not found")
        except PermissionError:
            print(f"Error: Permission denied to access {filename}")
        except IOError as e:
            print(f"IO Error with {filename}: {e}")
        except Exception as e:
            print(f"Unexpected error with {filename}: {e}")
    
    # Test with existing and non-existing files
    safe_file_operation("nonexistent_file.txt", "read")
    safe_file_operation("sample_output.txt", "write")
    
    # Clean up
    try:
        os.remove("sample_output.txt")
        print("Cleaned up sample_output.txt")
    except FileNotFoundError:
        pass
    print()
    
    # 12. Exception handling best practices
    print("12. Exception handling best practices:")
    
    # Good practice: Specific exception handling
    def divide_safely(a, b):
        try:
            result = a / b
            return result
        except ZeroDivisionError:
            print("Error: Division by zero")
            return None
        except TypeError:
            print("Error: Invalid input types")
            return None
    
    # Test the function
    print(f"10 / 2 = {divide_safely(10, 2)}")
    print(f"10 / 0 = {divide_safely(10, 0)}")
    print(f"10 / 'a' = {divide_safely(10, 'a')}")
    
    # Using context managers with exception handling
    def safe_file_read(filename):
        try:
            with open(filename, 'r') as file:
                return file.read()
        except FileNotFoundError:
            print(f"File {filename} not found, returning empty string")
            return ""
    
    content = safe_file_read("definitely_nonexistent_file.txt")
    print(f"Content: '{content}'")
    
    print("\nTask completed: Python exceptions demonstration")

if __name__ == "__main__":
    main()