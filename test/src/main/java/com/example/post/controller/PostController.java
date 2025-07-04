package com.example.post.controller;

import com.example.post.entity.Post;
import com.example.post.repository.PostRepository;
import com.example.post.service.PostService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/posts")
@Slf4j

public class PostController {
    private final PostService postService;
    private final PostRepository postRepository;

    public PostController(PostService postService, PostRepository postRepository) {
        this.postService = postService;
        this.postRepository = postRepository;
    }

    // CRUD를 컨트롤하는 아랫 부분이 DI 내용
    // 생성
    @PostMapping
    public Post createPost(@RequestBody Post post) {
        return postService.save(post);
    }

    // 전체조회
    @GetMapping
    public List<Post> getAllPosts() {
        return postService.findAll();
    }

    // 단일조회
    @GetMapping("/{postId}")
    public Post getPostById(@PathVariable Long postId) {
        Optional<Post> optionalPost = postService.findById(postId);
        return optionalPost.orElseThrow(() -> new IllegalArgumentException("ID not found"));
    }

    // 업데이트, 수정
    @PutMapping("/{postId}")
    public Post updatePost(@PathVariable Long postId, @RequestBody Post post) {
        post.setId(postId);
        return postService.save(post);
    }

    // 삭제
    @DeleteMapping("/{postId}")
    public void deletePost(@PathVariable Long postId){
        postService.deleteById(postId);
    }
}