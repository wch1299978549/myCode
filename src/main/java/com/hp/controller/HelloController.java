package com.hp.controller;

import com.hp.pojo.User;
import com.hp.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.sql.DataSource;
import java.util.List;

@Controller
@RequestMapping(value = "user")
public class HelloController {

    @Autowired
    UserService userService;

    @GetMapping("say")
    @ResponseBody
    public String sayHello(){
        return "hello";
    }
    @GetMapping("/{id}")
    @ResponseBody
    public User queryUserById(@PathVariable("id")Long userId){
        User user = userService.queryUserById(userId);
        return user;
    }
    @GetMapping("delete/{id}")
    @ResponseBody
    public String deleteUserById(@PathVariable("id")Long userId){

        if(userService.deleteUserById(userId)){
            return "true";
        }
        return "flase";
    }

    @RequestMapping("users")
    public String Users(Model model){
        List<User> users = userService.queryAllUser();
        model.addAttribute("users",users);
        return "users";
    }


}
