package com.scs.web.space.api.domain.dto;

import lombok.Data;

/**
 * @author wf
 * @ClassName LogDto
 * @Description TODO
 * @Date 2019/12/2
 */
@Data
public class NotesDto {
    private Integer id;
    private Integer userId;
    private String title;
    private String content;
    private Integer editStatus;
    private Integer accessStatus;
    private Short forwardStatus;
}
