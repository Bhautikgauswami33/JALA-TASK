"""
Python Abstract Class Implementation
This program demonstrates abstract classes in Python using abc module
"""

from abc import ABC, abstractmethod

# 1. Basic Abstract Class
class Animal(ABC):
    """Abstract base class for animals"""
    
    def __init__(self, name):
        self.name = name
    
    @abstractmethod
    def make_sound(self):
        """Abstract method for making sounds"""
        pass
    
    @abstractmethod
    def move(self):
        """Abstract method for movement"""
        pass
    
    def sleep(self):
        """Concrete method that can be inherited"""
        return f"{self.name} is sleeping"

class Dog(Animal):
    """Concrete implementation of Animal"""
    
    def make_sound(self):
        return f"{self.name} barks: Woof! Woof!"
    
    def move(self):
        return f"{self.name} runs on four legs"

class Cat(Animal):
    """Another concrete implementation of Animal"""
    
    def make_sound(self):
        return f"{self.name} meows: Meow! Meow!"
    
    def move(self):
        return f"{self.name} moves silently on four legs"

class Bird(Animal):
    """Another concrete implementation of Animal"""
    
    def __init__(self, name, can_fly=True):
        super().__init__(name)
        self.can_fly = can_fly
    
    def make_sound(self):
        return f"{self.name} chirps: Tweet! Tweet!"
    
    def move(self):
        if self.can_fly:
            return f"{self.name} flies in the sky"
        else:
            return f"{self.name} walks on the ground"

# 2. Abstract class with multiple abstract methods
class Shape(ABC):
    """Abstract base class for shapes"""
    
    @abstractmethod
    def area(self):
        """Calculate area of the shape"""
        pass
    
    @abstractmethod
    def perimeter(self):
        """Calculate perimeter of the shape"""
        pass
    
    def description(self):
        """Concrete method that can be inherited"""
        return f"This is a {self.__class__.__name__} shape"

class Rectangle(Shape):
    """Rectangle implementation of Shape"""
    
    def __init__(self, width, height):
        self.width = width
        self.height = height
    
    def area(self):
        return self.width * self.height
    
    def perimeter(self):
        return 2 * (self.width + self.height)

class Circle(Shape):
    """Circle implementation of Shape"""
    
    def __init__(self, radius):
        self.radius = radius
    
    def area(self):
        return 3.14159 * self.radius ** 2
    
    def perimeter(self):
        return 2 * 3.14159 * self.radius

class Triangle(Shape):
    """Triangle implementation of Shape"""
    
    def __init__(self, side1, side2, side3):
        self.side1 = side1
        self.side2 = side2
        self.side3 = side3
    
    def area(self):
        # Using Heron's formula
        s = self.perimeter() / 2
        return (s * (s - self.side1) * (s - self.side2) * (s - self.side3)) ** 0.5
    
    def perimeter(self):
        return self.side1 + self.side2 + self.side3

# 3. Abstract class with abstract properties
class Vehicle(ABC):
    """Abstract base class for vehicles"""
    
    def __init__(self, brand, model):
        self.brand = brand
        self.model = model
    
    @property
    @abstractmethod
    def max_speed(self):
        """Abstract property for maximum speed"""
        pass
    
    @abstractmethod
    def start_engine(self):
        """Abstract method to start engine"""
        pass
    
    def get_info(self):
        """Concrete method"""
        return f"{self.brand} {self.model}"

class Car(Vehicle):
    """Car implementation of Vehicle"""
    
    def __init__(self, brand, model, doors):
        super().__init__(brand, model)
        self.doors = doors
    
    @property
    def max_speed(self):
        return 200  # km/h
    
    def start_engine(self):
        return f"The {self.brand} car engine starts with a roar!"

class Motorcycle(Vehicle):
    """Motorcycle implementation of Vehicle"""
    
    def __init__(self, brand, model, engine_size):
        super().__init__(brand, model)
        self.engine_size = engine_size
    
    @property
    def max_speed(self):
        return 180  # km/h
    
    def start_engine(self):
        return f"The {self.brand} motorcycle engine starts with a vroom!"

