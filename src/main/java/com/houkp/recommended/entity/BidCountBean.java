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
public class BidCountBean {
    /**
     * 使用UUID做主键， 适配所有数据库
     */
    @Id
    @GeneratedValue(generator = "system-uuid")
    @GenericGenerator(name = "system-uuid", strategy = "uuid")
    private String id;

    private String hostAddress;//服务器ip
    private String adxId;//adx 编号
    private String adxName;//adx 名称
    private String appName;//App名称
    private String appPackageName;//App包名
    private String bidCount;//出手次数


    private String day;//天
    private Integer hour;//小时
    private Integer minute;//分钟


}
