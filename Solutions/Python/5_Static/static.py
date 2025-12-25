"""
Python Static Methods and Variables Implementation
This program demonstrates static methods and class variables in Python
"""

class MathOperations:
    """Class demonstrating static methods and class variables"""
    
    # Class variable (static variable)
    PI = 3.14159
    E = 2.71828
    calculation_count = 0  # Counter for all instances of the class
    
    def __init__(self, name="Calculator"):
        self.name = name
        self.instance_calculations = 0  # Instance-specific counter
    
    @staticmethod
    def add(a, b):
        """Static method to add two numbers"""
        MathOperations.calculations_count += 1  # Access class variable
        return a + b
    
    @staticmethod
    def multiply(a, b):
        """Static method to multiply two numbers"""
        MathOperations.calculations_count += 1
        return a * b
    
    @staticmethod
    def power(base, exponent):
        """Static method to raise base to exponent"""
        MathOperations.calculations_count += 1
        return base ** exponent
    
    @staticmethod
    def circle_area(radius):
        """Static method using class variable PI"""
        MathOperations.calculations_count += 1
        return MathOperations.PI * radius ** 2
    
    def instance_add(self, a, b):
        """Instance method that also increments counters"""
        result = MathOperations.add(a, b)  # Calling static method
        self.instance_calculations += 1
        return result

class Student:
    """Class demonstrating class variables"""
    
    # Class variables
    school_name = "Python High School"
    total_students = 0
    all_grades = []  # Shared among all instances
    
    def __init__(self, name, grade):
        self.name = name
        self.grade = grade
        Student.total_students += 1  # Increment class variable
        Student.all_grades.append(grade)  # Add to shared list
    
    @classmethod
    def get_school_info(cls):
        """Class method to get school information"""
        return f"School: {cls.school_name}, Total Students: {cls.total_students}"
    
    @classmethod
    def get_average_grade(cls):
        """Class method to calculate average grade"""
        if not cls.all_grades:
            return 0
        return sum(cls.all_grades) / len(cls.all_grades)

class Counter:
    """Class demonstrating static variables and methods for counting"""
    
    # Static variable to count all instances created
    total_instances = 0
    
    def __init__(self):
        Counter.total_instances += 1
        self.instance_id = Counter.total_instances
        self.count = 0
    
    def increment(self):
        """Instance method to increment this counter"""
        self.count += 1
    
    @staticmethod
    def get_total_instances():
        """Static method to get total instances created"""
        return Counter.total_instances
    
    @classmethod
    def create_multiple(cls, count):
        """Class method to create multiple instances"""
        instances = []
        for _ in range(count):
            instances.append(cls())
        return instances

class StringUtils:
    """Class with static methods for string operations"""
    
    # Class variable
    vowels = "aeiouAEIOU"
    
    @staticmethod
    def reverse_string(s):
        """Static method to reverse a string"""
        return s[::-1]
    
    @staticmethod
    def count_vowels(s):
        """Static method to count vowels in a string"""
        return sum(1 for char in s if char in StringUtils.vowels)
    
    @staticmethod
    def is_palindrome(s):
        """Static method to check if string is palindrome"""
        cleaned = ''.join(c.lower() for c in s if c.isalnum())
        return cleaned == cleaned[::-1]
    
    @staticmethod
    def word_count(s):
        """Static method to count words in a string"""
        return len(s.split()) if s.strip() else 0

class BankAccount:
    """Class demonstrating class variables for bank operations"""
    
    # Class variables
    bank_name = "Python Bank"
    interest_rate = 0.02  # 2% annual interest
    total_accounts = 0
    all_balances = []
    
    def __init__(self, account_holder, initial_balance=0):
        self.account_holder = account_holder
        self.balance = initial_balance
        BankAccount.total_accounts += 1
        BankAccount.all_balances.append(initial_balance)
    
    def deposit(self, amount):
        """Instance method to deposit money"""
        if amount > 0:
            self.balance += amount
            # Update class variable
            idx = BankAccount.all_balances.index(self.balance - amount)
            BankAccount.all_balances[idx] = self.balance
            return f"Deposited ${amount}. New balance: ${self.balance}"
        return "Deposit amount must be positive"
    
    @classmethod
    def get_bank_info(cls):
        """Class method to get bank information"""
        return f"Bank: {cls.bank_name}, Total Accounts: {cls.total_accounts}"
    
    @classmethod
    def get_average_balance(cls):
        """Class method to calculate average balance"""
        if not cls.all_balances:
            return 0
        return sum(cls.all_balances) / len(cls.all_balances)
    
    @staticmethod
    def calculate_interest(balance):
        """Static method to calculate interest for a balance"""
        return balance * BankAccount.interest_rate

class Shape:
    """Abstract-like class with static methods"""
    
    # Class variable
    shape_count = 0
    
    @staticmethod
    def get_shape_info():
        """Static method to provide general shape information"""
        return "Shapes have properties like area and perimeter"
    
    @classmethod
    def increment_shape_count(cls):
        """Class method to increment shape count"""
        cls.shape_count += 1
    
    @staticmethod
    def validate_positive(value):
        """Static method to validate positive numbers"""
        return value > 0

