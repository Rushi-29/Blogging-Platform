package com.geekster.Blogging.Platform.controller;

import com.geekster.Blogging.Platform.model.Comment;
import com.geekster.Blogging.Platform.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("comment")
public class CommentController {

    @Autowired
    CommentService commentService;

    @PostMapping
    public Comment addComment(@RequestBody Comment comment){
        return commentService.addComment(comment);
    }
    @DeleteMapping("{id}")
    public void deleteComment(@PathVariable Long id){
        commentService.deleteById(id);
    }

    @GetMapping
    public List<Comment> getTenComment(@RequestParam int pageNumber,int pageSize){
        return commentService.getAll(pageNumber,pageSize);
    }


}
