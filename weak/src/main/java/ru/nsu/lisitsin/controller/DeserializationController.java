package ru.nsu.lisitsin.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

@RestController
public class DeserializationController {

    @PostMapping("/deserialize")
    public String deserialize(@RequestBody byte[] data) {
        try (ByteArrayInputStream bis = new ByteArrayInputStream(data);
             ObjectInputStream ois = new ObjectInputStream(bis)) {

            Object obj = ois.readObject();
            return "Deserialized object: " + obj.toString();

        } catch (IOException | ClassNotFoundException e) {
            return "Deserialization failed: " + e.getMessage();
        }
    }
}
