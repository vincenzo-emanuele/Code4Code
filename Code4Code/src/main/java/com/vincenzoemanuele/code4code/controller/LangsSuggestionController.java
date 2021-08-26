package com.vincenzoemanuele.code4code.controller;

import com.vincenzoemanuele.code4code.complementarity.ComplementarityRunner;
import com.vincenzoemanuele.code4code.nlp.NLPRunner;
import com.vincenzoemanuele.code4code.similarity.SimilarityRunner;
import com.vincenzoemanuele.code4code.similarity.beans.Language;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

import java.util.*;

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

    private List<String> getFrameworks(Form form){
        List<String> inputFrameworks = new ArrayList<>();
        if(form.DOTNET) inputFrameworks.add("dotnet");
        if(form.AJAX) inputFrameworks.add("ajax");
        if(form.Amp) inputFrameworks.add("amp");
        if(form.Android) inputFrameworks.add("android");
        if(form.Angular) inputFrameworks.add("angular");
        if(form.ASPDOTNET) inputFrameworks.add("aspdotnet");
        if(form.Bootstrap) inputFrameworks.add("bootstrap");
        if(form.Django) inputFrameworks.add("django");
        if(form.Electron) inputFrameworks.add("electron");
        if(form.Ember) inputFrameworks.add("ember");
        if(form.Express) inputFrameworks.add("express");
        if(form.Firebase) inputFrameworks.add("firebase");
        if(form.Flask) inputFrameworks.add("flask");
        if(form.jQuery) inputFrameworks.add("jquery");
        if(form.Keras) inputFrameworks.add("keras");
        if(form.Koa) inputFrameworks.add("koa");
        if(form.Node) inputFrameworks.add("node");
        if(form.RubyOnRails) inputFrameworks.add("rails");
        if(form.Ratchet) inputFrameworks.add("ratchet");
        if(form.React) inputFrameworks.add("react");
        if(form.ReactNative) inputFrameworks.add("native");
        if(form.ReactiveUI) inputFrameworks.add("reactiveui");
        if(form.Scikit) inputFrameworks.add("scikit");
        if(form.Spring) inputFrameworks.add("spring");
        if(form.Symfony) inputFrameworks.add("symfony");
        if(form.TensorFlow) inputFrameworks.add("tensorflow");
        if(form.Thymeleaf) inputFrameworks.add("thymeleaf");
        if(form.Vue) inputFrameworks.add("vue");
        return inputFrameworks;
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
    public String getSuggestion(@ModelAttribute("form") Form form, Model model) throws Exception{
        inputLanguages = getLanguages(form);
        inputFrameworks = getFrameworks(form);
        List<Map.Entry<String, Double>> complementaryLanguages = ComplementarityRunner.getComplementarity(inputLanguages);
        List<Map.Entry<Language, Double>> similarLanguages = SimilarityRunner.getSimilarity(inputLanguages);
        removeDuplicates(complementaryLanguages, similarLanguages);
        ArrayList<String> languagesAndFrameworks = new ArrayList<>(inputLanguages);
        languagesAndFrameworks.addAll(inputFrameworks);
        List<List<Map.Entry<String, Double>>> suggestedFrameworks = NLPRunner.getSuggestedFrameworks(languagesAndFrameworks);
        System.out.println(complementaryLanguages);
        System.out.println(suggestedFrameworks);
        model.addAttribute("inputLanguages", inputLanguages);
        model.addAttribute("inputFrameworks", inputFrameworks);
        model.addAttribute("similarLanguages", similarLanguages);
        model.addAttribute("complementaryLanguages", complementaryLanguages);
        model.addAttribute("suggestedFrameworks", suggestedFrameworks);
        return "langs_result";
    }

    public void removeDuplicates(List<Map.Entry<String, Double>> complementaryLanguages, List<Map.Entry<Language, Double>> similarLanguages){
        List<Map.Entry<String, Double>> removeFromComplementary = new ArrayList<>();
        List<Map.Entry<Language, Double>> removeFromSimilarity = new ArrayList<>();
        for (Map.Entry<Language, Double> languageDoubleEntry : similarLanguages) {
            for (Map.Entry<String, Double> stringDoubleEntry : complementaryLanguages) {
                if (languageDoubleEntry.getKey().getName().equals(stringDoubleEntry.getKey())) {
                    if (languageDoubleEntry.getValue() > stringDoubleEntry.getValue()) {
                        removeFromComplementary.add(stringDoubleEntry);
                    } else {
                        removeFromSimilarity.add(languageDoubleEntry);
                    }
                }
            }
        }
        complementaryLanguages.removeAll(removeFromComplementary);
        similarLanguages.removeAll(removeFromSimilarity);
        complementaryLanguages.sort((o1, o2) -> o2.getValue().compareTo(o1.getValue()));
        similarLanguages.sort((o1, o2) -> o2.getValue().compareTo(o1.getValue()));
    }

    /*public List<Map.Entry<String, Double>> getComplementaryLanguages(List<String> inputLanguages) throws Exception {
        List<Map.Entry<String, Double>> complementary = ComplementarityRunner.getComplementarity(inputLanguages);
        List<Map.Entry<Language, Double>> similar = SimilarityRunner.getSimilarity(inputLanguages);
        List<Map.Entry<String, Double>> removeFromComplementary = new ArrayList<>();
        List<Map.Entry<Language, Double>> removeFromSimilarity = new ArrayList<>();

        for (Map.Entry<Language, Double> languageDoubleEntry : similar) {
            for (Map.Entry<String, Double> stringDoubleEntry : complementary) {
                if (languageDoubleEntry.getKey().getName().equals(stringDoubleEntry.getKey())) {
                    if (languageDoubleEntry.getValue() > stringDoubleEntry.getValue()) {
                        removeFromComplementary.add(stringDoubleEntry);
                    } else {
                        removeFromSimilarity.add(languageDoubleEntry);
                    }
                }
            }
        }
        complementary.removeAll(removeFromComplementary);
        similar.removeAll(removeFromSimilarity);
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
    }*/

    List<String> inputLanguages = new ArrayList<>();
    List<String> inputFrameworks = new ArrayList<>();

}
