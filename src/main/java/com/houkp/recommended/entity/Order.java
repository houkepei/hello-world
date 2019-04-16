package com.houkp.recommended.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import io.swagger.annotations.SwaggerDefinition;
import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.Date;

@Data
@Entity
@Table(name = "product_order")
@ApiModel(value="订单",description="订单描述")
public class Order implements Serializable {
    /**
     * 使用UUID做主键， 适配所有数据库
     */
    @Id
    @GeneratedValue(generator = "system-uuid")
    @GenericGenerator(name = "system-uuid", strategy = "uuid")
    private String id;

    @ApiModelProperty(value="订单号",name="orderNum",example="1213")
    private String orderNum;

    @ApiModelProperty(value="用户名",name="username",example="houkp")
    private String username;
    private String result;
    private String errorMessage;
    private String stepName;
    private int stepNo;
    private String transitionId;
    private boolean success;
    private Date startTime; // 开始时间产品类型
    private Date endTime;
}

