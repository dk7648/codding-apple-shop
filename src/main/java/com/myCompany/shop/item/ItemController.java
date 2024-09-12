package com.myCompany.shop.item;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@Controller
@RequiredArgsConstructor
public class ItemController {
    private final ItemRepository itemRepository;
    private final ItemService itemService;

    @GetMapping("/list")
    String list(Model model) {
        List<Item> items = itemRepository.findAll();
        model.addAttribute("items", items);
        model.addAttribute("name2", "개비싼 셔츠");
        return "item/list.html";
    }

    @GetMapping("/write")
    String write() {
        return "item/write.html";
    }

    /*
    @PostMapping("/add") //POST가 동사니까 url은 명사가 좋음
    String add(String title, Integer price) {
        //유저가 보낸 데이터를 해당 타입으로 변환해서 사용.
        //@RequestParam(name="title") String title 이게 정석인데 String title로 생략 가능.
        Item newItem = new Item();
        newItem.setTitle(title);
        newItem.setPrice(price);
        System.out.println(title);
        System.out.println(price);
        itemRepository.save(newItem);
        return "redirect:/list";
    }
    */
    @PostMapping("/add")
    String add(@ModelAttribute Item newItem) {
        itemService.saveItem(newItem);
        return "redirect:/item/detail/" + newItem.getId();
    }

    @GetMapping("/detail/{id}")
    String detail(@PathVariable Long id, Model model) {
        try {
            Optional<Item> item = itemService.findItem(id);
            model.addAttribute("item", item.get());
            return "item/detail.html";
        } catch(Exception e) {
            System.out.println(e.getMessage());
            return "redirect:/item/list";
        }
    }

    @GetMapping("/edit/{id}")
    String edit(@PathVariable Long id, Model model) {
        try {
            Optional<Item> item = itemService.findItem(id);
            model.addAttribute("item", item.get());
            return "item/edit.html";
        } catch(Exception e) {
            System.out.println("=======Error====\n" + e.getMessage());
            return "redirect:/item/list";
        }
    }

    @PostMapping("/test")
    String test1(@RequestBody Map<String, Object> body) {
        System.out.println(body.get("name"));
        return "redirect:/item/list";
    }

    @DeleteMapping("/delete")
    ResponseEntity<String> delete(@RequestParam Long id) {
        System.out.println(id);
        Optional<Item> target = itemRepository.findById(id);
        if(target.isPresent()) {
            System.out.println("now delete : " + target.get());
            itemRepository.delete(target.get());
            return ResponseEntity.status(HttpStatus.OK).body("삭제완료");
        }
        else {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("삭제 실패");
        }
    }
    //REST API 서버의 경우. try catch로는 이렇게 처리함.
//    @GetMapping("/detail/{id}")
//    ResponseEntity<String> detail(@PathVariable Long id, Model model) {
//        try {
//            Optional<Item> item = itemRepository.findById(id);
//            if (item.isPresent()) {
//                model.addAttribute("item", item.get());
//                return ResponseEntity.status(HttpStatus.OK).body("OK");
//            } else {
//                return ResponseEntity.status(HttpStatus.OK).body("OK");
//            }
//        } catch (Exception e) {
//            System.out.println(e.getMessage());
//            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Not Found");
//        }
//    }

    @GetMapping("/test2")
    String test2() {
        var result = new BCryptPasswordEncoder().encode("문자1111");
        System.out.println(result);
        return "redirect:/item/list";
    }

}
