package com.scs.web.space.api.domain.vo;

import com.scs.web.space.api.domain.entity.Comment;
import lombok.Data;

import java.sql.Timestamp;
import java.util.List;

/**
 * @author wf
 * @ClassName 日志Vo
 * @Description TODO
 * @Date 2019/12/4
 */
@Data
public class NotesVo {
    private Integer id;
    private Integer userId;
    private String title;
    private Integer comments;
    private Integer likes;
    private Integer forwards;
    private Timestamp createTime;
    private UserVo userVo;
    private List<AlbumVo> albumVo;
    private List<Comment> comment;
}
