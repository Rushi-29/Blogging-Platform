package com.geekster.Blogging.Platform.repository;

import com.geekster.Blogging.Platform.model.Comment;
import com.geekster.Blogging.Platform.model.User;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ICommentRepo extends JpaRepository<Comment, Long> {

}
