package com.scs.web.space.api.controller;
import com.scs.web.space.api.domain.entity.VerifyNumber;
import com.scs.web.space.api.service.RedisService;
import com.scs.web.space.api.service.UserService;
import com.scs.web.space.api.util.Result;
import com.scs.web.space.api.util.ResultCode;
import com.scs.web.space.api.util.SmsUtil;
import org.springframework.web.bind.annotation.*;
import javax.annotation.Resource;
import java.sql.SQLException;
import java.util.Date;

/**
 * @ClassName SmsController
 * @Description TODO
 * @Author 田震
 * @Date 2019/12/6
 **/
@RestController
@RequestMapping(value = "/api/sms")
public class SmsController {
    @Resource
    private RedisService redisService;
    @Resource
    private UserService  userService;
    private String phone;
    String verifyCode;
    /**
     * 通过短信验证注册
     * @param mobile（成功）
     * @return
     */
    @PostMapping(value = "/sendcode")
    public Result getVerifyCode(@RequestParam(value = "mobile") String mobile) throws SQLException {

            if (userService.getUserByMobile(mobile) != null) {
                return Result.failure(ResultCode.USER_HAS_EXISTED);
            } else {
                //发送验证码
                verifyCode = SmsUtil.send(mobile);
                /**
                 * 将手机号、验证码、发送和时间孙进redis
                 */
                VerifyNumber number = new VerifyNumber(mobile, verifyCode, new Date());
                redisService.set(mobile, number);
                return Result.success();
            }
    }

    /**
     * 根据短信验证直接登录
     * @param mobile
     * @return(成功)
     * @throws SQLException
     */
    @PostMapping(value = "/sendcode1")
    public Result getVerifyCode1(@RequestParam(value = "mobile") String mobile) throws SQLException {
        if (userService.getUserByMobile(mobile) != null) {
            verifyCode = SmsUtil.send(mobile);
            VerifyNumber number = new VerifyNumber(mobile, verifyCode, new Date());
            redisService.set(mobile, number);
            return Result.success();
        }else {
            return Result.failure(ResultCode.USER_NOT_EXIST);
        }
    }


    /**
     * 从Redis中取出这个手机号的验证码
     * 和客户端传过来的验证码比对
     *（成功）
     * @param mobile
     * @param verifyCode
     * @return
     */
    @PostMapping(value = "/checkcode")
    public Result checkVerifyCode(@RequestParam("mobile") String mobile, @RequestParam("verifyCode") String verifyCode) {
        VerifyNumber number = redisService.getValue(mobile, VerifyNumber.class);
        //从redis中先取出code，和verifyCode比较
        if (number.getCode().equals(verifyCode)) {
            if (((System.currentTimeMillis() - number.getTime().getTime()) /(1000*60)) <= 5) {

                return Result.success();
            } else {
                return Result.failure(ResultCode.USER_VERIFY_OVERDUE);
            }
        } else {
            return Result.failure(ResultCode.USER_VERIFY_CODE_ERROR);
        }
    }
}