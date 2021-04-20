package com.vincenzoemanuele.code4code.complementarity;

import com.google.gson.Gson;
import com.google.gson.stream.JsonReader;
import com.vincenzoemanuele.code4code.complementarity.beans.Rule;
import com.vincenzoemanuele.code4code.complementarity.beans.Wrapper;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import java.io.*;
import java.util.*;

public class ComplementarityTester {

    public static List<Wrapper> readWrappers(FileReader stream) throws Exception{
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

    public static void sortRules(List<Rule> rules){
        Collections.sort(rules, new Comparator<Rule>() {
            @Override
            public int compare(Rule r1, Rule r2) {
                if(r1.getConfidence() < r2.getConfidence()){
                    return -1;
                } else if(r1.getConfidence() > r2.getConfidence()){
                    return 1;
                } else {
                    return 0;
                }
            }
        });
    }

    public static List<Rule> filterByConfidence (List<Rule> rules){
        List<Rule> output = new ArrayList<>();
        for(Rule r : rules){
            if(r.getConfidence() > 0.15){
                output.add(r);
            }
        }
        return output;
    }

    public static List<Map.Entry<String, Double>> getSuggestedLangs(List<Rule> rules){
        HashMap<String, Double> output = new HashMap<>();
        List<Map.Entry<String, Double>> outputList = new ArrayList<>();
        int index = calculateIndex(rules);
        for(int i = index; i < rules.size(); i++){
            for(String succ : rules.get(i).getSucc()){
                output.put(succ, rules.get(i).getConfidence());
            }
        }
        outputList.addAll(output.entrySet());
        return outputList;
    }

    public static int calculateIndex(List<Rule> rules){
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
        sortRules(rules);
        List<Rule> filteredRules = filterByConfidence(rules);
        List<Map.Entry<String, Double>> suggested = getSuggestedLangs(filteredRules);
        for(int i = 0; i < suggested.size(); i++){
            if(inputLangs.contains(suggested.get(i).getKey())){
                suggested.remove(i);
                i--;
            }
        }
        System.out.println(suggested);
        System.out.println(filteredRules);
        return suggested;
    }

    private static List<Wrapper> wrappers;

}
