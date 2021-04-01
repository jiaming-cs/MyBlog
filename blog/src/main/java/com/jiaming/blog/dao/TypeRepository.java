package com.jiaming.blog.dao;

import com.jiaming.blog.po.Type;

import org.springframework.data.jpa.repository.JpaRepository;

public interface TypeRepository extends JpaRepository<Type, Long> {
    Type findTypeByName(String name);
}
