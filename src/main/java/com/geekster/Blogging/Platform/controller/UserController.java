package com.geekster.Blogging.Platform.controller;

import com.geekster.Blogging.Platform.model.User;
import com.geekster.Blogging.Platform.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("user")
public class UserController {

    @Autowired
    UserService userService;

    @PostMapping
    public ResponseEntity<User> createUser(@RequestBody User user) {
          User createdUser = userService.createUser(user);
        return new ResponseEntity<>(createdUser, HttpStatus.CREATED);
    }
    @GetMapping()
    public ResponseEntity<List<User>> getAll() {
        List<User> userlist = userService.getAllUser();
        return new ResponseEntity<>(userlist, HttpStatus.OK);
    }
    @PutMapping("{userId}")
    public ResponseEntity<String> updateUser(@PathVariable Long userId, @RequestBody User user){
        userService.update(userId, user);
        return new ResponseEntity<>("updated successfully",HttpStatus.OK);
    }
    @DeleteMapping("{userId}")
    public ResponseEntity<String> updateUser(@PathVariable Long userId){
        userService.deleteUser(userId);
        return new ResponseEntity<>("Deleted successfully",HttpStatus.OK);
    }



}
