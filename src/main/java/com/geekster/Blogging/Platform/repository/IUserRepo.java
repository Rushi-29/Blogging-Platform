package com.geekster.Blogging.Platform.repository;

import com.geekster.Blogging.Platform.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.LongSummaryStatistics;

public interface IUserRepo extends JpaRepository<User, Long> {

    User findByUserId(Long userId);
}
