package com.geekster.Blogging.Platform.repository;

import com.geekster.Blogging.Platform.model.Post;
import com.geekster.Blogging.Platform.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IPostRepo extends JpaRepository<Post, Long> {
}
