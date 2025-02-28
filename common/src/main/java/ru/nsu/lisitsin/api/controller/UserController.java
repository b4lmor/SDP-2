package ru.nsu.lisitsin.api.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import ru.nsu.lisitsin.api.model.UserRegistrationRequest;
import ru.nsu.lisitsin.api.service.UserService;

@RestController
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @PostMapping("/user")
    public ResponseEntity<Void> register(@RequestBody UserRegistrationRequest userRegistrationRequest) {
        userService.register(userRegistrationRequest);
        return ResponseEntity.ok().build();
    }

}
