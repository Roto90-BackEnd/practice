package com.example.post.service;

import com.example.post.entity.Post;
import com.example.post.repository.PostRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PostService {
    private final PostRepository postRepository;

    public PostService(PostRepository postRepository) {
        this.postRepository = postRepository;
    }

    public Post save(Post post) {
        return postRepository.save(post);
    }

    public List<Post> findAll() {
        return postRepository.findAll();
    }

    public void deleteById(Long postId) {
        postRepository.deleteById(postId);
    }

    public Optional<Post> findById(Long postId) {
        return postRepository.findById(postId);
    }
}
