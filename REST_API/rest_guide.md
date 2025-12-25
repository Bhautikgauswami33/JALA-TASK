# RESTful Web Services - Complete Guide

## What is REST?

REST (Representational State Transfer) is an architectural style for designing networked applications. It relies on a stateless, client-server, cacheable communications protocol, and in virtually all cases, the HTTP protocol is used.

## Key Principles of REST

### 1. Client-Server Architecture
- Separation of concerns between client and server
- Client handles user interface and user experience
- Server handles data storage and business logic
- Improves portability of client code and scalability of server components

### 2. Stateless
- Each request from client to server must contain all the information needed to understand and process the request
- Server doesn't store any client context between requests
- Improves reliability and scalability

### 3. Cacheable
- Responses must define themselves as cacheable or not
- Improves performance and reduces interactions

### 4. Uniform Interface
- Resource-based URLs
- Manipulation of resources through representations
- Self-descriptive messages
- Hypermedia as the engine of application state (HATEOAS)

### 5. Layered System
- Client cannot assume it's connected directly to the server
- Intermediary servers can improve system scalability

### 6. Code on Demand (Optional)
- Server can temporarily extend or customize client functionality
- Typically through downloadable code like JavaScript

## HTTP Methods (Verbs)

### GET
- Retrieve data from the server
- Should have no side effects
- Idempotent operation
- Example: GET /users - Get all users

### POST
- Create a new resource
- Non-idempotent operation
- Example: POST /users - Create a new user

### PUT
- Update an existing resource or create if it doesn't exist
- Idempotent operation
- Example: PUT /users/123 - Update user with ID 123

### PATCH
- Partial update of a resource
- Non-idempotent operation
- Example: PATCH /users/123 - Update specific fields of user with ID 123

### DELETE
- Delete a resource
- Idempotent operation
- Example: DELETE /users/123 - Delete user with ID 123

## HTTP Status Codes

### 1xx: Informational
- 100: Continue
- 101: Switching Protocols

### 2xx: Success
- 200: OK - Request successful
- 201: Created - Resource successfully created
- 202: Accepted - Request accepted but not yet processed
- 204: No Content - Request successful but no content to return

### 3xx: Redirection
- 301: Moved Permanently
- 304: Not Modified

### 4xx: Client Error
- 400: Bad Request - Invalid request syntax
- 401: Unauthorized - Authentication required
- 403: Forbidden - Access denied
- 404: Not Found - Resource doesn't exist
- 405: Method Not Allowed
- 409: Conflict - Resource conflict

### 5xx: Server Error
- 500: Internal Server Error
- 502: Bad Gateway
- 503: Service Unavailable
- 504: Gateway Timeout

## REST API Best Practices

### 1. Use Nouns Instead of Verbs
- Good: GET /users, POST /users
- Bad: GET /getUsers, POST /createUser

### 2. Use Plural Nouns
- Good: /users, /products
- Bad: /user, /product

### 3. Use HTTP Status Codes Appropriately
- 200 for successful GET requests
- 201 for successful POST requests
- 204 for successful DELETE requests
- 400 for bad requests
- 404 for not found
- 500 for server errors

### 4. Version Your APIs
- Include version in URL: /api/v1/users
- Or in headers: Accept: application/vnd.api+json;version=1

### 5. Use Proper Filtering, Sorting, and Pagination
- Filtering: /users?status=active
- Sorting: /users?sort=firstName,desc
- Pagination: /users?page=2&size=10

### 6. Use JSON for Request and Response Bodies
- Consistent data format
- Lightweight and widely supported

## Example REST API Endpoints

### User Management API
```
GET    /api/v1/users          # Get all users
GET    /api/v1/users/{id}     # Get user by ID
POST   /api/v1/users          # Create new user
PUT    /api/v1/users/{id}     # Update user by ID
DELETE /api/v1/users/{id}     # Delete user by ID
```

### Product Management API
```
GET    /api/v1/products                    # Get all products
GET    /api/v1/products/{id}              # Get product by ID
POST   /api/v1/products                   # Create new product
PUT    /api/v1/products/{id}              # Update product by ID
PATCH  /api/v1/products/{id}              # Partially update product
DELETE /api/v1/products/{id}              # Delete product by ID
GET    /api/v1/products?category=books    # Get products by category
```

## REST vs SOAP

| Feature | REST | SOAP |
|---------|------|------|
| Protocol | HTTP/HTTPS | HTTP/HTTPS, SMTP, TCP |
| Message Format | JSON, XML, HTML | XML |
| Speed | Faster | Slower |
| Flexibility | More flexible | Less flexible |
| Security | SSL/TLS | WS-Security |
| Caching | Can be cached | Cannot be cached |

## API Testing with Postman

### Key Features of Postman for API Testing:
1. Request building and sending
2. Response validation
3. Environment variables
4. Test scripts (JavaScript)
5. Collections and folders
6. Mock servers
7. Monitoring
8. Collaboration features

### Common Test Scenarios:
1. Status code validation
2. Response time validation
3. Response body validation
4. Response headers validation
5. Authentication testing
6. Error handling testing
7. Data validation testing

## Security Considerations

### 1. Authentication
- API Keys
- OAuth 2.0
- JWT (JSON Web Tokens)
- Basic Authentication (over HTTPS)

### 2. Authorization
- Role-based access control (RBAC)
- Scope-based access control

### 3. Rate Limiting
- Prevent API abuse
- Ensure fair usage

### 4. Input Validation
- Validate all input parameters
- Prevent injection attacks

### 5. HTTPS
- Always use HTTPS for sensitive data
- Encrypt data in transit

## Common REST API Frameworks

### Java
- Spring Boot with Spring MVC
- JAX-RS (Jersey, RESTEasy)
- Dropwizard

### Python
- Flask with Flask-RESTful
- Django REST Framework
- FastAPI

### Node.js
- Express.js
- Fastify
- Hapi

### C#
- ASP.NET Core Web API
- Web API with .NET Framework

## API Documentation

### OpenAPI (Swagger) Specification
- Standard for documenting REST APIs
- Machine-readable format
- Interactive documentation
- Code generation capabilities

### Key Documentation Elements:
1. API endpoints
2. HTTP methods
3. Request parameters
4. Request body format
5. Response format
6. Error responses
7. Authentication methods
8. Example requests and responses

## Testing REST APIs

### Types of API Testing:
1. Functional Testing
2. Load Testing
3. Security Testing
4. Penetration Testing
5. Fuzz Testing
6. Contract Testing

### API Testing Checklist:
- Verify correct HTTP status codes
- Validate response data structure
- Test error handling
- Verify authentication/authorization
- Test with different input values
- Verify performance requirements
- Test with different clients
- Validate security measures