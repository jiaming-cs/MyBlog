package com.jiaming.blog.po;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "t_comment")
public class Comment {

    @Id
    @GeneratedValue
    private Long id;
    private String nikeName;
    private String email;
    private String content;
    private String avatar;
    @Temporal(TemporalType.TIMESTAMP)
    private Date creatDate;

    @ManyToOne
    private Blog blog;

    @ManyToOne
    private Comment parentComment;

    @OneToMany(mappedBy = "parentComment")
    private List<Comment> subComments = new ArrayList<>();
    
    public Comment() {
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
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public String getContent() {
        return content;
    }
    public void setContent(String content) {
        this.content = content;
    }
    public String getAvatar() {
        return avatar;
    }
    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }
    public Date getCreatDate() {
        return creatDate;
    }
    public void setCreatDate(Date creatDate) {
        this.creatDate = creatDate;
    }

    @Override
    public String toString() {
        return "Comment [avatar=" + avatar + ", content=" + content + ", creatDate=" + creatDate + ", email=" + email
                + ", id=" + id + ", nikeName=" + nikeName + "]";
    }


    public Comment getParentComment() {
        return parentComment;
    }


    public void setParentComment(Comment parentComment) {
        this.parentComment = parentComment;
    }


    public List<Comment> getSubComments() {
        return subComments;
    }


    public void setSubComments(List<Comment> subComments) {
        this.subComments = subComments;
    }


    public Blog getBlog() {
        return blog;
    }


    public void setBlog(Blog blog) {
        this.blog = blog;
    }

    
}
