package com.vincenzoemanuele.code4code.complementarity;

import com.google.gson.Gson;
import com.google.gson.stream.JsonReader;
import com.vincenzoemanuele.code4code.complementarity.beans.Repo;
import com.vincenzoemanuele.code4code.complementarity.beans.RepoLang;
import com.vincenzoemanuele.code4code.complementarity.beans.Rule;
import com.vincenzoemanuele.code4code.complementarity.beans.Wrapper;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVRecord;

import java.io.*;
import java.lang.reflect.Array;
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
            if(r.getConfidence() > 0.10){
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
        HashSet<String> langs = new HashSet<>();
        for(Rule r : rules){
            langs.addAll(r.getSucc());
        }
        System.out.println("RULES: " + rules);
        for(Rule r : rules){
            for(String succ : r.getSucc()){
                if(!inputLangs.contains(succ)) {
                    if(suggestedLangs.containsKey(succ)){
                        if(suggestedLangs.get(succ) < r.getConfidence()){
                            suggestedLangs.put(succ, r.getConfidence());
                        }
                        //suggestedLangs.put(succ, suggestedLangs.get(succ) + r.getConfidence());
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

    public static ArrayList<Repo> readRepos() throws Exception{
        Reader in = new FileReader("src/main/resources/files/repos.csv");
        ArrayList<Repo> output = new ArrayList<>();
        Iterable<CSVRecord> records = CSVFormat.DEFAULT.parse(in);
        for(CSVRecord record : records){
            Repo repo = new Repo();
            ArrayList<RepoLang> repoLangs = new ArrayList<>();
            for (int i = 0; i < record.size(); i+=2) {
                repo.addLang(record.get(i));
                repo.addTotalCode(Double.parseDouble(record.get(i+1)));
                repoLangs.add(new RepoLang(record.get(i), Double.parseDouble(record.get(i+1))));
            }
            repo.setRepoLangs(repoLangs);
            for(RepoLang repoLang : repo.getRepoLangs()){
                repoLang.setPercentage(repoLang.getPercentage()/repo.getTotalCode());
            }
            output.add(repo);
        }

        return output;
    }

    public static List<Map.Entry<String, Double>> getComplementarity(List<String> inputLangs) throws Exception{
        FileReader reader = new FileReader("src/main/resources/files/langs_json.json");
        wrappers = readWrappers(reader);
        List<Rule> rules = getRelevantRules(inputLangs);
        List<Rule> filteredRules = filterByConfidence(rules);
        List<Map.Entry<String, Double>> suggested = getSuggestedLangs(filteredRules, inputLangs);
        repos = readRepos();
        ArrayList<Repo> relevantRepos;
        ArrayList<String> langsToRemove = new ArrayList<>();
        for(Map.Entry<String, Double> entry : suggested){
            double mean = 0.0;
            for(String inputLang : inputLangs){
                relevantRepos = new ArrayList<>();
                for(Repo r : repos){
                    if(r.getLangs().contains(entry.getKey()) && r.getLangs().contains(inputLang)){
                        relevantRepos.add(r);
                    }
                }
                double sum = 0.0;
                int numberOfRepos = 0;
                for(Repo r : relevantRepos){
                    for(RepoLang repoLang : r.getRepoLangs()){
                        if(repoLang.getLanguage().equals(entry.getKey())){
                            sum += repoLang.getPercentage();
                        }
                    }
                    numberOfRepos++;
                }
                if(mean < sum/numberOfRepos){
                    mean = sum/numberOfRepos;
                }
                System.out.println(entry.getKey() + " with " + inputLang + "=" + mean);
            }
            if(mean < 0.035){
                langsToRemove.add(entry.getKey());
            }
        }

        for(Map.Entry<String, Double> entry : suggested){
            double mean = 0.0;
            for(String inputLang : inputLangs){
                relevantRepos = new ArrayList<>();
                for(Repo r : repos){
                    if(r.getLangs().contains(entry.getKey()) && r.getLangs().contains(inputLang)){
                        relevantRepos.add(r);
                    }
                }
                double sum = 0.0;
                int numberOfRepos = 0;
                for(Repo r : relevantRepos){
                    for(RepoLang repoLang : r.getRepoLangs()){
                        if(repoLang.getLanguage().equals(inputLang)){
                            sum += repoLang.getPercentage();
                        }
                    }
                    numberOfRepos++;
                }
                if(mean < sum/numberOfRepos){
                    mean = sum/numberOfRepos;
                }
                System.out.println(inputLang + " with " + entry.getKey() + "=" + mean);

            }
            if(mean < 0.035){
                langsToRemove.add(entry.getKey());
            }
        }


        for(int i = 0; i < suggested.size(); i++){
            if(langsToRemove.contains(suggested.get(i).getKey())){
                suggested.remove(i);
                i--;
            }
        }

        return suggested;
    }

    private static List<Wrapper> wrappers;
    private static ArrayList<Repo> repos = new ArrayList<>();

}
