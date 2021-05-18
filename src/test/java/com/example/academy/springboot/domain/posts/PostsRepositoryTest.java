package com.example.academy.springboot.domain.posts;

import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.LocalDateTime;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest
public class PostsRepositoryTest {

    @Autowired
    PostsRepository postsRepository;

    @After      // 단위테스트가 끝난 후 cleanup 메서드를 실행
    public void cleanup() {
        postsRepository.deleteAll();
    }

    @Test
    public void saveArticle() {
        String title = "Test Title";
        String content = "Test Content";

        // save() : insert, update query 실행 메서드
        postsRepository.save(Posts.builder().title(title).content(content).author("aron@test.com").build());

        List<Posts> postsList = postsRepository.findAll();
        Posts posts = postsList.get(0);
        assertThat(posts.getTitle()).isEqualTo(title);
        assertThat(posts.getContent()).isEqualTo(content);
    }

    @Test
    public void registerBaseTimeEntity() {
        LocalDateTime now = LocalDateTime.of(2021, 5, 18, 0, 0, 0);
        postsRepository.save(Posts.builder().title("title").content("content").author("aron@test.com").build());

        List<Posts> postsList = postsRepository.findAll();
        Posts posts = postsList.get(0);
        System.out.println("===> CreatedDate = " + posts.getCreatedDate() + ", LastModifiedDate = " + posts.getModifiedDate());

        assertThat(posts.getCreatedDate()).isAfter(now);
        assertThat(posts.getModifiedDate()).isAfter(now);
    }
}
