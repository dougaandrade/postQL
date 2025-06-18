package com.dev.the_libs.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.dev.the_libs.model.Post;

public interface PostRepository extends JpaRepository<Post, Long> {

  boolean existsByTitle(String title);

}
