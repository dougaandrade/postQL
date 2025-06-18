package com.dev.the_libs.controller;

import java.util.List;

import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import com.dev.the_libs.dto.response.PostResponse;
import com.dev.the_libs.dto.resquest.PostRequest;
import com.dev.the_libs.model.Post;
import com.dev.the_libs.service.PostService;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class PostController {

  private final PostService postService;

  @MutationMapping
  public PostResponse createPost(@Argument PostRequest post) {
    return postService.CreateNewPost(post);
  }

  @QueryMapping
  public List<PostResponse> allPosts() {
    return postService.getAllPosts();
  }

  @QueryMapping
  public Post postById(@Argument Long id) {
    return postService.getPostById(id);
  }

  @MutationMapping
  public Post updatePost(@Argument Long id, @Argument Post post) {
    return postService.updatePost(id, post);
  }

  @MutationMapping
  public void deletePost(@Argument Long id) {
    postService.deletePost(id);
  }

}
