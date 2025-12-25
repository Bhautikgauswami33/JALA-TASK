import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.StandardCharsets;

public class RestApiExamples {
    
    // GET request example
    public static String getApiData(String apiUrl) throws Exception {
        URL url = new URL(apiUrl);
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        
        // Set request method
        connection.setRequestMethod("GET");
        
        // Set headers
        connection.setRequestProperty("Content-Type", "application/json");
        connection.setRequestProperty("Accept", "application/json");
        
        // Get response
        int responseCode = connection.getResponseCode();
        System.out.println("GET Response Code: " + responseCode);
        
        if (responseCode == HttpURLConnection.HTTP_OK) {
            BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            String inputLine;
            StringBuilder response = new StringBuilder();
            
            while ((inputLine = in.readLine()) != null) {
                response.append(inputLine);
            }
            in.close();
            
            return response.toString();
        } else {
            System.out.println("GET request failed");
            return null;
        }
    }
    
    // POST request example
    public static String postApiData(String apiUrl, String jsonData) throws Exception {
        URL url = new URL(apiUrl);
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        
        // Set request method
        connection.setRequestMethod("POST");
        
        // Set headers
        connection.setRequestProperty("Content-Type", "application/json");
        connection.setRequestProperty("Accept", "application/json");
        
        // Enable output
        connection.setDoOutput(true);
        
        // Send request body
        try (OutputStream os = connection.getOutputStream()) {
            byte[] input = jsonData.getBytes(StandardCharsets.UTF_8);
            os.write(input, 0, input.length);
        }
        
        // Get response
        int responseCode = connection.getResponseCode();
        System.out.println("POST Response Code: " + responseCode);
        
        if (responseCode == HttpURLConnection.HTTP_CREATED || 
            responseCode == HttpURLConnection.HTTP_OK) {
            BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            String inputLine;
            StringBuilder response = new StringBuilder();
            
            while ((inputLine = in.readLine()) != null) {
                response.append(inputLine);
            }
            in.close();
            
            return response.toString();
        } else {
            System.out.println("POST request failed");
            return null;
        }
    }
    
    // PUT request example
    public static String putApiData(String apiUrl, String jsonData) throws Exception {
        URL url = new URL(apiUrl);
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        
        // Set request method
        connection.setRequestMethod("PUT");
        
        // Set headers
        connection.setRequestProperty("Content-Type", "application/json");
        connection.setRequestProperty("Accept", "application/json");
        
        // Enable output
        connection.setDoOutput(true);
        
        // Send request body
        try (OutputStream os = connection.getOutputStream()) {
            byte[] input = jsonData.getBytes(StandardCharsets.UTF_8);
            os.write(input, 0, input.length);
        }
        
        // Get response
        int responseCode = connection.getResponseCode();
        System.out.println("PUT Response Code: " + responseCode);
        
        if (responseCode == HttpURLConnection.HTTP_OK) {
            BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            String inputLine;
            StringBuilder response = new StringBuilder();
            
            while ((inputLine = in.readLine()) != null) {
                response.append(inputLine);
            }
            in.close();
            
            return response.toString();
        } else {
            System.out.println("PUT request failed");
            return null;
        }
    }
    
    // DELETE request example
    public static boolean deleteApiData(String apiUrl) throws Exception {
        URL url = new URL(apiUrl);
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        
        // Set request method
        connection.setRequestMethod("DELETE");
        
        // Get response
        int responseCode = connection.getResponseCode();
        System.out.println("DELETE Response Code: " + responseCode);
        
        if (responseCode == HttpURLConnection.HTTP_OK || responseCode == HttpURLConnection.HTTP_NO_CONTENT) {
            System.out.println("DELETE request successful");
            return true;
        } else {
            System.out.println("DELETE request failed");
            return false;
        }
    }
    
    public static void main(String[] args) {
        try {
            System.out.println("=== REST API Examples ===\n");
            
            // Example GET request
            System.out.println("1. Performing GET request:");
            String getResponse = getApiData("https://jsonplaceholder.typicode.com/posts/1");
            System.out.println("GET Response: " + getResponse);
            System.out.println();
            
            // Example POST request
            System.out.println("2. Performing POST request:");
            String postData = "{\n" +
                            "  \"title\": \"My Post\",\n" +
                            "  \"body\": \"This is the post content\",\n" +
                            "  \"userId\": 1\n" +
                            "}";
            String postResponse = postApiData("https://jsonplaceholder.typicode.com/posts", postData);
            System.out.println("POST Response: " + postResponse);
            System.out.println();
            
            // Example PUT request (updating the first post)
            System.out.println("3. Performing PUT request:");
            String putData = "{\n" +
                           "  \"id\": 1,\n" +
                           "  \"title\": \"Updated Post Title\",\n" +
                           "  \"body\": \"This is the updated post content\",\n" +
                           "  \"userId\": 1\n" +
                           "}";
            String putResponse = putApiData("https://jsonplaceholder.typicode.com/posts/1", putData);
            System.out.println("PUT Response: " + putResponse);
            System.out.println();
            
            // Example DELETE request
            System.out.println("4. Performing DELETE request:");
            boolean deleteResult = deleteApiData("https://jsonplaceholder.typicode.com/posts/1");
            System.out.println("DELETE operation result: " + deleteResult);
            System.out.println();
            
            // Example of error handling with non-existent resource
            System.out.println("5. Performing GET request on non-existent resource:");
            String errorResponse = getApiData("https://jsonplaceholder.typicode.com/posts/999999");
            System.out.println("Error Response: " + errorResponse);
            
            System.out.println("\nREST API examples completed successfully!");
            
        } catch (Exception e) {
            System.out.println("An error occurred: " + e.getMessage());
            e.printStackTrace();
        }
    }
}