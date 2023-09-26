package com.study.gallery.Entity;

import lombok.Getter;

import javax.persistence.*;

@Table(name = "items")
@Getter
@Entity
public class Item {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 50, nullable = false)
    private String name;

    @Column(length = 100)
    private String img_path;

    @Column
    private int price;

    @Column
    private int discount_per;
}
