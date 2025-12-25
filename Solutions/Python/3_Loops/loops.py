"""
Python Loops Implementation
This program demonstrates different types of loops in Python
"""

def main():
    print("=== Python Loops Assignments ===\n")
    
    # 1. Write a program to print "Bright IT Career" ten times using for loop
    print("1. Printing 'Bright IT Career' ten times using for loop:")
    for i in range(10):
        print(f"{i+1}. Bright IT Career")
    print()
    
    # 2. Write a program to print 1 to 20 numbers using the while loop
    print("2. Printing 1 to 20 using while loop:")
    num = 1
    while num <= 20:
        print(num, end=" ")
        num += 1
    print("\n")
    
    # 3. Program to equal operator and not equal operators
    print("3. Equal and Not Equal Operators:")
    a = 10
    b = 20
    print(f"a = {a}, b = {b}")
    print(f"a == b (Equal): {a == b}")
    print(f"a != b (Not Equal): {a != b}")
    print()
    
    # 4. Write a program to print the odd and even numbers
    print("4. Odd and Even Numbers from 1 to 10:")
    numbers = list(range(1, 11))
    even_numbers = []
    odd_numbers = []
    
    for num in numbers:
        if num % 2 == 0:
            even_numbers.append(num)
        else:
            odd_numbers.append(num)
    
    print(f"Even numbers: {even_numbers}")
    print(f"Odd numbers: {odd_numbers}")
    print()
    
    # 5. Write a program to print largest number among three numbers
    print("5. Finding largest number among three numbers:")
    x, y, z = 15, 28, 12
    print(f"Numbers: {x}, {y}, {z}")
    largest = x
    if y > largest:
        largest = y
    if z > largest:
        largest = z
    print(f"Largest number: {largest}")
    print()
    
    # 6. Write a program to print even number between 10 and 20 using while
    print("6. Even numbers between 10 and 20 using while loop:")
    num = 10
    while num <= 20:
        if num % 2 == 0:
            print(num, end=" ")
        num += 1
    print("\n")
    
    # 7. Write a program to print 1 to 10 using the do-while loop statement
    # Python doesn't have do-while, but we can simulate it
    print("7. Printing 1 to 10 (simulating do-while loop):")
    num = 1
    while True:
        print(num, end=" ")
        num += 1
        if num > 10:
            break
    print("\n")
    
    # 8. Write a program to find Armstrong number or not
    print("8. Armstrong number check:")
    def is_armstrong(num):
        # Convert to string to count digits
        str_num = str(num)
        num_digits = len(str_num)
        sum_of_powers = sum(int(digit) ** num_digits for digit in str_num)
        return sum_of_powers == num
    
    test_num = 153  # 153 is an Armstrong number: 1^3 + 5^3 + 3^3 = 1 + 125 + 27 = 153
    print(f"Is {test_num} an Armstrong number? {is_armstrong(test_num)}")
    print()
    
    # 9. Write a program to find the prime or not
    print("9. Prime number check:")
    def is_prime(n):
        if n < 2:
            return False
        for i in range(2, int(n ** 0.5) + 1):
            if n % i == 0:
                return False
        return True
    
    test_num = 17
    print(f"Is {test_num} a prime number? {is_prime(test_num)}")
    print()
    
    # 10. Write a program to palindrome or not
    print("10. Palindrome check:")
    def is_palindrome(s):
        s = str(s).lower()  # Convert to lowercase for comparison
        return s == s[::-1]
    
    test_string = "racecar"
    print(f"Is '{test_string}' a palindrome? {is_palindrome(test_string)}")
    print()
    
    print("Task completed: Python loops and related concepts demonstration")

if __name__ == "__main__":
    main()