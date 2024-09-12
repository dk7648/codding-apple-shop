package com.myCompany.shop.MemberController;

import com.myCompany.shop.item.ItemRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MemberService {
    private final MemberRepository memberRepository;
    private final PasswordEncoder passwordEncoder;

    public void addMember(Member newMember) {
        System.out.println("멤버 생성");
        System.out.println(newMember.getUsername());
        System.out.println(newMember.getPassword());
        System.out.println(newMember.getDisplayName());
        var hashedPassword = passwordEncoder.encode(newMember.getPassword());
        newMember.setPassword(hashedPassword);
        memberRepository.save(newMember);
    }
}
