package com.dev.the_libs.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.dev.the_libs.dto.response.PostResponse;
import com.dev.the_libs.dto.resquest.PostRequest;
import com.dev.the_libs.mapper.PostMapper;
import com.dev.the_libs.model.Post;
import com.dev.the_libs.repository.PostRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class PostService {

  private final PostRepository postRepository;
  private final PostMapper postMapper;

  public PostResponse CreateNewPost(PostRequest request) {
    return postMapper.MaptoResponse(postRepository.save(postMapper.MaptoModel(request)));
  }

  public List<PostResponse> getAllPosts() {
    return postRepository.findAll()
        .stream()
        .map(postMapper::MaptoResponse)
        .toList();
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

  public void deletePost(Long id) {
    postRepository.deleteById(id);
  }
}
