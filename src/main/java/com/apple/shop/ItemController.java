package com.apple.shop;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@RequiredArgsConstructor
public class ItemController {
    private final ItemRepository itemRepository;
    @GetMapping("/list")
    String hello(Model model) {
        var result = itemRepository.findAll();
        model.addAttribute("items", result);
        return "list.html";
    }
}