# 4. Abstract class with abstract class methods
class Database(ABC):
    """Abstract base class for databases"""
    
    @abstractmethod
    def connect(self):
        """Abstract method to connect to database"""
        pass
    
    @abstractmethod
    def execute_query(self, query):
        """Abstract method to execute a query"""
        pass
    
    @classmethod
    @abstractmethod
    def get_db_type(cls):
        """Abstract class method to get database type"""
        pass

class MySQLDatabase(Database):
    """MySQL implementation of Database"""
    
    def connect(self):
        return "Connected to MySQL database"
    
    def execute_query(self, query):
        return f"Executing MySQL query: {query}"
    
    @classmethod
    def get_db_type(cls):
        return "MySQL"

class PostgreSQLDatabase(Database):
    """PostgreSQL implementation of Database"""
    
    def connect(self):
        return "Connected to PostgreSQL database"
    
    def execute_query(self, query):
        return f"Executing PostgreSQL query: {query}"
    
    @classmethod
    def get_db_type(cls):
        return "PostgreSQL"

# 5. Abstract class with abstract static methods
class MathOperations(ABC):
    """Abstract base class for math operations"""
    
    @staticmethod
    @abstractmethod
    def add(a, b):
        """Abstract static method to add two numbers"""
        pass
    
    @staticmethod
    @abstractmethod
    def multiply(a, b):
        """Abstract static method to multiply two numbers"""
        pass

class BasicMath(MathOperations):
    """Basic math implementation"""
    
    @staticmethod
    def add(a, b):
        return a + b
    
    @staticmethod
    def multiply(a, b):
        return a * b

