package io.guiders.api.controller;

import com.sun.jndi.toolkit.url.Uri;
import io.guiders.api.domain.Member;
import io.guiders.api.payload.ApiResponse;
import io.guiders.api.payload.MemberDto;
import io.guiders.api.service.AuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthController {

    private final AuthService authService;

    @PostMapping("/join")
    public ResponseEntity<?> join(@RequestBody MemberDto.JoinRequest joinRequest) {

        Member member = authService.joinMember(joinRequest);

        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest().path("/{id}")
                .buildAndExpand(member.getId()).toUri();

        return ResponseEntity.created(location).build();
    }

    @PostMapping("login")
    public ResponseEntity<?> login(@RequestBody MemberDto.LoginRequest loginRequest) {

        Member member = authService.loginMember(loginRequest);

        return ResponseEntity.ok(member);

    }

}
