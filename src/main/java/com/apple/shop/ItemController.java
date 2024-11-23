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
    String list(Model model) {
        var result = itemRepository.findAll();
        System.out.println("result : " + result.toString());
        model.addAttribute("items", result);
        return "list.html";
    }
}

