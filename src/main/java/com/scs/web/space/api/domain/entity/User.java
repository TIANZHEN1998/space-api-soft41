package com.scs.web.space.api.domain.entity;

import lombok.Builder;
import lombok.Data;

import java.sql.Date;
import java.sql.Timestamp;
import java.util.List;

/**
 * @ClassName User
 * @Description 用户实体类
 * @Author mq_xu
 * @Date 2019/12/1
 **/
@Data
public class User {
    private Integer id;
    private String mobile;
    private String password;
    private String nickname;
    private String avatar;
    private String autograph;
    private String introduction;
    private String email;
    private String birthday;
    private  String job;
    private  String hobby;
    private  String constellation;
    private Integer styleId;
    private Short permission;
    private String code;
    private Short status;
    private Timestamp createTime;
    private  String address;
    private  String backgroundimg;
    private  String flower;
    private List<Notes> notesList;
    private Comment comment;
    private List<Album> album;

}
