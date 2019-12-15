package com.scs.web.space.api.controller;

import com.scs.web.space.api.service.FriendService;
import com.scs.web.space.api.util.Result;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author wf
 * @ClassName FriendController
 * @Description TODO
 * @Date 2019/12/4
 */
@RestController
@RequestMapping(value = "/api/dynamic")

public class FriendController {
    @Resource
    private FriendService friendService;

    @GetMapping(value = "/{id}")
    Result getFriendDynamic(@PathVariable int id){
        return friendService.getFriendDynamic(id);
    }
}
