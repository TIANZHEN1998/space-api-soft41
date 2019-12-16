package com.scs.web.space.api.service.impl;

import com.scs.web.space.api.domain.dto.FriendDto;
import com.scs.web.space.api.domain.entity.Friend;
import com.scs.web.space.api.mapper.FriendMapper;
import com.scs.web.space.api.service.FriendService;
import com.scs.web.space.api.util.Result;
import com.scs.web.space.api.util.ResultCode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author wf
 * @ClassName FriendServiceImpl
 * @Description TODO
 * @Date 2019/12/4
 */
@Service
public class FriendServiceImpl implements FriendService {
    @Resource
    private FriendMapper friendMapper;
    private Logger logger = LoggerFactory.getLogger(FriendServiceImpl.class);

    @Override
    public Result getFriendDynamic(int userId) {
        List<Friend> friendList = new ArrayList<>();
        try {
            friendList = friendMapper.getFriendDynamicById(userId);
        } catch (SQLException e) {
            logger.error("好友动态查询异常");
        }
        if (friendList != null) {
            return Result.success(friendList);
        }
        return Result.failure(ResultCode.RESULT_CODE_DATA_NONE);
    }

    @Override
    public Friend findStatus(int from_id, int to_id)
    {
        return null;
    }

    @Override
    public List<FriendDto> listFriend(Integer from_id, Integer to_id) {
        List<FriendDto> listFriend =new ArrayList<>();
        try {
            listFriend=friendMapper.listFrinend(from_id, to_id);
        } catch (SQLException e) {
            logger.error("好友展示查询异常");
        }
        return listFriend;
    }
}