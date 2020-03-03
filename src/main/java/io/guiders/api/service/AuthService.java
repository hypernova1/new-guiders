package io.guiders.api.service;

import io.guiders.api.domain.Follower;
import io.guiders.api.domain.Guider;
import io.guiders.api.domain.User;
import io.guiders.api.exception.MemberNotFoundException;
import io.guiders.api.payload.UserDto;
import io.guiders.api.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthService {

    private final ModelMapper modelMapper;

    private final UserRepository userRepository;

    public User joinMember(UserDto.JoinRequest joinRequest) {

        if (joinRequest.getMemberType().equals("G")) {
            return userRepository.save(modelMapper.map(joinRequest, Guider.class));
        }

        return userRepository.save(modelMapper.map(joinRequest, Follower.class));
    }


    public User loginMember(UserDto.LoginRequest loginRequest) {
        return userRepository.findByEmailAndPassword(loginRequest.getEmail(), loginRequest.getPassword())
                .orElseThrow(MemberNotFoundException::new);
    }
}
