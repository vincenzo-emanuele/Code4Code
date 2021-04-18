package com.vincenzoemanuele.code4code.controller;

import com.vincenzoemanuele.code4code.complementarity.ComplementarityTester;
import com.vincenzoemanuele.code4code.similarity.SimilarityTester;
import com.vincenzoemanuele.code4code.similarity.beans.Language;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class LangsSuggestionController {

    @ModelAttribute(value = "form")
    public Form newForm(){
        return new Form();
    }

    @GetMapping("/home")
    public String getHome(Model model) throws Exception{
        return "index";
    }

    @GetMapping("/suggest")
    public String getSuggestion(@ModelAttribute("form") Form form, Model model) throws Exception {
        System.out.println(form);
        List<String> inputLanguages = new ArrayList<>();
        inputLanguages.add("Java");
        HashMap<String, Double> map = ComplementarityTester.getComplementarity(inputLanguages);
        ArrayList<Map.Entry<Language, Integer>> output = SimilarityTester.getSimilarity("Java");
        model.addAttribute("output", output);
        model.addAttribute("map", map);
        return "langs_result";
    }

}
