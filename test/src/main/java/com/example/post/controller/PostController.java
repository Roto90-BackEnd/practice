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

// 현재 코드의 문제점 1.
// Controller의 과도한 책임: Controller가 PostRepository를 직접 알고 있습니다.
// Controller는 Service에게 작업을 위임해야지, Repository에 직접 접근하면 안 됩니다.

// 현재 코드의 문제점 2.
// Entity 직접 노출: Controller가 클라이언트로부터 Post 엔티티를 직접 받고, 그대로 반환하고 있습니다.
// 이는 DB 구조를 외부에 노출하는 것과 같아 매우 위험합니다.

// 현재 코드의 문제점 3.
// 불안정한 업데이트 방식: updatePost 메서드는 요청받은 post 객체에 ID만 덮어씌워 저장합니다.
// 이는 제목만 바꾸고 싶어도 내용, 작성자까지 전부 보내야 하는 비효율적인 방식이며, 부분 수정이 불가능합니다.

public class PostController {
    private final PostService postService;
    private final PostRepository postRepository;

    public PostController(PostService postService, PostRepository postRepository) {
        this.postService = postService;
        this.postRepository = postRepository;
    }

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