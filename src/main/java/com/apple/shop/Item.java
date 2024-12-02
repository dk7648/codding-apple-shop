package com.apple.shop;

import jakarta.persistence.*;
import lombok.ToString;

@Entity
@ToString
@Table(name = "item")
public class Item {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Auto Increment에 해당
    public Integer id;

    @Column(nullable = false) // NOT NULL
    public Integer price;

    @Column(length = 45, nullable = false) // VARCHAR(255) 및 NOT NULL
    public String title;

    @ManyToOne // N:1 관계 설정
    @JoinColumn(name = "store_id", nullable = false) // 외래 키 매핑
    public Store store; // Store 엔티티와의 관계

    @Column
    public Integer count;

}
