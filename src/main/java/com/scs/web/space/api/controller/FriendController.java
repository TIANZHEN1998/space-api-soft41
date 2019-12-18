package com.scs.web.space.api.controller;

import com.scs.web.space.api.domain.dto.FriendDto;
import com.scs.web.space.api.domain.entity.Friend;
import com.scs.web.space.api.service.FriendService;
import com.scs.web.space.api.util.Result;
import org.apache.ibatis.annotations.Param;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.validation.Valid;
import java.util.List;

/**
 * @author wf
 * @ClassName FriendController
 * @Description TODO
 * @Date 2019/12/4
 */
@RestController
@RequestMapping(value = "/api/friend")

public class FriendController {
    @Resource
    private FriendService friendService;

    @GetMapping(value = "/{id}")
    Result getFriendDynamic(@PathVariable int id){
        return friendService.getFriendDynamic(id);
    }

    /**
     * 根据好友的id获取自己的好友(成功)
     * * @param from_id
     * @param to_id
     * @return
     */
    @PostMapping(value = "/listfriend/{from_id}/{to_id}")
    List<FriendDto> listfrined(@PathVariable Integer from_id,
                             @PathVariable Integer to_id){
        System.out.println(from_id+"   "+to_id);
       return  friendService.listFriend(from_id, to_id);
    }

    /**
     * 查看双向非好友并获取（成功）
     * @param from_id
     * @param to_id
     * @return
     */

    @PostMapping(value = "/listnotfriend/{from_id}/{to_id}")
    List<FriendDto> listnotfrined(@PathVariable("from_id") Integer from_id,
                               @PathVariable("to_id") Integer to_id){
        return  friendService.listnotFriend(from_id, to_id);
    }


    /**
     * 发送好友申请(成功)
     * @param friend
     * @returnr
     */
    @PostMapping(value = "/insertfriend")
    Result insetfriend(@RequestBody FriendDto friend) {
        return  friendService.insertFriend(friend);
    }

    /**
     * 同意好友之后将Status改为1
     * @param friendDto
     * @return
     */
    @PostMapping(value = "/updatestatus")
    Result updatestatus(@RequestBody FriendDto friendDto){
        return  friendService.updatestatus(friendDto);
    }
}
