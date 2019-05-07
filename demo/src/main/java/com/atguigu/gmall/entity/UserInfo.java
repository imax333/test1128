package com.atguigu.gmall.entity;


import lombok.Data;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Data
public class UserInfo {


    /**
     * TABLE：使用一个特定的数据库表格来保存主键。
     SEQUENCE：根据底层数据库的序列来生成主键，条件是数据库支持序列。
     IDENTITY：主键由数据库自动生成（主要是自动增长型）
     AUTO：主键由程序控制。
     strategy 策略
     */
    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String id;
    @Column
    private String loginName;
    @Column
    private String nickName;
    @Column
    private String passwd;
    @Column
    private String name;
    @Column
    private String phoneNum;
    @Column
    private String email;
    @Column
    private String headImg;
    @Column
    private String userLevel;


}
