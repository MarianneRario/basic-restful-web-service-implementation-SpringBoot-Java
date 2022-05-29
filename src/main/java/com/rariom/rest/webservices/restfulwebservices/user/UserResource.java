package com.rariom.rest.webservices.restfulwebservices.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import org.springframework.hateoas.*;
import javax.validation.Valid;
import java.net.URI;
import java.util.List;

@RestController
@RequestMapping(path = "/users")
public class UserResource {

    // reference of method in UserDaoService
    private UserDaoService service;

    @Autowired
    public UserResource(UserDaoService service){
        this.service = service;
    }

    // retrieve all users
    // GET /users
    @GetMapping
    public List<User> retrieveAllUsers(){
        return service.findAll();
    }

    // retrieveUser(int id)
    // GET /users/{id}
    @GetMapping(path = "{id}")
    // public User retrieveUser(@PathVariable int id) -> former return type
    public EntityModel<User> retrieveUser(@PathVariable int id) {
        User user = service.findOne(id);

        if(user == null){
            throw new UserNotFoundException("Id: " + id);
        }

        /* HATEOAS
        - provide link to view all users
        - "all-users", SERVER_PATH + "users" */
        // create a resource that will show all the users when clicked (link)

        EntityModel<User> entityModel = EntityModel.of(user); // this is what I want to return (specific user)
        WebMvcLinkBuilder linkTo =  WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(this.getClass()).retrieveAllUsers());
        entityModel.add(linkTo.withRel("all-users")); // this is what I want to add (link to retrieve all users)


        return entityModel; // returning both a specific user and link to all users
    }

    // createNewUser
    // POST /users/{id}
    @PostMapping
    public ResponseEntity<Object> createNewUser(@Valid @RequestBody User user){
        User savedUser = service.save(user);
        // return a "Created" response
        // current uri should be -> /users/{id} -> /users/savedUser.getId()
        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(savedUser.getId()) // -> kung ano ang ipapalit sa .path("/{id}")
                .toUri();
        // set the URI for the created resource into the response
        return ResponseEntity.created(location).build();

    }

    // DELETE method
    @DeleteMapping(path = "{id}")
    public void deleteUser(@PathVariable int id) {
        User user = service.deleteById(id);
        if(user == null){
            throw new UserNotFoundException("Id: " + id);
        }

    }

}
