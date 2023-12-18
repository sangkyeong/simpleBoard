package com.example.simpleBoard.reply.service;

import com.example.simpleBoard.CRUD.Converter;
import com.example.simpleBoard.post.db.PostRepository;
import com.example.simpleBoard.reply.db.ReplyEntity;
import com.example.simpleBoard.reply.db.ReplyRepository;
import com.example.simpleBoard.reply.model.ReplyDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class ReplyConverter implements Converter<ReplyDto, ReplyEntity> {
    private final PostRepository postRepository;
    @Override
    public ReplyDto toDto(ReplyEntity replyEntity) {

        return ReplyDto.builder()
                .id(replyEntity.getId())
                .post(replyEntity.getPost().getId())
                .status(replyEntity.getStatus())
                .title(replyEntity.getTitle())
                .userName(replyEntity.getUserName())
                .password(replyEntity.getPassword())
                .contents(replyEntity.getContents())
                .repliedAt(replyEntity.getRepliedAt())
                .build();
    }

    @Override
    public ReplyEntity toEntity(ReplyDto replyDto) {
        var postEntity = postRepository.findById(replyDto.getPost());
        return ReplyEntity.builder()
                .id(replyDto.getId())
                .post(postEntity.orElse(null))
                .status((replyDto.getStatus() != null) ? replyDto.getStatus() : "REGISTERED")
                .title(replyDto.getTitle())
                .userName(replyDto.getUserName())
                .password(replyDto.getPassword())
                .contents(replyDto.getContents())
                .repliedAt((replyDto.getRepliedAt() != null) ? replyDto.getRepliedAt() : LocalDateTime.now())
                .build();
    }
}

