package com.dev.the_libs.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.dev.the_libs.model.Post;
import com.dev.the_libs.repository.PostRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class PostService {

  private final PostRepository postRepository;

  public Post CreateNewPost(Post post) {
    return postRepository.save(post);
  }

  public List<Post> getAllPosts() {
    return postRepository.findAll();
  }

  public Post getPostById(Long id) {
    return postRepository.findById(id).orElse(null);
  }

  public Post updatePost(Long id, Post post) {
    return postRepository.findById(id)
        .map(postPresent -> {
          existingPost(postPresent, post);
          return postRepository.save(postPresent);
        })
        .orElseThrow(() -> new RuntimeException("Post not found"));
  }

  private void existingPost(Post postPresent, Post post) {
    Optional.ofNullable(post.getTitle()).ifPresent(postPresent::setTitle);
    Optional.ofNullable(post.getContent()).ifPresent(postPresent::setContent);
  }
}
