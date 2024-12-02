package com.apple.shop;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

@Entity
@ToString
@NoArgsConstructor
@Table(name = "store")
public class Store {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Auto Increment에 해당
    public Integer id;

    @Column(length = 45, nullable = false) // VARCHAR(45) 및 NOT NULL
    public String name;

    @Column(name = "is_open", length = 10, nullable = false) // snake_case 컬럼명 매핑
    public String isOpen;

    @Column(length = 45, nullable = false) // VARCHAR(45) 및 NOT NULL
    public String address;

    @Column(name = "phone_number", length = 45, nullable = false) // snake_case 컬럼명 매핑
    public String phoneNumber;
}
