package com.vincenzoemanuele.code4code.similarity;

import com.google.gson.Gson;
import com.google.gson.stream.JsonReader;
import com.vincenzoemanuele.code4code.complementarity.beans.Wrapper;
import com.vincenzoemanuele.code4code.similarity.beans.*;

import java.io.FileInputStream;
import java.io.FileReader;
import java.util.*;

public class SimilarityRunner {

    public static List<Language> readLanguages(FileReader stream) {
        Gson gson = new Gson();
        JsonReader r = new JsonReader(stream);
        return new ArrayList<>(Arrays.asList(gson.fromJson(r, Language[].class)));
/*
        Gson gson = new Gson();
        Scanner sc = new Scanner(stream);
        String content = sc.nextLine();
        Language[] languages = gson.fromJson(content, Language[].class);
        return new ArrayList<>(Arrays.asList(languages));
*/
    }

    public static Language findLanguage(String languageName){
        for(Language l : languages){
            if(l.getName().equals(languageName)){
                return l;
            }
        }
        return null;
    }

    public static List<Language> filterLanguages(Type type){
        List<Language> output = new ArrayList<>();
        for(Language l : languages){
            if(l.getType().equals(type)){
                output.add(l);
            }
        }
        return output;
    }

    public static List<Map.Entry<Language, Integer>> getLanguagesScore(Language inputLanguage, List<Language> filteredLanguages){
        ArrayList<Map.Entry<Language, Integer>> output = new ArrayList<>();
        for(Language l : filteredLanguages){
            output.add(new AbstractMap.SimpleEntry<Language, Integer>(l, calculateScore(inputLanguage, l)));
        }
        return output;
    }

    public static int calculateScore(Language inputLanguage, Language currentLanguage){
        int score = 0;
        HashSet<Usage> commonUsages = new HashSet<>(inputLanguage.getUsages());
        commonUsages.retainAll(currentLanguage.getUsages());
        score += commonUsages.size();
        HashSet<Paradigm> commonParadigms = new HashSet<>(inputLanguage.getParadigms());
        commonParadigms.retainAll(currentLanguage.getParadigms());
        score += commonParadigms.size();
        HashSet<Typing> commonTypings = new HashSet<>(inputLanguage.getTypings());
        commonTypings.retainAll(currentLanguage.getTypings());
        score += commonTypings.size();
        return score;
    }

    public static List<Map.Entry<Language, Integer>> filterByScore(List<Map.Entry<Language, Integer>> languagesScore){
        sortLangsByScore(languagesScore);
        boolean noZero = false;
        for(int i = 0; i < languagesScore.size(); i++){
            if(languagesScore.get(i).getValue() != 0){
                noZero = true;
                break;
            }
        }
        if(noZero) {
            for (int i = 0; i < languagesScore.size(); i++) {
                if (languagesScore.get(i).getValue() == 0) {
                    languagesScore.remove(i);
                    i--;
                }
            }
        }
        int index;
        if(languagesScore.size() > 5){
            index = languagesScore.size()/2;
        } else {
            index = 0;
        }
        ArrayList<Map.Entry<Language, Integer>> output = new ArrayList<>();
        for(int i = index; i < languagesScore.size(); i++){
            output.add(languagesScore.get(i));
        }
        return output;
    }

    public static void sortLangsByScore(List<Map.Entry<Language, Integer>> languageScore){
        Collections.sort(languageScore, new Comparator<Map.Entry<Language, Integer>>() {
            @Override
            public int compare(Map.Entry<Language, Integer> o1, Map.Entry<Language, Integer> o2) {
                if(o1.getValue() < o2.getValue()){
                    return -1;
                } else if(o1.getValue() > o2.getValue()){
                    return 1;
                } else {
                    return 0;
                }
            }
        });
    }

    public static List<Map.Entry<Language, Double>> getSingleSimilarity(String language) {
        Language inputLanguage = findLanguage(language);
        languages.remove(inputLanguage);
        List<Language> filteredLanguages = filterLanguages(inputLanguage.getType());
        List<Map.Entry<Language, Integer>> languagesScore = getLanguagesScore(inputLanguage, filteredLanguages);
        List<Map.Entry<Language, Integer>> result = filterByScore(languagesScore);
        List<Map.Entry<Language, Double>> output = new ArrayList<>();
        for(Map.Entry<Language, Integer> entry : result){
            double value1 = entry.getKey().getParadigms().size() + entry.getKey().getUsages().size() + entry.getKey().getTypings().size();
            double value2 = entry.getValue();
            double out = value2/value1;
            output.add(new AbstractMap.SimpleEntry<Language, Double>(entry.getKey(), out));
        }
        return output;
    }

    public static List<Map.Entry<Language, Double>> filterByRatio(List<Map.Entry<Language, Double>> langs){
        langs.sort(new Comparator<Map.Entry<Language, Double>>() {
            @Override
            public int compare(Map.Entry<Language, Double> o1, Map.Entry<Language, Double> o2) {
                return o2.getValue().compareTo(o1.getValue());
            }
        });

        int index;
        if(langs.size() > 5){
            index = langs.size()/2;
        } else {
            index = 0;
        }
        ArrayList<Map.Entry<Language, Double>> output = new ArrayList<>();
        for(int i = index; i < langs.size(); i++){
            output.add(langs.get(i));
        }
        return output;

    }

    public static List<Map.Entry<Language, Double>> getSimilarity(List<String> inputLangs) throws Exception{
        languages = readLanguages(new FileReader("src/main/resources/files/langs.json"));
        ArrayList<Map.Entry<Language, Double>> output = new ArrayList<>();
        for(String lang : inputLangs){
            output.addAll(getSingleSimilarity(lang));
        }
        for(int i = 0; i < output.size(); i++){
            if(inputLangs.contains(output.get(i).getKey().getName())){
                output.remove(i);
                i--;
            }
        }
        List<Map.Entry<Language, Double>> result = filterByRatio(output);
        HashMap<Language, Double> map = new HashMap<>();
        for(Map.Entry<Language, Double> entry : result){
            if(map.containsKey(entry.getKey())){
                if(map.get(entry.getKey()) < entry.getValue()) {
                    map.put(entry.getKey(), entry.getValue());
                }
            } else {
                map.put(entry.getKey(), entry.getValue());
            }
        }
        return new ArrayList<>(map.entrySet());
    }

    private static List<Language> languages;

}
