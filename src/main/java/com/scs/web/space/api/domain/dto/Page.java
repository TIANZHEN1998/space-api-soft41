package com.scs.web.space.api.domain.dto;

import lombok.Data;

/**
 * @author wf
 * @ClassName Page
 * @Description TODO
 * @Date 2019/12/3
 */
@Data
public class Page {
    private Integer userId;
    private Integer currentPage;
    private Integer pageSize;

}
