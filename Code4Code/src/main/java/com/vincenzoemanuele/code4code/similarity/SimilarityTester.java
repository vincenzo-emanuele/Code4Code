package com.vincenzoemanuele.code4code.similarity;

import com.google.gson.Gson;
import com.vincenzoemanuele.code4code.similarity.beans.Language;
import com.vincenzoemanuele.code4code.similarity.beans.Paradigm;
import com.vincenzoemanuele.code4code.similarity.beans.Type;
import com.vincenzoemanuele.code4code.similarity.beans.Usage;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.*;

public class SimilarityTester {

    public static List<Language> readLanguages(FileInputStream stream) throws FileNotFoundException {
        Gson gson = new Gson();
        Scanner sc = new Scanner(stream);
        String content = sc.nextLine();
        Language[] languages = gson.fromJson(content, Language[].class);
        return new ArrayList<>(Arrays.asList(languages));
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

    public static HashMap<Language, Integer> getLanguagesScore(Language inputLanguage, List<Language> filteredLanguages){
        HashMap<Language, Integer> output = new HashMap<>();
        for(Language l : filteredLanguages){
            output.put(l, calculateScore(inputLanguage, l));
        }
        return output;
    }

    public static int calculateScore(Language inputLanguage, Language currentLanguage){
        int score = 0;
        HashSet<Usage> temp = new HashSet<>(inputLanguage.getUsages());
        temp.retainAll(currentLanguage.getUsages());
        score += temp.size();
        HashSet<Paradigm> temp2 = new HashSet<>(inputLanguage.getParadigms());
        temp2.retainAll(currentLanguage.getParadigms());
        score += temp.size();
        return score;
    }

    public static ArrayList<Map.Entry<Language, Integer>> filterByScore(HashMap<Language, Integer> languagesScore){
        ArrayList<Map.Entry<Language, Integer>> sorted = sortMapByScore(languagesScore);
        for(int i = 0; i < sorted.size(); i++){
            if(sorted.get(i).getValue() == 0){
                sorted.remove(i);
                i--;
            }
        }
        int index;
        if(sorted.size() > 5){
            index = sorted.size()/2;
        } else {
            index = 0;
        }
        ArrayList<Map.Entry<Language, Integer>> output = new ArrayList<>();
        for(int i = index; i < sorted.size(); i++){
            output.add(sorted.get(i));
        }
        return output;
    }

    public static ArrayList<Map.Entry<Language, Integer>> sortMapByScore(HashMap<Language, Integer> languageScore){
        ArrayList<Map.Entry<Language, Integer>> temp = new ArrayList<>(languageScore.entrySet());
        Collections.sort(temp, new Comparator<Map.Entry<Language, Integer>>() {
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
        return temp;
    }

    public static ArrayList<Map.Entry<Language, Integer>> getSimilarity(String language)  throws Exception {

        languages = readLanguages(new FileInputStream("src/main/resources/files/langs.txt"));
        Language inputLanguage = findLanguage(language);
        languages.remove(inputLanguage);
        List<Language> filteredLanguages = filterLanguages(inputLanguage.getType());
        HashMap<Language, Integer> languagesScore = getLanguagesScore(inputLanguage, filteredLanguages);
        ArrayList<Map.Entry<Language, Integer>> result = filterByScore(languagesScore);
        for(Map.Entry<Language, Integer> entry : result){
            System.out.println(entry.getKey().getName() + "=" + entry.getValue());
            double value1 = entry.getKey().getParadigms().size() + entry.getKey().getUsages().size();
            double value2 = entry.getValue();
            double out = value2/value1;
            System.out.println("Value1: " + value1);
            System.out.println("Value2 " + value2);
            System.out.println("VALUE: " + out);
        }
        return result;
    }

    private static List<Language> languages;

}
