package com.jiaming.blog.service;

import com.jiaming.blog.dao.UserRepository;
import com.jiaming.blog.po.User;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public User checkUser(String userName, String passWord){
        User user = userRepository.findByUserNameAndPassWord(userName, passWord);
        return user;
    }
}
