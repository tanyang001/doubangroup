package org.weixin.bjbasketball.model;

import java.util.Date;

/**
 * @COMPANY: 北京亿脑信息技术有限公司
 * @CLASS: Comment
 * @DESCRIPTION: 评论实体类
 * @AUTHOR: tanyang
 * @VERSION: v1.0
 * @DATE: 2014-3-5 上午10:02:58
 */
public class Comment {
    
    private String text; //回复内容
    
    private Author author;   //回复人
    
    private String id;  //id
    
    private Date time;  //回复时间

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Author getAuthor() {
        return author;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }

}
