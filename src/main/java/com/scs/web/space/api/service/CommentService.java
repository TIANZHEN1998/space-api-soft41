package com.scs.web.space.api.service;
import com.scs.web.space.api.domain.dto.CommentVO;
import com.scs.web.space.api.util.Result;

/**
 * @ClassName CommentService
 * @Description TODO
 * @Author 田震
 * @Date 2019/12/16
 **/
public interface CommentService {
    /**
     * 增加评论
     * @param comment
     * @return
     */
    Result insertcomment(CommentVO comment);

}