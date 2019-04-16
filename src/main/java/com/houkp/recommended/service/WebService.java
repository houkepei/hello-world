package com.houkp.recommended.service;

import com.houkp.recommended.entity.Order;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Map;
import java.util.Set;


public interface WebService {
    /**
     * 查询所有数据
     * @param pageable
     * @return
     */
    public Page<Order>  search(Pageable pageable);

    public String  updateBlacklistIp(Set set, String startDate, String endDate);
}
