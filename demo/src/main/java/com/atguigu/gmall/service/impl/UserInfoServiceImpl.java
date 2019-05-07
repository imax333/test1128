package com.atguigu.gmall.service.impl;

import com.atguigu.gmall.entity.UserInfo;
import com.atguigu.gmall.mapper.UserInfoMapper;
import com.atguigu.gmall.service.UserInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

import java.util.List;


@Service
public class UserInfoServiceImpl implements UserInfoService {


    private UserInfoMapper userInfoMapper;

    @Autowired
    public void setUserInfoMapper(UserInfoMapper userInfoMapper){
        this.userInfoMapper = userInfoMapper;

    }


    @Override
    public List<UserInfo> getUserInfoAll() {
        return userInfoMapper.selectAll();
    }

    @Override
    public void addUserInfo(UserInfo userInfo) {
        userInfoMapper.insertSelective(userInfo);
    }

    @Override
    public void update(UserInfo userInfo) {

        userInfoMapper.updateByPrimaryKeySelective(userInfo);
    }

    @Override
    public void updateByLoginName(String loginName) {
        Example example = new Example(UserInfo.class);
        example.createCriteria().andEqualTo("loginName",loginName);

        UserInfo userInfo = new UserInfo();
        userInfo.setName("test");
        userInfoMapper.updateByExampleSelective(userInfo,example);
    }

    @Override
    public void updateByEmail(String email) {
        Example example = new Example(UserInfo.class);

        example.createCriteria().andEqualTo("email",email);

        UserInfo userInfo = new UserInfo();
        userInfo.setNickName("小李");

        userInfoMapper.updateByExampleSelective(userInfo,example);

    }

    @Override
    public void deleteById(String id) {


        userInfoMapper.deleteByPrimaryKey(id);
    }

    @Override
    public void deleteByEmail(String email) {

        Example example = new Example(UserInfo.class);

        example.createCriteria().andEqualTo("email",email);

        userInfoMapper.deleteByExample(example);
    }

    @Override
    public void updatePasswordByEmail(String email) {

        Example example = new Example(UserInfo.class);

        example.createCriteria().andEqualTo("email",email);

        UserInfo userInfo = new UserInfo();
        userInfo.setPasswd("2333333");
        userInfoMapper.updateByExampleSelective(userInfo,example);
    }

    @Override
    public UserInfo selectUserInfo(UserInfo userInfo) {


        // userInfoMapper.selectOne(userInfo);
        return  userInfoMapper.selectOne(userInfo);
    }

    @Override
    public UserInfo selectUserInfoByLoginName(String loginName) {

        Example example = new Example(UserInfo.class);
        example.createCriteria().andEqualTo("loginName",loginName);
        return   userInfoMapper.selectOneByExample(example);
    }


}
