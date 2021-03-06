package com.houkp.recommended.web;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.houkp.recommended.config.RequestLimit;
import com.houkp.recommended.dto.RequestCountDTO;
import com.houkp.recommended.entity.BidCountBean;
import com.houkp.recommended.entity.RequestCountBean;
import com.houkp.recommended.service.WebService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiParam;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import java.io.*;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.*;


@Api(value = "WebController", description = "监控平台")
@RestController
public class WebController {

    private static final Logger log = LoggerFactory.getLogger(WebController.class);

    @Autowired
    private WebService webService;


    /**
     * 上传ip黑名单
     *
     * @param file
     * @param startDate
     * @param endDate
     * @return
     */
    @PostMapping(value = "/blackListIp")
    @ResponseBody
    public String blackListIp(@RequestParam @ApiParam(value = "上传ip黑名单", required = true) MultipartFile file, @RequestParam @ApiParam(value = "例如:2019-04-15", required = true) String startDate, @RequestParam String endDate) {

        Set set = new HashSet();
        String s1 = file.getName();
        try {
            String gbk = new String(s1.getBytes("UTF-8"), "gbk");
            System.out.println(gbk);//浣犲ソ鍟婄殑
            String utf8 = new String(gbk.getBytes("gbk"), "utf-8");
            System.out.println(utf8);//你好啊的
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        try {
            InputStream inputStream = file.getInputStream();
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
            String line;

            while ((line = bufferedReader.readLine()) != null) {
                set.add(line);
            }
            log.debug("此次更新blacklist_ip的条数：{}", set.size());
            webService.updateBlacklistIp(set, startDate, endDate);
        } catch (Exception e) {
            log.error("异常：{}", e);

        }
        return "ok";
    }

    /**
     * 接收每台服务出手统计次数
     *
     * @param bidCount
     * @return
     */
    @PostMapping(value = "/postBid")
    @ResponseBody
    public String postBid(@RequestBody String bidCount) {
        List<BidCountBean> list = new ArrayList<>();
        String[] split = bidCount.replace("{", "").replace("}", "").split(",");
        for (String s : split) {
            String[] strings = s.split(":");
            BidCountBean bidCountBean = new BidCountBean();
            bidCountBean.setBidCount(strings[1]);
            String replace = strings[0].replace("\"", "");
            String[] bidCountBeansplit = replace.split("\\$");
            String adxName = bidCountBeansplit[1];
            if (adxName.equals("1")) {
                bidCountBean.setAdxName("灵集");
            } else if (adxName.equals("2")) {
                bidCountBean.setAdxName("快友");
            } else if (adxName.equals("3")) {
                bidCountBean.setAdxName("悠易");
            } else if (adxName.equals("4")) {
                bidCountBean.setAdxName("腾讯广点通");
            } else if (adxName.equals("5")) {
                bidCountBean.setAdxName("百度");
            }
            bidCountBean.setHostAddress(bidCountBeansplit[0]);
            bidCountBean.setAdxId(bidCountBeansplit[1]);
//            bidCountBean.setAppName(bidCountBeansplit[2]);
//            bidCountBean.setAppPackageName(bidCountBeansplit[3]);
            bidCountBean.setDay(LocalDate.now().toString());
            bidCountBean.setHour(LocalTime.now().getHour());
            bidCountBean.setMinute(LocalTime.now().getMinute());
            list.add(bidCountBean);
        }
        webService.saveBidCountList(list);
        return null;
    }

    /**
     * 接收每台服务统计次数
     *
     * @param requestCount
     * @return
     */
    @PostMapping(value = "/postRequest")
    @ResponseBody
    public String postRequest(@RequestBody String requestCount) {
        String[] split = requestCount.replace("{", "").replace("}", "").split(",");
        List<RequestCountBean> list = new ArrayList();
        for (String s : split) {
            String[] strings = s.split(":");
            RequestCountBean requestCountBean = new RequestCountBean();
            requestCountBean.setRequestCount(strings[1]);
            String replace = strings[0].replace("\"", "");
            String[] bidCountBeansplit = replace.split("\\$");
            String adxName = bidCountBeansplit[1];
            if (adxName.equals("1")) {
                requestCountBean.setAdxName("灵集");
            } else if (adxName.equals("2")) {
                requestCountBean.setAdxName("快友");
            } else if (adxName.equals("3")) {
                requestCountBean.setAdxName("悠易");
            } else if (adxName.equals("4")) {
                requestCountBean.setAdxName("腾讯广点通");
            } else if (adxName.equals("5")) {
                requestCountBean.setAdxName("百度");
            }
            requestCountBean.setHostAddress(bidCountBeansplit[0]);
            requestCountBean.setAdxId(bidCountBeansplit[1]);
//            requestCountBean.setAppName(bidCountBeansplit[2]);
//            requestCountBean.setAppPackageName(bidCountBeansplit[3]);
            requestCountBean.setDay(LocalDate.now().toString());
            requestCountBean.setHour(LocalTime.now().getHour());
            requestCountBean.setMinute(LocalTime.now().getMinute());
            list.add(requestCountBean);
        }
        webService.saveRequestCountList(list);

        return null;
    }

    //    @RequestLimit(count = 1, time = 120000)
    @GetMapping("/hello")
//    @ResponseBody
    public ModelAndView hello() {
        System.out.println("11111111111111111111111111");
        return new ModelAndView("echatrts");
    }

    /**
     * 页面展示数据
     *
     * @return
     */
    @GetMapping("/echatrts")
    public ModelAndView echatrts() {
        return new ModelAndView("echatrtsTest");
    }


    /**
     * 查询请求
     *
     * @param pageable
     * @return
     */
    @GetMapping(value = "/requestCountList")
    @ResponseBody
    public Page<RequestCountBean> orderList(Pageable pageable) {
        Page<RequestCountBean> requestCountBeanPage = webService.search(pageable);
        return requestCountBeanPage;
    }

    /**
     * 查询请求数
     *
     * @param
     * @return
     */
    @GetMapping(value = "/queryRequestCount")
    @ResponseBody
    public String queryRequestCount(@RequestParam String hostAddress) {
        //页面json数据
        Map echarts = new HashMap();
        //legend 标题
        List adxNameList = new ArrayList();
        //数据
        List series = new ArrayList();
        //当前日期
        String now = LocalDate.now().toString();
        //当前小时
        int hour = LocalTime.now().getHour();
        List requestCountBeanList = webService.queryRequestCount(now, hour,hostAddress);
        for (Object o : requestCountBeanList) {
            RequestCountDTO requestCountDTO = RequestCountDTO.convertRequestCount(JSON.toJSONString(o));
            String adxName = requestCountDTO.getHostAddress() + requestCountDTO.getAdxName();
            adxNameList.add(adxName);
            Map seriesMap = new HashMap();
            seriesMap.put("name", adxName);
            seriesMap.put("type", "line");
            seriesMap.put("stack", "总量");
            seriesMap.put("data", requestCountDTO.getRequestCount().split(","));
            series.add(seriesMap);
        }
        echarts.put("legend", adxNameList);
        echarts.put("series", series);
        System.out.println(JSON.toJSONString(echarts));
        return JSON.toJSONString(echarts);
    }


    /**
     * 查询赢价数
     *
     * @param
     * @return
     */
    @GetMapping(value = "/queryBidCount")
    @ResponseBody
    public String queryBidCount(@RequestParam String hostAddress) {
        //页面json数据
        Map echarts = new HashMap();
        //legend 标题
        List adxNameList = new ArrayList();
        //数据
        List series = new ArrayList();
        //当前日期
        String now = LocalDate.now().toString();
        //当前小时
        int hour = LocalTime.now().getHour();
        List bidCountBeanList = webService.queryBidCount(now, hour,hostAddress);
        for (Object o : bidCountBeanList) {
            RequestCountDTO requestCountDTO = RequestCountDTO.convertRequestCount(JSON.toJSONString(o));
            String adxName = requestCountDTO.getHostAddress() + requestCountDTO.getAdxName();
            adxNameList.add(adxName);
            Map seriesMap = new HashMap();
            seriesMap.put("name", adxName);
            seriesMap.put("type", "line");
            seriesMap.put("stack", "总量");
            seriesMap.put("data", requestCountDTO.getRequestCount().split(","));
            series.add(seriesMap);
        }
        echarts.put("legend", adxNameList);
        echarts.put("series", series);
        System.out.println(JSON.toJSONString(echarts));
        return JSON.toJSONString(echarts);
    }

    public static void main(String[] args) {

    }

}
