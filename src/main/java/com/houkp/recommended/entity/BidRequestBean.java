package com.houkp.recommended.entity;

import io.swagger.annotations.ApiModel;
import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@Entity
@Table(name = "bid_count")
@ApiModel(value="出手表")
public class BidRequestBean {
    /**
     * 使用UUID做主键， 适配所有数据库
     */
    @Id
    @GeneratedValue(generator = "system-uuid")
    @GenericGenerator(name = "system-uuid", strategy = "uuid")
    private String id;
    private String username;
    private int age;
}
