package com.apple.shop;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Post {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    String title;
    String text;
    String date;
}