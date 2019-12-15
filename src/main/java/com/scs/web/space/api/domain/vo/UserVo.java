package com.scs.web.space.api.domain.vo;

import com.scs.web.space.api.domain.entity.Album;
import lombok.Data;

import java.util.List;

/**
 * @author wf
 * @ClassName UserVo
 * @Description 用户Vo
 * @Date 2019/12/4
 */

@Data
public class UserVo {
    private Integer id;
    private String nickname;
    private String avatar;
    private List<NotesVo> notesVo;
    private List<AlbumVo> albumVo;
}
