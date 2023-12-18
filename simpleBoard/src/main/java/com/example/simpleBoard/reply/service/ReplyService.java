package com.example.simpleBoard.reply.service;

import com.example.simpleBoard.CRUD.crudAbstractService;
import com.example.simpleBoard.post.db.PostRepository;
import com.example.simpleBoard.reply.db.ReplyEntity;
import com.example.simpleBoard.reply.db.ReplyRepository;
import com.example.simpleBoard.reply.model.ReplyDto;
import com.example.simpleBoard.reply.model.ReplyRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ReplyService extends crudAbstractService<ReplyDto, ReplyEntity> {

    /*private final ReplyRepository replyRepository;
    private final PostRepository postRepository;

    public ReplyEntity create(
            ReplyRequest replyRequest
    ){
        var postEntity = postRepository.findById(replyRequest.getPostId());

        if(postEntity.isEmpty()){
            throw new RuntimeException("게시물이 존재하지 않습니다 : "+replyRequest.getPostId());
        }
        var entity = ReplyEntity.builder()
                .post(postEntity.get())
                .userName(replyRequest.getUserName())
                .password(replyRequest.getPassword())
                .status("REGISTERED")
                .title(replyRequest.getTitle())
                .contents(replyRequest.getContent())
                .repliedAt(LocalDateTime.now())
                .build();
        return replyRepository.save(entity);
    }

    public List<ReplyEntity> findAllByPostId(Long postId){
        return replyRepository.findAllByPostIdAndStatusOrderByIdDesc(postId, "REGISTERED");
    }*/
}
