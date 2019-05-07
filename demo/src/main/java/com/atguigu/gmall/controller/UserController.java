package com.atguigu.gmall.controller;


import com.atguigu.gmall.entity.UserInfo;
import com.atguigu.gmall.service.UserInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class UserController {


    private UserInfoService userInfoService;

    @Autowired
    public void setUserInfoService(UserInfoService userInfoService){
        this.userInfoService = userInfoService;

    }


    @ResponseBody
    @RequestMapping("getAll")
    public List<UserInfo> getAll(){
        return  userInfoService.getUserInfoAll();
    }


    @RequestMapping("add")
    @ResponseBody
    public String addUserInfo(){

        UserInfo userInfo = new UserInfo();
        userInfo.setLoginName("cc");
        userInfo.setEmail("cc@qq.com");
        userInfoService.addUserInfo(userInfo);
        return "ok";
    }

    @ResponseBody
    @RequestMapping("update")
    public String update(){

        UserInfo userInfo = new UserInfo();

        userInfo.setId("4");
        userInfo.setLoginName("cc");
        userInfo.setEmail("123456@qq.com");

        userInfoService.update(userInfo);

        return "success";
    }



    @RequestMapping("update1")
    @ResponseBody
    public String update1(String loginName){
        userInfoService.updateByLoginName(loginName);
        return "ok";
    }




    @ResponseBody
    @RequestMapping("updateByEmail")
    public String updateByEmail(String email){

        userInfoService.updateByEmail(email);

        return "update by email";
    }


    @ResponseBody
    @RequestMapping("delete")
    public String deleteById(String id){

        userInfoService.deleteById(id);
        return "delete by id";
    }


    @ResponseBody
    @GetMapping("deleteByEmail")
    public String deleteByEmail(String email){
        userInfoService.deleteByEmail(email);

        return "delete by email";

    }


    @ResponseBody
    @GetMapping("updatePasswordByEmail")
    public String updatePasswordByEmail(String email){

        userInfoService.updatePasswordByEmail(email);

        return "update password by email";

    }


    @ResponseBody
    @RequestMapping("selectOne")
    public UserInfo selectUserInfo(){

        UserInfo userInfo = new UserInfo();
        userInfo.setLoginName("cc");

      return   userInfoService.selectUserInfo(userInfo);
    }


    @ResponseBody
    @GetMapping("selectUserInfoByLoginName")
    public UserInfo selectUserInfoByLoginName(String loginName){

        return userInfoService.selectUserInfoByLoginName(loginName);

    }



}
