package com.dev.the_libs.mapper;

import org.springframework.stereotype.Component;

import com.dev.the_libs.dto.response.PostResponse;
import com.dev.the_libs.dto.resquest.PostRequest;
import com.dev.the_libs.model.Post;

@Component
public class PostMapper {

  public Post MaptoModel(PostRequest request) {
    return Post.builder()
        .title(request.getTitle())
        .content(request.getContent())
        .build();
  }

  public PostResponse MaptoResponse(Post post) {
    return PostResponse.builder()
        .id(post.getId())
        .title(post.getTitle())
        .content(post.getContent())
        .build();
  }

}