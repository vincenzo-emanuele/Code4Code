package com.vincenzoemanuele.code4code.complementarity;

import com.google.gson.Gson;
import com.google.gson.stream.JsonReader;
import com.vincenzoemanuele.code4code.complementarity.beans.Rule;
import com.vincenzoemanuele.code4code.complementarity.beans.Wrapper;
import java.io.*;
import java.util.*;

public class ComplementarityRunner {

    public static List<Wrapper> readWrappers(FileReader stream) {
        Gson gson = new Gson();
        JsonReader r = new JsonReader(stream);
        return Arrays.asList(gson.fromJson(r, Wrapper[].class));
    }

    public static List<Rule> getRelevantRules(List<String> inputLangs){
        List<Rule> output = new ArrayList<>();
        for(Wrapper w : wrappers){
            if(inputLangs.containsAll(w.getLinguaggi())){
                continue;
            }
            for(Rule r : w.getRules()){
                if(inputLangs.containsAll(r.getPred())){
                    output.add(r);
                }
            }
        }
        return output;
    }

    public static void sortLanguages(List<Map.Entry<String, Double>> languages){
        languages.sort(new Comparator<Map.Entry<String, Double>>() {
            @Override
            public int compare(Map.Entry<String, Double> o1, Map.Entry<String, Double> o2) {
                return o1.getValue().compareTo(o2.getValue());
            }
        });
    }

    public static List<Rule> filterByConfidence (List<Rule> rules){
        List<Rule> output = new ArrayList<>();
        for(Rule r : rules){
            if(r.getConfidence() > 0.01){
                output.add(r);
            }
        }
        return output;
    }

    public static List<Map.Entry<String, Double>> getSuggestedLangs(List<Rule> rules, List<String> inputLangs){
        List<Map.Entry<String, Double>> languages = getLanguagesList(rules, inputLangs);
        sortLanguages(languages);
        List<Map.Entry<String, Double>> outputList = new ArrayList<>();
        /*languages.sort(new Comparator<Map.Entry<String, Double>>() {
            @Override
            public int compare(Map.Entry<String, Double> o1, Map.Entry<String, Double> o2) {
                return o1.getValue().compareTo(o2.getValue());
            }
        });*/
        int index = calculateIndex(languages);
        for(int i = index; i < languages.size(); i++){
            outputList.add(languages.get(i));
        }
        return outputList;
    }

    public static List<Map.Entry<String, Double>> getLanguagesList(List<Rule> rules, List<String> inputLangs){
        HashMap<String, Double> suggestedLangs = new HashMap<>();
        for(Rule r : rules){
            for(String succ : r.getSucc()){
                if(!inputLangs.contains(succ)) {
                    if(suggestedLangs.containsKey(succ)){
                        if(suggestedLangs.get(succ) < r.getConfidence()){
                            suggestedLangs.put(succ, r.getConfidence());
                        }
                    } else {
                        suggestedLangs.put(succ, r.getConfidence());
                    }
                }
            }
        }
        System.out.println("AFTER REMOVE INPUT LANGS: " + suggestedLangs);
        return new ArrayList<>(suggestedLangs.entrySet());
    }

    public static int calculateIndex(List<Map.Entry<String, Double>> rules){
        int index;
        if(rules.size() <= 10){
            index = 0;
        } else if(rules.size() < 20){
            index = rules.size()/2;
        } else {
            index = 3*rules.size()/4;
        }
        return index;
    }

    public static List<Map.Entry<String, Double>> getComplementarity(List<String> inputLangs) throws Exception{
        FileReader reader = new FileReader("src/main/resources/files/langs_json.json");
        wrappers = readWrappers(reader);
        List<Rule> rules = getRelevantRules(inputLangs);
        System.out.println("BEFORE SORTING: " + rules);
        //sortRules(rules);
        System.out.println("AFTER SORTING: " + rules);
        List<Rule> filteredRules = filterByConfidence(rules);
        System.out.println("AFTER FILTERING: " + filteredRules);
        List<Map.Entry<String, Double>> suggested = getSuggestedLangs(filteredRules, inputLangs);
        return suggested;
    }

    private static List<Wrapper> wrappers;

}
