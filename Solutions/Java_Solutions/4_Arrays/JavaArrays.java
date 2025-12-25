public class JavaArrays {
    public static void main(String[] args) {
        System.out.println("=== Java Arrays Assignments ===\n");
        
        // Initialize an array for testing
        int[] numbers = {5, 10, 15, 20, 25, 30, 15, 35, 40, 20};
        
        // 1. Write a function to add integer values of an array
        System.out.println("1. Sum of array elements: " + addArrayElements(numbers));
        
        // 2. Write a function to calculate the average value of an array of integers
        System.out.println("2. Average of array elements: " + calculateAverage(numbers));
        
        // 3. Write a program to find the index of an array element
        int searchElement = 20;
        System.out.println("3. Index of " + searchElement + " in array: " + findIndex(numbers, searchElement));
        
        // 4. Write a function to test if array contains a specific value
        int specificValue = 15;
        System.out.println("4. Array contains " + specificValue + ": " + containsValue(numbers, specificValue));
        
        // 5. Write a function to remove a specific element from an array
        int removeValue = 15;
        int[] newArray = removeElement(numbers, removeValue);
        System.out.print("5. Array after removing " + removeValue + ": ");
        printArray(newArray);
        
        // 6. Write a function to copy an array to another array
        int[] copiedArray = copyArray(numbers);
        System.out.print("6. Copied array: ");
        printArray(copiedArray);
        
        // 7. Write a function to insert an element at a specific position in the array
        int[] insertedArray = insertElement(numbers, 99, 2);
        System.out.print("7. Array after inserting 99 at index 2: ");
        printArray(insertedArray);
        
        // 8. Write a function to find the minimum and maximum value of an array
        int[] minMax = findMinMax(numbers);
        System.out.println("8. Minimum: " + minMax[0] + ", Maximum: " + minMax[1]);
        
        // 9. Write a function to reverse an array of integer values
        int[] reversedArray = reverseArray(numbers);
        System.out.print("9. Reversed array: ");
        printArray(reversedArray);
        
        // 10. Write a function to find the duplicate values of an array
        System.out.print("10. Duplicate values in array: ");
        findDuplicates(numbers);
        System.out.println();
        
        // 11. Write a program to find the common values between two arrays
        int[] array1 = {1, 2, 3, 4, 5};
        int[] array2 = {4, 5, 6, 7, 8};
        System.out.print("11. Common values between two arrays: ");
        findCommonValues(array1, array2);
        System.out.println();
        
        // 12. Write a method to remove duplicate elements from an array
        int[] withDuplicates = {1, 2, 2, 3, 4, 4, 5};
        int[] withoutDuplicates = removeDuplicates(withDuplicates);
        System.out.print("12. Array after removing duplicates: ");
        printArray(withoutDuplicates);
        
        // 13. Write a method to find the second largest number in an array
        int[] secondLargestTest = {10, 5, 20, 8, 15};
        System.out.println("13. Second largest number: " + findSecondLargest(secondLargestTest));
        
        // 15. Write a method to find number of even number and odd numbers in an array
        int[] evenOddTest = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        int[] evenOddCount = countEvenOdd(evenOddTest);
        System.out.println("15. Even numbers: " + evenOddCount[0] + ", Odd numbers: " + evenOddCount[1]);
        
        // 16. Write a function to get the difference of largest and smallest value
        System.out.println("16. Difference between largest and smallest: " + getDifferenceLargestSmallest(numbers));
        
        // 17. Write a method to verify if the array contains two specified elements(12,23)
        int[] containsTest = {10, 12, 15, 20, 23, 30};
        System.out.println("17. Array contains 12 and 23: " + containsTwoElements(containsTest, 12, 23));
    }
    
    // 1. Function to add integer values of an array
    public static int addArrayElements(int[] arr) {
        int sum = 0;
        for(int i = 0; i < arr.length; i++) {
            sum += arr[i];
        }
        return sum;
    }
    
    // 2. Function to calculate the average value of an array of integers
    public static double calculateAverage(int[] arr) {
        int sum = addArrayElements(arr);
        return (double)sum / arr.length;
    }
    
    // 3. Function to find the index of an array element
    public static int findIndex(int[] arr, int value) {
        for(int i = 0; i < arr.length; i++) {
            if(arr[i] == value) {
                return i;
            }
        }
        return -1; // Element not found
    }
    
    // 4. Function to test if array contains a specific value
    public static boolean containsValue(int[] arr, int value) {
        return findIndex(arr, value) != -1;
    }
    
    // 5. Function to remove a specific element from an array
    public static int[] removeElement(int[] arr, int value) {
        int count = 0;
        for(int i = 0; i < arr.length; i++) {
            if(arr[i] != value) {
                count++;
            }
        }
        
        int[] result = new int[count];
        int j = 0;
        for(int i = 0; i < arr.length; i++) {
            if(arr[i] != value) {
                result[j] = arr[i];
                j++;
            }
        }
        
        return result;
    }
    
    // 6. Function to copy an array to another array
    public static int[] copyArray(int[] arr) {
        int[] copied = new int[arr.length];
        for(int i = 0; i < arr.length; i++) {
            copied[i] = arr[i];
        }
        return copied;
    }
    
    // 7. Function to insert an element at a specific position in the array
    public static int[] insertElement(int[] arr, int element, int position) {
        int[] result = new int[arr.length + 1];
        for(int i = 0; i < position; i++) {
            result[i] = arr[i];
        }
        result[position] = element;
        for(int i = position + 1; i < result.length; i++) {
            result[i] = arr[i - 1];
        }
        return result;
    }
    
    // 8. Function to find the minimum and maximum value of an array
    public static int[] findMinMax(int[] arr) {
        int min = arr[0];
        int max = arr[0];
        
        for(int i = 1; i < arr.length; i++) {
            if(arr[i] < min) {
                min = arr[i];
            }
            if(arr[i] > max) {
                max = arr[i];
            }
        }
        
        return new int[]{min, max};
    }
    
    // 9. Function to reverse an array of integer values
    public static int[] reverseArray(int[] arr) {
        int[] reversed = new int[arr.length];
        for(int i = 0; i < arr.length; i++) {
            reversed[i] = arr[arr.length - 1 - i];
        }
        return reversed;
    }
    
    // 10. Function to find the duplicate values of an array
    public static void findDuplicates(int[] arr) {
        for(int i = 0; i < arr.length; i++) {
            for(int j = i + 1; j < arr.length; j++) {
                if(arr[i] == arr[j]) {
                    System.out.print(arr[i] + " ");
                    break;
                }
            }
        }
    }
    
    // 11. Function to find the common values between two arrays
    public static void findCommonValues(int[] arr1, int[] arr2) {
        for(int i = 0; i < arr1.length; i++) {
            for(int j = 0; j < arr2.length; j++) {
                if(arr1[i] == arr2[j]) {
                    System.out.print(arr1[i] + " ");
                    break;
                }
            }
        }
    }
    
    // 12. Method to remove duplicate elements from an array
    public static int[] removeDuplicates(int[] arr) {
        int[] temp = new int[arr.length];
        int j = 0;
        
        for(int i = 0; i < arr.length - 1; i++) {
            if(arr[i] != arr[i + 1]) {
                temp[j++] = arr[i];
            }
        }
        temp[j++] = arr[arr.length - 1];
        
        int[] result = new int[j];
        for(int i = 0; i < j; i++) {
            result[i] = temp[i];
        }
        
        return result;
    }
    
    // 13. Method to find the second largest number in an array
    public static int findSecondLargest(int[] arr) {
        int largest = arr[0];
        int secondLargest = arr[0];
        
        for(int i = 1; i < arr.length; i++) {
            if(arr[i] > largest) {
                secondLargest = largest;
                largest = arr[i];
            } else if(arr[i] > secondLargest && arr[i] != largest) {
                secondLargest = arr[i];
            }
        }
        
        return secondLargest;
    }
    
    // 15. Method to find number of even number and odd numbers in an array
    public static int[] countEvenOdd(int[] arr) {
        int evenCount = 0;
        int oddCount = 0;
        
        for(int i = 0; i < arr.length; i++) {
            if(arr[i] % 2 == 0) {
                evenCount++;
            } else {
                oddCount++;
            }
        }
        
        return new int[]{evenCount, oddCount};
    }
    
    // 16. Function to get the difference of largest and smallest value
    public static int getDifferenceLargestSmallest(int[] arr) {
        int[] minMax = findMinMax(arr);
        return minMax[1] - minMax[0]; // max - min
    }
    
    // 17. Method to verify if the array contains two specified elements(12,23)
    public static boolean containsTwoElements(int[] arr, int element1, int element2) {
        boolean found1 = false, found2 = false;
        
        for(int i = 0; i < arr.length; i++) {
            if(arr[i] == element1) found1 = true;
            if(arr[i] == element2) found2 = true;
        }
        
        return found1 && found2;
    }
    
    // Helper method to print array
    public static void printArray(int[] arr) {
        for(int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }
}