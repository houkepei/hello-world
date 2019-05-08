package com.houkp.recommended.service.impl;

import com.houkp.recommended.entity.BidCountBean;
import com.houkp.recommended.entity.BlacklistIp;
import com.houkp.recommended.entity.Order;
import com.houkp.recommended.entity.RequestCountBean;
import com.houkp.recommended.repository.BidCountRepository;
import com.houkp.recommended.repository.BlacklistIpRepository;
import com.houkp.recommended.repository.OrderRepository;
import com.houkp.recommended.repository.RequestCountRepository;
import com.houkp.recommended.service.WebService;
import com.houkp.recommended.utils.InsertDataDemo;
import jdk.nashorn.internal.ir.RuntimeNode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.jdbc.core.BatchPreparedStatementSetter;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.*;


@Service
public class WebServiceImpl implements WebService {

    @Autowired
    private OrderRepository orderRepository;
    @Autowired
    private JdbcTemplate jdbcTemplate;
    @Autowired
    private BlacklistIpRepository blacklistIpRepository;

    @Autowired
    private BidCountRepository bidCountRepository;

    @Autowired
    private RequestCountRepository requestCountRepository;

    @Override
    public Page<RequestCountBean> search(Pageable pageable) {

        return requestCountRepository.findAll(pageable);
    }

    @Override
    public String updateBlacklistIp(Set set, String startDate, String endDate) {
        InsertDataDemo.insert(set,startDate,endDate);
//        LocalDate localDate = LocalDate.now();
//        Date date  =Date.valueOf(localDate);
//        List list = new ArrayList(set);
//        final String strSql = "insert into  blacklist_ip (ip_blacklist, flag, end_time,  start_time, version) values (?, ?, ?, ?, ?)";
//        jdbcTemplate.batchUpdate(strSql, new BatchPreparedStatementSetter() {
//            @Override
//            public void setValues(PreparedStatement preparedStatement, int i) throws SQLException {
//                preparedStatement.setString(1, String.valueOf(list.get(i)));
//                preparedStatement.setInt(2, 1);
//                preparedStatement.setDate(3, date);
//                preparedStatement.setDate(4,  date);
//                preparedStatement.setString(5, startDate);
//            }
//
//            @Override
//            public int getBatchSize() {
//                return list.size();
//            }
//        });
//        List<BlacklistIp> list = new ArrayList();
//        for (Object o : set) {
//            BlacklistIp blacklistIp = new BlacklistIp();
//            System.out.println(o.toString());
//            blacklistIp.setIpBlacklist(o.toString());
//            blacklistIp.setFlag(1);
//            list.add(blacklistIp);
//
////            blacklistIpRepository.save(blacklistIp);
//        }
        System.out.println(set.size());
        return String.valueOf(set.size());
    }

    @Override
    public String saveBidCount(BidCountBean bidCountBean) {
        bidCountRepository.save(bidCountBean);
        return null;
    }

    @Override
    public String saveRequestCount(RequestCountBean requestCountBean) {
        requestCountRepository.save(requestCountBean);
        return null;
    }

    @Override
    public String saveBidCountList(List<BidCountBean> bidCountBeans) {
        bidCountRepository.save(bidCountBeans);
        return null;
    }

    @Override
    public String saveRequestCountList(List<RequestCountBean> requestCountBeans) {
        requestCountRepository.save(requestCountBeans);
        return null;
    }

    @Override
    public List queryRequestCount(String now, int hour,String hostAddress) {
        return requestCountRepository.findRequestCount(now,hour,hostAddress);
    }

    @Override
    public List queryBidCount(String now, int hour, String hostAddress) {
        return requestCountRepository.findBidCount(now,hour,hostAddress);
    }
}
