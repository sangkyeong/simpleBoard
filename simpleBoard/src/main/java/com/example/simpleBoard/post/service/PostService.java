package com.example.simpleBoard.post.service;

import com.example.simpleBoard.board.common.Api;
import com.example.simpleBoard.board.common.Pagination;
import com.example.simpleBoard.board.db.BoardRepository;
import com.example.simpleBoard.post.db.PostEntity;
import com.example.simpleBoard.post.db.PostRepository;
import com.example.simpleBoard.post.model.PostRequest;
import com.example.simpleBoard.post.model.PostViewRequest;
import com.example.simpleBoard.reply.service.ReplyService;
import lombok.Builder;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;


import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class PostService {

    private final PostRepository postRepository;
    private final BoardRepository boardRepository;

    public PostEntity create(
            PostRequest postRequest
    ){
        var boardEntity = boardRepository.findById(postRequest.getBoardId()).get();
        var entity = PostEntity.builder()
                .board(boardEntity)
                .userName(postRequest.getUserName())
                .password(postRequest.getPassword())
                .email(postRequest.getEmail())
                .status("REGISTERD")
                .title(postRequest.getTitle())
                .contents(postRequest.getContent())
                .postedAt(LocalDateTime.now())
                .build();

        return postRepository.save(entity);
    }

    public PostEntity view(PostViewRequest postViewRequest) {
        return postRepository.findFirstByIdAndStatusOrderByIdDesc(postViewRequest.getPostId(), "REGISTERED")
        .map( it -> {
            if(!it.getPassword().equals(postViewRequest.getPassword())){
                var format = "패스워드가 맞지않습니다. %s vs %s";
                throw new RuntimeException(String.format(format, it.getPassword(), postViewRequest.getPassword()));
            }
            return it;
        }).orElseThrow(
            () ->{
                return new RuntimeException("해당 게시글이 존재하지 않습니다. : "+postViewRequest.getPostId());
            }
        );
    }

    public Api<List<PostEntity>> all(Pageable pageable) {
        var list = postRepository.findAll(pageable);
        var pagination = Pagination.builder()
                .page(list.getNumber())
                .size(list.getSize())
                .currentElements(list.getNumberOfElements())
                .totalElements(list.getTotalElements())
                .totalPage(list.getTotalPages())
                .build();
        var res = Api.<List<PostEntity>>builder()
                .body(list.toList())
                .pagination(pagination)
                .build();
        return res;
    }

    public void delete(PostViewRequest postViewRequest) {
        postRepository.findById(postViewRequest.getPostId())
            .map( it -> {
                if(!it.getPassword().equals(postViewRequest.getPassword())){
                    var format = "패스워드가 맞지않습니다. %s vs %s";
                    throw new RuntimeException(String.format(format, it.getPassword(), postViewRequest.getPassword()));
                }

                it.setStatus("UNREGISTERED");
                postRepository.save(it);
                return it;
            }).orElseThrow(
                    () ->{
                        return new RuntimeException("해당 게시글이 존재하지 않습니다. : "+postViewRequest.getPostId());
                    }
            );
    }
}
