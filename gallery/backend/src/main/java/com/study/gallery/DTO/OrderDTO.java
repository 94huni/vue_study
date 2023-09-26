package com.study.gallery.DTO;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class OrderDTO {
    private String name;
    private String address;
    private String payment;
    private String cardNumber;
    private String items;
}
