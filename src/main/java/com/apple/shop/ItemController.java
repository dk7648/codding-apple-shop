package com.apple.shop;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Map;
import java.util.Optional;

@Controller
@RequiredArgsConstructor
public class ItemController {
    private final ItemRepository itemRepository;
    private final UserRepository userRepository;
    private final StoreRepository storeRepository;
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
    String addPost(@ModelAttribute Item newItem) {
        itemRepository.save(newItem);
        return "redirect:list";
    }
    @GetMapping("/detail/{id}")
    String detail(@PathVariable Long id, Model model) {
        Optional<Item> result = itemRepository.findById(id);
        try {
            model.addAttribute("item", result.get());
            return "detail.html";
        } catch (Exception e) {
            System.out.println("=======Error====\n" + e.getMessage());
            return "redirect:list";
        }
    }

    @GetMapping("/edit/{id}")
    String edit(@PathVariable Long id, Model model) {
        try {
            Optional<Item> item = itemRepository.findById(id);
            model.addAttribute("item", item.get());
            return "edit.html";
        } catch(Exception e) {
            System.out.println("=======Error====\n" + e.getMessage());
            return "redirect:list";
        }
    }

    @DeleteMapping("/delete")
    String delete(@RequestParam Long id) {
        System.out.println(id);
        Optional<Item> target = itemRepository.findById(id);
        try {
            System.out.println("now delete : " + target.get());
            itemRepository.delete(target.get());
        }
        catch(Exception e) {
            System.out.println("=======Error====\n" + e.getMessage());
        }
        return "redirect:list";
    }
}

