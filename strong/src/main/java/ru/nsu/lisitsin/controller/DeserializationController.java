package ru.nsu.lisitsin.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DeserializationController {

    @PostMapping("/deserialize")
    public String deserialize(@RequestBody Test data) {
        return "success";
    }

    public record Test() {
    }
}
