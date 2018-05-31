package com.houkp.recommended.service.impl;

import com.houkp.recommended.service.Fruits;
/**
 * 接口的工厂模式
 */
public class Orange implements Fruits {
    @Override
    public void eat() {
        System.out.println("**** 吃橘子");
    }
}
