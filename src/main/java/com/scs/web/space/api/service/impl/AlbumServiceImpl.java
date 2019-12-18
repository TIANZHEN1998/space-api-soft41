package com.scs.web.space.api.service.impl;

import com.scs.web.space.api.domain.entity.Album;
import com.scs.web.space.api.mapper.AlbumMapper;
import com.scs.web.space.api.service.AlbumService;
import com.scs.web.space.api.util.Result;
import com.scs.web.space.api.util.ResultCode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.List;

/**
 * @ClassName AlbumServiceImpl
 * @Description TODO
 * @Author wf
 * @Date 2019/12/1
 **/
@Service
public class AlbumServiceImpl implements AlbumService {
    private Logger logger = LoggerFactory.getLogger(AlbumServiceImpl.class);

    @Resource
    private AlbumMapper albumMapper;

    @Override
    public int insert(Album album) {
        int n=0;
        try {
            Album album1 = new Album();
            album1.setUserId(album.getUserId());
            album1.setAlbumName(album.getAlbumName());
            album1.setCover(album.getCover());
            album1.setCreateTime(Timestamp.valueOf(LocalDateTime.now()));
           n= albumMapper.insert(album1);
        } catch (SQLException e) {
            logger.error("新增相册异常");
        }
        return n;
    }

    @Override
    public List<Album> selectAll() {
      List<Album> albumList=null;
        try {
            albumList=albumMapper.selectallalbus();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return albumList ;
    }

    @Override
    public Result selectByUserId(int userId) {
        Album albumList = null;
        try {
            albumList = albumMapper.selectByUserId(userId);
        } catch (SQLException e) {
            logger.error("查询个人相册异常");
        }
        if (albumList != null) {
            return Result.success(albumList);
        }
        return Result.failure(ResultCode.RESULT_CODE_DATA_NONE);
    }


    @Override
    public Result deletealbum(int id) {
        try {
            albumMapper.delete(id);
        } catch (SQLException e) {
            logger.error("删除相册异常");
            return Result.failure(ResultCode.RESULT_CODE_DATA_NONE);
        }
        return Result.success();
    }
}
