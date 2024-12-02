package com.apple.shop;

import jakarta.persistence.*;
import lombok.ToString;

import java.util.List;

@Entity
@ToString
@Table(name = "user")
public class User {
    @Id
    @Column(name = "user_id", length = 45) // PK, VARCHAR(45)
    public String userId;

    @Column(nullable = false) // NOT NULL
    public Integer address;

    @Column(length = 45, nullable = false) // VARCHAR(45), NOT NULL
    public String name;

    @Column(name = "phone_number", length = 45, nullable = false) // snake_case 컬럼 매핑
    public String phoneNumber;
}
