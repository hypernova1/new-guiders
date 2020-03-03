package io.guiders.api.controller;

import io.guiders.api.payload.PostDto;
import io.guiders.api.service.PostService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import org.springframework.web.util.UriBuilder;
import org.springframework.web.util.UriBuilderFactory;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/post")
@RequiredArgsConstructor
public class PostController {

    private final PostService postService;

    @GetMapping
    public ResponseEntity<?> getPostList(@RequestParam(defaultValue = "1") int page,
                                         @RequestParam(defaultValue = "10") int size) {

        Pageable pageable = PageRequest.of(page - 1, size, Sort.Direction.DESC, "id");

        List postList = postService.getPostList(pageable);

        return ResponseEntity.ok(postList);
    }

    @PostMapping
    public ResponseEntity<?> registerPost(@Valid @RequestBody PostDto.Request request) {

        PostDto.Response post = postService.registerPost(request);

        URI location = ServletUriComponentsBuilder
                .fromCurrentContextPath()
                .path("{id}")
                .buildAndExpand(post.getId()).toUri();
        return ResponseEntity.created(location).build();
    }


}
