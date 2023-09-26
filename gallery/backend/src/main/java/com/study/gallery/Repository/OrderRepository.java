package com.study.gallery.Repository;

import com.study.gallery.Entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface OrderRepository extends JpaRepository<Order, Long> {
    List<Order> findByMemberIdOrderByIdDesc(Long memberId);
}
