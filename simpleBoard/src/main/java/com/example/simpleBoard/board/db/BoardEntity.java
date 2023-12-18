package com.example.simpleBoard.board.db;

import com.example.simpleBoard.post.db.PostEntity;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.Where;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
@Entity(name = "board")
public class BoardEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String boardName;

    private String status;

    @OneToMany(
        mappedBy = "board"
    )
    @Builder.Default
    @Where(clause = "status = 'REGISTERED'")
    private List<PostEntity> postList = List.of();
}
