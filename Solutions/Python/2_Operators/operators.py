"""
Operators demonstration tasks - JALA Academy.

This module contains functions that implement basic arithmetic, increment/decrement,
equality checking, relational operators, and finding the smaller/larger of two numbers.
All logic is implemented manually without using built-in helper functions.
"""

def arithmetic_operators(a, b):
    """Perform basic arithmetic operations on two numbers.

    Args:
        a (int or float): First operand.
        b (int or float): Second operand.

    Returns:
        tuple: (sum, difference, product, quotient). If b is zero, quotient is None.
    """
    sum_val = a + b
    diff_val = a - b
    prod_val = a * b
    # Handle division by zero manually
    if b != 0:
        quot_val = a / b
    else:
        quot_val = None
    return sum_val, diff_val, prod_val, quot_val

def increment(num):
    """Increment a number by 1 manually.

    Args:
        num (int or float): Number to increment.

    Returns:
        int or float: Incremented number.
    """
    return num + 1

def decrement(num):
    """Decrement a number by 1 manually.

    Args:
        num (int or float): Number to decrement.

    Returns:
        int or float: Decremented number.
    """
    return num - 1

def are_equal(a, b):
    """Check if two numbers are equal.

    Args:
        a (int or float): First number.
        b (int or float): Second number.

    Returns:
        bool: True if numbers are equal, False otherwise.
    """
    return a == b

def relational_operators(a, b):
    """Evaluate relational operators between two numbers.

    Args:
        a (int or float): First number.
        b (int or float): Second number.

    Returns:
        dict: Mapping of operator names to boolean results.
    """
    results = {
        'less_than': a < b,
        'less_than_or_equal': a <= b,
        'greater_than': a > b,
        'greater_than_or_equal': a >= b,
    }
    return results

def print_smaller_and_larger(a, b):
    """Print the smaller and larger of two numbers using manual comparison.

    If both numbers are equal, a message indicating equality is printed.

    Args:
        a (int or float): First number.
        b (int or float): Second number.
    """
    if a < b:
        print(f"Smaller number: {a}")
        print(f"Larger number: {b}")
    elif a > b:
        print(f"Smaller number: {b}")
        print(f"Larger number: {a}")
    else:
        print(f"Both numbers are equal: {a}")

def main():
    """Demonstrate the operator functions with example values."""
    # Example numbers for demonstration
    x = 10
    y = 5

    # 1. Arithmetic operators
    add, sub, mul, div = arithmetic_operators(x, y)
    print("=== Arithmetic Operators ===")
    print(f"{x} + {y} = {add}")
    print(f"{x} - {y} = {sub}")
    print(f"{x} * {y} = {mul}")
    if div is not None:
        print(f"{x} / {y} = {div}")
    else:
        print(f"{x} / {y} = Division by zero (undefined)")

    # 2. Increment and decrement
    inc_x = increment(x)
    dec_x = decrement(x)
    print("\n=== Increment / Decrement ===")
    print(f"Increment of {x} -> {inc_x}")
    print(f"Decrement of {x} -> {dec_x}")

    # 3. Equality check
    equal = are_equal(x, y)
    print("\n=== Equality Check ===")
    print(f"Are {x} and {y} equal? {equal}")

    # 4. Relational operators
    rel = relational_operators(x, y)
    print("\n=== Relational Operators ===")
    for op_name, result in rel.items():
        # Format operator names for better display
        op_display = op_name.replace('_', ' ')
        print(f"{x} {op_display} {y}: {result}")

    # 5. Smaller and larger number
    print("\n=== Smaller and Larger Number ===")
    print_smaller_and_larger(x, y)

if __name__ == "__main__":
    main()
