package com.apple.shop;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ItemController {
    @GetMapping("/list")
    String hello(Model model) {
        model.addAttribute("name", "홍길동");
        return "list.html";
    }
}
