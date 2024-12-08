package com.apple.shop;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

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

    @GetMapping("/write")
    String write(Model model) {
        return "write.html";
    }

    @PostMapping("/add")
    String addPost(@RequestParam String title, @RequestParam int price) {
        //@ModelAttribute Item item으로도 받아올 수 있다.
        System.out.println(title);
        System.out.println(price);
        Item newItem = new Item();
        newItem.setTitle(title);
        newItem.setPrice(price);
        itemRepository.save(newItem);
        return "redirect:/list";
    }

//    @GetMapping("/detail/{id}")
//    String detail(@PathVariable Long id, Model model) {
//        Optional<Item> result = itemRepository.findById(id);
//        if (result.isPresent()) {
//            System.out.println(result.get());
//            model.addAttribute("item", result.get());
//            return "detail.html";
//        }
//        return "redirect:/list";
//    }

    //rest api의 경우
    @GetMapping("/detail/{id}")
    String detail(@PathVariable Long id, Model model) {
        try {
            Optional<Item> result = itemRepository.findById(id);
            System.out.println(result.get());
            model.addAttribute("item", result.get());
            return "detail.html";
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return "redirect:/list";
        }
    }

    //같은 페이지에서 발생하는 모든 에러를 이곳에서 처리
//    @ExceptionHandler(Exception.class)
//    public ResponseEntity<String> handler() {
//        return ResponseEntity.status(400).body("에러");
//    }
}

