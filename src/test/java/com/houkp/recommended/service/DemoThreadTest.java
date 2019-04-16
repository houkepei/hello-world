package com.houkp.recommended.service;

import com.houkp.recommended.config.FruitsFactory;
import com.houkp.recommended.service.impl.DemoRunnable;
import com.houkp.recommended.service.impl.ProxySubject;
import com.houkp.recommended.service.impl.RealSubject;
import org.junit.Test;

import static org.junit.Assert.*;

public class DemoThreadTest {


  @Test
  public void thread(){
      DemoRunnable demoRunnable1 =new DemoRunnable("Runnable 1");
      DemoRunnable demoRunnable2 =new DemoRunnable("Runnable 2");
      DemoRunnable demoRunnable3 =new DemoRunnable("Runnable 3");

      demoRunnable1.start();
      demoRunnable2.start();
      demoRunnable3.start();
  }
    @Test
    public void fruits(){
        Fruits f = FruitsFactory.getFruits("com.houkp.recommended.service.impl.Apple");
        f.eat();
    }

    @Test
    public void subject(){
       Subject subject=new ProxySubject( new RealSubject());
        subject.make();
    }


}