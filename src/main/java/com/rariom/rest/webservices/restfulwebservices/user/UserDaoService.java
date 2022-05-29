package com.rariom.rest.webservices.restfulwebservices.user;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

@Component // talks to the database
public class UserDaoService {

    // create a simple arrayList to store a list of users
    private static List<User> users = new ArrayList<>();
    private static int userCount = 3;

    static {
        users.add(new User(1, "Marianne", new Date()));
        users.add(new User(2, "Paulo", new Date()));
        users.add(new User(3, "Selah", new Date()));
    }

    /* Create three methods
    1. findAll()
    2. save()
    3. findOne() */

    public List<User> findAll(){
        return users;
    }

    public User save(User user){
        // check if user has id, if null, provide an id
        if(user.getId() == null){
            user.setId(++userCount);
        }
        users.add(user);
        return user;
    }

    public User findOne(int id){
        for(User user: users){
            if(user.getId() == id){
                return user;
            }
        }
        return null;
    }
    public User deleteById(int id){
        Iterator<User> iterator = users.iterator();
        while (iterator.hasNext()){
            User user = iterator.next();
            if(user.getId() == id){
                iterator.remove();
                return user; // when removed, return the deleted resource
            }
        }
        return null;
    }

}
