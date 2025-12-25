"""
Python Access Modifiers Implementation
This program demonstrates access control in Python (using naming conventions)
"""

class BasicClass:
    """Class demonstrating different access levels in Python"""
    
    def __init__(self):
        self.public_var = "I am public"           # Public: accessed from anywhere
        self._protected_var = "I am protected"    # Protected: internal use (convention)
        self.__private_var = "I am private"       # Private: name mangled by Python
    
    def public_method(self):
        """Public method - can be accessed from outside"""
        return "This is a public method"
    
    def _protected_method(self):
        """Protected method - internal use (convention)"""
        return "This is a protected method"
    
    def __private_method(self):
        """Private method - name mangled by Python"""
        return "This is a private method"
    
    def access_all(self):
        """Method to demonstrate access to all members from within the class"""
        result = []
        result.append(f"Public: {self.public_var}")
        result.append(f"Protected: {self._protected_var}")
        result.append(f"Private: {self.__private_var}")
        result.append(f"Public method: {self.public_method()}")
        result.append(f"Protected method: {self._protected_method()}")
        result.append(f"Private method: {self.__private_method()}")
        return result

class DerivedClass(BasicClass):
    """Derived class to demonstrate access in inheritance"""
    
    def access_parent_members(self):
        """Method to access parent class members"""
        result = []
        # Public members can be accessed
        result.append(f"Public from parent: {self.public_var}")
        result.append(f"Public method from parent: {self.public_method()}")
        
        # Protected members can be accessed (by convention, they're intended for internal use)
        result.append(f"Protected from parent: {self._protected_var}")
        result.append(f"Protected method from parent: {self._protected_method()}")
        
        # Private members cannot be accessed directly (name mangled)
        try:
            result.append(f"Private from parent: {self.__private_var}")
        except AttributeError as e:
            result.append(f"Cannot access private variable: {e}")
        
        try:
            result.append(f"Private method from parent: {self.__private_method()}")
        except AttributeError as e:
            result.append(f"Cannot access private method: {e}")
        
        return result

