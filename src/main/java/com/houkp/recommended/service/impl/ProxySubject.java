package com.houkp.recommended.service.impl;

import com.houkp.recommended.service.Subject;

/**
 * 代理主题的接口代理模式
 */
public class ProxySubject implements Subject {
    private Subject subject;

    //要接收一个真实主题的操作对象
    public  ProxySubject(Subject subject){
        this.subject=subject;
    }
    //准备前工作
    public void prepare(){
        System.out.println("1,准备前工作");
    }
    @Override
    public void make() {
        this.prepare();
        this.subject.make();
        this.destroy();
    }
    //销毁
    public void  destroy(){
        System.out.println("3.销毁工作");
    }
}
