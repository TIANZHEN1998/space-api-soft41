package com.scs.web.space.api.domain.dto;

import com.scs.web.space.api.domain.vo.UserVo;
import lombok.Data;

/**
 * @ClassName CommentVO
 * @Description TODO
 * @Author 田震
 * @Date 2019/12/16
 **/
@Data
public class CommentVO {
    private Integer id;
    private Integer userId;
    private Integer notesId;
    private String content;
}