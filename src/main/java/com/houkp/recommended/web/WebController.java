package com.houkp.recommended.web;

import com.alibaba.fastjson.JSON;
import com.houkp.recommended.bean.adview.request.BidRequestBean;
import com.houkp.recommended.bean.adview.request.Impression;
import com.houkp.recommended.bean.adview.response.Bid;
import com.houkp.recommended.bean.adview.response.BidResponseBean;
import com.houkp.recommended.bean.adview.response.SeatBid;
import com.houkp.recommended.config.RequestLimit;
import com.houkp.recommended.entity.Order;
import com.houkp.recommended.service.WebService;
import io.swagger.annotations.Api;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import java.io.File;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
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
     * @param file
     * @param startDate
     * @param endDate
     * @return
     */
    @PostMapping(value = "/blackListIp")
    @ResponseBody
    public String blackListIp(@RequestParam MultipartFile file, @RequestParam String startDate, @RequestParam  String endDate) {

        file.getName();
        System.out.println(  file.getSize());
        System.out.println(  file.getName());
        System.out.println(startDate);
        System.out.println(endDate);
        return "ok";
    }


//    @PostMapping(value = "/post")
//    @ResponseBody
//    public String post(Pageable pageable,@RequestBody BidRequestBean bidRequestBean) {
//        //请求报文BidResponse返回
//        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyyMMddHHmmssSSS");
//        String format = LocalDateTime.now().format(formatter);//时间戳
//        BidResponseBean bidResponseBean= new BidResponseBean();
//        bidResponseBean.setId(bidRequestBean.getId());
//        bidResponseBean.setBidid("Bidid"+format);//BidResponse 的唯一标识,由 DSP生成
//        List<SeatBid> seatBidList =new ArrayList<SeatBid>();//注意第一层数组  DSP出价
//        List<Bid> bidList =new ArrayList<Bid>();//注意第二层数组 针对单次曝光的出价
//
//        SeatBid seatBid =new SeatBid();
//        seatBid.setSeat("seat"+format);//SeatBid 的标识,由 DSP 生成
//
//        Bid bid =new Bid();
//        bid.setAdid("adid"+format);//广告id，对应duFlowBean的AdUid；
//        List<Impression> imp = bidRequestBean.getImp();
//        Impression impression = imp.get(0);
//        bid.setImpid(impression.getId());//从bidRequestBean里面取
//        bid.setWurl("http://dsp.example.com/winnotice?price="+"60000");//赢价通知，由 AdView 服务器 发出  编码格式的 CPM 价格*10000，如价格为 CPM 价格 0.6 元，则取值0.6*10000=6000。
//        List<Map<Integer, List<String>>>  nurl =new ArrayList();
//        List<String> urls=  new ArrayList<>();
//        urls.add("http://dsp.example1.com");
//        urls.add("http://dsp.example2.com");
//        urls.add("http://dsp.example3.com");
//        urls.add("http://dsp.example4.com");
//        Map nurlMap =new HashMap();
//        nurlMap.put(0,urls);
//        nurl.add(nurlMap);
//        bid.setNurl(nurl);//带延迟的展示汇报，由客户端发送
//        bid.setAdmt(4);//广告类型
//        bid.setPrice(6000);//CPM 出价，数值为 CPM 实际价格*10000，如出价为 0.6 元，
//        bid.setCurl(urls);//点击监控地址，客户端逐个发送通知
//        bid.setCrid("crid"+format);//广告物料 ID
//        String adm =  "<meta http-equiv='Content-Type' content='text/html; charset=UTF-8' /><style type='text/css'>*{padding:0px;margin:0px;} a:link{text-decoration:none;}";
//        bid.setAdm(adm);// 广告物料数据
//        bid.setAdh(50);//广告物料高度
//        bid.setAdw(320);//广告物料宽度
//        bid.setAdct(1);// 广告点击行为类型，参考附录 9
//        bid.setCid("cid"+format);//广告创意 ID，可用于去重
//        //添加到list中
//        bidList.add(bid);
//        seatBid.setBid(bidList);
//        seatBidList.add(seatBid);
//        bidResponseBean.setSeatBid(seatBidList);
//        Object o = JSON.toJSON(bidResponseBean);
////        responseStr=o.toString();
//        return o.toString();
//    }

    @RequestLimit(count = 1,time = 120000)
    @GetMapping(value = "/hello")
    @ResponseBody
    public String hello() {
        System.out.println("11111111111111111111111111");
        return "hello word";
    }
}
