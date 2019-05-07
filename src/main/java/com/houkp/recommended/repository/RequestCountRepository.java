package com.houkp.recommended.repository;

import com.houkp.recommended.entity.RequestCountBean;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface RequestCountRepository extends JpaRepository<RequestCountBean,String> {

    Page<RequestCountBean> findAll(Specification<RequestCountBean> specification, Pageable pageable);

    /**
     * 根据当前日期和小时查询数据
     * @param now
     * @param hour
     * @return
     */
    @Query(nativeQuery = true,value = " SELECT host_address,adx_name,GROUP_CONCAT(request_count) AS   adx_count FROM request_count  WHERE  DAY= ?1  AND HOUR =?2   GROUP BY adx_name,host_address;")
    List findRequestCount(String now, int hour);
//    List findRequestCount();
}
