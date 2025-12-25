"""
Python Constructors Implementation
This program demonstrates constructor concepts in Python
"""

class BasicConstructor:
    """Class demonstrating basic constructor"""
    
    def __init__(self, name):
        self.name = name
        print(f"BasicConstructor initialized with name: {name}")

class ConstructorWithDefaults:
    """Class demonstrating constructor with default parameters"""
    
    def __init__(self, name="Unknown", age=0, city="Not Specified"):
        self.name = name
        self.age = age
        self.city = city
        print(f"ConstructorWithDefaults initialized - Name: {name}, Age: {age}, City: {city}")

class ConstructorWithValidation:
    """Class demonstrating constructor with validation"""
    
    def __init__(self, name, age):
        if not isinstance(name, str) or len(name.strip()) == 0:
            raise ValueError("Name must be a non-empty string")
        if not isinstance(age, int) or age < 0:
            raise ValueError("Age must be a non-negative integer")
        
        self.name = name
        self.age = age
        print(f"ConstructorWithValidation initialized - Name: {name}, Age: {age}")

class MultiConstructorClass:
    """Class demonstrating multiple ways to initialize (using class methods)"""
    
    def __init__(self, name, age):
        self.name = name
        self.age = age
        self.initialization_type = "normal"
    
    @classmethod
    def from_string(cls, person_str):
        """Create instance from string"""
        name, age = person_str.split('-')
        return cls(name, int(age))
    
    @classmethod
    def from_dict(cls, person_dict):
        """Create instance from dictionary"""
        return cls(person_dict['name'], person_dict['age'])
    
    @classmethod
    def empty(cls):
        """Create instance with default values"""
        return cls("Unknown", 0)

class InheritedConstructor(BaseException):
    """Class demonstrating constructor inheritance"""
    
    def __init__(self, name, age, grade="N/A"):
        super().__init__()  # Call parent constructor if needed
        self.name = name
        self.age = age
        self.grade = grade
        print(f"InheritedConstructor initialized - Name: {name}, Age: {age}, Grade: {grade}")

class ConstructorWithProperties:
    """Class demonstrating constructor with property initialization"""
    
    def __init__(self, name, salary):
        self._name = name
        self._salary = max(0, salary)  # Ensure non-negative salary
    
    @property
    def name(self):
        return self._name
    
    @property
    def salary(self):
        return self._salary
    
    @salary.setter
    def salary(self, value):
        if value >= 0:
            self._salary = value
        else:
            raise ValueError("Salary cannot be negative")

