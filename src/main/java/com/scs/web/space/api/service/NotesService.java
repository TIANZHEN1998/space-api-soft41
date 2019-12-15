package com.scs.web.space.api.service;


import com.scs.web.space.api.domain.dto.NotesDto;
import com.scs.web.space.api.domain.dto.Page;
import com.scs.web.space.api.domain.entity.Notes;
import com.scs.web.space.api.util.Result;

import java.util.List;
import java.util.Map;

/**
 * @ClassName LogService
 * @Description 日志服务接口
 * @Author wf
 * @Date 2019/12/1
 **/
public interface NotesService {
    /**
     * 用户所有日志列表
     * @param userId
     * @return Result
     */
    Result getByUserId(int userId, int currentPage, int pageSize);

    /**
     * 查询所有日志
     * @return
     */
    Result getAllNotes();

    /**
     * 日志详情
     * @param id
     * @return Result
     */
    Result getNotesById(int id);

    /**
     * 新增日志
     * @param notesDto
     * @return Result
     */
    Result insertNotes(NotesDto notesDto);

    /**
     * 更新指定id日志
     * @param notesDto
     * @return Result
     */
    Result updateNotes(NotesDto notesDto);

    /**
     * 删除指定id的日志
     * @param id
     * @return Result
     */
    Result deleteById(int id);

    /**
     * 批量删除日志
     * @param list
     * @return Result
     */
    Result batchDelete(List<Notes> list);

    /**
     * 用户所有日志列表
     * @param userId
     * @return
     */
    Result selectNotesByUserId(int userId);

    Result getPersonDynamic(int userId);
}
