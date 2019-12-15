package com.scs.web.space.api.service;

import com.scs.web.space.api.domain.entity.Album;
import com.scs.web.space.api.util.Result;


/**
 * @ClassName AlbumService
 * @Description 相册服务接口
 * @Author wf
 * @Date 2019/12/1
 **/
public interface AlbumService {
    /**
     * 新增相册
     * @param album
     * @return
     */
    Result insert(Album album);

    /**
     * 查询所有相册
     * @return
     */
    Result selectAll();


    /**
     * 查询个人所有相册
     * @param id
     * @return
     */
    Result selectByUserId(int id);

    /**
     * 删除相册
     * @param id
     * @return
     */
    Result delete(int id);
}
