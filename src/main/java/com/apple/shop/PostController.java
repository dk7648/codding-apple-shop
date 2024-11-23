package com.apple.shop;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@RequiredArgsConstructor
public class PostController {
    private final PostRepository postRepository;

    @GetMapping("/post")
    String post(Model model) {
        var result = postRepository.findAll();
        System.out.println("post result : " + result.toString());
        model.addAttribute("posts", result);
        return "post.html";
    }
}
