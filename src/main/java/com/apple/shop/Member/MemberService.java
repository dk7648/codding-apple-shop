package com.apple.shop.Member;

import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MemberService {
    private final MemberRepository memberRepository;
    private final PasswordEncoder passwordEncoder;
    public void add(String username, String password, String display_name) {
        if(memberRepository.findById(username).isPresent()) {
            return;
        }
        String hashedPassword = getHashedPassword(password);
        Member member = new Member(username, hashedPassword, display_name);
        System.out.println(member);
        memberRepository.save(member);
    }

    public void isExist(String username, String password) {
        var target = memberRepository.findById(username);
        if(target.isPresent()) {
            String targetHashedPassword = target.get().getPassword();
            String tryHashedPassword = getHashedPassword(password);
            if(targetHashedPassword.equals(tryHashedPassword)) {
                //입장권 발급
                System.out.println("로그인 가능");
                return;
            }
        }
        System.out.println("로그인 불가");
    }
    public String getHashedPassword(String password) {
        return passwordEncoder.encode(password);
    }
}
