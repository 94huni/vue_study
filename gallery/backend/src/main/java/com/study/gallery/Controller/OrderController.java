package com.study.gallery.Controller;

import com.study.gallery.DTO.OrderDTO;
import com.study.gallery.Entity.Order;
import com.study.gallery.Repository.CartRepository;
import com.study.gallery.Repository.OrderRepository;
import com.study.gallery.Service.JwtService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class OrderController {
    private final JwtService jwtService;
    private final OrderRepository orderRepository;
    private final CartRepository cartRepository;

    @GetMapping("/api/orders")
    public ResponseEntity getOrder(@CookieValue(value = "token", required = false) String token) {
        if (!jwtService.isValid(token)) {
            throw new ResponseStatusException(HttpStatus.UNAUTHORIZED);
        }

        List<Order> orders = orderRepository.findByMemberIdOrderByIdDesc(jwtService.getId(token));
        return new ResponseEntity<>(orders, HttpStatus.OK);
    }

    @Transactional
    @PostMapping("/api/orders")
    public ResponseEntity pushOrder(@RequestBody OrderDTO orderDTO,
                                    @CookieValue(value = "token", required = false) String token) {
        if (!jwtService.isValid(token)) {
            throw new ResponseStatusException(HttpStatus.UNAUTHORIZED);
        }

        Long memberId = jwtService.getId(token);
        Order newOrder = new Order();
        newOrder.setMemberId(memberId);
        newOrder.setName(orderDTO.getName());
        newOrder.setAddress(orderDTO.getAddress());
        newOrder.setCardNumber(orderDTO.getCardNumber());
        newOrder.setPayment(orderDTO.getPayment());
        newOrder.setItems(orderDTO.getItems());


        orderRepository.save(newOrder);
        cartRepository.deleteByMemberId(memberId);

        return new ResponseEntity<>(HttpStatus.CREATED);
    }
}
