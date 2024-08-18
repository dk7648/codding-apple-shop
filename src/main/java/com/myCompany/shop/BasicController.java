package com.myCompany.shop;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.time.ZonedDateTime;

@Controller
public class BasicController {
    @GetMapping("")
    //@ResponseBody //리턴 뒤에 문자열 그대로 보내달라는 뜻
    String hello() {
        return "index.html";
    }
    @GetMapping("/about")
    @ResponseBody
    String about() {
        return "사이트 소개글";
    }
    @GetMapping("/mypage")
    @ResponseBody
    String mypage() {
        return "마이페이지ㅋ";
    }
    @GetMapping("/date")
    @ResponseBody
    String date() {
        return ZonedDateTime.now().toString();
    }
}
