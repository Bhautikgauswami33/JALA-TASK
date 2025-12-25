# REST API Consumption Examples

## Java Example - Using HttpURLConnection

```java
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.StandardCharsets;

public class RestApiClient {
    
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
    
    public static void main(String[] args) {
        try {
            // Example GET request
            String getResponse = getApiData("https://jsonplaceholder.typicode.com/posts/1");
            System.out.println("GET Response: " + getResponse);
            
            // Example POST request
            String postData = "{\n" +
                            "  \"title\": \"My Post\",\n" +
                            "  \"body\": \"This is the post content\",\n" +
                            "  \"userId\": 1\n" +
                            "}";
            String postResponse = postApiData("https://jsonplaceholder.typicode.com/posts", postData);
            System.out.println("POST Response: " + postResponse);
            
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
```

## JavaScript Example - Using Fetch API

```javascript
// GET request example
async function getApiData(url) {
    try {
        const response = await fetch(url, {
            method: 'GET',
            headers: {
                'Content-Type': 'application/json',
            }
        });
        
        if (!response.ok) {
            throw new Error(`HTTP error! status: ${response.status}`);
        }
        
        const data = await response.json();
        console.log('GET Response:', data);
        return data;
    } catch (error) {
        console.error('GET request failed:', error);
        throw error;
    }
}

// POST request example
async function postApiData(url, data) {
    try {
        const response = await fetch(url, {
            method: 'POST',
            headers: {
                'Content-Type': 'application/json',
            },
            body: JSON.stringify(data)
        });
        
        if (!response.ok) {
            throw new Error(`HTTP error! status: ${response.status}`);
        }
        
        const result = await response.json();
        console.log('POST Response:', result);
        return result;
    } catch (error) {
        console.error('POST request failed:', error);
        throw error;
    }
}

// Example usage
getApiData('https://jsonplaceholder.typicode.com/posts/1')
    .then(data => console.log('Data retrieved:', data));

postApiData('https://jsonplaceholder.typicode.com/posts', {
    title: 'My Post',
    body: 'This is the post content',
    userId: 1
}).then(result => console.log('Post created:', result));
```

## Python Example - Using Requests Library

```python
import requests
import json

# GET request example
def get_api_data(url):
    try:
        headers = {
            'Content-Type': 'application/json',
            'Accept': 'application/json'
        }
        
        response = requests.get(url, headers=headers)
        
        if response.status_code == 200:
            print(f"GET Response Code: {response.status_code}")
            data = response.json()
            print("GET Response:", data)
            return data
        else:
            print(f"GET request failed with status code: {response.status_code}")
            return None
    except requests.exceptions.RequestException as e:
        print(f"GET request failed: {e}")
        return None

# POST request example
def post_api_data(url, data):
    try:
        headers = {
            'Content-Type': 'application/json',
            'Accept': 'application/json'
        }
        
        response = requests.post(url, headers=headers, json=data)
        
        if response.status_code in [200, 201]:
            print(f"POST Response Code: {response.status_code}")
            result = response.json()
            print("POST Response:", result)
            return result
        else:
            print(f"POST request failed with status code: {response.status_code}")
            return None
    except requests.exceptions.RequestException as e:
        print(f"POST request failed: {e}")
        return None

# Example usage
if __name__ == "__main__":
    # GET request
    get_response = get_api_data("https://jsonplaceholder.typicode.com/posts/1")
    
    # POST request
    post_data = {
        "title": "My Post",
        "body": "This is the post content",
        "userId": 1
    }
    post_response = post_api_data("https://jsonplaceholder.typicode.com/posts", post_data)
```

## C# Example - Using HttpClient

```csharp
using System;
using System.Net.Http;
using System.Text;
using System.Threading.Tasks;
using Newtonsoft.Json;

public class RestApiClient
{
    private static readonly HttpClient client = new HttpClient();
    
    // GET request example
    public static async Task<string> GetApiDataAsync(string apiUrl)
    {
        try
        {
            client.DefaultRequestHeaders.Clear();
            client.DefaultRequestHeaders.Add("Accept", "application/json");
            
            HttpResponseMessage response = await client.GetAsync(apiUrl);
            
            if (response.IsSuccessStatusCode)
            {
                Console.WriteLine($"GET Response Code: {(int)response.StatusCode}");
                string responseContent = await response.Content.ReadAsStringAsync();
                Console.WriteLine("GET Response: " + responseContent);
                return responseContent;
            }
            else
            {
                Console.WriteLine($"GET request failed with status code: {(int)response.StatusCode}");
                return null;
            }
        }
        catch (Exception ex)
        {
            Console.WriteLine($"GET request failed: {ex.Message}");
            return null;
        }
    }
    
    // POST request example
    public static async Task<string> PostApiDataAsync(string apiUrl, object data)
    {
        try
        {
            string jsonData = JsonConvert.SerializeObject(data);
            var content = new StringContent(jsonData, Encoding.UTF8, "application/json");
            
            client.DefaultRequestHeaders.Clear();
            client.DefaultRequestHeaders.Add("Accept", "application/json");
            
            HttpResponseMessage response = await client.PostAsync(apiUrl, content);
            
            if (response.IsSuccessStatusCode)
            {
                Console.WriteLine($"POST Response Code: {(int)response.StatusCode}");
                string responseContent = await response.Content.ReadAsStringAsync();
                Console.WriteLine("POST Response: " + responseContent);
                return responseContent;
            }
            else
            {
                Console.WriteLine($"POST request failed with status code: {(int)response.StatusCode}");
                return null;
            }
        }
        catch (Exception ex)
        {
            Console.WriteLine($"POST request failed: {ex.Message}");
            return null;
        }
    }
    
    public static async Task Main(string[] args)
    {
        // GET request
        var getResponse = await GetApiDataAsync("https://jsonplaceholder.typicode.com/posts/1");
        
        // POST request
        var postData = new
        {
            title = "My Post",
            body = "This is the post content",
            userId = 1
        };
        
        var postResponse = await PostApiDataAsync("https://jsonplaceholder.typicode.com/posts", postData);
    }
}
```