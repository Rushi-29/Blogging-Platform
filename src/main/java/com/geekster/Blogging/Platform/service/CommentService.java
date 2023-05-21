package com.geekster.Blogging.Platform.service;

import com.geekster.Blogging.Platform.model.Comment;
import com.geekster.Blogging.Platform.repository.ICommentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class CommentService {

    @Autowired
    ICommentRepo commentRepo;
    public Comment addComment(Comment comment) {
        return commentRepo.save(comment);
    }

    public void deleteById(Long id) {
        commentRepo.deleteById(id);
    }

    public List<Comment> getAll(int pageNumber, int pageSize) {
        Pageable p = PageRequest.of(pageNumber, pageSize);
        Page<Comment> pageComment = commentRepo.findAll(p);
       return pageComment.getContent();
    }
}
