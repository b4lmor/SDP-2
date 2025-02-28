package ru.nsu.lisitsin.api.service;

import ru.nsu.lisitsin.api.model.UserRegistrationRequest;

public interface UserService {

    void register(UserRegistrationRequest userRegistrationRequest);

    String info(Long id);
}
