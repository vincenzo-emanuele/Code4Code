package com.vincenzoemanuele.code4code.controller;

import com.vincenzoemanuele.code4code.complementarity.ComplementarityTester;
import com.vincenzoemanuele.code4code.similarity.SimilarityTester;
import com.vincenzoemanuele.code4code.similarity.beans.Language;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class LangsSuggestionController {

    @GetMapping("/home")
    public String getHome(Model model) throws Exception{
        return "index";
    }

    @GetMapping("/suggest")
    public String getSuggestion(Model model) throws Exception {
        List<String> inputLanguages = new ArrayList<>();
        inputLanguages.add("Java");
        HashMap<String, Double> map = ComplementarityTester.getComplementarity(inputLanguages);
        ArrayList<Map.Entry<Language, Integer>> output = SimilarityTester.getSimilarity("Java");
        model.addAttribute("output", output);
        model.addAttribute("map", map);
        return "langs_result";
    }

}
