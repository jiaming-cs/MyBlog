package com.jiaming.blog.po;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "t_user")
public class User {

    @Id
    @GeneratedValue
    private Long id;
    private String nikeName;
    private String userName;
    private String passWord;
    private String email;
    private String avatar;
    private Integer type;
    @Temporal(TemporalType.TIMESTAMP)
    private Date createTime;
    @Temporal(TemporalType.TIMESTAMP)
    private Date updateTime;

    @OneToMany(mappedBy = "user")
    private List<Blog> blogs = new ArrayList<>();     
    
    public User() {
    }

    
    

    @Override
    public String toString() {
        return "User [avatar=" + avatar + ", createTime=" + createTime + ", email=" + email + ", id=" + id
                + ", nikeName=" + nikeName + ", passWord=" + passWord + ", type=" + type + ", updateTime=" + updateTime
                + ", userName=" + userName + "]";
    }




    public Long getId() {
        return id;
    }




    public void setId(Long id) {
        this.id = id;
    }




    public String getNikeName() {
        return nikeName;
    }




    public void setNikeName(String nikeName) {
        this.nikeName = nikeName;
    }




    public String getUserName() {
        return userName;
    }




    public void setUserName(String userName) {
        this.userName = userName;
    }




    public String getPassWord() {
        return passWord;
    }




    public void setPassWord(String passWord) {
        this.passWord = passWord;
    }




    public String getEmail() {
        return email;
    }




    public void setEmail(String email) {
        this.email = email;
    }




    public String getAvatar() {
        return avatar;
    }




    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }




    public Integer getType() {
        return type;
    }




    public void setType(Integer type) {
        this.type = type;
    }




    public Date getCreateTime() {
        return createTime;
    }




    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }




    public Date getUpdateTime() {
        return updateTime;
    }




    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }
    
    
    
}
