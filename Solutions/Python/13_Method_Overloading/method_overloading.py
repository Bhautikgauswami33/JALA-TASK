"""
Python Method Overloading Implementation
This program demonstrates method overloading in Python
"""

from functools import singledispatch
from multipledispatch import dispatch

class BasicOverloading:
    """Class demonstrating basic approach to method overloading in Python"""
    
    def add(self, a, b):
        """Basic addition method"""
        return a + b
    
    def add_with_default(self, a, b=0, c=0):
        """Method with default parameters to simulate overloading"""
        return a + b + c

class MethodOverloadingDemo:
    """Class demonstrating various approaches to method overloading in Python"""
    
    def __init__(self):
        self.history = []
    
    def calculate(self, *args):
        """Method that handles different numbers of arguments"""
        if len(args) == 2:
            result = args[0] + args[1]
            operation = f"Addition: {args[0]} + {args[1]}"
        elif len(args) == 3:
            result = args[0] + args[1] + args[2]
            operation = f"Addition: {args[0]} + {args[1]} + {args[2]}"
        elif len(args) == 1:
            result = args[0] ** 2
            operation = f"Square: {args[0]}^2"
        else:
            result = 0
            operation = "No operation"
        
        self.history.append((operation, result))
        return result
    
    def process_data(self, data):
        """Method that handles different types of data"""
        if isinstance(data, str):
            result = f"Processing string: {data.upper()}"
        elif isinstance(data, int):
            result = f"Processing integer: {data * 2}"
        elif isinstance(data, list):
            result = f"Processing list with {len(data)} elements: {sum(data) if all(isinstance(x, (int, float)) for x in data) else 'mixed types'}"
        elif isinstance(data, dict):
            result = f"Processing dict with {len(data)} keys: {list(data.keys())}"
        else:
            result = f"Processing unknown type: {type(data)}"
        
        self.history.append(("Data Processing", result))
        return result

class AdvancedOverloading:
    """Class demonstrating advanced overloading techniques"""
    
    def __init__(self):
        self.items = []
    
    def add_item(self, *args, **kwargs):
        """Advanced method to add items with different signatures"""
        if args and not kwargs:
            if len(args) == 1:
                # Add single item
                item = args[0]
                self.items.append(item)
                return f"Added single item: {item}"
            elif len(args) == 2:
                # Add item with priority
                item, priority = args
                self.items.insert(priority, item)
                return f"Added item '{item}' at position {priority}"
            elif len(args) > 2:
                # Add multiple items
                items = list(args)
                self.items.extend(items)
                return f"Added multiple items: {items}"
        elif kwargs:
            # Add item with named parameters
            if 'name' in kwargs and 'value' in kwargs:
                item = {'name': kwargs['name'], 'value': kwargs['value']}
                self.items.append(item)
                return f"Added named item: {item}"
            elif 'item' in kwargs:
                item = kwargs['item']
                self.items.append(item)
                return f"Added item using keyword: {item}"
        
        return "No items added"

# Using functools.singledispatch for type-based dispatching
@singledispatch
def format_data(arg):
    """Default implementation for format_data"""
    return f"Unknown type: {type(arg)}"

@format_data.register
def _(arg: str):
    """String implementation"""
    return f"String: {arg.upper()}"

@format_data.register
def _(arg: int):
    """Integer implementation"""
    return f"Integer: {arg * 2}"

@format_data.register
def _(arg: list):
    """List implementation"""
    return f"List: {[x * 2 if isinstance(x, int) else str(x).upper() for x in arg]}"

# Using multipledispatch for multiple argument dispatching (simulated)
try:
    @dispatch(int, int)
    def multiply(a, b):
        return a * b
    
    @dispatch(str, int)
    def multiply(a, b):
        return a * b
    
    @dispatch(int, str)
    def multiply(a, b):
        return str(a) + b
except ImportError:
    # If multipledispatch is not available, define a simple version
    def multiply(a, b):
        if isinstance(a, int) and isinstance(b, int):
            return a * b
        elif isinstance(a, str) and isinstance(b, int):
            return a * b
        elif isinstance(a, int) and isinstance(b, str):
            return str(a) + b
        else:
            return f"{a}{b}"

