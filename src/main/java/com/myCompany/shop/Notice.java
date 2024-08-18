package com.myCompany.shop;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.time.ZoneId;

@Entity
public class Notice {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long id;
    public String title;
    public String date;

}
