package com.vincenzoemanuele.code4code.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class FrameworkLibrarySuggestionController {

    @GetMapping("/framework")
    public String getFramework(Model model) throws Exception{
        return "framework";
    }

}
