package com.atguigu.gmall.service;

import com.atguigu.gmall.entity.UserInfo;

import java.util.List;

public interface UserInfoService {


    List<UserInfo> getUserInfoAll();

    void addUserInfo(UserInfo userInfo);

    void update(UserInfo userInfo);

    void updateByLoginName(String loginName);

    void updateByEmail(String  email);

    void deleteById(String id);

    void deleteByEmail(String email);

    void updatePasswordByEmail(String email);

    UserInfo selectUserInfo(UserInfo userInfo);

    UserInfo selectUserInfoByLoginName(String loginName);
}
