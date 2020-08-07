package com.cookbook.v001.Controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/post")
public class PostController {

    @RequestMapping("/submit")
    public void submitPost(){
        System.out.println("Wow we got a post");
    }
}
