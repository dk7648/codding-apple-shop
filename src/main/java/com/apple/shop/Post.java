package com.apple.shop;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.ToString;

@Entity
@ToString
public class Post {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    public String title;
    public String text;
    public String date;
}
