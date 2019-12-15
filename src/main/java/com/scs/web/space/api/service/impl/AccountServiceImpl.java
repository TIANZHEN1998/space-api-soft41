package com.scs.web.space.api.service.impl;

import com.scs.web.space.api.mapper.AccountMapper;
import com.scs.web.space.api.mapper.UserMapper;
import com.scs.web.space.api.service.AccountService;
import com.scs.web.space.api.util.Mail163Test;
import com.scs.web.space.api.util.Result;
import com.scs.web.space.api.util.ResultCode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author wf
 * @ClassName AccountServiceImpl
 * @Description TODO
 * @Date 2019/12/4
 */
@Service
public class AccountServiceImpl implements AccountService {
    @Resource
    private AccountMapper accountMapper;
    private UserMapper userMapper;
    private Logger logger = LoggerFactory.getLogger(AccountServiceImpl.class);

    @Override
    public Result getUserAccounts(int id) {
        Map map = new HashMap();
        try {
            map = accountMapper.getUserAccount(id);
        } catch (SQLException e) {
            logger.error("查询用户account异常");
        }
        if(map != null){
            return Result.success(map);
        }
        return Result.failure(ResultCode.RESULT_CODE_DATA_NONE);
    }

    @Override
    public List list() {
        return null;
    }

    @Override
    public void ActivationMobile(String email) {
        try {
            Mail163Test.Email(email);
            userMapper.jihuo(1,email);
        } catch (Exception e) {
            logger.error("邮箱发送异常");
        }
    }


}
