package com.hiya.jdktools;

import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

public class ThreadTest   implements Runnable
{
    @Override
    public void run()
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
    }
}


