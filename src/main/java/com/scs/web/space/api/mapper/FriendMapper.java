package com.scs.web.space.api.mapper;


import com.scs.web.space.api.domain.dto.FriendDto;
import com.scs.web.space.api.domain.entity.Friend;
import com.scs.web.space.api.domain.entity.User;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.jdbc.SQL;

import java.sql.SQLException;
import java.util.List;

public interface FriendMapper {

    /*查看是否为好友*/
    @Select("SELECT * FROM t_friend WHERE from_id = #{fromId} AND to_id = #{toId}")
    Friend getFriend(int fromId, int toId) throws SQLException;


    @Select("SELECT * FROM t_friend WHERE from_id = #{id}")
    @Results({
            @Result(property = "toId", column = "to_id"),
            @Result(property = "userVo", column = "to_id",
                    many = @Many(select = "com.scs.web.space.api.mapper.UserMapper.getFriendDynamicById")),
    })
    List<Friend> getFriendDynamicById(@Param("id") int id) throws SQLException;



    @Select("SELECT t1.*,t2.nickname,t2.avatar,t2.autograph \n" +
            "            FROM t_friend t1 \n" +
            "            LEFT JOIN t_user t2 \n" +
            "            ON t1.to_id = t2.id \n" +
            "            WHERE (t1.from_id=#{from_id} )AND t1.status=1\n" +
            "UNION\t\n" +
            "\n" +
            "SELECT t1.*,t2.nickname,t2.avatar,t2.autograph \n" +
            "            FROM t_friend t1 \n" +
            "            LEFT JOIN t_user t2 \n" +
            "            ON t1.from_id = t2.id \n" +
            "            WHERE (t1.to_id=#{to_id}) AND t1.status=1")
    List<FriendDto> listFrinend(@Param("from_id") int from_id,@Param("to_id") int to_id) throws SQLException;
}
