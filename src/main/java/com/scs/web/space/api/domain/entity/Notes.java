package com.scs.web.space.api.domain.entity;

import com.scs.web.space.api.domain.vo.UserVo;
import lombok.Data;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.List;

/**
 * @author wf
 * @ClassName Log
 * @Description 日志实体类
 * @Date 2019/12/2
 */
@Data
public class Notes {
    private Integer id;
    private Integer userId;
    private String title;
    private String description;
    private String content;
    private Integer comments;
    private Integer likes;
    private Integer forwards;
    private Integer editStatus;
    private Integer accessStatus;
    private Short forwardStatus;
    private Timestamp createTime;
    private UserVo userVo;
    private List<Comment> comment;
}
