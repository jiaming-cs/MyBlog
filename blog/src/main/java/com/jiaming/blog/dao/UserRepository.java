package com.jiaming.blog.dao;

import com.jiaming.blog.po.User;

import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
    User findByUserNameAndPassWord(String userName, String passWord);
}
