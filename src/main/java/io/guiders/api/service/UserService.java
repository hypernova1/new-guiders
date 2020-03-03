package io.guiders.api.service;

import io.guiders.api.domain.User;
import io.guiders.api.exception.MemberNotFoundException;
import io.guiders.api.payload.UserDto;
import io.guiders.api.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class UserService {

    private final ModelMapper modelMapper;
    private final UserRepository userRepository;


    public List<UserDto.UserResponse> getUserList(Pageable pageable) {
        return userRepository.findAll(pageable)
                .getContent().stream()
                .map(user -> modelMapper.map(user, UserDto.UserResponse.class))
                .collect(Collectors.toList());
    }

    public User modifyUserInfo(UserDto.ModifyRequest modifyRequest) {
        User user = userRepository.findById(modifyRequest.getId()).orElseThrow(MemberNotFoundException::new);
        user.setName(modifyRequest.getName());
        user.setPassword(modifyRequest.getPassword());
        return user;
    }
}
