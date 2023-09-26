package com.study.gallery.Repository;

import com.study.gallery.Entity.Cart;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CartRepository extends JpaRepository<Cart, Long> {

    List<Cart> findByMemberId(Long id);
    Cart findByMemberIdAndItemId(Long memberId, Long itemId);
    void deleteByMemberId(Long memberId);
}
