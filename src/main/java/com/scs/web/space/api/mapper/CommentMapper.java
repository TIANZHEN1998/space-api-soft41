package com.scs.web.space.api.mapper;

import com.scs.web.space.api.domain.entity.Comment;
import com.scs.web.space.api.domain.entity.Notes;
import com.scs.web.space.api.domain.entity.User;
import org.apache.ibatis.annotations.*;

import java.sql.SQLException;
import java.util.List;

public interface CommentMapper {
    @Select("SELECT * FROM t_comment WHERE notes_id = #{id}")
    @Results({
            @Result(property = "userVo", column = "user_id",
                    many = @Many(select = "com.scs.web.space.api.mapper.UserMapper.getUserById"))
    })
    List<Comment> getByUserId(@Param("id") int id) throws SQLException;

}