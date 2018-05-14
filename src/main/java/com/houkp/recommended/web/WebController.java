package com.houkp.recommended.web;

import com.houkp.recommended.entity.Order;
import com.houkp.recommended.service.WebService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class WebController {

    private static final Logger log = LoggerFactory.getLogger(WebController.class);

    @Autowired
    private WebService webService;

    @RequestMapping(value =  "/orderList")
    @ResponseBody
    public Page<Order> orderList(Pageable pageable){
        Page<Order> orders = webService.search(pageable);

            return orders;
    }

    @RequestMapping(value = "/hello")
    @ResponseBody
    public String  hello(){

        return "hello word";
    }
}
