package com.example.simpleBoard.board.contoller;

import com.example.simpleBoard.board.db.BoardEntity;
import com.example.simpleBoard.board.model.BoardDto;
import com.example.simpleBoard.board.model.BoardRequest;
import com.example.simpleBoard.board.service.BoardService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/board")
@RequiredArgsConstructor
public class BoardApiController {

    private final BoardService boardService;
    @PostMapping("")
    public BoardDto create(
            @Valid
            @RequestBody
            BoardRequest boardRequest
    ){
        return boardService.create(boardRequest);
    }

    @GetMapping("/id/{id}")
    public BoardDto view(
            @PathVariable Long id
    ){
        return boardService.view(id);
    }
}
