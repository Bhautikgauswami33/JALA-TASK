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
            print("GET Response:", json.dumps(data, indent=2))
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
            print("POST Response:", json.dumps(result, indent=2))
            return result
        else:
            print(f"POST request failed with status code: {response.status_code}")
            return None
    except requests.exceptions.RequestException as e:
        print(f"POST request failed: {e}")
        return None

# PUT request example
def put_api_data(url, data):
    try:
        headers = {
            'Content-Type': 'application/json',
            'Accept': 'application/json'
        }
        
        response = requests.put(url, headers=headers, json=data)
        
        if response.status_code == 200:
            print(f"PUT Response Code: {response.status_code}")
            result = response.json()
            print("PUT Response:", json.dumps(result, indent=2))
            return result
        else:
            print(f"PUT request failed with status code: {response.status_code}")
            return None
    except requests.exceptions.RequestException as e:
        print(f"PUT request failed: {e}")
        return None

# DELETE request example
def delete_api_data(url):
    try:
        response = requests.delete(url)
        
        if response.status_code in [200, 204]:
            print(f"DELETE Response Code: {response.status_code}")
            print("DELETE request successful")
            return True
        else:
            print(f"DELETE request failed with status code: {response.status_code}")
            return False
    except requests.exceptions.RequestException as e:
        print(f"DELETE request failed: {e}")
        return False

# Main execution
if __name__ == "__main__":
    print("=== REST API Examples in Python ===\n")
    
    # Example GET request
    print("1. Performing GET request:")
    get_response = get_api_data("https://jsonplaceholder.typicode.com/posts/1")
    print()
    
    # Example POST request
    print("2. Performing POST request:")
    post_data = {
        "title": "My Post",
        "body": "This is the post content",
        "userId": 1
    }
    post_response = post_api_data("https://jsonplaceholder.typicode.com/posts", post_data)
    print()
    
    # Example PUT request (updating the first post)
    print("3. Performing PUT request:")
    put_data = {
        "id": 1,
        "title": "Updated Post Title",
        "body": "This is the updated post content",
        "userId": 1
    }
    put_response = put_api_data("https://jsonplaceholder.typicode.com/posts/1", put_data)
    print()
    
    # Example DELETE request
    print("4. Performing DELETE request:")
    delete_result = delete_api_data("https://jsonplaceholder.typicode.com/posts/1")
    print()
    
    # Example of error handling with non-existent resource
    print("5. Performing GET request on non-existent resource:")
    error_response = get_api_data("https://jsonplaceholder.typicode.com/posts/999999")
    
    print("\nREST API examples completed successfully!")