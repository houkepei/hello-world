package com.houkp.recommended.service;

import com.houkp.recommended.entity.Order;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;


public interface WebService {

    public Page<Order>  search(Pageable pageable);
}
