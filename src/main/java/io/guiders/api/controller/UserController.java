package io.guiders.api.controller;

import io.guiders.api.domain.User;
import io.guiders.api.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @GetMapping
    public ResponseEntity<?> getUserList(@RequestParam(defaultValue = "1") int page,
                                         @RequestParam(defaultValue = "10") int size) {

        Pageable pageable = PageRequest.of(page - 1, size);

        List<User> userList = userService.getUserList(pageable);

        if (userList.size() == 0) return ResponseEntity.notFound().build();

        return ResponseEntity.ok(userList);
    }


}
