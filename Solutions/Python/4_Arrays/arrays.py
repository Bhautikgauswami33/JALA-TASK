"""
Python Arrays Implementation
This program demonstrates array-like structures in Python (lists)
"""

def main():
    print("=== Python Arrays (Lists) Assignments ===\n")
    
    # 1. Creating and initializing arrays (lists)
    print("1. Creating and initializing arrays (lists):")
    numbers = [1, 2, 3, 4, 5]
    fruits = ["apple", "banana", "orange", "grape"]
    mixed_array = [1, "hello", 3.14, True, [1, 2, 3]]
    
    print(f"Numbers array: {numbers}")
    print(f"Fruits array: {fruits}")
    print(f"Mixed array: {mixed_array}")
    print()
    
    # 2. Accessing array elements
    print("2. Accessing array elements:")
    print(f"First element of numbers: {numbers[0]}")
    print(f"Last element of numbers: {numbers[-1]}")
    print(f"Second element of fruits: {fruits[1]}")
    print()
    
    # 3. Modifying array elements
    print("3. Modifying array elements:")
    numbers[0] = 10
    print(f"After modifying first element: {numbers}")
    print()
    
    # 4. Array length
    print("4. Array length:")
    print(f"Length of numbers array: {len(numbers)}")
    print(f"Length of fruits array: {len(fruits)}")
    print()
    
    # 5. Adding elements to array
    print("5. Adding elements to array:")
    numbers.append(6)  # Add to end
    print(f"After appending 6: {numbers}")
    
    numbers.insert(0, 0)  # Insert at specific position
    print(f"After inserting 0 at index 0: {numbers}")
    print()
    
    # 6. Removing elements from array
    print("6. Removing elements from array:")
    numbers.remove(10)  # Remove by value
    print(f"After removing 10: {numbers}")
    
    removed_element = numbers.pop()  # Remove and return last element
    print(f"After popping last element ({removed_element}): {numbers}")
    
    removed_element = numbers.pop(0)  # Remove and return first element
    print(f"After popping first element ({removed_element}): {numbers}")
    print()
    
    # 7. Array slicing
    print("7. Array slicing:")
    slice1 = numbers[1:4]  # Elements from index 1 to 3
    print(f"Slice [1:4]: {slice1}")
    
    slice2 = numbers[:3]   # Elements from start to index 2
    print(f"Slice [:3]: {slice2}")
    
    slice3 = numbers[2:]   # Elements from index 2 to end
    print(f"Slice [2:]: {slice3}")
    print()
    
    # 8. Iterating through arrays
    print("8. Iterating through arrays:")
    print("Using for loop:")
    for i, fruit in enumerate(fruits):
        print(f"Index {i}: {fruit}")
    print()
    
    # 9. Searching in arrays
    print("9. Searching in arrays:")
    search_fruit = "banana"
    if search_fruit in fruits:
        index = fruits.index(search_fruit)
        print(f"'{search_fruit}' found at index {index}")
    else:
        print(f"'{search_fruit}' not found")
    print()
    
    # 10. Sorting arrays
    print("10. Sorting arrays:")
    unsorted_numbers = [5, 2, 8, 1, 9]
    print(f"Unsorted: {unsorted_numbers}")
    
    sorted_numbers = sorted(unsorted_numbers)
    print(f"Sorted (new array): {sorted_numbers}")
    
    unsorted_numbers.sort()  # Sort in place
    print(f"Sorted (in place): {unsorted_numbers}")
    print()
    
    # 11. Multi-dimensional arrays (lists of lists)
    print("11. Multi-dimensional arrays:")
    matrix = [
        [1, 2, 3],
        [4, 5, 6],
        [7, 8, 9]
    ]
    print("Matrix:")
    for row in matrix:
        print(row)
    
    # Accessing elements in 2D array
    print(f"Element at [1][2]: {matrix[1][2]}")
    print()
    
    # 12. Array operations
    print("12. Array operations:")
    list1 = [1, 2, 3]
    list2 = [4, 5, 6]
    
    # Concatenation
    concatenated = list1 + list2
    print(f"Concatenated: {concatenated}")
    
    # Repetition
    repeated = list1 * 3
    print(f"Repeated: {repeated}")
    
    # Membership
    print(f"Is 2 in list1? {2 in list1}")
    print()
    
    print("Task completed: Python arrays (lists) demonstration")

if __name__ == "__main__":
    main()