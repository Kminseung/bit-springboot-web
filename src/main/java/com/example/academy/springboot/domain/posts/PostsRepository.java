package com.example.academy.springboot.domain.posts;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface PostsRepository extends JpaRepository<Posts, Long> {       // DAO
    // JpaRepository : CRUD 메서드 자동 생성
    // Repository 어노테이션도 필요없음

    @Query("select p from Posts p order by p.id desc")
    List<Posts> findAllDesc();
}
