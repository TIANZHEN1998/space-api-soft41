package com.scs.web.space.api.mapper;

import com.scs.web.space.api.domain.entity.Comment;
import com.scs.web.space.api.domain.entity.Notes;
import com.scs.web.space.api.domain.entity.User;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.jdbc.SQL;
import org.springframework.web.bind.annotation.ResponseBody;

import java.sql.SQLException;
import java.util.List;

public interface CommentMapper {



    /**
     * 根据日志的id查询评论
     * @param id
     * @return
     * @throws SQLException
     */


    @Select("SELECT * FROM t_comment WHERE notes_id = #{id}")
    @Results({
            @Result(property = "userVo", column = "user_id",
                    many = @Many(select = "com.scs.web.space.api.mapper.UserMapper.getUserById"))
    })
    List<Comment> getByUserId(@Param("id") int id) throws SQLException;

    /**
     * 增加评论
     * @param comment
     * @return
     * @throws SQLException
     */

    @Insert("insert into t_comment(id,user_id,notes_id,content) values (null,#{userId},#{notesId}," +
            "#{content})")
    int insertcomment(Comment comment) throws SQLException;


}