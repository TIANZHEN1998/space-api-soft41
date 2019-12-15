package com.scs.web.space.api.service;

import com.scs.web.space.api.domain.dto.AdminDto;
import com.scs.web.space.api.domain.dto.UserDto;
import com.scs.web.space.api.domain.entity.User;
import com.scs.web.space.api.util.Result;

import java.util.List;
import java.util.Map;

/**
 * @ClassName UserService
 * @Description 用户服务接口
 * @Author
 * @Date 2019/12/1
 **/
public interface UserService {

    /***
     * 用户登录功能
     * @return
     */
    Result login(AdminDto  adminDto);


    /**
     * 用户注册功能
     *
     * @param userDto
     * @return Result
     */
    Result sign(UserDto userDto);

    /**
     * 获取短信验证
     * @param userDto
     * @return
     */
    Result sendSms(UserDto userDto);


    /**
     * 验证短信是否正确（signDto中有手机号和验证码两部分内容）
     * @param userDto
     * @return Result
     */
    Result checkSms(UserDto userDto);

    /**
     * 根据昵称模糊查询
     * @return
     */

    List<User> findUserByNickName(String key_name);



    /**
     * 查询所有用户
     *
     * @return Result
     * @author mq_xu
     * @date 2019.12.1
     */
    Result selectAll(int id);

    /**
     * 根据id查询用户
     * @param id
     * @author taoyongxin
     * @return Result
     */
    Result getUserById(int id);

    /***
     * 根据手机号查询用户的全部信息
     * @param mobile
     * @return
     */
    Result getUserByMobile(String mobile);

    Result getDynamicById(int id);

    /**
     * 修改用户信息
     * @param user
     * @return
     */
      int updateUser(User user);

    /**
     * 根据手机号查看是否存在此用户
     * @param mobile
     * @return
     */

    Result findUserByMobile(String mobile);

}
