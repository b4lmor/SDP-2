package ru.nsu.lisitsin.api.model;

import lombok.Builder;
import lombok.Value;
import lombok.extern.jackson.Jacksonized;

@Value
@Builder
@Jacksonized
public class UserRegistrationRequest {

    String name;

    String password;

}
