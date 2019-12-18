package com.scs.web.space.api.controller;

import com.scs.web.space.api.domain.dto.NotesDto;
import com.scs.web.space.api.domain.dto.Page;
import com.scs.web.space.api.domain.entity.Notes;
import com.scs.web.space.api.domain.vo.NotesVo;
import com.scs.web.space.api.service.NotesService;
import com.scs.web.space.api.util.Result;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author wf
 * @ClassName LogController
 * @Description TODO
 * @Date 2019/12/2
 */
@RestController
@RequestMapping(value = "/api/notes")
public class NotesController {
    @Resource
    private NotesService notesService;

    /***
     *
     * @param page
     * @return
     */
    @PostMapping(value = "/user")
    Result getByUserId(@RequestBody Page page){
        return notesService.getByUserId(page.getUserId(), page.getCurrentPage(), page.getPageSize());
    }

    /**
     * 查询所有的日志
     * @return
     */
    @PostMapping(value = "/selectallnotes")
    List<Notes>  selectallnotes() {
        return  notesService.selectallnotes();
    }
    @GetMapping(value = "/d/{id}")
    Result getPersonDynamic(@PathVariable int id){
        return notesService.getPersonDynamic(id);
    }

    /**
     * 根据用户的、"currentPage"
     *   "pageSize"
     *   "userId"查询日志（成功）
     * @param id
     * @return
     */
    @GetMapping(value = "/user/{id}")
    Result selectNotes(@PathVariable int id){
        return notesService.selectNotesByUserId(id);
    }


    /**
     * 根据日志id获取日志详情（成功）
     * @param id
     * @return
     */

    @GetMapping(value = "/{id}")
    Result getNotesById(@PathVariable int id){
        return notesService.getNotesById(id);
    }

    /**
     * 增加日志信息（成功）
     * @param notesDto
     * @return
     */

    @PostMapping(value = "/insertnotes")
    Result insertNotes(@RequestBody NotesDto notesDto){
        return notesService.insertNotes(notesDto);
    }

    /***
     * 修改日志信息（成功）
     * @param notesDto
     * @return
     */
    @PostMapping(value = "/updatenotes")
    Result updateNotes(@RequestBody NotesDto notesDto){
        return notesService.updateNotes(notesDto);
    }

    /**
     * 根据日志的Id删除日志（成功）
     * @param id
     * @return
     */
    @DeleteMapping(value = "/{id}")
    Result deleteById(@PathVariable int id){
        return notesService.deleteById(id);
    }



}
