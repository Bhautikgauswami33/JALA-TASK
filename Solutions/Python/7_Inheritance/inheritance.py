"""
Python Inheritance Implementation
This program demonstrates inheritance in Python
"""

class Animal:
    """Base class for all animals"""
    def __init__(self, name, species):
        self.name = name
        self.species = species
        self.alive = True
    
    def eat(self):
        return f"{self.name} is eating."
    
    def sleep(self):
        return f"{self.name} is sleeping."
    
    def make_sound(self):
        return f"{self.name} makes a sound."
    
    def info(self):
        return f"{self.name} is a {self.species}"

class Dog(Animal):
    """Dog class inheriting from Animal"""
    def __init__(self, name, breed):
        super().__init__(name, "Dog")
        self.breed = breed
    
    def make_sound(self):  # Method overriding
        return f"{self.name} barks: Woof! Woof!"
    
    def fetch(self):
        return f"{self.name} fetches the ball."

class Cat(Animal):
    """Cat class inheriting from Animal"""
    def __init__(self, name, color):
        super().__init__(name, "Cat")
        self.color = color
    
    def make_sound(self):  # Method overriding
        return f"{self.name} meows: Meow! Meow!"
    
    def climb(self):
        return f"{self.name} climbs the tree."

class Bird(Animal):
    """Bird class inheriting from Animal"""
    def __init__(self, name, can_fly=True):
        super().__init__(name, "Bird")
        self.can_fly = can_fly
    
    def make_sound(self):
        return f"{self.name} chirps: Tweet! Tweet!"
    
    def fly(self):
        if self.can_fly:
            return f"{self.name} is flying high!"
        else:
            return f"{self.name} cannot fly."

class Puppy(Dog):
    """Puppy class inheriting from Dog (multi-level inheritance)"""
    def __init__(self, name, breed):
        super().__init__(name, breed)
        self.age = "puppy"
    
    def make_sound(self):
        return f"{self.name} yaps: Yap! Yap!"
    
    def play(self):
        return f"{self.name} plays with toys."

