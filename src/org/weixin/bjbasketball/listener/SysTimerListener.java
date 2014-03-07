package org.weixin.bjbasketball.listener;

import java.util.Timer;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;


public class SysTimerListener implements ServletContextListener {
    
    private Timer timer=null;
    
    public void contextInitialized(ServletContextEvent event) {
        timer = new Timer(true);
        
        //定时抓取报名帖信息，每一小时执行一次
        timer.schedule(new DoubanTimerManager(event.getServletContext()),0,(1*60*60*1000));

    }
    
    public void contextDestroyed(ServletContextEvent event) {
        if(timer != null){
            timer.cancel();
        }
    }

    
    
}
