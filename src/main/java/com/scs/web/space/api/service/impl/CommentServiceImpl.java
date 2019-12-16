package com.scs.web.space.api.service.impl;

import com.scs.web.space.api.domain.entity.Comment;
import com.scs.web.space.api.domain.dto.CommentVO;
import com.scs.web.space.api.mapper.CommentMapper;
import com.scs.web.space.api.service.CommentService;
import com.scs.web.space.api.util.Result;
import com.scs.web.space.api.util.ResultCode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.time.LocalDateTime;

/**
 * @ClassName CommentServiceImpl
 * @Description TODO
 * @Author 田震
 * @Date 2019/12/16
 **/
@Service
public class CommentServiceImpl implements CommentService {
    private Logger logger = LoggerFactory.getLogger(NotesServiceImpl.class);
    @Resource
    private CommentMapper commentMapper;
    @Override
    public Result insertcomment(CommentVO comment) {
        int n = 0;
        try {
            Comment savecomment = new Comment();
            savecomment.setId(comment.getId());
            savecomment.setUserId(comment.getUserId());
            savecomment.setNotesId(comment.getNotesId());
            savecomment.setContent(comment.getContent());
            savecomment.setCreateTime(Timestamp.valueOf(LocalDateTime.now()));
            n = commentMapper.insertcomment(savecomment);
        } catch (SQLException e) {
            logger.error("新增评论异常");
        }
        if (n != 0) {
            return Result.success(n);
        }
        return Result.failure(ResultCode.RESULT_CODE_DATA_NONE);
    }
}