package com.scs.web.space.api.domain.dto;

import lombok.Data;

/**
 * @author wf
 * @ClassName FriendDto
 * @Description TODO
 * @Date 2019/12/5
 */
@Data
public class FriendDto {
    private  Integer id;
    private Integer fromId;
    private Integer toId;
    private  String nickname;
    private  String avatar;
    private  String autograph;
    private  Integer status;
}
