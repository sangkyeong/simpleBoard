package com.example.simpleBoard.reply.controller;

import com.example.simpleBoard.CRUD.crudAbstractApiController;
import com.example.simpleBoard.reply.db.ReplyEntity;
import com.example.simpleBoard.reply.model.ReplyDto;
import com.example.simpleBoard.reply.model.ReplyRequest;
import com.example.simpleBoard.reply.service.ReplyService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/reply")
@RequiredArgsConstructor
public class ReplyApiController extends crudAbstractApiController<ReplyDto,ReplyEntity> {

/*    private final ReplyService replyService;

    @PostMapping("")
    public ReplyEntity create(
            @Valid
            @RequestBody ReplyRequest replyRequest
    ){
        return replyService.create(replyRequest);
    }*/
}
