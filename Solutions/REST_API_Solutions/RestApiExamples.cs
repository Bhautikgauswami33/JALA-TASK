using System;
using System.Net.Http;
using System.Text;
using System.Threading.Tasks;
using Newtonsoft.Json;

public class RestApiExamples
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
    
    // PUT request example
    public static async Task<string> PutApiDataAsync(string apiUrl, object data)
    {
        try
        {
            string jsonData = JsonConvert.SerializeObject(data);
            var content = new StringContent(jsonData, Encoding.UTF8, "application/json");
            
            client.DefaultRequestHeaders.Clear();
            client.DefaultRequestHeaders.Add("Accept", "application/json");
            
            HttpResponseMessage response = await client.PutAsync(apiUrl, content);
            
            if (response.IsSuccessStatusCode)
            {
                Console.WriteLine($"PUT Response Code: {(int)response.StatusCode}");
                string responseContent = await response.Content.ReadAsStringAsync();
                Console.WriteLine("PUT Response: " + responseContent);
                return responseContent;
            }
            else
            {
                Console.WriteLine($"PUT request failed with status code: {(int)response.StatusCode}");
                return null;
            }
        }
        catch (Exception ex)
        {
            Console.WriteLine($"PUT request failed: {ex.Message}");
            return null;
        }
    }
    
    // DELETE request example
    public static async Task<bool> DeleteApiDataAsync(string apiUrl)
    {
        try
        {
            client.DefaultRequestHeaders.Clear();
            client.DefaultRequestHeaders.Add("Accept", "application/json");
            
            HttpResponseMessage response = await client.DeleteAsync(apiUrl);
            
            if (response.IsSuccessStatusCode)
            {
                Console.WriteLine($"DELETE Response Code: {(int)response.StatusCode}");
                Console.WriteLine("DELETE request successful");
                return true;
            }
            else
            {
                Console.WriteLine($"DELETE request failed with status code: {(int)response.StatusCode}");
                return false;
            }
        }
        catch (Exception ex)
        {
            Console.WriteLine($"DELETE request failed: {ex.Message}");
            return false;
        }
    }
    
    public static async Task Main(string[] args)
    {
        Console.WriteLine("=== REST API Examples in C# ===\n");
        
        // Example GET request
        Console.WriteLine("1. Performing GET request:");
        var getResponse = await GetApiDataAsync("https://jsonplaceholder.typicode.com/posts/1");
        Console.WriteLine();
        
        // Example POST request
        Console.WriteLine("2. Performing POST request:");
        var postData = new
        {
            title = "My Post",
            body = "This is the post content",
            userId = 1
        };
        
        var postResponse = await PostApiDataAsync("https://jsonplaceholder.typicode.com/posts", postData);
        Console.WriteLine();
        
        // Example PUT request (updating the first post)
        Console.WriteLine("3. Performing PUT request:");
        var putData = new
        {
            id = 1,
            title = "Updated Post Title",
            body = "This is the updated post content",
            userId = 1
        };
        
        var putResponse = await PutApiDataAsync("https://jsonplaceholder.typicode.com/posts/1", putData);
        Console.WriteLine();
        
        // Example DELETE request
        Console.WriteLine("4. Performing DELETE request:");
        var deleteResult = await DeleteApiDataAsync("https://jsonplaceholder.typicode.com/posts/1");
        Console.WriteLine($"DELETE operation result: {deleteResult}");
        Console.WriteLine();
        
        // Example of error handling with non-existent resource
        Console.WriteLine("5. Performing GET request on non-existent resource:");
        var errorResponse = await GetApiDataAsync("https://jsonplaceholder.typicode.com/posts/999999");
        
        Console.WriteLine("\nREST API examples completed successfully!");
    }
}