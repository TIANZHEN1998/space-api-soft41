package com.scs.web.space.api.controller;
import com.scs.web.space.api.domain.dto.AdminDto;
import com.scs.web.space.api.domain.dto.UserDto;
import com.scs.web.space.api.domain.entity.User;
import com.scs.web.space.api.service.RedisService;
import com.scs.web.space.api.service.UserService;
import com.scs.web.space.api.util.Result;
import org.springframework.web.bind.annotation.*;
import javax.annotation.Resource;
import javax.validation.Valid;
import java.io.IOException;
import java.util.List;

/**
 * @ClassName UserController
 * @Description TODO
 * @Author 田震
 * @Date 2019/12/5
 **/
@RestController
@RequestMapping(value = "/api/user")
public class UserController {
    @Resource
    private UserService userService;
    /***
     * 登录
     * @param adminDto
     * @return
     * @throws IOException
     */
    @PostMapping(value = "/login")
    public Result signIn(@RequestBody AdminDto adminDto) throws IOException {
        return  userService.login(adminDto);
    }

    /**
     * 注册
     * @param userDto
     * @return
     */
        @PostMapping(value = "/signup")
    Result signUp(@RequestBody UserDto userDto) {
        return userService.sign(userDto);
    }

    /**
     * 得到验证码
     */
    @PostMapping(value = "/sms")
    Result getSms(@RequestBody UserDto userDto) {
        return userService.sendSms(userDto);
    }
    /**
     *  检查验证码是否正确
     */
    @PostMapping(value = "/sms/check")
    Result checkSms(@RequestBody UserDto userDto) {
        return userService.checkSms(userDto);
    }



    /**
     * 查找所有用户
     * @param id
     * @return
     */
    @GetMapping(value = "/list")
    Result getAll(@PathVariable  int id) {
        return userService.selectAll(id);
    }

    /**
     *根据Id查询用户
     * @param id（成功）
     * @return
     */
    @GetMapping(value = "/{id}")
    public Result getUserById(@PathVariable("id")  @Valid int id){
        return userService.getUserById(id);
    }

    /**
     * 根据手机号查询用户的所有信息
     * @param mobile(成功)
     * @return
     */
    @GetMapping(value = "/findUserByMobile/{mobile}")
    Result findUserByMobile(@PathVariable("mobile") @Valid  String mobile){
        return  userService.getUserByMobile(mobile);
    }
    /**
     * 根据昵称模糊查询
     * @param(成功)
     * @return
     */

    @PostMapping(value = "/findUserByNickName/{key_name}")
    List<User> findUserByNickName(@PathVariable("key_name") @Valid String key_name){
        return  userService.findUserByNickName(key_name);
    }

    /**
     * 修改用户信息
     * @param user
     */
    @GetMapping(value = "/updateUser")
    public  void  updateUser(User user){
        userService.updateUser(user);
    }


}