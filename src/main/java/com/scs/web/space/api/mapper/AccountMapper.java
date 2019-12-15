package com.scs.web.space.api.mapper;

import com.scs.web.space.api.domain.entity.Account;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

public interface AccountMapper {

    @Results({
            @Result(property = "nickname", column = "nickname"),
            @Result(property = "avatar", column = "avatar")
    })
    @Select("SELECT t1.*,t2.nickname,t2.avatar " +
            "FROM t_account t1 " +
            "LEFT JOIN t_user t2 " +
            "ON t1.user_id = t2.id " +
            "WHERE user_id = #{userId} ")
    Map getUserAccount(int userId) throws SQLException;


}
