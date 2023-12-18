package com.example.simpleBoard.reply.model;

import com.example.simpleBoard.post.db.PostEntity;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@JsonNaming(value = PropertyNamingStrategies.SnakeCaseStrategy.class)
public class ReplyDto {

    private Long id;

    private Long post;

    private String userName;

    private String password;

    private String status;

    private String title;

    private String contents;

    private LocalDateTime repliedAt;
}
