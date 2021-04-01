package com.jiaming.blog.service;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jiaming.blog.NotFoundException;
import com.jiaming.blog.dao.TypeRepository;
import com.jiaming.blog.po.Type;

@Service
public class TypeService {

    @Autowired
    private TypeRepository typeRepository;

    @Transactional
    public Type saveType(Type type){
        return typeRepository.save(type);
    }

    @Transactional
    public Type getType(Long id){
        return typeRepository.findById(id).get();
    }

    @Transactional
    public Page<Type> getTypeList(Pageable pageable){
        return typeRepository.findAll(pageable);
    }   

    @Transactional
    public Type updateType(Type type, Long id) throws NotFoundException{
        Type t = typeRepository.findById(id).orElse(null);
        if (t==null){
            throw new NotFoundException();
        }
        
        BeanUtils.copyProperties(type, t);
        
        return typeRepository.save(t);

    }

    @Transactional
    public void deleteType(Long id){
        typeRepository.deleteById(id);
    }

    @Transactional
    public Type getTypeByName(String name){
        return typeRepository.findTypeByName(name);
    }
    
}
