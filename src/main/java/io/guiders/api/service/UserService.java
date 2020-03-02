package io.guiders.api.service;

import io.guiders.api.domain.User;
import io.guiders.api.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;


    public List<User> getUserList(Pageable pageable) {
        return userRepository.findAll(pageable).getContent();
    }
}
