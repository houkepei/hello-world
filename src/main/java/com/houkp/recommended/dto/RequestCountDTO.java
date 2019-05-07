package com.houkp.recommended.dto;

import lombok.Data;

@Data
public class RequestCountDTO {

    private String hostAddress;//服务器ip
    private String adxId;//adx 编号
    private String adxName;//adx 名称
    private String requestCount;//请求次数

    public static RequestCountDTO convertRequestCount(String requestCount) {
        RequestCountDTO requestCountDTO =new RequestCountDTO();
        String[] split = requestCount.replace("[\"","").replace("\"]","").split("\",\"");
        requestCountDTO.setHostAddress(split[0]);
        requestCountDTO.setAdxName(split[1]);
        requestCountDTO.setRequestCount(split[2]);
        return requestCountDTO;
    }
}
