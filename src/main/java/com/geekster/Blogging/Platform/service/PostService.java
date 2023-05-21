package com.geekster.Blogging.Platform.service;

import com.geekster.Blogging.Platform.model.Post;
import com.geekster.Blogging.Platform.model.User;
import com.geekster.Blogging.Platform.repository.IPostRepo;
import com.geekster.Blogging.Platform.repository.IUserRepo;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;


import java.awt.*;
import java.util.List;
import java.util.Optional;

@Service
public class PostService {

    @Autowired
    IPostRepo postRepo;

    @Autowired
    IUserRepo userRepo;

    public  void deletePost(Long id) {
        postRepo.deleteById(id);
    }

    public Post save(Post post) {
       return postRepo.save(post);
    }


    public void updatePost(Long userId, Post post) {
        User user = userRepo.findByUserId(userId);
        if(user!=null){
            postRepo.save(post);
        }
    }
    public List<Post> getAll() {
        return postRepo.findAll();
    }
}
