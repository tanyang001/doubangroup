package org.weixin.bjbasketball.model;

import java.util.Date;

public class Topics {
    
    private String id;
    
    private String title;
    
    private String content;
    
    private Date created;
    
    private Date updated;
    
    private String alt;
    
    private String locked;
    
    private Author author;
    
    private String comments_count;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Date getCreated() {
        return created;
    }

    public void setCreated(Date created) {
        this.created = created;
    }

    public Date getUpdated() {
        return updated;
    }

    public void setUpdated(Date updated) {
        this.updated = updated;
    }

    public String getAlt() {
        return alt;
    }

    public void setAlt(String alt) {
        this.alt = alt;
    }

    public String getLocked() {
        return locked;
    }

    public void setLocked(String locked) {
        this.locked = locked;
    }

    public Author getAuthor() {
        return author;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }

    public String getComments_count() {
        return comments_count;
    }

    public void setComments_count(String commentsCount) {
        comments_count = commentsCount;
    }
    
}
