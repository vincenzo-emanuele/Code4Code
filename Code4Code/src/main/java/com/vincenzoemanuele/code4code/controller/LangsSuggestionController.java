package com.vincenzoemanuele.code4code.controller;

import com.vincenzoemanuele.code4code.complementarity.ComplementarityTester;
import com.vincenzoemanuele.code4code.similarity.SimilarityTester;
import com.vincenzoemanuele.code4code.similarity.beans.Language;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

import java.util.*;
import java.util.stream.Collectors;

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

    private List<String> getLanguages(Form form){
        List<String> inputLanguages = new ArrayList<>();
        if(form.Assembly)inputLanguages.add("Assembly");
        if(form.Bash) inputLanguages.add("Shell");
        if(form.Batch) inputLanguages.add("Batch");
        if(form.C) inputLanguages.add("C");
        if(form.Cpp) inputLanguages.add("C++");
        if(form.CSharp) inputLanguages.add("C#");
        if(form.CoffeeScript) inputLanguages.add("CoffeeScript");
        if(form.CSS) inputLanguages.add("CSS");
        if(form.Go) inputLanguages.add("Go");
        if(form.Groovy) inputLanguages.add("Groovy");
        if(form.Hack) inputLanguages.add("Hack");
        if(form.HTML) inputLanguages.add("HTML");
        if(form.Java) inputLanguages.add("Java");
        if(form.JavaScript) inputLanguages.add("JavaScript");
        if(form.Kotlin) inputLanguages.add("Kotlin");
        if(form.Lua) inputLanguages.add("Lua");
        if(form.ObjectiveC) inputLanguages.add("Objective-C");
        if(form.Perl) inputLanguages.add("Perl");
        if(form.PHP) inputLanguages.add("PHP");
        if(form.Python) inputLanguages.add("Python");
        if(form.PowerShell) inputLanguages.add("PowerShell");
        if(form.Ruby) inputLanguages.add("Ruby");
        if(form.SQL) inputLanguages.add("SQL");
        if(form.Swift) inputLanguages.add("Swift");
        if(form.TeX) inputLanguages.add("TeX");
        if(form.TypeScript) inputLanguages.add("TypeScript");
        return inputLanguages;
    }

    @GetMapping("/suggest")
    public String getSuggestion(@ModelAttribute("form") Form form, Model model) throws Exception {
        List<String> inputLanguages = getLanguages(form);
        List<Map.Entry<String, Double>> complementary = ComplementarityTester.getComplementarity(inputLanguages);
        List<Map.Entry<Language, Double>> similar = SimilarityTester.getSimilarity(inputLanguages);
        for(int i = 0; i < similar.size(); i++){
            for(int j = 0; j < complementary.size(); j++){
                if(similar.get(i).getKey().getName().equals(complementary.get(j).getKey())){
                    if(similar.get(i).getValue() > complementary.get(j).getValue()){
                        complementary.remove(j);
                        j--;
                    } else {
                        similar.remove(i);
                        i--;
                    }
                }
            }
        }
        complementary.sort(new Comparator<Map.Entry<String, Double>>() {
            @Override
            public int compare(Map.Entry<String, Double> o1, Map.Entry<String, Double> o2) {
                return o2.getValue().compareTo(o1.getValue());
            }
        });
        similar.sort(new Comparator<Map.Entry<Language, Double>>() {
            @Override
            public int compare(Map.Entry<Language, Double> o1, Map.Entry<Language, Double> o2) {
                return o2.getValue().compareTo(o1.getValue());
            }
        });
        model.addAttribute("inputLanguages", inputLanguages);
        model.addAttribute("similar", similar);
        model.addAttribute("complementary", complementary);
        return "langs_result";
    }

}
