package com.example.academy.springboot.domain.posts;

import org.springframework.data.jpa.repository.JpaRepository;

public interface PostsRepository extends JpaRepository<Posts, Long> {       // DAO
    // CRUD 메서드 자동 생성
    // Repository 어노테이션도 필요없음
}
