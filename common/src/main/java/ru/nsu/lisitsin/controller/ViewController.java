package ru.nsu.lisitsin.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ru.nsu.lisitsin.service.ViewService;

@Controller
@RequiredArgsConstructor
public class ViewController {

    private final ViewService viewService;

    @GetMapping("/greet")
    public String greet(@RequestParam(name = "name", required = false, defaultValue = "World") String name, Model model) {
        viewService.editModelGreet(model, name);
        return "greet";
    }

}
