public class JavaStrings {
    public static void main(String[] args) {
        System.out.println("=== Java Strings Assignments ===\n");
        
        // 1. Different ways creating a string
        System.out.println("1. Different ways of creating a string:");
        String str1 = "Hello World";                    // Using string literal
        String str2 = new String("Hello World");        // Using new keyword
        char[] charArray = {'H', 'e', 'l', 'l', 'o'};   // Using character array
        String str3 = new String(charArray);
        
        System.out.println("String literal: " + str1);
        System.out.println("Using new keyword: " + str2);
        System.out.println("From character array: " + str3);
        
        // 2. Concatenating two strings using + operator
        System.out.println("\n2. Concatenating two strings using + operator:");
        String firstName = "John";
        String lastName = "Doe";
        String fullName = firstName + " " + lastName;
        System.out.println("Full name: " + fullName);
        
        // 3. Finding the length of the string
        System.out.println("\n3. Finding the length of the string:");
        String text = "Java Programming";
        System.out.println("Text: " + text);
        System.out.println("Length: " + text.length());
        
        // 4. Extract a string using Substring
        System.out.println("\n4. Extract a string using Substring:");
        String originalString = "Hello World";
        String subString = originalString.substring(0, 5);  // Extract "Hello"
        System.out.println("Original string: " + originalString);
        System.out.println("Substring (0,5): " + subString);
        
        // 5. Searching in strings using indexOf()
        System.out.println("\n5. Searching in strings using indexOf():");
        String searchStr = "Hello World";
        int index = searchStr.indexOf('W');
        System.out.println("String: " + searchStr);
        System.out.println("Index of 'W': " + index);
        
        // 6. Matching a String Against a Regular Expression With matches()
        System.out.println("\n6. Matching a String Against a Regular Expression With matches():");
        String email = "test@example.com";
        String phone = "123-456-7890";
        String emailPattern = "^[a-zA-Z0-9+_.-]+@[a-zA-Z0-9.-]+$";
        String phonePattern = "\\d{3}-\\d{3}-\\d{4}";
        
        System.out.println("Email: " + email + " matches email pattern: " + email.matches(emailPattern));
        System.out.println("Phone: " + phone + " matches phone pattern: " + phone.matches(phonePattern));
        
        // 7. Comparing strings using the methods equals()
        System.out.println("\n7. Comparing strings using equals():");
        String strA = "Hello";
        String strB = "Hello";
        String strC = "hello";
        System.out.println("strA.equals(strB): " + strA.equals(strB));
        System.out.println("strA.equals(strC): " + strA.equals(strC));
        
        // 8. equalsIgnoreCase(), startsWith(), endsWith() and compareTo()
        System.out.println("\n8. equalsIgnoreCase(), startsWith(), endsWith() and compareTo():");
        System.out.println("strA.equalsIgnoreCase(strC): " + strA.equalsIgnoreCase(strC));
        System.out.println("strA.startsWith('H'): " + strA.startsWith("H"));
        System.out.println("strA.endsWith('o'): " + strA.endsWith("o"));
        System.out.println("strA.compareTo(strC): " + strA.compareTo(strC));
        
        // 9. Trimming strings with trim()
        System.out.println("\n9. Trimming strings with trim():");
        String withSpaces = "  Hello World  ";
        System.out.println("Original: '" + withSpaces + "'");
        System.out.println("Trimmed: '" + withSpaces.trim() + "'");
        
        // 10. Replacing characters in strings with replace()
        System.out.println("\n10. Replacing characters in strings with replace():");
        String original = "Hello World";
        String replaced = original.replace('l', 'x');
        System.out.println("Original: " + original);
        System.out.println("After replacing 'l' with 'x': " + replaced);
        
        // 11. Splitting strings with split()
        System.out.println("\n11. Splitting strings with split():");
        String sentence = "Hello,World,Java,Programming";
        String[] parts = sentence.split(",");
        System.out.print("Split result: ");
        for(String part : parts) {
            System.out.print(part + " ");
        }
        System.out.println();
        
        // 12. Converting Numbers to Strings with valueOf()
        System.out.println("\n12. Converting Numbers to Strings with valueOf():");
        int num = 123;
        double decimal = 45.67;
        String numStr = String.valueOf(num);
        String decimalStr = String.valueOf(decimal);
        System.out.println("Number " + num + " as string: " + numStr + " (type: " + numStr.getClass().getSimpleName() + ")");
        System.out.println("Decimal " + decimal + " as string: " + decimalStr + " (type: " + decimalStr.getClass().getSimpleName() + ")");
        
        // 13. Converting integer objects to Strings
        System.out.println("\n13. Converting integer objects to Strings:");
        Integer integerObj = 456;
        String integerStr = integerObj.toString();
        System.out.println("Integer object " + integerObj + " as string: " + integerStr + " (type: " + integerStr.getClass().getSimpleName() + ")");
        
        // 14. Converting to uppercase and lowercase
        System.out.println("\n14. Converting to uppercase and lowercase:");
        String mixedCase = "Hello World";
        System.out.println("Original: " + mixedCase);
        System.out.println("Uppercase: " + mixedCase.toUpperCase());
        System.out.println("Lowercase: " + mixedCase.toLowerCase());
    }
}