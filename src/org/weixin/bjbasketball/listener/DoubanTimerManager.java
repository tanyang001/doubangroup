package org.weixin.bjbasketball.listener;

import java.util.TimerTask;

import javax.servlet.ServletContext;

import org.weixin.bjbasketball.service.DoubanService;

public class DoubanTimerManager extends TimerTask{
    
    private ServletContext servletContent = null;

    public DoubanTimerManager(ServletContext servletContent) {
        this.servletContent = servletContent;
    }

    @Override
    public void run() {
        DoubanService.getApplyURLByJson();
        DoubanService.getApplyMemberCountByJson();
    }

}
