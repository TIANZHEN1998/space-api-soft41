package com.scs.web.space.api.service;


import com.scs.web.space.api.domain.dto.FriendDto;
import com.scs.web.space.api.domain.entity.Friend;
import com.scs.web.space.api.util.Result;

import java.util.List;

public interface FriendService {

    Result getFriendDynamic(int userId);

    /**
     * 根据两个好友的id查询当前的状态是否为好友
     * @param from_id
     * @param to_id
     * @return
     */
    Friend findStatus(int from_id,int to_id);

    /**
     * 查找根据from_id 和to_id来查找自己的好友的接口
     * @param from_id
     * @param to_id
     * @return
     */
    List<FriendDto> listFriend(Integer from_id,Integer to_id);

    /**
     * 查询双向非好友（status为0）
     * @param from_id
     * @param to_id
     * @return
     */
    List<FriendDto> listnotFriend(Integer from_id,Integer to_id);

    /**
     * 发送好友申请，此时的状态status为0
     * @param friend
     * @return
     */
   Result insertFriend(FriendDto friend);

    /**
     * 同意好友，将0变为1
     * @param friendDto
     * @return
     */
   Result updatestatus(FriendDto friendDto);
}
