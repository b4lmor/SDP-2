package ru.nsu.lisitsin.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

@Service
@RequiredArgsConstructor
public class ViewServiceBean implements ViewService {

    @Override
    public void editModelGreet(Model model, String name) {
        model.addAttribute("name", name);
    }
}
