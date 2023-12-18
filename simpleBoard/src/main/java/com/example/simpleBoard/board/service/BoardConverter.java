package com.example.simpleBoard.board.service;

import com.example.simpleBoard.board.db.BoardEntity;
import com.example.simpleBoard.board.model.BoardDto;
import com.example.simpleBoard.post.service.PostConverter;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class BoardConverter {
    private final PostConverter postConverter;
    public BoardDto toDto(BoardEntity boardEntity){
        var postList = boardEntity.getPostList()
                .stream()
                .map(postConverter::toDto)
                .toList();

       return BoardDto.builder()
                .id(boardEntity.getId())
                .boardName(boardEntity.getBoardName())
                .status(boardEntity.getStatus())
                .postList(postList)
                .build();
    }
}
