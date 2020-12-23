package com.zbcssm.service;

import com.zbcssm.dao.UserMapper;
import com.zbcssm.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
@EnableTransactionManagement(proxyTargetClass = true)
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper userMapper;

    @Override
    public User findUserById(int id){
        return this.userMapper.findUserById(id);
    }

    @Override
    public List<User> getAll(){
        return userMapper.getAll();
    }

    @Override
    public int deleteById(int id){
        return userMapper.deleteById(id);
    }

    @Override
    public int addOne(User user) {
        return userMapper.addOne(user);
    }
}
