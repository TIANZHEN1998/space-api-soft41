package com.scs.web.space.api.domain.entity;

import com.scs.web.space.api.domain.vo.UserVo;
import lombok.Data;
import lombok.NonNull;

import java.sql.Timestamp;
import java.time.LocalDateTime;

/**
 * @ClassName Album
 * @Description 相册实体类
 * @Author wf
 * @Date 2019/12/1
 **/
@Data
public class Album {
    private Integer id;
    private Integer userId;
    private Integer photos;
    private String albumName;
    private String cover;
    private Timestamp createTime;
    private UserVo userVo;
}