def main():
    print("=== Python Access Modifiers Assignments ===\n")
    
    # 1. Creating an instance of the basic class
    print("1. Creating an instance of BasicClass:")
    obj = BasicClass()
    
    # 2. Accessing public members
    print("2. Accessing public members:")
    print(f"Public variable: {obj.public_var}")
    print(f"Public method: {obj.public_method()}")
    print()
    
    # 3. Accessing protected members (by convention)
    print("3. Accessing protected members (by convention):")
    print(f"Protected variable: {obj._protected_var}")
    print(f"Protected method: {obj._protected_method()}")
    print("Note: Protected members can be accessed but shouldn't be by convention")
    print()
    
    # 4. Attempting to access private members
    print("4. Attempting to access private members:")
    print("Direct access to private members will fail:")
    try:
        print(f"Private variable: {obj.__private_var}")
    except AttributeError as e:
        print(f"Error accessing private variable: {e}")
    
    try:
        print(f"Private method: {obj.__private_method()}")
    except AttributeError as e:
        print(f"Error accessing private method: {e}")
    print()
    
    # 5. Accessing private members using name mangling
    print("5. Accessing private members using name mangling:")
    print(f"Private variable (name mangled): {obj._BasicClass__private_var}")
    print(f"Private method (name mangled): {obj._BasicClass__private_method()}")
    print()
    
    # 6. Accessing all members from within the class
    print("6. Accessing all members from within the class:")
    for access_result in obj.access_all():
        print(f"  {access_result}")
    print()
    
    # 7. Access in inheritance
    print("7. Access in inheritance:")
    derived_obj = DerivedClass()
    for access_result in derived_obj.access_parent_members():
        print(f"  {access_result}")
    print()
    
    # 8. Properties for controlled access
    print("8. Using properties for controlled access:")
    
    class BankAccount:
        def __init__(self, initial_balance=0):
            self._balance = initial_balance  # Protected attribute
            self.__account_number = "ACCT" + str(id(self))[-4:]  # Private attribute
        
        @property
        def balance(self):
            """Public property to access balance"""
            return self._balance
        
        @property
        def account_number(self):
            """Public property to access account number (read-only)"""
            return self.__account_number
        
        @balance.setter
        def balance(self, amount):
            """Setter for balance with validation"""
            if amount >= 0:
                self._balance = amount
            else:
                raise ValueError("Balance cannot be negative")
        
        def deposit(self, amount):
            if amount > 0:
                self._balance += amount
                return f"Deposited ${amount}. New balance: ${self._balance}"
            return "Deposit amount must be positive"
        
        def withdraw(self, amount):
            if 0 < amount <= self._balance:
                self._balance -= amount
                return f"Withdrew ${amount}. New balance: ${self._balance}"
            return "Insufficient funds or invalid amount"
    
    account = BankAccount(100)
    print(f"Initial balance: ${account.balance}")
    print(f"Account number: {account.account_number}")
    print(account.deposit(50))
    print(f"Balance after deposit: ${account.balance}")
    
    try:
        account.balance = -50  # This will raise an error
    except ValueError as e:
        print(f"Error setting balance: {e}")
    print()
    
    # 9. Name mangling demonstration
    print("9. Name mangling demonstration:")
    
    class Parent:
        def __init__(self):
            self.public = "Parent Public"
            self._protected = "Parent Protected"
            self.__private = "Parent Private"
    
    class Child(Parent):
        def __init__(self):
            super().__init__()
            self.public = "Child Public"
            self._protected = "Child Protected"
            self.__private = "Child Private"  # This creates a new private attribute
        
        def show_attributes(self):
            result = []
            result.append(f"Public: {self.public}")
            result.append(f"Protected: {self._protected}")
            result.append(f"Child's private: {self.__private}")
            result.append(f"Parent's private: {self._Parent__private}")
            return result
    
    child = Child()
    for attr_result in child.show_attributes():
        print(f"  {attr_result}")
    print()
    
    # 10. Using __slots__ for attribute control
    print("10. Using __slots__ for attribute control:")
    
    class LimitedClass:
        __slots__ = ['name', 'age']  # Only these attributes are allowed
        
        def __init__(self, name, age):
            self.name = name
            self.age = age
    
    limited_obj = LimitedClass("Alice", 30)
    print(f"Limited object: {limited_obj.name}, {limited_obj.age}")
    
    try:
        limited_obj.email = "alice@example.com"  # This will raise an error
    except AttributeError as e:
        print(f"Cannot add new attribute: {e}")
    print()
    
    # 11. Public vs Private methods in practice
    print("11. Public vs Private methods in practice:")
    
    class DataProcessor:
        def __init__(self):
            self.data = []
        
        def add_data(self, value):
            """Public method that validates input before processing"""
            if self.__is_valid(value):
                self.data.append(value)
                return f"Added {value} to data"
            else:
                return f"Invalid data: {value}"
        
        def get_processed_data(self):
            """Public method that returns processed data"""
            return self.__process_data()
        
        def __is_valid(self, value):
            """Private method for validation (internal use)"""
            return isinstance(value, (int, float, str)) and len(str(value)) > 0
        
        def __process_data(self):
            """Private method for data processing (internal use)"""
            return [str(item).upper() if isinstance(item, str) else item for item in self.data]
    
    processor = DataProcessor()
    print(processor.add_data("hello"))
    print(processor.add_data(42))
    print(processor.add_data(""))
    print(f"Processed data: {processor.get_processed_data()}")
    
    try:
        processor.__is_valid("test")  # This will fail
    except AttributeError as e:
        print(f"Cannot call private method directly: {e}")
    print()
    
    # 12. Convention-based access control
    print("12. Convention-based access control:")
    
    class APIClass:
        def __init__(self):
            self.public_attr = "Available to all users"
            self._internal_attr = "For internal use only"
            self.__private_attr = "Strictly private"
        
        def public_interface(self):
            """Public interface to the class"""
            return {
                "public_data": self.public_attr,
                "processed_internal": self._internal_operation()
            }
        
        def _internal_operation(self):
            """Internal operation (not part of public API)"""
            return f"Processed: {self._internal_attr}"
        
        def __private_operation(self):
            """Private operation (not accessible outside class)"""
            return f"Private: {self.__private_attr}"
    
    api_obj = APIClass()
    print("Public interface:")
    print(f"  {api_obj.public_interface()}")
    print(f"  Internal attr (accessible but not recommended): {api_obj._internal_attr}")
    print("  Private attr: Cannot be accessed directly")
    
    print("\nTask completed: Python access modifiers demonstration")

if __name__ == "__main__":
    main()