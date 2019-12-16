package com.scs.web.space.api.controller;

import com.scs.web.space.api.service.AccountService;
import com.scs.web.space.api.service.UserService;
import com.scs.web.space.api.util.Result;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * @author wf
 * @ClassName AccountController
 * @Description TODO
 * @Date 2019/12/4
 */
@RestController
@RequestMapping(value = "/api/account")
public class AccountController {
    @Resource
    private AccountService accountService;
    private UserService userService;

    @GetMapping(value = "/{id}")
    Result getUserAccount(@PathVariable int id){
        return accountService.getUserAccounts(id);
    }

}
