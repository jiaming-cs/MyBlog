package com.jiaming.blog.po;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;


@Entity
@Table(name = "t_blog")
public class Blog {

    @Id
    @GeneratedValue
    private Long id;
    private String title;
    private String content;
    private String frontPageImg;
    private String flag;
    private Integer views;
    private boolean allowAppreciation;
    private boolean allowShare;
    private boolean allowComment;
    @Temporal(TemporalType.TIMESTAMP)
    private Date releaseTime;
    @Temporal(TemporalType.TIMESTAMP)
    private Date createTime;
    @Temporal(TemporalType.TIMESTAMP)
    private Date renewTime;

    @ManyToOne
    private Type type;

    @ManyToMany(cascade = {CascadeType.PERSIST})
    private List<Tag> tags = new ArrayList<>();
    
    @ManyToOne
    private User user;

    @OneToMany(mappedBy = "blog")
    private List<Comment> comments = new ArrayList<>();
    
    public Blog() {
    }


    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
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

    public String getFrontPageImg() {
        return frontPageImg;
    }

    public void setFrontPageImg(String frontPageImg) {
        this.frontPageImg = frontPageImg;
    }

    public String getFlag() {
        return flag;
    }

    public void setFlag(String flag) {
        this.flag = flag;
    }

    public Integer getViews() {
        return views;
    }

    public void setViews(Integer views) {
        this.views = views;
    }

    public boolean isAllowAppreciation() {
        return allowAppreciation;
    }

    public void setAllowAppreciation(boolean allowAppreciation) {
        this.allowAppreciation = allowAppreciation;
    }

    public boolean isAllowShare() {
        return allowShare;
    }

    public void setAllowShare(boolean allowShare) {
        this.allowShare = allowShare;
    }

    public boolean isAllowComment() {
        return allowComment;
    }

    public void setAllowComment(boolean allowComment) {
        this.allowComment = allowComment;
    }

    public Date getReleaseTime() {
        return releaseTime;
    }

    public void setReleaseTime(Date releaseTime) {
        this.releaseTime = releaseTime;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getRenewTime() {
        return renewTime;
    }

    public void setRenewTime(Date renewTime) {
        this.renewTime = renewTime;
    }

    @Override
    public String toString() {
        return "Blog [allowAppreciation=" + allowAppreciation + ", allowComment=" + allowComment + ", allowShare="
                + allowShare + ", content=" + content + ", createTime=" + createTime + ", flag=" + flag
                + ", frontPageImg=" + frontPageImg + ", releaseTime=" + releaseTime + ", renewTime=" + renewTime
                + ", title=" + title + ", views=" + views + "]";
    }



    public Type getType() {
        return type;
    }



    public void setType(Type type) {
        this.type = type;
    }



    public List<Tag> getTags() {
        return tags;
    }



    public void setTags(List<Tag> tags) {
        this.tags = tags;
    }



    public User getUser() {
        return user;
    }



    public void setUser(User user) {
        this.user = user;
    }



    public List<Comment> getComments() {
        return comments;
    }



    public void setComments(List<Comment> comments) {
        this.comments = comments;
    }


    
    
    
}