class Calculator:
    """Calculator class demonstrating various overloading approaches"""
    
    def __init__(self):
        self.last_result = 0
    
    def compute(self, *args, operation="add"):
        """Method that computes based on different numbers of arguments"""
        if len(args) == 0:
            return 0
        elif len(args) == 1:
            # Unary operation
            if operation == "square":
                result = args[0] ** 2
            elif operation == "negate":
                result = -args[0]
            elif operation == "abs":
                result = abs(args[0])
            else:
                result = args[0]
        elif len(args) == 2:
            # Binary operation
            if operation == "add":
                result = args[0] + args[1]
            elif operation == "subtract":
                result = args[0] - args[1]
            elif operation == "multiply":
                result = args[0] * args[1]
            elif operation == "divide":
                result = args[0] / args[1] if args[1] != 0 else float('inf')
            else:
                result = args[0] + args[1]
        elif len(args) == 3:
            # Ternary operation
            if operation == "add":
                result = args[0] + args[1] + args[2]
            elif operation == "average":
                result = sum(args) / len(args)
            else:
                result = args[0] + args[1] + args[2]
        else:
            # Multiple arguments
            if operation == "sum":
                result = sum(args)
            elif operation == "max":
                result = max(args)
            elif operation == "min":
                result = min(args)
            else:
                result = sum(args)
        
        self.last_result = result
        return result

