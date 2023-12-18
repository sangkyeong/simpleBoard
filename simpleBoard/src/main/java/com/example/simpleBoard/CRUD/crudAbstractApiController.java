package com.example.simpleBoard.CRUD;

import com.example.simpleBoard.board.common.Api;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.*;

import org.springframework.data.domain.Pageable;
import java.util.List;
import java.util.Optional;

public abstract class crudAbstractApiController<DTO, ENTITY> implements crudInterface<DTO> {

    @Autowired(required = false)
    private crudAbstractService<DTO, ENTITY> crudAbstractService;

    @PostMapping("")
    @Override
    public DTO create(
            @RequestBody
            @Valid
            DTO dto
    ) {
        return crudAbstractService.create(dto);
    }

    @GetMapping("/id/{id}")
    @Override
    public Optional<DTO> read(
            @PathVariable
            Long id
    ) {
        return crudAbstractService.read(id);
    }

    @PutMapping("")
    @Override
    public DTO update(
            @Valid
            @RequestBody
            DTO dto
    ) {
        return crudAbstractService.update(dto);
    }

    @DeleteMapping("")
    @Override
    public void delete(
            @PathVariable
            Long id
    ) {
        crudAbstractService.delete(id);
    }

    @GetMapping("/all")
    @Override
    public Api<List<DTO>> list(
            @PageableDefault
            Pageable pageable
    ) {
        return crudAbstractService.list(pageable);
    }
}
