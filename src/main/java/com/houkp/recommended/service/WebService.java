package com.houkp.recommended.service;

import com.houkp.recommended.entity.BidCountBean;
import com.houkp.recommended.entity.Order;
import com.houkp.recommended.entity.RequestCountBean;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Set;


public interface WebService {
    /**
     * 查询所有数据
     * @param pageable
     * @return
     */
    public Page<Order>  search(Pageable pageable);

    /**
     * 添加ip黑名单数据
     * @param set
     * @param startDate
     * @param endDate
     * @return
     */
    public String  updateBlacklistIp(Set set, String startDate, String endDate);

    /**
     * 保存出手数
     * @param bidCountBean
     * @return
     */
    public String  saveBidCount(BidCountBean bidCountBean);

    /**
     * 保存流量数
     * @param requestCountBean
     * @return
     */
    public String  saveRequestCount(RequestCountBean requestCountBean);





}
