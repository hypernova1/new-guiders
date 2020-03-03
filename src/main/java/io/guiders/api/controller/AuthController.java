package io.guiders.api.controller;

import io.guiders.api.domain.User;
import io.guiders.api.payload.UserDto;
import io.guiders.api.service.AuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthController {

    private final AuthService authService;

    @PostMapping("/join")
    public ResponseEntity<?> join(@Valid @RequestBody UserDto.JoinRequest joinRequest) {

        User member = authService.joinMember(joinRequest);

        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest().path("/{id}")
                .buildAndExpand(member.getId()).toUri();

        return ResponseEntity.created(location).build();
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@Valid @RequestBody UserDto.LoginRequest loginRequest) {

        User member = authService.loginMember(loginRequest);

        return ResponseEntity.ok(member);
    }

}