def main():
    print("=== Python Constructors Assignments ===\n")
    
    # 1. Basic constructor
    print("1. Basic constructor:")
    obj1 = BasicConstructor("Alice")
    print(f"Object name: {obj1.name}\n")
    
    # 2. Constructor with default parameters
    print("2. Constructor with default parameters:")
    obj2a = ConstructorWithDefaults("Bob", 25, "New York")
    obj2b = ConstructorWithDefaults("Charlie")  # Using defaults for age and city
    obj2c = ConstructorWithDefaults()  # Using all defaults
    print()
    
    # 3. Constructor with validation
    print("3. Constructor with validation:")
    try:
        obj3 = ConstructorWithValidation("David", 30)
        print(f"Valid object created: {obj3.name}, {obj3.age}")
        
        # This will raise an exception
        invalid_obj = ConstructorWithValidation("", -5)
    except ValueError as e:
        print(f"Validation error: {e}\n")
    
    # 4. Multiple constructors using class methods
    print("4. Multiple constructors using class methods:")
    obj4a = MultiConstructorClass.from_string("Eve-28")
    print(f"From string: {obj4a.name}, {obj4a.age}, Type: {obj4a.initialization_type}")
    
    obj4b = MultiConstructorClass.from_dict({"name": "Frank", "age": 35})
    print(f"From dict: {obj4b.name}, {obj4b.age}, Type: {obj4b.initialization_type}")
    
    obj4c = MultiConstructorClass.empty()
    print(f"Empty: {obj4c.name}, {obj4c.age}, Type: {obj4c.initialization_type}\n")
    
    # 5. Constructor with initialization of complex objects
    print("5. Constructor with initialization of complex objects:")
    
    class Student:
        def __init__(self, name, subjects=None):
            self.name = name
            self.subjects = subjects or []  # Avoid mutable default argument
            self.grades = {}
        
        def add_subject(self, subject, grade):
            self.subjects.append(subject)
            self.grades[subject] = grade
    
    student1 = Student("Grace")
    student2 = Student("Henry", ["Math", "Science"])
    
    student1.add_subject("English", 85)
    student2.add_subject("History", 90)
    
    print(f"Student 1: {student1.name}, Subjects: {student1.subjects}, Grades: {student1.grades}")
    print(f"Student 2: {student2.name}, Subjects: {student2.subjects}, Grades: {student2.grades}\n")
    
    # 6. Constructor with property handling
    print("6. Constructor with property handling:")
    emp = ConstructorWithProperties("Ivy", 50000)
    print(f"Employee: {emp.name}, Salary: ${emp.salary}")
    
    try:
        emp.salary = -1000  # This will raise an error
    except ValueError as e:
        print(f"Error setting salary: {e}\n")
    
    # 7. Constructor inheritance
    print("7. Constructor inheritance:")
    inherited_obj = InheritedConstructor("Jack", 22, "A")
    print(f"Inherited object: {inherited_obj.name}, {inherited_obj.age}, {inherited_obj.grade}\n")
    
    # 8. __new__ vs __init__ demonstration
    print("8. __new__ vs __init__ demonstration:")
    
    class Singleton:
        _instance = None
        
        def __new__(cls, name):
            if cls._instance is None:
                cls._instance = super().__new__(cls)
            return cls._instance
        
        def __init__(self, name):
            # Prevent re-initialization if already exists
            if not hasattr(self, 'name'):
                self.name = name
    
    singleton1 = Singleton("First")
    singleton2 = Singleton("Second")
    
    print(f"Singleton 1 name: {singleton1.name}")
    print(f"Singleton 2 name: {singleton2.name}")
    print(f"Are they the same object? {singleton1 is singleton2}\n")
    
    # 9. Constructor with *args and **kwargs
    print("9. Constructor with *args and **kwargs:")
    
    class FlexibleConstructor:
        def __init__(self, *args, **kwargs):
            if args:
                self.name = args[0] if len(args) > 0 else "Default"
                self.age = args[1] if len(args) > 1 else 0
            else:
                self.name = kwargs.get('name', 'Default')
                self.age = kwargs.get('age', 0)
            
            # Store any additional keyword arguments
            for key, value in kwargs.items():
                if key not in ['name', 'age']:
                    setattr(self, key, value)
    
    flex1 = FlexibleConstructor("Kate", 25)
    flex2 = FlexibleConstructor(name="Liam", age=30, city="Boston")
    flex3 = FlexibleConstructor("Mia", 28, country="USA")
    
    print(f"Flex 1: {flex1.name}, {flex1.age}")
    print(f"Flex 2: {flex2.name}, {flex2.age}, {flex2.city}")
    print(f"Flex 3: {flex3.name}, {flex3.age}, {flex3.country}\n")
    
    # 10. Constructor with resource management
    print("10. Constructor with resource management:")
    
    class ResourceManager:
        def __init__(self, resource_name):
            self.resource_name = resource_name
            self.is_active = True
            print(f"Resource '{self.resource_name}' acquired")
        
        def __del__(self):
            if self.is_active:
                print(f"Resource '{self.resource_name}' released")
    
    resource = ResourceManager("Database Connection")
    print(f"Resource: {resource.resource_name}, Active: {resource.is_active}\n")
    
    # 11. Constructor patterns - Factory pattern
    print("11. Constructor patterns - Factory pattern:")
    
    class Animal:
        def __init__(self, name):
            self.name = name
        
        @classmethod
        def create_dog(cls, name):
            dog = cls(name)
            dog.species = "Dog"
            dog.sound = "Woof"
            return dog
        
        @classmethod
        def create_cat(cls, name):
            cat = cls(name)
            cat.species = "Cat"
            cat.sound = "Meow"
            return cat
    
    dog = Animal.create_dog("Buddy")
    cat = Animal.create_cat("Whiskers")
    
    print(f"Dog: {dog.name}, Species: {dog.species}, Sound: {dog.sound}")
    print(f"Cat: {cat.name}, Species: {cat.species}, Sound: {cat.sound}\n")
    
    # 12. Constructor with type hints (Python 3.5+)
    print("12. Constructor with type hints:")
    
    from typing import List, Optional
    
    class TypedConstructor:
        def __init__(self, name: str, age: int, subjects: Optional[List[str]] = None):
            self.name: str = name
            self.age: int = age
            self.subjects: List[str] = subjects or []
        
        def add_subject(self, subject: str) -> None:
            self.subjects.append(subject)
        
        def get_info(self) -> str:
            return f"Name: {self.name}, Age: {self.age}, Subjects: {self.subjects}"
    
    typed_obj = TypedConstructor("Noah", 20, ["Math", "Physics"])
    typed_obj.add_subject("Chemistry")
    print(typed_obj.get_info())
    
    print("\nTask completed: Python constructors demonstration")

if __name__ == "__main__":
    main()