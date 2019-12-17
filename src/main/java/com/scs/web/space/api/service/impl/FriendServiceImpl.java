package com.scs.web.space.api.service.impl;

import com.fasterxml.jackson.datatype.jsr310.deser.InstantDeserializer;
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

    /**
     * 查看双向好友
     * @param from_id
     * @param to_id
     * @return
     */
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

    /**
     * 查看双向非好友
     * @param from_id
     * @param to_id
     * @return
     */
    @Override
    public List<FriendDto> listnotFriend(Integer from_id, Integer to_id) {
        List<FriendDto> listFriend =new ArrayList<>();
        try {
            listFriend=friendMapper.listnotFrinend(from_id, to_id);
        } catch (SQLException e) {
            logger.error("好友展示查询异常");
        }
        return listFriend;
    }

    @Override
    public Result insertFriend(FriendDto friend) {
        int n=0;
        try {

            Friend savefriend = new Friend();
            savefriend.setId(friend.getId());
            savefriend.setFromId(friend.getFromId());
            savefriend.setToId(friend.getToId());
            savefriend.setStatus(0);
            n = friendMapper.insetfriend(savefriend);
        }catch (SQLException e) {
            logger.error("发送好友请求异常");
        }
        if (n != 0) {
            return Result.success(n);
        }
        return Result.failure(ResultCode.RESULT_CODE_DATA_NONE);
    }

    @Override
    public Result updatestatus(FriendDto friendDto) {
        int n=0;
        try {
                Friend friend = new Friend();
                friend.setId(friendDto.getId());
                friend.setStatus(1);
                n = friendMapper.update(friend);
            }catch(SQLException e){
                logger.error("同意好友请求发生异常");
            }
            if (n != 0) {
                return Result.success(n);
            }
            return Result.failure(ResultCode.RESULT_CODE_DATA_NONE);
    }
}