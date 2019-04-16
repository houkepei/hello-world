package com.houkp.recommended.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
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
@Table(name = "blacklist_ip")
@ApiModel(value="ip_blacklist",description="ip黑名单")
public class BlacklistIp implements Serializable {
    /**
     * 主键
     */
    @Id
    private String ipBlacklist;

    private Integer flag; //开关标识
    private String version; //版本号
    private Date startTime; // 开始时间
    private Date endTime;   //结束时间
}

