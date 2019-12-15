package com.scs.web.space.api.domain.entity;

import com.scs.web.space.api.domain.vo.UserVo;
import lombok.Data;

import java.sql.Timestamp;
import java.util.List;

/**
 * @author wf
 * @ClassName Comment
 * @Description 好友实体类
 * @Date 2019/12/3
 */
@Data
public class Friend {
    private Integer id;
    private Integer fromId;
    private Integer toId;
    private Integer status;
    private Timestamp createTime;
    private UserVo userVo;
    private Album album;
}