def main():
    print("=== Python Method Overloading Assignments ===\n")
    
    # 1. Basic overloading with default parameters
    print("1. Basic overloading with default parameters:")
    basic = BasicOverloading()
    print(f"add(5, 3): {basic.add(5, 3)}")
    print(f"add_with_default(5): {basic.add_with_default(5)}")
    print(f"add_with_default(5, 3): {basic.add_with_default(5, 3)}")
    print(f"add_with_default(5, 3, 2): {basic.add_with_default(5, 3, 2)}\n")
    
    # 2. Overloading with variable arguments
    print("2. Overloading with variable arguments:")
    demo = MethodOverloadingDemo()
    print(f"calculate(5): {demo.calculate(5)}")
    print(f"calculate(5, 3): {demo.calculate(5, 3)}")
    print(f"calculate(5, 3, 2): {demo.calculate(5, 3, 2)}")
    print()
    
    # 3. Type-based overloading
    print("3. Type-based overloading:")
    print(f"process_data('hello'): {demo.process_data('hello')}")
    print(f"process_data(5): {demo.process_data(5)}")
    print(f"process_data([1, 2, 3]): {demo.process_data([1, 2, 3])}")
    print(f"process_data({'a': 1, 'b': 2}): {demo.process_data({'a': 1, 'b': 2})}")
    print()
    
    # 4. Advanced overloading with multiple signatures
    print("4. Advanced overloading with multiple signatures:")
    advanced = AdvancedOverloading()
    print(advanced.add_item("apple"))
    print(advanced.add_item("banana", 0))  # Insert at position 0
    print(advanced.add_item("cherry", "date", "elderberry"))  # Multiple items
    print(advanced.add_item(name="fruit", value="apple"))  # Named parameters
    print(f"Items in list: {advanced.items}\n")
    
    # 5. Using functools.singledispatch
    print("5. Using functools.singledispatch:")
    print(format_data("hello"))
    print(format_data(42))
    print(format_data([1, 2, 3]))
    print()
    
    # 6. Multiple dispatch for different argument types
    print("6. Multiple dispatch for different argument types:")
    print(f"multiply(5, 3): {multiply(5, 3)}")
    print(f"multiply('hi', 3): {multiply('hi', 3)}")
    print(f"multiply(5, 'hello'): {multiply(5, 'hello')}")
    print()
    
    # 7. Calculator with operation parameter
    print("7. Calculator with operation parameter:")
    calc = Calculator()
    print(f"compute(5, operation='square'): {calc.compute(5, operation='square')}")
    print(f"compute(10, 5, operation='subtract'): {calc.compute(10, 5, operation='subtract')}")
    print(f"compute(2, 3, 4, operation='average'): {calc.compute(2, 3, 4, operation='average')}")
    print(f"compute(1, 2, 3, 4, 5, operation='sum'): {calc.compute(1, 2, 3, 4, 5, operation='sum')}")
    print()
    
    # 8. Method overloading with keyword arguments
    print("8. Method overloading with keyword arguments:")
    
    class Shape:
        def __init__(self):
            self.properties = {}
        
        def set_dimensions(self, **kwargs):
            """Method that accepts different keyword arguments"""
            if 'radius' in kwargs:
                # Circle
                self.properties = {'shape': 'circle', 'radius': kwargs['radius']}
                return f"Circle created with radius: {kwargs['radius']}"
            elif 'length' in kwargs and 'width' in kwargs:
                # Rectangle
                self.properties = {
                    'shape': 'rectangle', 
                    'length': kwargs['length'], 
                    'width': kwargs['width']
                }
                return f"Rectangle created with length: {kwargs['length']}, width: {kwargs['width']}"
            elif 'side' in kwargs:
                # Square
                self.properties = {'shape': 'square', 'side': kwargs['side']}
                return f"Square created with side: {kwargs['side']}"
            else:
                return "Unknown shape"
    
    shape = Shape()
    print(shape.set_dimensions(radius=5))
    print(shape.set_dimensions(length=10, width=5))
    print(shape.set_dimensions(side=4))
    print(f"Shape properties: {shape.properties}\n")
    
    # 9. Method overloading with type checking
    print("9. Method overloading with type checking:")
    
    class DataProcessor:
        def process(self, data):
            """Process data based on its type"""
            if isinstance(data, str):
                return self._process_string(data)
            elif isinstance(data, (int, float)):
                return self._process_number(data)
            elif isinstance(data, list):
                return self._process_list(data)
            elif isinstance(data, dict):
                return self._process_dict(data)
            else:
                return f"Cannot process type: {type(data)}"
        
        def _process_string(self, data):
            return f"Processed string: {data.strip().title()}"
        
        def _process_number(self, data):
            return f"Processed number: {data * 2}"
        
        def _process_list(self, data):
            if all(isinstance(x, (int, float)) for x in data):
                return f"Processed list (sum): {sum(data)}"
            else:
                return f"Processed list (length): {len(data)}"
        
        def _process_dict(self, data):
            return f"Processed dict (keys): {list(data.keys())}"
    
    processor = DataProcessor()
    print(processor.process("hello world"))
    print(processor.process(42))
    print(processor.process([1, 2, 3, 4]))
    print(processor.process({"name": "John", "age": 30}))
    print()
    
    # 10. Constructor overloading simulation
    print("10. Constructor overloading simulation:")
    
    class Person:
        def __init__(self, *args, **kwargs):
            if args:
                if len(args) == 1:
                    self.name = args[0]
                    self.age = 0
                    self.city = "Unknown"
                elif len(args) == 2:
                    self.name, self.age = args
                    self.city = "Unknown"
                elif len(args) == 3:
                    self.name, self.age, self.city = args
            elif kwargs:
                self.name = kwargs.get('name', 'Unknown')
                self.age = kwargs.get('age', 0)
                self.city = kwargs.get('city', 'Unknown')
            else:
                self.name = "Unknown"
                self.age = 0
                self.city = "Unknown"
        
        def __str__(self):
            return f"Person(name='{self.name}', age={self.age}, city='{self.city}')"
    
    person1 = Person("Alice")
    person2 = Person("Bob", 25)
    person3 = Person("Charlie", 30, "New York")
    person4 = Person(name="David", age=35, city="Boston")
    
    print(person1)
    print(person2)
    print(person3)
    print(person4)
    print()
    
    # 11. Operator overloading as method overloading
    print("11. Operator overloading as method overloading:")
    
    class Vector:
        def __init__(self, x, y):
            self.x = x
            self.y = y
        
        def __add__(self, other):
            """Overload + operator"""
            return Vector(self.x + other.x, self.y + other.y)
        
        def __mul__(self, scalar):
            """Overload * operator"""
            return Vector(self.x * scalar, self.y * scalar)
        
        def __str__(self):
            return f"Vector({self.x}, {self.y})"
    
    v1 = Vector(2, 3)
    v2 = Vector(1, 4)
    v3 = v1 + v2
    v4 = v1 * 3
    
    print(f"v1: {v1}")
    print(f"v2: {v2}")
    print(f"v1 + v2: {v3}")
    print(f"v1 * 3: {v4}")
    print()
    
    print("Task completed: Python method overloading demonstration")

if __name__ == "__main__":
    main()