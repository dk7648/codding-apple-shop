package com.myCompany.shop.MemberController;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@RequiredArgsConstructor
public class MemberController {
    private final MemberRepository memberRepository;
    private final MemberService memberService;
    @GetMapping("member/write")
    String write() {
        return "member/write.html";
    }
    @PostMapping("member/add")
    String add(@ModelAttribute Member newMember) {
        memberService.addMember(newMember);
        return "redirect:/member/detail";
    }
}
