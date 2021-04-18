package com.vincenzoemanuele.code4code.complementarity;

import com.google.gson.Gson;
import com.vincenzoemanuele.code4code.complementarity.beans.Rule;
import com.vincenzoemanuele.code4code.complementarity.beans.Wrapper;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.*;

public class ComplementarityTester {

    public static List<Wrapper> readWrappers(FileInputStream stream) throws FileNotFoundException{
        Gson gson = new Gson();
        Scanner sc = new Scanner(stream);
        String content = sc.nextLine();
        return Arrays.asList(gson.fromJson(content, Wrapper[].class));
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
            if(r.getConfidence() > 0.10){
                output.add(r);
            }
        }
        return output;
    }

    public static HashMap<String, Double> getSuggestedLangs(List<Rule> rules){
        HashMap<String, Double> output = new HashMap<>();
        int index = calculateIndex(rules);
        for(int i = index; i < rules.size(); i++){
            for(String succ : rules.get(i).getSucc()){
                output.put(succ, rules.get(i).getConfidence());
            }
        }
        return output;
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

    public static HashMap<String, Double> getComplementarity(List<String> inputLangs) throws Exception{
        FileInputStream stream = new FileInputStream("src/main/resources/files/langs_json.txt");
        wrappers = readWrappers(stream);
        HashSet<String> set = new HashSet<>();
        for(Wrapper w : wrappers){
            set.addAll(w.getLinguaggi());
        }
        System.out.println(set);
        System.out.println(set.size());
        List<Rule> rules = getRelevantRules(inputLangs);
        sortRules(rules);
        List<Rule> filteredRules = filterByConfidence(rules);
        HashMap<String, Double> suggested = getSuggestedLangs(filteredRules);
        for(Map.Entry<String, Double> entry : suggested.entrySet()){
            System.out.println(entry);
        }
        return suggested;
    }

    private static List<Wrapper> wrappers;

}
