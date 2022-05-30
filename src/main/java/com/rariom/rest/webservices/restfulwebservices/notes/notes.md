# RESTful  Web Services
Social Media Application
<br>
Relationship - One to Many
<br>
User -> Posts
- Retrieve all Users - GET /users
- Create a User - POST /users
- Retrieve one User - GET /users/{id} -> /users/1
- Delete a User - DELETE /users/{id}
<hr>
POST  
<br>
- Retrieve all posts for a User - GET /users/{id}/posts
<br>
- Create a posts fo a User - POST /users/{id}/posts
<br>
- Retrieve details of a post of a User - GET /users/{id}/posts/{post_id}