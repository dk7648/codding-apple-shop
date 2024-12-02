package com.apple.shop;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Controller
@RequiredArgsConstructor
public class StoreController {
    private final StoreRepository storeRepository;

    @GetMapping("/store/list")
    String list(Model model) {
        var result = storeRepository.findAll();
        System.out.println("result : " + result.toString());
        model.addAttribute("stores", result);
        return "store/list.html";
    }

    @GetMapping("/store/write")
    String write(Model model) {
        return "store/write.html";
    }

    @PostMapping("/store/add")
    String addPost(@RequestParam String name,
                   @RequestParam String isOpen,
                   @RequestParam String address,
                   @RequestParam String phoneNumber) {
        System.out.println("===============================");
        System.out.println(name);
        System.out.println(isOpen);
        System.out.println(address);
        System.out.println(phoneNumber);
        System.out.println("===============================");
        var newStore = new Store();
        newStore.name = name;
        newStore.isOpen = isOpen;
        newStore.address = address;
        newStore.phoneNumber = phoneNumber;
        storeRepository.save(newStore);
        return "redirect:/store/list";
    }

    @PostMapping("/store/edit")
    String editPost(
            @RequestParam Integer id,
            @RequestParam String name,
            @RequestParam String isOpen,
            @RequestParam String address,
            @RequestParam String phoneNumber) {
        System.out.println("===============================");
        System.out.println(name);
        System.out.println(isOpen);
        System.out.println(address);
        System.out.println(phoneNumber);
        System.out.println("===============================");
        var newStore = new Store();
        newStore.id = id;
        newStore.name = name;
        newStore.isOpen = isOpen;
        newStore.address = address;
        newStore.phoneNumber = phoneNumber;
        storeRepository.save(newStore);
        return "redirect:/store/list";
    }

    @GetMapping("/store/detail/{id}")
    String detail(@PathVariable Long id, Model model) {
        Optional<Store> result = storeRepository.findById(id);
        try {
            model.addAttribute("store", result.get());
            return "/store/detail.html";
        } catch (Exception e) {
            System.out.println("=======Error====\n" + e.getMessage());
            return "redirect:/store/list";
        }
    }

    @GetMapping("/store/edit/{id}")
    String edit(@PathVariable Long id, Model model) {
        try {
            Optional<Store> store = storeRepository.findById(id);
            model.addAttribute("store", store.get());
            return "store/edit.html";
        } catch (Exception e) {
            System.out.println("=======Error====\n" + e.getMessage());
            return "redirect:/store/list";
        }
    }

    @DeleteMapping("/store/delete")
    String delete(@RequestParam Long id) {
        System.out.println(id);
        Optional<Store> target = storeRepository.findById(id);
        try {
            System.out.println("now delete : " + target.get());
            storeRepository.delete(target.get());
        } catch (Exception e) {
            System.out.println("=======Error====\n" + e.getMessage());
        }
        return "redirect:/store/list";
    }
}

