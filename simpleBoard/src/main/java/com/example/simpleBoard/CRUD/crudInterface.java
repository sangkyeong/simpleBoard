package com.example.simpleBoard.CRUD;

import com.example.simpleBoard.board.common.Api;

import org.springframework.data.domain.Pageable;
import java.util.List;
import java.util.Optional;

public interface crudInterface<DTO> {

    DTO create(DTO dto);

    Optional<DTO> read(Long id);

    DTO update(DTO dto);

    void delete(Long id);

    Api<List<DTO>> list(Pageable pageable);
}
