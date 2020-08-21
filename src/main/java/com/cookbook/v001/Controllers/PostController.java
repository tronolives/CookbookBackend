package com.cookbook.v001.Controllers;

import com.cookbook.v001.Entities.Post;
import com.cookbook.v001.Repositories.PostRepository;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/posts")
public class PostController {

    final PostRepository postRepository;

    public PostController(PostRepository postRepository) {
        this.postRepository = postRepository;
    }

    @PostMapping("/submit")
    public @ResponseBody String submitPost(@RequestBody Post post){
        System.out.println("Wow we got a post");
        postRepository.save(post);
        return "Good one!";
    }
}
