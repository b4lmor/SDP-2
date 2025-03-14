package ru.nsu.lisitsin.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import ru.nsu.lisitsin.model.UserRegistrationRequest;
import ru.nsu.lisitsin.dao.UserRepository;
import ru.nsu.lisitsin.dao.entity.User;

@Slf4j
@Component
@RequiredArgsConstructor
public class UserServiceBean implements UserService {

    private final UserRepository userRepository;

    @Override
    public void register(UserRegistrationRequest userRegistrationRequest) {
        log.info("login: '{}' password: '{}'", userRegistrationRequest.getName(), userRegistrationRequest.getPassword());
        User user = new User();
        user.setLogin(userRegistrationRequest.getName());
        user.setPassword(userRegistrationRequest.getPassword());
        userRepository.save(user);
    }

    @Override
    public String info(Long id) {
        return userRepository.findById(id)
                .map(u -> "%s:%s:%s".formatted(u.getId(), u.getLogin(), u.getPassword()))
                .orElse("Not found");
    }
}
