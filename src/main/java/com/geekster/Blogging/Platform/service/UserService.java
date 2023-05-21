package com.geekster.Blogging.Platform.service;

import com.geekster.Blogging.Platform.model.User;
import com.geekster.Blogging.Platform.repository.IUserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    IUserRepo userRepo;
    public User createUser(User user) {
        return userRepo.save(user);
    }

    public List<User> getAllUser() {
        return userRepo.findAll();
    }

    public User update(Long userId, User user) {
        User user1 = userRepo.findByUserId(userId);
        if(user1!=null){
            user1.setFirstname(user.getFirstname());
            user1.setLastname(user.getLastname());
            user1.setEmail(user.getEmail());
            user1.setPassword(user.getPassword());
            userRepo.save(user1);

            return user1;
        }
        return user1;
    }

    public void deleteUser(Long userId) {
        User user2 = userRepo.findByUserId(userId);
        if(user2!=null ){userRepo.delete(user2);}
    }



}
