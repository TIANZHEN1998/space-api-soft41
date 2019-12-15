package com.scs.web.space.api.domain.vo;

import lombok.Data;

import java.sql.Timestamp;

/**
 * @author wf
 * @ClassName 相册Vo
 * @Description TODO
 * @Date 2019/12/4
 */
@Data
public class AlbumVo {
    private Integer id;
    private Integer userId;
    private String albumName;
    private Timestamp createTime;
}
