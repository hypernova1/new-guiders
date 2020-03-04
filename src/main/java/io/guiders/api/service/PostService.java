package io.guiders.api.service;

import io.guiders.api.domain.Essay;
import io.guiders.api.domain.Guider;
import io.guiders.api.exception.MemberNotFoundException;
import io.guiders.api.payload.EssayDto;
import io.guiders.api.repository.EssayRepository;
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

    private final EssayRepository essayRepository;
    private final UserRepository userRepository;

    public List<EssayDto.Response> getEssayList(Pageable pageable) {
        return essayRepository.findAll(pageable).getContent()
                .stream()
                .map(post -> modelMapper.map(post, EssayDto.Response.class))
                .collect(Collectors.toList());
    }

    @Transactional
    public EssayDto.Response registerEssay(EssayDto.Request request) {

        Guider byId = (Guider) userRepository.findById(1L).orElseThrow(MemberNotFoundException::new);

        Essay essay = modelMapper.map(request, Essay.class);
        essay.setGuider(byId);
        Essay save = essayRepository.save(essay);
        return modelMapper.map(save, EssayDto.Response.class);
    }
}
