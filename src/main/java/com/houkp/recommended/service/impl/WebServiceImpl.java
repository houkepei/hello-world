package com.houkp.recommended.service.impl;

import com.houkp.recommended.entity.Order;
import com.houkp.recommended.repository.OrderRepository;
import com.houkp.recommended.service.WebService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;


@Service
public class WebServiceImpl implements WebService {

    @Autowired
    private OrderRepository orderRepository;

    @Override
    public Page<Order> search(Pageable pageable) {

        return orderRepository.findAll(pageable);
    }

    @Override
    public String updateBlacklistIp(Set set, String startDate, String endDate) {
        List list = new ArrayList(set);
        System.out.println(list.size());
        orderRepository.save(list);
        return null;
    }
}
