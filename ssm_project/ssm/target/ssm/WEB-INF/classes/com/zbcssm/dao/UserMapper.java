package com.zbcssm.dao;

import com.zbcssm.pojo.User;

import java.util.List;

public interface UserMapper {
    User findUserById(int id);

    List<User> getAll();

    int addOne(User user);

    int deleteById(int id);
}

