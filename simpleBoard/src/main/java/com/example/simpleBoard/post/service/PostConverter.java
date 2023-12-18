package com.example.simpleBoard.post.service;

import com.example.simpleBoard.post.db.PostEntity;
import com.example.simpleBoard.post.model.PostDto;
import org.springframework.stereotype.Service;

@Service
public class PostConverter {

    public PostDto toDto(PostEntity postEntity){
        return PostDto.builder()
                .id(postEntity.getId())
                .userName(postEntity.getUserName())
                .status(postEntity.getStatus())
                .email(postEntity.getEmail())
                .password(postEntity.getPassword())
                .title(postEntity.getTitle())
                .contents(postEntity.getContents())
                .postedAt(postEntity.getPostedAt())
                .boardId(postEntity.getBoard().getId())
                .build();
    }
}
