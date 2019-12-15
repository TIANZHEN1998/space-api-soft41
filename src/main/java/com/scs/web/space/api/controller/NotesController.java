package com.scs.web.space.api.controller;

import com.scs.web.space.api.domain.dto.NotesDto;
import com.scs.web.space.api.domain.dto.Page;
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

    @PostMapping(value = "/user")
    Result getByUserId(@RequestBody Page page){
        return notesService.getByUserId(page.getUserId(), page.getCurrentPage(), page.getPageSize());
    }

    @GetMapping(value = "/d/{id}")
    Result getPersonDynamic(@PathVariable int id){
        return notesService.getPersonDynamic(id);
    }

    @GetMapping(value = "/user/{id}")
    Result selectNotes(@PathVariable int id){
        return notesService.selectNotesByUserId(id);
    }

    @GetMapping(value = "/{id}")
    Result getNotesById(@PathVariable int id){
        return notesService.getNotesById(id);
    }

    @PostMapping(value = "")
    Result insertNotes(@RequestBody NotesDto notesDto){
        return notesService.insertNotes(notesDto);
    }

    @PostMapping(value = "/u")
    Result updateNotes(@RequestBody NotesDto notesDto){
        return notesService.updateNotes(notesDto);
    }

    @DeleteMapping(value = "/{id}")
    Result deleteById(@PathVariable int id){
        return notesService.deleteById(id);
    }



}
