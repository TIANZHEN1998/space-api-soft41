package com.scs.web.space.api.mapper;

import com.scs.web.space.api.domain.entity.Album;
import com.scs.web.space.api.domain.vo.AlbumVo;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.jdbc.SQL;

import java.sql.SQLException;
import java.util.List;

/**
 * @ClassName AlbumMapper
 * @Description 相册Mapper
 * @Author wf
 * @Date 2019/12/1
 **/
public interface AlbumMapper {
    /**
     * 新增相册
     * @param album
     * @return int
     * @throws SQLException
     */
    @Insert("INSERT INTO t_album VALUES (null,#{userId},#{name},#{cover},#{createTime}) " )
    void insert(Album album) throws SQLException;

    /**
     * 按创建时间升序查询所有相册
     * @return List<album>
     * @throws SQLException
     */
    @Select("SELECT * FROM t_album WHERE user_id = #{userId} ORDER BY create_time ASC ")
    AlbumVo getAlbumByUserId(@Param("userId") int userId) throws SQLException;

    /**
     * 根据相册id删除相册记录
     * @param id
     * @return int
     * @throws SQLException
     */
    @Delete("DELETE FROM t_album WHERE id = #{id} ")
    void delete(int id) throws SQLException;

    /**
     * 根据用户id得到该用户所有相册记录
     * @param userId
     * @return List<Album>
     * @throws SQLException
     */
    @Select("SELECT * FROM t_album WHERE user_id = #{userId} ")

    Album selectByUserId(@Param("userId") int userId) throws SQLException;
}
