package ru.nsu.lisitsin.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import ru.nsu.lisitsin.api.model.UserRegistrationRequest;
import ru.nsu.lisitsin.api.service.UserService;
import ru.nsu.lisitsin.dao.UserRepository;

@Slf4j
@Component
@RequiredArgsConstructor
public class UserServiceBean implements UserService {

    private final UserRepository userRepository;

    @Override
    public void register(UserRegistrationRequest userRegistrationRequest) {
        log.info("login: '{}' password: '{}'", userRegistrationRequest.getName(), userRegistrationRequest.getPassword());
        userRepository.save(userRegistrationRequest.getName(), userRegistrationRequest.getPassword());
    }
}
