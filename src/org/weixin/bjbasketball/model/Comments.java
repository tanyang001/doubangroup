package org.weixin.bjbasketball.model;

import java.util.List;

/**
 * @COMPANY: 北京亿脑信息技术有限公司
 * @CLASS: Comments
 * @DESCRIPTION: 评论列表类
 * @AUTHOR: tanyang
 * @VERSION: v1.0
 * @DATE: 2014-3-5 上午10:01:47
 */
public class Comments {
    
    private Integer total;   //回复总数
    
    private List<Comment> comments;  //回复内容实体

    public Integer getTotal() {
        return total;
    }

    public void setTotal(Integer total) {
        this.total = total;
    }

    public List<Comment> getComments() {
        return comments;
    }

    public void setComments(List<Comment> comments) {
        this.comments = comments;
    }
    
}
