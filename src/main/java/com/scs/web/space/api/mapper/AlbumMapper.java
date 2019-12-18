package com.scs.web.space.api.mapper;

import com.scs.web.space.api.domain.entity.Album;
import com.scs.web.space.api.domain.vo.AlbumVo;
import org.apache.ibatis.annotations.*;

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
     * 查询松油的相册
     * @return
     * @throws SQLException
     */
    @Select("select * from  t_album")
    List<Album> selectallalbus() throws  SQLException;
    /**
     * 新增相册
     * @param album
     * @return int
     * @throws SQLException
     */
    @Insert("INSERT INTO t_album(id,user_id,album_name,cover,photos,create_time) VALUES (null,#{userId},#{albumName}," +
            "#{cover},#{photos},#{createTime}) " )
    int insert(Album album) throws SQLException;


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
