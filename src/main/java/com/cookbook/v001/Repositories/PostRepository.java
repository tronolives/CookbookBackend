package com.cookbook.v001.Repositories;

import com.cookbook.v001.Entities.Post;
import org.springframework.data.repository.CrudRepository;

public interface PostRepository extends CrudRepository<Post, Integer> {
}