def main():
    print("=== Python Static Methods and Variables Assignments ===\n")
    
    # 1. Static methods in MathOperations
    print("1. Static methods in MathOperations:")
    print(f"Add 5 + 3: {MathOperations.add(5, 3)}")
    print(f"Multiply 4 * 6: {MathOperations.multiply(4, 6)}")
    print(f"Power 2^8: {MathOperations.power(2, 8)}")
    print(f"Circle area (radius=5): {MathOperations.circle_area(5):.2f}")
    print(f"Total calculations: {MathOperations.calculations_count}")
    print()
    
    # 2. Class variables in Student
    print("2. Class variables in Student:")
    student1 = Student("Alice", 85)
    student2 = Student("Bob", 92)
    student3 = Student("Charlie", 78)
    
    print(Student.get_school_info())
    print(f"Average grade: {Student.get_average_grade():.2f}")
    print(f"All grades: {Student.all_grades}")
    print()
    
    # 3. Static variables for counting instances
    print("3. Static variables for counting instances:")
    counter1 = Counter()
    counter2 = Counter()
    counter3 = Counter()
    
    print(f"Total instances created: {Counter.get_total_instances()}")
    print(f"Counter 1 ID: {counter1.instance_id}")
    print(f"Counter 2 ID: {counter2.instance_id}")
    print(f"Counter 3 ID: {counter3.instance_id}")
    print()
    
    # 4. Multiple instances creation using class method
    print("4. Multiple instances creation using class method:")
    counters = Counter.create_multiple(2)
    print(f"Created {len(counters)} more counters")
    print(f"Total instances now: {Counter.get_total_instances()}")
    print()
    
    # 5. Static methods in StringUtils
    print("5. Static methods in StringUtils:")
    test_string = "A man a plan a canal Panama"
    print(f"Original: {test_string}")
    print(f"Reversed: {StringUtils.reverse_string(test_string)}")
    print(f"Vowel count: {StringUtils.count_vowels(test_string)}")
    print(f"Is palindrome: {StringUtils.is_palindrome(test_string)}")
    print(f"Word count: {StringUtils.word_count(test_string)}")
    print()
    
    # 6. Class variables in BankAccount
    print("6. Class variables in BankAccount:")
    account1 = BankAccount("John", 1000)
    account2 = BankAccount("Jane", 1500)
    account3 = BankAccount("Joe", 2000)
    
    print(BankAccount.get_bank_info())
    print(f"Average balance: ${BankAccount.get_average_balance():.2f}")
    print(f"Interest on $1000: ${BankAccount.calculate_interest(1000):.2f}")
    print()
    
    # 7. Instance operations affecting class variables
    print("7. Instance operations affecting class variables:")
    print(account1.deposit(500))
    print(f"Updated average balance: ${BankAccount.get_average_balance():.2f}")
    print()
    
    # 8. Static vs Instance method access
    print("8. Static vs Instance method access:")
    
    calc = MathOperations("MyCalculator")
    print(f"Instance name: {calc.name}")
    print(f"Using instance to call static: {calc.add(10, 20)}")
    print(f"Using class to call static: {MathOperations.add(10, 20)}")
    print(f"Instance calculation count: {calc.instance_calculations}")
    print(f"Class calculation count: {MathOperations.calculations_count}")
    print()
    
    # 9. Class method vs Static method
    print("9. Class method vs Static method:")
    
    # Class method has access to class (cls)
    print(f"Class method - School info: {Student.get_school_info()}")
    
    # Static method doesn't have access to class or instance
    print(f"Static method - Reversed 'hello': {StringUtils.reverse_string('hello')}")
    
    # 10. Practical example with validation
    print("10. Practical example with validation:")
    
    if Shape.validate_positive(5):
        print("5 is a valid positive number for a shape dimension")
    else:
        print("5 is not valid")
    
    print(f"General shape info: {Shape.get_shape_info()}")
    Shape.increment_shape_count()
    print(f"Shape count after increment: {Shape.shape_count}")
    print()
    
    # 11. Constants as class variables
    print("11. Constants as class variables:")
    print(f"Value of PI: {MathOperations.PI}")
    print(f"Value of E: {MathOperations.E}")
    
    # Demonstrating that class variables are shared
    calc1 = MathOperations("Calculator1")
    calc2 = MathOperations("Calculator2")
    
    initial_count = MathOperations.calculations_count
    calc1.add(1, 1)
    after_calc1 = MathOperations.calculations_count
    calc2.multiply(2, 2)
    after_calc2 = MathOperations.calculations_count
    
    print(f"Calculations count - Initial: {initial_count}")
    print(f"Calculations count - After calc1: {after_calc1}")
    print(f"Calculations count - After calc2: {after_calc2}")
    print()
    
    # 12. Real-world example: Configuration class
    print("12. Real-world example: Configuration class:")
    
    class AppConfig:
        # Class variables as configuration constants
        DATABASE_URL = "localhost:5432"
        API_VERSION = "v1"
        MAX_CONNECTIONS = 100
        DEBUG_MODE = True
        
        @staticmethod
        def get_database_config():
            return {
                "url": AppConfig.DATABASE_URL,
                "max_connections": AppConfig.MAX_CONNECTIONS
            }
        
        @classmethod
        def get_api_endpoint(cls, resource):
            return f"/api/{cls.API_VERSION}/{resource}"
    
    config = AppConfig()
    print(f"Database config: {AppConfig.get_database_config()}")
    print(f"API endpoint for users: {AppConfig.get_api_endpoint('users')}")
    
    print("\nTask completed: Python static methods and variables demonstration")

if __name__ == "__main__":
    main()