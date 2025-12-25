import java.util.*;

public class JavaCollections {
    public static void main(String[] args) {
        System.out.println("=== Java Collections Assignments ===\n");
        
        // 1. ArrayList operations
        System.out.println("1. ArrayList Operations:");
        ArrayList<String> arrayList = new ArrayList<>();
        
        // Add 10 string elements to ArrayList
        String[] elements = {"Apple", "Banana", "Cherry", "Date", "Elderberry", 
                            "Fig", "Grape", "Honeydew", "Kiwi", "Lemon"};
        
        for(String element : elements) {
            arrayList.add(element);
        }
        
        System.out.println("Initial ArrayList: " + arrayList);
        
        // Add an element to the ArrayList
        arrayList.add("Mango");
        System.out.println("After adding 'Mango': " + arrayList);
        
        // Iterate through the ArrayList by using Iterator object
        System.out.print("Iterating using Iterator: ");
        Iterator<String> iterator = arrayList.iterator();
        while(iterator.hasNext()) {
            System.out.print(iterator.next() + " ");
        }
        System.out.println();
        
        // Add an element at a specific index
        arrayList.add(2, "Blueberry");
        System.out.println("After adding 'Blueberry' at index 2: " + arrayList);
        
        // Remove an element from the ArrayList
        arrayList.remove("Date");
        System.out.println("After removing 'Date': " + arrayList);
        
        // Remove at an index
        arrayList.remove(0);
        System.out.println("After removing element at index 0: " + arrayList);
        
        // Update the element at a specific index
        arrayList.set(1, "Raspberry");
        System.out.println("After updating element at index 1 to 'Raspberry': " + arrayList);
        
        // Check the element is present at a particular index
        System.out.println("Element at index 2 is 'Raspberry': " + arrayList.get(2).equals("Raspberry"));
        
        // Get an element at a particular index
        System.out.println("Element at index 3: " + arrayList.get(3));
        
        // Find out the size of the ArrayList
        System.out.println("Size of ArrayList: " + arrayList.size());
        
        // Check the given element is present in the ArrayList
        System.out.println("Is 'Cherry' in ArrayList: " + arrayList.contains("Cherry"));
        
        // Remove all elements of the ArrayList
        ArrayList<String> backupList = new ArrayList<>(arrayList); // Keep a backup
        arrayList.clear();
        System.out.println("After clearing ArrayList: " + arrayList);
        
        // Restore the list for further operations
        arrayList.addAll(backupList);
        System.out.println("Restored ArrayList: " + arrayList);
        
        System.out.println(); // Empty line for separation
        
        // 2. HashMap operations
        System.out.println("2. HashMap Operations:");
        HashMap<Integer, String> studentMap = new HashMap<>();
        
        // Create a HashMap with at least 10 key value pairs of the Student ID and Name
        studentMap.put(101, "Alice");
        studentMap.put(102, "Bob");
        studentMap.put(103, "Charlie");
        studentMap.put(104, "Diana");
        studentMap.put(105, "Eve");
        studentMap.put(106, "Frank");
        studentMap.put(107, "Grace");
        studentMap.put(108, "Henry");
        studentMap.put(109, "Ivy");
        studentMap.put(110, "Jack");
        
        System.out.println("Initial HashMap: " + studentMap);
        
        // Insert a Key value mapping into the map
        studentMap.put(111, "Kate");
        System.out.println("After adding (111, 'Kate'): " + studentMap);
        
        // Fetch the value of a Key
        System.out.println("Value for key 105: " + studentMap.get(105));
        
        // Create a clone/copy of HashMap
        HashMap<Integer, String> clonedMap = (HashMap<Integer, String>) studentMap.clone();
        System.out.println("Cloned HashMap: " + clonedMap);
        
        // Check if the given Key is in the Map
        System.out.println("Is key 107 in the map: " + studentMap.containsKey(107));
        
        // Check if the value is in the Map
        System.out.println("Is 'Henry' in the map: " + studentMap.containsValue("Henry"));
        
        // Check if the map is empty
        System.out.println("Is map empty: " + studentMap.isEmpty());
        
        // Print the size of the Map to the console
        System.out.println("Size of map: " + studentMap.size());
        
        // Print all the Keys of the map to the console
        System.out.println("All keys: " + studentMap.keySet());
        
        // Remove a specific Key-value pair
        studentMap.remove(110);
        System.out.println("After removing key 110: " + studentMap);
        
        // Copy all the elements of the Map to another Map
        HashMap<Integer, String> newMap = new HashMap<>();
        newMap.putAll(studentMap);
        System.out.println("Copied to new map: " + newMap);
        
        System.out.println(); // Empty line for separation
        
        // 3. HashSet operations
        System.out.println("3. HashSet Operations:");
        HashSet<String> hashSet = new HashSet<>();
        
        // Create a HashSet with at least 10 elements of type String
        String[] hashElements = {"Red", "Blue", "Green", "Yellow", "Orange", 
                                "Purple", "Pink", "Brown", "Black", "White"};
        
        for(String element : hashElements) {
            hashSet.add(element);
        }
        
        System.out.println("Initial HashSet: " + hashSet);
        
        // Add an element
        hashSet.add("Cyan");
        System.out.println("After adding 'Cyan': " + hashSet);
        
        // Check if an element exists
        System.out.println("Is 'Red' in HashSet: " + hashSet.contains("Red"));
        
        // Remove an element
        hashSet.remove("Brown");
        System.out.println("After removing 'Brown': " + hashSet);
        
        // Size of HashSet
        System.out.println("Size of HashSet: " + hashSet.size());
        
        // Check if HashSet is empty
        System.out.println("Is HashSet empty: " + hashSet.isEmpty());
        
        // Iterate through HashSet
        System.out.print("Iterating through HashSet: ");
        for(String element : hashSet) {
            System.out.print(element + " ");
        }
        System.out.println();
        
        // Convert HashSet to Array
        Object[] array = hashSet.toArray();
        System.out.println("HashSet as Array: " + Arrays.toString(array));
        
        // Clear all elements
        HashSet<String> backupSet = new HashSet<>(hashSet); // Keep backup
        hashSet.clear();
        System.out.println("After clearing HashSet: " + hashSet);
        
        // Restore and demonstrate retainAll
        hashSet.addAll(backupSet);
        HashSet<String> retainSet = new HashSet<>();
        retainSet.add("Red");
        retainSet.add("Blue");
        retainSet.add("Green");
        hashSet.retainAll(retainSet);
        System.out.println("After retaining only Red, Blue, Green: " + hashSet);
        
        System.out.println("\nAll collections operations completed!");
    }
}