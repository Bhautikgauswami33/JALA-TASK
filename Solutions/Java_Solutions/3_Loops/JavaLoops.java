public class JavaLoops {
    public static void main(String[] args) {
        System.out.println("=== Java Loops Assignments ===\n");
        
        // 1. Write a program to print "Bright IT Career" ten times using for loop
        System.out.println("1. Print 'Bright IT Career' ten times using for loop:");
        for(int i = 0; i < 10; i++) {
            System.out.println("Bright IT Career");
        }
        
        // 2. Write a java program to print 1 to 20 numbers using the while loop
        System.out.println("\n2. Print 1 to 20 using while loop:");
        int j = 1;
        while(j <= 20) {
            System.out.print(j + " ");
            j++;
        }
        System.out.println();
        
        // 3. Program to equal operator and not equal operators
        System.out.println("\n3. Equal and not equal operators:");
        int a = 10, b = 20;
        if(a == b) {
            System.out.println("a is equal to b");
        } else {
            System.out.println("a is not equal to b");
        }
        
        // 4. Write a program to print the odd and even numbers
        System.out.println("\n4. Odd and even numbers from 1 to 10:");
        System.out.print("Even numbers: ");
        for(int i = 1; i <= 10; i++) {
            if(i % 2 == 0) {
                System.out.print(i + " ");
            }
        }
        System.out.print("\nOdd numbers: ");
        for(int i = 1; i <= 10; i++) {
            if(i % 2 != 0) {
                System.out.print(i + " ");
            }
        }
        System.out.println();
        
        // 5. Write a program to print largest number among three numbers
        System.out.println("\n5. Largest number among three numbers:");
        int x = 10, y = 25, z = 15;
        int largest = x;
        if(y > largest) largest = y;
        if(z > largest) largest = z;
        System.out.println("Largest among " + x + ", " + y + ", " + z + " is: " + largest);
        
        // 6. Write a program to print even number between 10 and 100 using while
        System.out.println("\n6. Even numbers between 10 and 100:");
        int num = 10;
        while(num <= 100) {
            if(num % 2 == 0) {
                System.out.print(num + " ");
            }
            num++;
        }
        System.out.println();
        
        // 7. Write a program to print 1 to 10 using the do-while loop statement
        System.out.println("\n7. Print 1 to 10 using do-while loop:");
        int k = 1;
        do {
            System.out.print(k + " ");
            k++;
        } while(k <= 10);
        System.out.println();
        
        // 8. Write a program to find Armstrong number or not
        System.out.println("\n8. Armstrong number check:");
        int armstrongNum = 153;
        if(isArmstrong(armstrongNum)) {
            System.out.println(armstrongNum + " is an Armstrong number");
        } else {
            System.out.println(armstrongNum + " is not an Armstrong number");
        }
        
        // 9. Write a program to find the prime or not
        System.out.println("\n9. Prime number check:");
        int primeNum = 17;
        if(isPrime(primeNum)) {
            System.out.println(primeNum + " is a prime number");
        } else {
            System.out.println(primeNum + " is not a prime number");
        }
        
        // 10. Write a program to palindrome or not
        System.out.println("\n10. Palindrome check:");
        int palindromeNum = 121;
        if(isPalindrome(palindromeNum)) {
            System.out.println(palindromeNum + " is a palindrome");
        } else {
            System.out.println(palindromeNum + " is not a palindrome");
        }
        
        // 11. Program to check whether a number is EVEN or ODD using switch
        System.out.println("\n11. Check if number is EVEN or ODD using switch:");
        int checkNum = 8;
        switch(checkNum % 2) {
            case 0:
                System.out.println(checkNum + " is EVEN");
                break;
            case 1:
                System.out.println(checkNum + " is ODD");
                break;
        }
        
        // 12. Print gender (Male/Female) program according to given M/F using switch
        System.out.println("\n12. Gender identification using switch:");
        char gender = 'M';
        switch(gender) {
            case 'M':
            case 'm':
                System.out.println("Male");
                break;
            case 'F':
            case 'f':
                System.out.println("Female");
                break;
            default:
                System.out.println("Invalid input");
        }
        
        // 13. Program for multiple if else statement (Largest number in 10,20 and 30)
        System.out.println("\n13. Largest number in 10, 20 and 30:");
        int p = 10, q = 20, r = 30;
        if(p >= q && p >= r) {
            System.out.println(p + " is the largest");
        } else if(q >= p && q >= r) {
            System.out.println(q + " is the largest");
        } else {
            System.out.println(r + " is the largest");
        }
    }
    
    // Method to check if a number is Armstrong
    public static boolean isArmstrong(int num) {
        int original = num;
        int sum = 0;
        int digits = String.valueOf(num).length();
        
        while(num > 0) {
            int digit = num % 10;
            sum += Math.pow(digit, digits);
            num /= 10;
        }
        
        return sum == original;
    }
    
    // Method to check if a number is prime
    public static boolean isPrime(int num) {
        if(num <= 1) return false;
        for(int i = 2; i <= Math.sqrt(num); i++) {
            if(num % i == 0) return false;
        }
        return true;
    }
    
    // Method to check if a number is palindrome
    public static boolean isPalindrome(int num) {
        int original = num;
        int reversed = 0;
        
        while(num > 0) {
            int digit = num % 10;
            reversed = reversed * 10 + digit;
            num /= 10;
        }
        
        return original == reversed;
    }
}