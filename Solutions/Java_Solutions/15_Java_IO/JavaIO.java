import java.io.*;
import java.util.Properties;

public class JavaIO {
    public static void main(String[] args) {
        System.out.println("=== Java IO Assignments ===\n");
        
        String fileName = "sample.txt";
        String propertiesFile = "config.properties";
        
        // 2. Write text to .txt file using OutputStream
        System.out.println("2. Writing text to .txt file using OutputStream:");
        writeWithOutputStream(fileName, "Hello from OutputStream!\nThis is a test file.");
        
        // 1. Read text from .txt file using InputStream
        System.out.println("\n1. Reading text from .txt file using InputStream:");
        readWithInputStream(fileName);
        
        // 4. Write text to .txt file using BufferedOutputStream
        System.out.println("\n4. Writing text to .txt file using BufferedOutputStream:");
        writeWithBufferedOutputStream(fileName, "Hello from BufferedOutputStream!\nThis is another test.");
        
        // 3. Read text from .txt file using BufferedInputStream
        System.out.println("\n3. Reading text from .txt file using BufferedInputStream:");
        readWithBufferedInputStream(fileName);
        
        // 6. Write text to .txt file using FileWriter
        System.out.println("\n6. Writing text to .txt file using FileWriter:");
        writeWithFileWriter(fileName, "Hello from FileWriter!\nWriting character data.");
        
        // 5. Read text from .txt file using FileReader
        System.out.println("\n5. Reading text from .txt file using FileReader:");
        readWithFileReader(fileName);
        
        // 8. Write text to .txt file using BufferedWriter
        System.out.println("\n8. Writing text to .txt file using BufferedWriter:");
        writeWithBufferedWriter(fileName, "Hello from BufferedWriter!\nEfficient character writing.");
        
        // 7. Read text from .txt file using BufferedReader
        System.out.println("\n7. Reading text from .txt file using BufferedReader:");
        readWithBufferedReader(fileName);
        
        // 9. Read data from properties file
        System.out.println("\n9. Writing and reading from properties file:");
        writePropertiesFile(propertiesFile);
        readPropertiesFile(propertiesFile);
    }
    
    // 2. Write text to .txt file using OutputStream
    public static void writeWithOutputStream(String fileName, String content) {
        try (OutputStream os = new FileOutputStream(fileName)) {
            byte[] data = content.getBytes();
            os.write(data);
            os.flush();
            System.out.println("Successfully wrote to file using OutputStream");
        } catch (IOException e) {
            System.out.println("Error writing with OutputStream: " + e.getMessage());
        }
    }
    
    // 1. Read text from .txt file using InputStream
    public static void readWithInputStream(String fileName) {
        try (InputStream is = new FileInputStream(fileName)) {
            int byteData;
            StringBuilder content = new StringBuilder();
            while ((byteData = is.read()) != -1) {
                content.append((char) byteData);
            }
            System.out.println(content.toString());
        } catch (IOException e) {
            System.out.println("Error reading with InputStream: " + e.getMessage());
        }
    }
    
    // 4. Write text to .txt file using BufferedOutputStream
    public static void writeWithBufferedOutputStream(String fileName, String content) {
        try (BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(fileName))) {
            byte[] data = content.getBytes();
            bos.write(data);
            bos.flush();
            System.out.println("Successfully wrote to file using BufferedOutputStream");
        } catch (IOException e) {
            System.out.println("Error writing with BufferedOutputStream: " + e.getMessage());
        }
    }
    
    // 3. Read text from .txt file using BufferedInputStream
    public static void readWithBufferedInputStream(String fileName) {
        try (BufferedInputStream bis = new BufferedInputStream(new FileInputStream(fileName))) {
            int byteData;
            StringBuilder content = new StringBuilder();
            while ((byteData = bis.read()) != -1) {
                content.append((char) byteData);
            }
            System.out.println(content.toString());
        } catch (IOException e) {
            System.out.println("Error reading with BufferedInputStream: " + e.getMessage());
        }
    }
    
    // 6. Write text to .txt file using FileWriter
    public static void writeWithFileWriter(String fileName, String content) {
        try (FileWriter fw = new FileWriter(fileName)) {
            fw.write(content);
            fw.flush();
            System.out.println("Successfully wrote to file using FileWriter");
        } catch (IOException e) {
            System.out.println("Error writing with FileWriter: " + e.getMessage());
        }
    }
    
    // 5. Read text from .txt file using FileReader
    public static void readWithFileReader(String fileName) {
        try (FileReader fr = new FileReader(fileName)) {
            int charData;
            StringBuilder content = new StringBuilder();
            while ((charData = fr.read()) != -1) {
                content.append((char) charData);
            }
            System.out.println(content.toString());
        } catch (IOException e) {
            System.out.println("Error reading with FileReader: " + e.getMessage());
        }
    }
    
    // 8. Write text to .txt file using BufferedWriter
    public static void writeWithBufferedWriter(String fileName, String content) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(fileName))) {
            bw.write(content);
            bw.flush();
            System.out.println("Successfully wrote to file using BufferedWriter");
        } catch (IOException e) {
            System.out.println("Error writing with BufferedWriter: " + e.getMessage());
        }
    }
    
    // 7. Read text from .txt file using BufferedReader
    public static void readWithBufferedReader(String fileName) {
        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = br.readLine()) != null) {
                System.out.println(line);
            }
        } catch (IOException e) {
            System.out.println("Error reading with BufferedReader: " + e.getMessage());
        }
    }
    
    // 9. Write to properties file
    public static void writePropertiesFile(String fileName) {
        try (OutputStream output = new FileOutputStream(fileName)) {
            Properties prop = new Properties();
            
            // Set properties
            prop.setProperty("database.url", "jdbc:mysql://localhost:3306/mydb");
            prop.setProperty("database.user", "admin");
            prop.setProperty("database.password", "password123");
            
            // Save properties to file
            prop.store(output, null);
            System.out.println("Properties file created successfully");
        } catch (IOException e) {
            System.out.println("Error writing properties file: " + e.getMessage());
        }
    }
    
    // 9. Read from properties file
    public static void readPropertiesFile(String fileName) {
        try (InputStream input = new FileInputStream(fileName)) {
            Properties prop = new Properties();
            
            // Load properties from file
            prop.load(input);
            
            // Get properties values
            String url = prop.getProperty("database.url");
            String user = prop.getProperty("database.user");
            String password = prop.getProperty("database.password");
            
            System.out.println("Database URL: " + url);
            System.out.println("Database User: " + user);
            System.out.println("Database Password: " + password);
        } catch (IOException e) {
            System.out.println("Error reading properties file: " + e.getMessage());
        }
    }
}