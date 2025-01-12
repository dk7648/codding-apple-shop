package com.apple.shop.Item;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@Controller
@RequiredArgsConstructor
public class ItemController {
    private final ItemRepository itemRepository;
    private final ItemService itemService;

    @GetMapping("/list")
    String list(Model model) {
        var result = itemRepository.findAll();
        System.out.println("result : " + result.toString());
        model.addAttribute("items", result);
        return "list.html";
    }

    @GetMapping("/write")
    String write(Model model) {
        return "write.html";
    }

    @PostMapping("/add")
    String addPost(@RequestParam String title, @RequestParam int price) {
        //@ModelAttribute Item item으로도 받아올 수 있다.
        itemService.saveItem(title, price);
        return "redirect:/list";
    }

    @GetMapping("/detail/{id}")
    String detail(@PathVariable Long id, Model model) {
        Item item = itemService.findItem(id);
        model.addAttribute("item", item);
        return "detail.html";
    }

    @GetMapping("edit/{id}")
    String edit(@PathVariable Long id, Model model) {
        Item item = itemService.findItem(id);
        model.addAttribute("item", item);
        return "edit.html";
    }

    @PostMapping("/edit")
    String addPost(@RequestParam Long id, @RequestParam String title, @RequestParam int price) {
        //@ModelAttribute Item item으로도 받아올 수 있다.
        itemService.editItem(id, title, price);
        return "redirect:/list";
    }

    @PostMapping("/test1")
    String test1(@RequestBody Map<String, Object> body) {
        System.out.println(body.get("name"));
        return "redirect:/list";
    }

    @DeleteMapping("/delete")
    String deletePost(@RequestParam Long id) {
        itemRepository.deleteById(id);
        return "redirect:/list";
    }
}

