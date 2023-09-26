package com.study.gallery.Entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Table(name = "cart")
@Getter
@Entity
@Setter
public class Cart {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private Long memberId;

    @Column
    private Long itemId;
}
