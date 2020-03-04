package io.guiders.api.controller;

import io.guiders.api.payload.EssayDto;
import io.guiders.api.service.PostService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/essay")
@RequiredArgsConstructor
public class EssayController {

    private final PostService postService;

    @GetMapping
    public ResponseEntity<?> getEssayList(@RequestParam(defaultValue = "1") int page,
                                         @RequestParam(defaultValue = "10") int size) {

        Pageable pageable = PageRequest.of(page - 1, size, Sort.Direction.DESC, "id");

        List essayList = postService.getEssayList(pageable);

        return ResponseEntity.ok(essayList);
    }

    @PostMapping
    public ResponseEntity<?> registerEssay(@Valid @RequestBody EssayDto.Request request) {

        EssayDto.Response essay = postService.registerEssay(request);

        URI location = ServletUriComponentsBuilder
                .fromCurrentContextPath()
                .path("{id}")
                .buildAndExpand(essay.getId()).toUri();
        return ResponseEntity.created(location).build();
    }


}
