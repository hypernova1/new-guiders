package io.guiders.api.service;

import io.guiders.api.domain.Guider;
import io.guiders.api.domain.Post;
import io.guiders.api.domain.constant.PostType;
import io.guiders.api.exception.MemberNotFoundException;
import io.guiders.api.payload.PostDto;
import io.guiders.api.repository.PostRepository;
import io.guiders.api.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class PostService {

    private final ModelMapper modelMapper;

    private final PostRepository postRepository;
    private final UserRepository userRepository;

    public List<PostDto.Response> getPostList(Pageable pageable) {
        return postRepository.findAll(pageable).getContent()
                .stream()
                .map(post -> modelMapper.map(post, PostDto.Response.class))
                .collect(Collectors.toList());
    }

    @Transactional
    public PostDto.Response registerPost(PostDto.Request request) {

        Guider byId = (Guider) userRepository.findById(1L).orElseThrow(MemberNotFoundException::new);

        Post post = modelMapper.map(request, Post.class);
        post.setPostType(PostType.TEST);
        System.out.println(post.toString());
        post.setWriter(byId);
        Post save = postRepository.save(post);
        return modelMapper.map(save, PostDto.Response.class);
    }
}
