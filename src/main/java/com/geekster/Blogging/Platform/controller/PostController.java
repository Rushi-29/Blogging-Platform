package com.geekster.Blogging.Platform.controller;

import com.geekster.Blogging.Platform.model.Post;
import com.geekster.Blogging.Platform.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("post")
public class PostController {

    @Autowired
    PostService postService;

    @PostMapping
    public ResponseEntity<Post> createPost(@RequestBody Post post){
       Post createdPost = postService.save(post);
        return new ResponseEntity<>(createdPost, HttpStatus.CREATED);
    }
    @GetMapping()
    public List<Post> getAllPost(){
        return  postService.getAll();
    }

    @PutMapping("{userId}")
    public void updatePost(@PathVariable Long userId, @RequestBody Post post) throws NoSuchFieldException {
        postService.updatePost(userId, post);
    }
    @DeleteMapping("{id}")
    public ResponseEntity<String> updateUser(@PathVariable Long id){
        postService.deletePost(id);
        return new ResponseEntity<>("Deleted successfully",HttpStatus.OK);
    }




}
