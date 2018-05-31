package com.houkp.recommended.service.impl;

public class DemoRunnable implements Runnable {
    private Thread t;
    private String threadName;

    public DemoRunnable(String name) {
        threadName = name;
        System.out.println("Creating " +  threadName );
    }
  
    public void run() {
        System.out.println("Running " +  threadName );

        System.out.println( Thread.currentThread().getId());
        try {
            for(int i = 4; i > 0; i--) {
                System.out.println("Thread: " + threadName + ", " + i);
                // 让线程睡眠一会
                Thread.sleep(50);
            }
        }catch (InterruptedException e) {
            System.out.println("Thread " +  threadName + " interrupted.");
        }
        System.out.println("Thread " +  threadName + " exiting.");
    }

    public void start () {
        System.out.println("Starting " +  threadName );
        if (t == null) {
            t = new Thread (this, threadName);
            t.start ();
        }

        try {
            System.out.println( Thread.currentThread().getId());

            Thread.sleep(1000l);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }


}
