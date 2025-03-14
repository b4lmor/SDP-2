package ru.nsu.lisitsin.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import ru.nsu.lisitsin.model.UserRegistrationRequest;
import ru.nsu.lisitsin.service.UserService;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/user")
public class UserController {

    private final UserService userService;

    @PostMapping
    public ResponseEntity<Void> register(@RequestBody UserRegistrationRequest userRegistrationRequest) {
        userService.register(userRegistrationRequest);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<String> info(@PathVariable("id") Long id) {
        return ResponseEntity.ok().body(userService.info(id));
    }

    @PostMapping("/transfer")
    public String transferMoney(@RequestParam("amount") double amount, @RequestParam("account") String account) {
        log.info("Transferring ${} to account {}", amount, account);
        return "Transfer successful";
    }

}
