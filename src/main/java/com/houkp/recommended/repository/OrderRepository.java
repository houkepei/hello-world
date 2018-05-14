package com.houkp.recommended.repository;

import com.houkp.recommended.entity.Order;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order,String> {

    Page<Order> findAll(Specification<Order> specification, Pageable pageable);
}
