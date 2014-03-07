package org.weixin.bjbasketball.model;

import java.util.Date;
import java.util.List;

public class Group {

    private String domain; // 是否公开
    
    private String uid; // 小组豆瓣名称
    
    private String member_role;

    private String alt;
    
    private String id;  // 小组的uid
    
    private String name;    //小组名称

    private String desc;

    private String member_count;

    private Date created;

    private String admin_role_name; //管理员昵称

    private String member_role_name;    //用户昵称
    
    private List<Author> owners;
    
    private List<Author> admins;

    public String getDomain() {
        return domain;
    }

    public void setDomain(String domain) {
        this.domain = domain;
    }

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public String getMember_role() {
        return member_role;
    }

    public void setMember_role(String memberRole) {
        member_role = memberRole;
    }

    public String getAlt() {
        return alt;
    }

    public void setAlt(String alt) {
        this.alt = alt;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public String getMember_count() {
        return member_count;
    }

    public void setMember_count(String memberCount) {
        member_count = memberCount;
    }

    public Date getCreated() {
        return created;
    }

    public void setCreated(Date created) {
        this.created = created;
    }

    public String getAdmin_role_name() {
        return admin_role_name;
    }

    public void setAdmin_role_name(String adminRoleName) {
        admin_role_name = adminRoleName;
    }

    public String getMember_role_name() {
        return member_role_name;
    }

    public void setMember_role_name(String memberRoleName) {
        member_role_name = memberRoleName;
    }

    public List<Author> getOwners() {
        return owners;
    }

    public void setOwners(List<Author> owners) {
        this.owners = owners;
    }

    public List<Author> getAdmins() {
        return admins;
    }

    public void setAdmins(List<Author> admins) {
        this.admins = admins;
    }

}
