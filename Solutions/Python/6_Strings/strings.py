"""
Python Strings Implementation
This program demonstrates string operations in Python
"""

def main():
    print("=== Python Strings Assignments ===\n")
    
    # 1. Creating and initializing strings
    print("1. Creating and initializing strings:")
    str1 = "Hello, World!"
    str2 = 'Python Programming'
    str3 = """This is a
    multi-line string"""
    
    print(f"String 1: {str1}")
    print(f"String 2: {str2}")
    print(f"String 3: {str3}")
    print()
    
    # 2. String length
    print("2. String length:")
    print(f"Length of '{str1}': {len(str1)}")
    print(f"Length of '{str2}': {len(str2)}")
    print()
    
    # 3. Accessing string characters
    print("3. Accessing string characters:")
    print(f"First character of '{str1}': {str1[0]}")
    print(f"Last character of '{str1}': {str1[-1]}")
    print(f"Character at index 7 of '{str1}': {str1[7]}")
    print()
    
    # 4. String slicing
    print("4. String slicing:")
    print(f"'{str1}'[0:5]: {str1[0:5]}")  # First 5 characters
    print(f"'{str1}'[7:]: {str1[7:]}")    # From index 7 to end
    print(f"'{str1}'[:5]: {str1[:5]}")    # From start to index 4
    print(f"'{str1}'[::-1]: {str1[::-1]}")  # Reverse string
    print()
    
    # 5. String concatenation
    print("5. String concatenation:")
    greeting = "Hello"
    name = "Alice"
    full_greeting = greeting + ", " + name + "!"
    print(f"Concatenated string: {full_greeting}")
    
    # Using join for multiple strings
    words = ["Python", "is", "awesome"]
    sentence = " ".join(words)
    print(f"Joined string: {sentence}")
    print()
    
    # 6. String methods - case conversion
    print("6. String methods - case conversion:")
    text = "Hello World"
    print(f"Original: '{text}'")
    print(f"Uppercase: '{text.upper()}'")
    print(f"Lowercase: '{text.lower()}'")
    print(f"Title case: '{text.title()}'")
    print(f"Swap case: '{text.swapcase()}'")
    print()
    
    # 7. String methods - searching
    print("7. String methods - searching:")
    text = "Python programming is fun and Python is powerful"
    print(f"Text: '{text}'")
    print(f"Find 'Python': index {text.find('Python')}")
    print(f"Find 'Java': index {text.find('Java')}")  # Returns -1 if not found
    print(f"Count 'Python': {text.count('Python')}")
    print(f"Starts with 'Python': {text.startswith('Python')}")
    print(f"Ends with 'powerful': {text.endswith('powerful')}")
    print()
    
    # 8. String methods - modification
    print("8. String methods - modification:")
    text = "  Hello, World!  "
    print(f"Original: '{text}'")
    print(f"After strip(): '{text.strip()}'")
    print(f"After replace('World', 'Python'): '{text.replace('World', 'Python').strip()}'")
    
    # Splitting strings
    sentence = "apple,banana,orange"
    fruits = sentence.split(",")
    print(f"After split(','): {fruits}")
    print()
    
    # 9. String formatting
    print("9. String formatting:")
    name = "John"
    age = 25
    city = "New York"
    
    # Using format method
    formatted1 = "My name is {}, I'm {} years old, and I live in {}".format(name, age, city)
    print(f"Using format(): {formatted1}")
    
    # Using f-strings (Python 3.6+)
    formatted2 = f"My name is {name}, I'm {age} years old, and I live in {city}"
    print(f"Using f-strings: {formatted2}")
    
    # Using % formatting
    formatted3 = "My name is %s, I'm %d years old, and I live in %s" % (name, age, city)
    print(f"Using % formatting: {formatted3}")
    print()
    
    # 10. Checking string properties
    print("10. Checking string properties:")
    test_strings = ["hello", "Hello", "123", "hello123", "   ", "Hello World"]
    
    for s in test_strings:
        print(f"String: '{s}'")
        print(f"  Is alphabetic: {s.isalpha()}")
        print(f"  Is numeric: {s.isdigit()}")
        print(f"  Is alphanumeric: {s.isalnum()}")
        print(f"  Is lowercase: {s.islower()}")
        print(f"  Is uppercase: {s.isupper()}")
        print(f"  Is space: {s.isspace()}")
        print()
    
    # 11. Escape characters and raw strings
    print("11. Escape characters and raw strings:")
    path = "C:\\Users\\Name\\Documents\\file.txt"
    raw_path = r"C:\Users\Name\Documents\file.txt"
    print(f"Regular string with escapes: {path}")
    print(f"Raw string: {raw_path}")
    
    # Multi-line string with quotes
    multiline = """He said, "Hello!" 
    She replied, 'Hi there!'"""
    print(f"Multi-line with quotes:\n{multiline}")
    print()
    
    # 12. Advanced string operations
    print("12. Advanced string operations:")
    
    # Padding strings
    text = "Python"
    print(f"Left pad with 10 chars: '{text.rjust(10)}'")
    print(f"Right pad with 10 chars: '{text.ljust(10)}'")
    print(f"Center with 10 chars: '{text.center(10)}'")
    
    # Padding with specific character
    print(f"Center with *: '{text.center(10, '*')}'")
    
    # Partitioning strings
    email = "user@example.com"
    username, separator, domain = email.partition("@")
    print(f"Email '{email}' partitioned: '{username}', '{separator}', '{domain}'")
    print()
    
    print("Task completed: Python strings demonstration")

if __name__ == "__main__":
    main()