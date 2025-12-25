"""
Python Files Implementation
This program demonstrates file operations in Python
"""

def main():
    print("=== Python Files Assignments ===\n")
    
    # 1. Creating and writing to a file
    print("1. Creating and writing to a file:")
    filename = "sample.txt"
    
    # Writing text to the file
    with open(filename, 'w') as file:
        file.write("Hello, World!\n")
        file.write("This is a sample text file.\n")
        file.write("Python file handling is easy.\n")
    
    print(f"Content written to {filename}")
    print()
    
    # 2. Reading from a file
    print("2. Reading from a file:")
    with open(filename, 'r') as file:
        content = file.read()
        print(f"Content of {filename}:")
        print(content)
    print()
    
    # 3. Reading file line by line
    print("3. Reading file line by line:")
    with open(filename, 'r') as file:
        print("Reading line by line:")
        for line_num, line in enumerate(file, 1):
            print(f"Line {line_num}: {line.strip()}")
    print()
    
    # 4. Appending to a file
    print("4. Appending to a file:")
    with open(filename, 'a') as file:
        file.write("This line is appended.\n")
        file.write("File handling in Python is flexible.\n")
    
    print(f"Content appended to {filename}")
    
    # Reading the updated file
    with open(filename, 'r') as file:
        updated_content = file.read()
        print(f"Updated content of {filename}:")
        print(updated_content)
    print()
    
    # 5. Reading file using readlines()
    print("5. Reading file using readlines():")
    with open(filename, 'r') as file:
        lines = file.readlines()
        print(f"Lines in the file: {len(lines)}")
        for i, line in enumerate(lines):
            print(f"  {i+1}: {line.strip()}")
    print()
    
    # 6. Writing a list to a file
    print("6. Writing a list to a file:")
    data_list = ["apple", "banana", "cherry", "date"]
    list_filename = "fruits.txt"
    
    with open(list_filename, 'w') as file:
        for item in data_list:
            file.write(item + "\n")
    
    print(f"List written to {list_filename}")
    
    # Reading it back
    with open(list_filename, 'r') as file:
        read_list = [line.strip() for line in file]
        print(f"List read from {list_filename}: {read_list}")
    print()
    
    # 7. Working with file positions
    print("7. Working with file positions:")
    with open(filename, 'r') as file:
        print(f"Initial file position: {file.tell()}")
        
        # Read first 5 characters
        first_five = file.read(5)
        print(f"First 5 characters: '{first_five}'")
        print(f"File position after reading 5 chars: {file.tell()}")
        
        # Move to beginning
        file.seek(0)
        print(f"File position after seek(0): {file.tell()}")
        
        # Read first line after seek
        first_line = file.readline()
        print(f"First line after seek: '{first_line.strip()}'")
    print()
    
    # 8. Exception handling in file operations
    print("8. Exception handling in file operations:")
    try:
        with open("nonexistent.txt", 'r') as file:
            content = file.read()
    except FileNotFoundError:
        print("File 'nonexistent.txt' not found!")
    
    # Safe file operation
    try:
        with open(filename, 'r') as file:
            content = file.read()
            print(f"Successfully read from {filename}")
    except Exception as e:
        print(f"An error occurred: {e}")
    print()
    
    # 9. Working with different file modes
    print("9. Working with different file modes:")
    
    # Using 'x' mode (exclusive creation)
    import os
    new_file = "new_file.txt"
    if os.path.exists(new_file):
        os.remove(new_file)  # Remove if exists
    
    try:
        with open(new_file, 'x') as file:  # 'x' mode fails if file exists
            file.write("This file is created with 'x' mode.")
        print(f"File {new_file} created successfully with 'x' mode")
    except FileExistsError:
        print(f"File {new_file} already exists!")
    
    # Using 'r+' mode (read and write)
    with open(new_file, 'r+') as file:
        content = file.read()
        print(f"Content before writing in r+ mode: {content}")
        file.write("\nAdded with r+ mode")
        file.seek(0)  # Go back to start
        content = file.read()
        print(f"Content after writing in r+ mode: {content}")
    print()
    
    # 10. Working with binary files
    print("10. Working with binary files:")
    binary_data = b"This is binary data.\x00\x01\x02"
    binary_file = "binary_sample.bin"
    
    # Write binary data
    with open(binary_file, 'wb') as file:
        file.write(binary_data)
    
    # Read binary data
    with open(binary_file, 'rb') as file:
        read_binary = file.read()
        print(f"Binary data written and read: {read_binary}")
    print()
    
    # 11. Using context managers properly
    print("11. Using context managers properly:")
    
    # Reading and writing simultaneously
    input_file = filename
    output_file = "processed_" + filename
    
    with open(input_file, 'r') as infile, open(output_file, 'w') as outfile:
        for line_num, line in enumerate(infile, 1):
            processed_line = f"{line_num}: {line.strip().upper()}\n"
            outfile.write(processed_line)
    
    print(f"Processed content written to {output_file}")
    
    # Read the processed file
    with open(output_file, 'r') as file:
        processed_content = file.read()
        print(f"Processed content:")
        print(processed_content)
    print()
    
    # 12. Practical file operations
    print("12. Practical file operations:")
    
    # Counting words in a file
    with open(filename, 'r') as file:
        text = file.read()
        words = text.split()
        word_count = len(words)
        char_count = len(text)
        line_count = len(text.split('\n'))
        
        print(f"Statistics for {filename}:")
        print(f"  Lines: {line_count}")
        print(f"  Words: {word_count}")
        print(f"  Characters: {char_count}")
    
    # Copying a file
    copy_file = "copy_of_" + filename
    with open(filename, 'r') as source, open(copy_file, 'w') as dest:
        dest.write(source.read())
    print(f"File copied to {copy_file}")
    
    # Check if files are identical
    with open(filename, 'r') as f1, open(copy_file, 'r') as f2:
        if f1.read() == f2.read():
            print("Original and copy files are identical")
    print()
    
    # Clean up created files
    cleanup_files = [list_filename, new_file, binary_file, output_file, copy_file]
    for file_to_remove in cleanup_files:
        try:
            os.remove(file_to_remove)
            print(f"Cleaned up: {file_to_remove}")
        except FileNotFoundError:
            pass  # File doesn't exist
    
    print(f"\nTask completed: Python files demonstration")

if __name__ == "__main__":
    main()