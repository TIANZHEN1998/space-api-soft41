package com.scs.web.space.api.service;


import com.scs.web.space.api.domain.entity.Friend;
import com.scs.web.space.api.util.Result;

public interface FriendService {

    Result getFriendDynamic(int userId);

    /**
     * 根据两个好友的id查询当前的状态是否为好友
     * @param from_id
     * @param to_id
     * @return
     */
    Friend findStatus(int from_id,int to_id);
}
