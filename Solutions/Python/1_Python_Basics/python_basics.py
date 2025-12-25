"""
Python Basics Assignments - JALA Academy
Solutions for Task 1 to Task 4
"""

# Task 1: Print Your Name
def print_name():
    """
    This function prints a name to the console.
    """
    name = "Jenish Barvaliya"
    print(name)

# Task 2: Demonstrate Comments
def demonstrate_comments():
    """
    This function demonstrates single-line and multi-line comments in Python.
    """
    # This is a single-line comment
    print("Demonstrating comments")

    '''
    This is a multi-line comment.
    It can span multiple lines.
    '''
    print("Comments demonstrated")

# Task 3: Define Variables of Different Data Types
def define_data_types():
    """
    This function defines variables of different data types and prints them.
    """
    # Integer
    integer_var = 42
    # Boolean
    boolean_var = True
    # Character (represented as a string of length 1 in Python)
    char_var = 'A'
    # Float
    float_var = 3.14
    # Double (Python's float type handles double precision)
    double_var = 3.141592653589793

    print("Integer:", integer_var)
    print("Boolean:", boolean_var)
    print("Character:", char_var)
    print("Float:", float_var)
    print("Double:", double_var)

# Task 4: Local and Global Variables
global_var = "I am global"

def demonstrate_variable_scope():
    """
    This function demonstrates the scope of local and global variables.
    """
    global global_var
    
    # Defining a local variable with the same name
    local_shadow = "I am local"
    print("Local variable (shadowing logic):", local_shadow)
    
    # Accessing the modified global variable
    print("Global variable inside function:", global_var)

def print_global_variable():
    """
    Simple function to print the global variable state.
    """
    print("Global variable current state:", global_var)

# Main execution
if __name__ == "__main__":
    print("--- Task 1: Print Name ---")
    print_name()
    
    print("\n--- Task 2: Demonstrate Comments ---")
    demonstrate_comments()
    
    print("\n--- Task 3: Define Data Types ---")
    define_data_types()
    
    print("\n--- Task 4: Demonstrate Variable Scope ---")
    print("Before function call:")
    print_global_variable()
    demonstrate_variable_scope()
    print("After function call:")
    print_global_variable()
