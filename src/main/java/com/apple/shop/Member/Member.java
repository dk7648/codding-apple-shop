package com.apple.shop.Member;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.*;

@Entity
@ToString
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Member {
    @Id
    private String username;

    @Column(nullable = false)
    private String password;
    @Column(nullable = false)
    private String display_name;


}
