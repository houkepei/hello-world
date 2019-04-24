package com.houkp.recommended.web;

import com.houkp.recommended.config.RequestLimit;
import com.houkp.recommended.entity.BidRequestBean;
import com.houkp.recommended.service.WebService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiParam;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.*;
import java.util.*;


@Api(value = "WebController", description = "推荐中心")
@Controller
public class WebController {

    private static final Logger log = LoggerFactory.getLogger(WebController.class);

    @Autowired
    private WebService webService;


//    @Resource
//    private RedisTemplate<String, Object> redisTemplate;

//    @GetMapping(value = "/orderList")
//    @ResponseBody
//    public Page<Order> orderList(Pageable pageable) {
//        Page<Order> orders = webService.search(pageable);
//        return orders;
//    }

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


    @PostMapping(value = "/post")
    @ResponseBody
    public String postBid(@RequestBody BidRequestBean bidRequestBean) {

        return null;
    }

    @RequestLimit(count = 1, time = 120000)
    @GetMapping(value = "/hello")
    @ResponseBody
    public String hello(@RequestHeader HttpServletRequest httpServletRequest) {
        System.out.println("11111111111111111111111111");
        return "hello word";
    }
}
