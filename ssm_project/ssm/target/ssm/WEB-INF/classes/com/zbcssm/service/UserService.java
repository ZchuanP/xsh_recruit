package com.zbcssm.service;


import com.zbcssm.pojo.User;

import java.util.List;

public interface UserService {
    User findUserById(int id);

    List<User> getAll();

    int addOne(User user);

    int deleteById(int id);

}
