package com.houkp.recommended.service;

import com.houkp.recommended.service.impl.DemoThread;
import org.junit.Test;

import static org.junit.Assert.*;

public class DemoThreadTest {

  private DemoThread demoThread;
  @Test
  public void thread(){
      demoThread.run();
      demoThread.start();
  }
}