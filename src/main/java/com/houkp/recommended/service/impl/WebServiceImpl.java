package com.houkp.recommended.service.impl;

import com.houkp.recommended.entity.Order;
import com.houkp.recommended.repository.OrderRepository;
import com.houkp.recommended.service.WebService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;


@Service
public class WebServiceImpl implements WebService {

    @Autowired
    private OrderRepository orderRepository;
    @Override
    public Page<Order> search(Pageable pageable) {
        return orderRepository.findAll(pageable);
    }
}
