package com.apple.shop;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.time.LocalDate;

@Controller
public class BasicController {
    @GetMapping("/")
    String hello() {
        return "index.html";
    }
    @GetMapping("/date")
    @ResponseBody
    String test() {
        LocalDate now = LocalDate.now();
        return now.toString();
    }
}