def main():
    print("=== Python Abstract Class Assignments ===\n")
    
    # 1. Basic abstract class usage
    print("1. Basic abstract class usage:")
    dog = Dog("Buddy")
    cat = Cat("Whiskers")
    bird = Bird("Tweety")
    
    print(dog.make_sound())
    print(dog.move())
    print(dog.sleep())  # Inherited concrete method
    
    print(cat.make_sound())
    print(cat.move())
    print(cat.sleep())  # Inherited concrete method
    
    print(bird.make_sound())
    print(bird.move())
    print(bird.sleep())  # Inherited concrete method
    print()
    
    # 2. Shape abstract class
    print("2. Shape abstract class:")
    shapes = [
        Rectangle(5, 3),
        Circle(4),
        Triangle(3, 4, 5)
    ]
    
    for shape in shapes:
        print(f"{shape.description()}")
        print(f"  Area: {shape.area():.2f}")
        print(f"  Perimeter: {shape.perimeter():.2f}")
    print()
    
    # 3. Vehicle abstract class with properties
    print("3. Vehicle abstract class with properties:")
    car = Car("Toyota", "Camry", 4)
    motorcycle = Motorcycle("Honda", "CBR", "600cc")
    
    print(f"{car.get_info()}")
    print(f"Max speed: {car.max_speed} km/h")
    print(car.start_engine())
    
    print(f"{motorcycle.get_info()}")
    print(f"Max speed: {motorcycle.max_speed} km/h")
    print(motorcycle.start_engine())
    print()
    
    # 4. Database abstract class with class methods
    print("4. Database abstract class with class methods:")
    databases = [
        MySQLDatabase(),
        PostgreSQLDatabase()
    ]
    
    for db in databases:
        print(f"DB Type: {db.get_db_type()}")
        print(db.connect())
        print(db.execute_query("SELECT * FROM users"))
        print()
    
    # 5. Math operations abstract class with static methods
    print("5. Math operations abstract class with static methods:")
    math_ops = BasicMath()
    print(f"Addition: {math_ops.add(5, 3)}")
    print(f"Multiply: {math_ops.multiply(4, 6)}")
    print()
    
    # 6. Attempting to instantiate abstract class (this will raise an error)
    print("6. Attempting to instantiate abstract class:")
    try:
        abstract_animal = Animal("Generic")
    except TypeError as e:
        print(f"Error: {e}")
    print()
    
    # 7. Abstract class with multiple inheritance
    print("7. Abstract class with multiple inheritance:")
    
    class Flyable(ABC):
        @abstractmethod
        def fly(self):
            pass
    
    class Swimmable(ABC):
        @abstractmethod
        def swim(self):
            pass
    
    class Duck(Animal, Flyable, Swimmable):
        def make_sound(self):
            return f"{self.name} quacks: Quack! Quack!"
        
        def move(self):
            return f"{self.name} walks on land"
        
        def fly(self):
            return f"{self.name} flies over the pond"
        
        def swim(self):
            return f"{self.name} swims in the water"
    
    duck = Duck("Donald")
    print(duck.make_sound())
    print(duck.move())
    print(duck.fly())
    print(duck.swim())
    print()
    
    # 8. Template method pattern with abstract class
    print("8. Template method pattern with abstract class:")
    
    class DataProcessor(ABC):
        """Abstract class with template method pattern"""
        
        def process_data(self):
            """Template method that defines the algorithm"""
            self.load_data()
            self.transform_data()
            self.save_data()
        
        def load_data(self):
            print("Loading data from source...")
        
        @abstractmethod
        def transform_data(self):
            """Abstract method that must be implemented"""
            pass
        
        def save_data(self):
            print("Saving processed data...")
    
    class CSVProcessor(DataProcessor):
        def transform_data(self):
            print("Transforming CSV data...")
    
    class JSONProcessor(DataProcessor):
        def transform_data(self):
            print("Transforming JSON data...")
    
    csv_processor = CSVProcessor()
    print("Processing CSV:")
    csv_processor.process_data()
    
    json_processor = JSONProcessor()
    print("\nProcessing JSON:")
    json_processor.process_data()
    print()
    
    # 9. Abstract properties with setters
    print("9. Abstract properties with setters:")
    
    class Temperature(ABC):
        def __init__(self, value):
            self._value = value
        
        @property
        @abstractmethod
        def celsius(self):
            pass
        
        @celsius.setter
        @abstractmethod
        def celsius(self, value):
            pass
    
    class Celsius(Temperature):
        @property
        def celsius(self):
            return self._value
        
        @celsius.setter
        def celsius(self, value):
            self._value = value
        
        def to_fahrenheit(self):
            return (self._value * 9/5) + 32
    
    temp = Celsius(25)
    print(f"Temperature in Celsius: {temp.celsius}")
    print(f"Temperature in Fahrenheit: {temp.to_fahrenheit()}")
    temp.celsius = 30
    print(f"Updated Celsius: {temp.celsius}")
    print()
    
    # 10. Practical abstract class example
    print("10. Practical abstract class example:")
    
    class PaymentProcessor(ABC):
        """Abstract base class for payment processing"""
        
        @abstractmethod
        def validate_payment(self, amount, details):
            """Validate payment details"""
            pass
        
        @abstractmethod
        def process_payment(self, amount, details):
            """Process the actual payment"""
            pass
        
        def complete_transaction(self, amount, details):
            """Template method for completing a transaction"""
            if self.validate_payment(amount, details):
                result = self.process_payment(amount, details)
                return f"Transaction completed: {result}"
            else:
                return "Transaction failed: Invalid payment details"
    
    class CreditCardProcessor(PaymentProcessor):
        def validate_payment(self, amount, details):
            return 'card_number' in details and len(details['card_number']) == 16
        
        def process_payment(self, amount, details):
            return f"Paid ${amount} using credit card ending in {details['card_number'][-4:]}"
    
    class PayPalProcessor(PaymentProcessor):
        def validate_payment(self, amount, details):
            return 'email' in details and '@' in details['email']
        
        def process_payment(self, amount, details):
            return f"Paid ${amount} using PayPal account {details['email']}"
    
    credit_card = CreditCardProcessor()
    paypal = PayPalProcessor()
    
    print(credit_card.complete_transaction(100, {'card_number': '1234567890123456'}))
    print(paypal.complete_transaction(75, {'email': 'user@example.com'}))
    
    print("\nTask completed: Python abstract classes demonstration")

if __name__ == "__main__":
    main()