package ru.nsu.lisitsin.service;

import ru.nsu.lisitsin.model.UserRegistrationRequest;

public interface UserService {

    void register(UserRegistrationRequest userRegistrationRequest);

    String info(Long id);
}
