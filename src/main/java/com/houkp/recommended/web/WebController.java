package com.houkp.recommended.web;

import com.houkp.recommended.entity.Order;
import com.houkp.recommended.service.WebService;
import io.swagger.annotations.Api;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;






@Api(value = "WebController",description = "推荐中心")
@Controller
public class WebController {

    private static final Logger log = LoggerFactory.getLogger(WebController.class);

    @Autowired
    private WebService webService;

    @GetMapping(value =  "/orderList")
    @ResponseBody
    public Page<Order> orderList(Pageable pageable){
        Page<Order> orders = webService.search(pageable);

            return orders;
    }

    @GetMapping(value = "/hello")
    @ResponseBody
    public String  hello(){

        return "hello word";
    }
}
