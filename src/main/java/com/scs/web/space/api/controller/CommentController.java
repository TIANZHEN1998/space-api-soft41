package com.scs.web.space.api.controller;

import com.scs.web.space.api.domain.dto.CommentVO;
import com.scs.web.space.api.service.CommentService;
import com.scs.web.space.api.util.Result;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * @ClassName CommentController
 * @Description TODO
 * @Author 田震
 * @Date 2019/12/16
 **/

@RestController
@RequestMapping(value = "/api/commment")
public class CommentController {
@Resource
private CommentService commentService;

    /**
     * 新增评论(成功)
     * @param comment
     * @return
     */
    @PostMapping(value = "/insertcomment")
    Result insertComment(@RequestBody CommentVO comment){
        return commentService.insertcomment(comment);
    }





}