def main():
    print("=== Python Inheritance Assignments ===\n")
    
    # 1. Basic inheritance
    print("1. Basic inheritance:")
    dog = Dog("Buddy", "Golden Retriever")
    cat = Cat("Whiskers", "Orange")
    
    print(dog.info())
    print(cat.info())
    print(dog.eat())
    print(cat.sleep())
    print()
    
    # 2. Method overriding
    print("2. Method overriding:")
    print(dog.make_sound())
    print(cat.make_sound())
    print()
    
    # 3. Adding new methods in child classes
    print("3. Adding new methods in child classes:")
    print(dog.fetch())
    print(cat.climb())
    print()
    
    # 4. Multi-level inheritance
    print("4. Multi-level inheritance:")
    puppy = Puppy("Max", "Labrador")
    print(puppy.info())
    print(puppy.make_sound())
    print(puppy.play())
    print(f"{puppy.name} is a {puppy.age}")
    print()
    
    # 5. Multiple inheritance example
    print("5. Multiple inheritance example:")
    
    class Flyable:
        def fly(self):
            return "Flying with wings!"
    
    class Swimmable:
        def swim(self):
            return "Swimming with fins!"
    
    class Duck(Animal, Flyable, Swimmable):
        def __init__(self, name):
            super().__init__(name, "Duck")
        
        def make_sound(self):
            return f"{self.name} quacks: Quack! Quack!"
    
    duck = Duck("Donald")
    print(duck.info())
    print(duck.make_sound())
    print(duck.fly())
    print(duck.swim())
    print()
    
    # 6. Using super() function
    print("6. Using super() function:")
    
    class Vehicle:
        def __init__(self, brand, model):
            self.brand = brand
            self.model = model
        
        def start(self):
            return f"The {self.brand} {self.model} starts."
    
    class Car(Vehicle):
        def __init__(self, brand, model, doors):
            super().__init__(brand, model)  # Using super() to call parent constructor
            self.doors = doors
        
        def start(self):
            base_start = super().start()  # Using super() to call parent method
            return f"{base_start} It's a {self.doors}-door car."
    
    car = Car("Toyota", "Camry", 4)
    print(car.start())
    print()
    
    # 7. Method Resolution Order (MRO)
    print("7. Method Resolution Order (MRO):")
    print(f"MRO for Duck: {Duck.__mro__}")
    print(f"MRO for Puppy: {Puppy.__mro__}")
    print()
    
    # 8. isinstance() and issubclass() functions
    print("8. isinstance() and issubclass() functions:")
    print(f"isinstance(dog, Animal): {isinstance(dog, Animal)}")
    print(f"isinstance(dog, Dog): {isinstance(dog, Dog)}")
    print(f"isinstance(dog, Cat): {isinstance(dog, Cat)}")
    print(f"issubclass(Dog, Animal): {issubclass(Dog, Animal)}")
    print(f"issubclass(Animal, Dog): {issubclass(Animal, Dog)}")
    print()
    
    # 9. Abstract base class simulation (without importing abc)
    print("9. Abstract base class simulation:")
    
    class Shape:
        def area(self):
            raise NotImplementedError("Subclass must implement area method")
        
        def perimeter(self):
            raise NotImplementedError("Subclass must implement perimeter method")
    
    class Rectangle(Shape):
        def __init__(self, width, height):
            self.width = width
            self.height = height
        
        def area(self):
            return self.width * self.height
        
        def perimeter(self):
            return 2 * (self.width + self.height)
    
    class Circle(Shape):
        def __init__(self, radius):
            self.radius = radius
        
        def area(self):
            return 3.14159 * self.radius ** 2
        
        def perimeter(self):
            return 2 * 3.14159 * self.radius
    
    rect = Rectangle(5, 3)
    circle = Circle(4)
    
    print(f"Rectangle area: {rect.area()}")
    print(f"Rectangle perimeter: {rect.perimeter()}")
    print(f"Circle area: {circle.area()}")
    print(f"Circle perimeter: {circle.perimeter()}")
    print()
    
    # 10. Property inheritance
    print("10. Property inheritance:")
    
    class Person:
        def __init__(self, name, age):
            self._name = name
            self._age = age
        
        @property
        def name(self):
            return self._name
        
        @property
        def age(self):
            return self._age
        
        @age.setter
        def age(self, value):
            if value >= 0:
                self._age = value
            else:
                raise ValueError("Age cannot be negative")
    
    class Student(Person):
        def __init__(self, name, age, student_id):
            super().__init__(name, age)
            self.student_id = student_id
        
        def study(self):
            return f"{self.name} is studying."
    
    student = Student("Alice", 20, "S12345")
    print(f"Student name: {student.name}")
    print(f"Student age: {student.age}")
    print(f"Student ID: {student.student_id}")
    print(student.study())
    
    try:
        student.age = -5  # This will raise an error
    except ValueError as e:
        print(f"Error setting age: {e}")
    print()
    
    # 11. Operator overloading in inheritance
    print("11. Operator overloading in inheritance:")
    
    class Number:
        def __init__(self, value):
            self.value = value
        
        def __add__(self, other):
            if isinstance(other, Number):
                return Number(self.value + other.value)
            return Number(self.value + other)
        
        def __str__(self):
            return str(self.value)
    
    class ComplexNumber(Number):
        def __init__(self, real, imag=0):
            super().__init__(complex(real, imag))
        
        def __add__(self, other):
            if isinstance(other, ComplexNumber):
                result = self.value + other.value
                return ComplexNumber(result.real, result.imag)
            return ComplexNumber((self.value + other).real, (self.value + other).imag)
    
    num1 = ComplexNumber(3, 4)  # 3+4j
    num2 = ComplexNumber(1, 2)  # 1+2j
    result = num1 + num2
    print(f"({num1}) + ({num2}) = {result}")
    print()
    
    # 12. Practical inheritance example
    print("12. Practical inheritance example:")
    
    class BankAccount:
        def __init__(self, account_holder, initial_balance=0):
            self.account_holder = account_holder
            self.balance = initial_balance
        
        def deposit(self, amount):
            if amount > 0:
                self.balance += amount
                return f"Deposited ${amount}. New balance: ${self.balance}"
            return "Deposit amount must be positive"
        
        def withdraw(self, amount):
            if 0 < amount <= self.balance:
                self.balance -= amount
                return f"Withdrew ${amount}. New balance: ${self.balance}"
            return "Insufficient funds or invalid amount"
        
        def get_balance(self):
            return f"Balance: ${self.balance}"
    
    class SavingsAccount(BankAccount):
        def __init__(self, account_holder, initial_balance=0, interest_rate=0.02):
            super().__init__(account_holder, initial_balance)
            self.interest_rate = interest_rate
        
        def add_interest(self):
            interest = self.balance * self.interest_rate
            self.balance += interest
            return f"Interest added: ${interest:.2f}. New balance: ${self.balance:.2f}"
    
    class CheckingAccount(BankAccount):
        def __init__(self, account_holder, initial_balance=0, overdraft_limit=100):
            super().__init__(account_holder, initial_balance)
            self.overdraft_limit = overdraft_limit
        
        def withdraw(self, amount):
            if 0 < amount <= self.balance + self.overdraft_limit:
                self.balance -= amount
                return f"Withdrew ${amount}. New balance: ${self.balance}"
            return "Exceeds overdraft limit or invalid amount"
    
    savings = SavingsAccount("John Doe", 1000)
    checking = CheckingAccount("Jane Smith", 500)
    
    print(savings.deposit(200))
    print(savings.add_interest())
    print(checking.withdraw(550))  # This should work due to overdraft
    print(f"Savings balance: ${savings.balance}")
    print(f"Checking balance: ${checking.balance}")
    
    print("\nTask completed: Python inheritance demonstration")

if __name__ == "__main__":
    main()