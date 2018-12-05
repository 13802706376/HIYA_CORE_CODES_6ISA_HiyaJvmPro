package com.hiya.jdktools;

import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

/*
看看执行结果
可以看到刚才的已经执行的代码
schedule.JDKTimerDemo
Output:
9736 AppMain schedule.JDKTimerDemo
1612
7788 Jps -m
 */
public class JpsTest 
{
    public static void main(String[] args) 
    {
        Timer timer = new Timer();
        timer.schedule(new TimerTask() 
        {
            @Override            
            public void run() 
            {
                System.out.println(Thread.currentThread().getName()+ " is running");
            }
        }, new Date(), 10000);
        
     
        
        
        ThreadTest test1 = new ThreadTest();
        Thread t1 = new Thread(test1);
        t1.start();
        
        ThreadTest test2 = new ThreadTest();
        Thread t2 = new Thread(test2);
        t2.start();
    } 
}



