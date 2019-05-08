package com.houkp.recommended.service;

import com.houkp.recommended.entity.BidCountBean;
import com.houkp.recommended.entity.Order;
import com.houkp.recommended.entity.RequestCountBean;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Set;


public interface WebService {





    /**
     * 查询所有数据
     * @param pageable
     * @return
     */
    public Page<RequestCountBean>  search(Pageable pageable);

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


    /**
     * 保存出手数
     * @param bidCountBeans
     * @return
     */
    public String  saveBidCountList(List<BidCountBean> bidCountBeans);

    /**
     * 保存流量数
     * @param requestCountBeans
     * @return
     */
    public String  saveRequestCountList(List<RequestCountBean> requestCountBeans);

    /**
     * 根据当前日期和小时查询请求数据
     * @param now
     * @param hour
     * @return
     */
    List queryRequestCount(String now, int hour,String hostAddress);

    /**
     * 根据当前日期和小时查询赢价数据
     * @param now
     * @param hour
     * @return
     */
    List queryBidCount(String now, int hour, String hostAddress);
}
