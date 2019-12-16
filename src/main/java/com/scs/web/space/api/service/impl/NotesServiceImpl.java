package com.scs.web.space.api.service.impl;

import com.scs.web.space.api.domain.dto.NotesDto;
import com.scs.web.space.api.domain.entity.Notes;
import com.scs.web.space.api.domain.vo.NotesVo;
import com.scs.web.space.api.mapper.FriendMapper;
import com.scs.web.space.api.mapper.NotesMapper;
import com.scs.web.space.api.service.NotesService;
import com.scs.web.space.api.util.Result;
import com.scs.web.space.api.util.ResultCode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @author wf
 * @ClassName LogServiceImpl
 * @Description TODO
 * @Date 2019/12/2
 */
@Service
public class NotesServiceImpl implements NotesService {
    private Logger logger = LoggerFactory.getLogger(NotesServiceImpl.class);

    @Resource
    private NotesMapper notesMapper;
    private FriendMapper friendMapper;

    @Override
    public Result getByUserId(int userId,int currentPage, int pageSize) {
        List<Map> map = new ArrayList<Map>();
        try {
            map = notesMapper.getByUserId(userId,currentPage,pageSize);
        } catch (SQLException e) {
            logger.error("获取用户日志异常");
        }
        if(map != null){
            return Result.success(map);
        }
        return Result.failure(ResultCode.RESULT_CODE_DATA_NONE);
    }

    @Override
    public Result getAllNotes() {
        return null;
    }

    @Override
    public Result getNotesById(int id) {
        Notes notes = new Notes();
        try {
            notes = notesMapper.getNotesById(id);
        } catch (SQLException e) {
            logger.error("日志详情获取异常");
        }
        if(notes != null){
            return Result.success(notes);
        }
        return Result.failure(ResultCode.RESULT_CODE_DATA_NONE);
    }

    /***
     * 增加日志
     * @param notesDto
     * @return
     */
    @Override
    public Result insertNotes(NotesDto notesDto) {
        int n = 0;
        try {
            Notes notes = new Notes();
            notes.setUserId(notesDto.getUserId());
            notes.setTitle(notesDto.getTitle());
            notes.setContent(notesDto.getContent());
            notes.setEditStatus(notesDto.getEditStatus());
            notes.setAccessStatus(notesDto.getAccessStatus());
            notes.setForwardStatus(notesDto.getForwardStatus());
            notes.setCreateTime(Timestamp.valueOf(LocalDateTime.now()));
            n = notesMapper.insertNotes(notes);
        } catch (SQLException e) {
            logger.error("新增日志异常");
        }
        if(n != 0){
            return Result.success(n);
        }
        return Result.failure(ResultCode.RESULT_CODE_DATA_NONE);
    }

    /**
     * 修改日志信息
     * @param notesDto
     * @return
     */
    @Override
    public Result updateNotes(NotesDto notesDto) {
        int n = 0;
        try {
            Notes notes = new Notes();
            notes.setId(notesDto.getId());
            notes.setTitle(notesDto.getTitle());
            notes.setContent(notesDto.getContent());
            notes.setEditStatus(notesDto.getEditStatus());
            notes.setForwardStatus(notesDto.getForwardStatus());
            notes.setAccessStatus(notesDto.getAccessStatus());
            notes.setCreateTime(Timestamp.valueOf(LocalDateTime.now()));
            n = notesMapper.updateNotes(notes);
        } catch (SQLException e) {
            logger.error("更改日志异常");
        }
        if(n != 0){
            return Result.success(n);
        }
        return Result.failure(ResultCode.RESULT_CODE_DATA_NONE);
    }

    @Override
    public Result deleteById(int id) {
        int n = 0;
        n = notesMapper.deleteById(id);
        if(n != 0){
            return Result.success(n);
        }
        return Result.failure(ResultCode.RESULT_CODE_DATA_NONE);
    }

    @Override
    public Result batchDelete(List<Notes> list) {
        return null;
    }

    @Override
    public Result selectNotesByUserId(int userId) {
        List<NotesVo> notesList = null;
        try {
            notesList = notesMapper.getNotesCommentById(userId);
        } catch (SQLException e) {
            logger.error("根据用户id查询所有日志出现异常");
        }

        if (notesList != null) {
            return Result.success(notesList);
        } else {
            return Result.failure(ResultCode.RESULT_CODE_DATA_NONE);
        }

    }

    @Override
    public Result getPersonDynamic(int userId) {
       /* List<NotesVo> notesVoList = new ArrayList<>();
        try {
            notesVoList = notesMapper.getDynamicById(userId);
        } catch (SQLException e) {
            logger.error("个人动态查询异常");
        }
        if(notesVoList != null){
            return Result.success(notesVoList);
        }*/
        return Result.failure(ResultCode.RESULT_CODE_DATA_NONE);
    }

}
