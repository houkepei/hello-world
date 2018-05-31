package com.houkp.recommended.service.impl;

import com.houkp.recommended.service.Subject;

/**
 * 真正主题的接口代理模式
 */
public class RealSubject implements Subject {
    @Override
    public void make() {
        System.out.println("真正主题内容");
    }
}
