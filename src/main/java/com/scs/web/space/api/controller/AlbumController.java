package com.scs.web.space.api.controller;

import com.scs.web.space.api.domain.entity.Album;
import com.scs.web.space.api.service.AlbumService;
import com.scs.web.space.api.util.Result;
import org.apache.ibatis.annotations.Param;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * @ClassName AlbumController
 * @Description TODO
 * @Author 田震
 * @Date 2019/12/18
 **/
@RestController
@RequestMapping(value = "/api/album")
public class AlbumController {
    @Resource
    private AlbumService albumService;

    /***
     * 查询所有的日志
     * @return
     */
    @PostMapping(value = "/selectallalbums")
    List<Album> selectAll(){
        return  albumService.selectAll();
    }

    /**
     * 增加相册
     * @param album
     * @return
     */
    @PostMapping(value = "/insetablum")
    int insertablum(Album album) {
        return albumService.insert(album);

    }

    /**
     * 删除相册
     * @param id
     * @return
     */

    @PostMapping(value = "/deletealbum")
    Result deleteablum(@PathVariable int id) {
        return  albumService.deletealbum(id);
    }





}