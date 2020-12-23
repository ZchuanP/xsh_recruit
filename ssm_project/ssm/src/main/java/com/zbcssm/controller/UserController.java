package com.zbcssm.controller;


import com.zbcssm.pojo.User;
import com.zbcssm.service.UserServiceImpl;
import com.zbcssm.util.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("/homework")
public class UserController {
    public Result result = new Result();
    @Autowired
    private UserServiceImpl userService;

    @RequestMapping("/getAll")
    @ResponseBody
    public Result getAll(){
        List<User> users=userService.getAll();
        result.setCount(users.size());
        if(result.getCount()!=0) {
            result.setMsg("全部的数据");
            result.setStatus(200);
        }
        else{
            result.setStatus(400);
            result.setMsg("没有数据");
        }
        result.setUsers(users);
        return result;
    }

    @RequestMapping("/add")
    @ResponseBody
    public Result addOne(@RequestBody User user){
        User user1 = userService.findUserById(user.getId());
        if(user1!=null){
            result.setStatus(403);
            result.setMsg("已经存在名字"+user1.getName()+" Id为"+user1.getId());
            result.setUsers(null);
            result.setCount(0);
        }
        else{
            userService.addOne(user);
            List<User> users=userService.getAll();
            result.setStatus(200);
            result.setMsg("加入名字为"+user.getName()+" id为"+user.getId());
            result.setUsers(users);
            result.setCount(users.size());
        }

        return result;
    }


    @RequestMapping("/delete")
    @ResponseBody
    public Result deleteOne(@RequestBody User user){
        User user1= userService.findUserById(user.getId());
        if(user1!=null){
            userService.deleteById(user.getId());
            List<User> users=userService.getAll();
            result.setStatus(201);
            result.setMsg("删除名字"+user.getName()+" id为"+user.getId());
            result.setUsers(users);
            result.setCount(users.size());
        }
        else{
            result.setStatus(400);
            result.setMsg("这个id不存在 id为"+user.getId());
            result.setUsers(null);
            result.setCount(0);
        }

        return result;
    }

}
