package com.vincenzoemanuele.code4code.utility;

import com.google.gson.Gson;
import com.vincenzoemanuele.code4code.similarity.beans.*;

import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

public class LangFiller {

    public static void main(String[] args) {

        ArrayList<Language> languages = new ArrayList<>();
        ArrayList<Paradigm> paradigms;
        ArrayList<Usage> usage;
        ArrayList<Typing> typings = new ArrayList<>();

        //C++
        paradigms = new ArrayList<>(){{
            add(Paradigm.PROCEDURALE);
            add(Paradigm.FUNZIONALE);
            add(Paradigm.OBJECT_ORIENTED);
        }};
        usage = new ArrayList<>(){{
            add(Usage.APPLICATION);
            add(Usage.EMBDEDDED_SYSTEM);
        }};
        typings = new ArrayList<>(){{
           add(Typing.FORTE);
        }};
        languages.add(new Language("C++", Type.PROGRAMMAZIONE, typings, paradigms, usage));

        //Go
        paradigms = new ArrayList<>(){{
            add(Paradigm.FUNZIONALE);
            add(Paradigm.OBJECT_ORIENTED);
            add(Paradigm.IMPERATIVO);
        }};
        usage = new ArrayList<>(){{
            add(Usage.APPLICATION);
            add(Usage.WEB);
            add(Usage.SERVER_SIDE);
        }};
        typings = new ArrayList<>(){{
           add(Typing.FORTE);
        }};
        languages.add(new Language("Go", Type.PROGRAMMAZIONE, typings, paradigms, usage));

        //Objective-C
        paradigms = new ArrayList<>(){{
            add(Paradigm.OBJECT_ORIENTED);
        }};
        usage = new ArrayList<>(){{
            add(Usage.GENERAL_PURPOSE);
            add(Usage.APPLICATION);
        }};
        typings = new ArrayList<>(){{
            add(Typing.DEBOLE);
        }};
        languages.add(new Language("Objective-C", Type.PROGRAMMAZIONE, typings, paradigms, usage));

        //Swift
        paradigms = new ArrayList<>(){{
            add(Paradigm.OBJECT_ORIENTED);
            add(Paradigm.FUNZIONALE);
            add(Paradigm.IMPERATIVO);
            add(Paradigm.DICHIARATIVO);
        }};
        usage = new ArrayList<>(){{
            add(Usage.APPLICATION);
            add(Usage.GENERAL_PURPOSE);
            add(Usage.MOBILE_DEVELOPMENT);
        }};
        typings = new ArrayList<>(){{
            add(Typing.FORTE);
        }};
        languages.add(new Language("Swift", Type.PROGRAMMAZIONE, typings, paradigms, usage));

        //Hack
        paradigms = new ArrayList<>(){{
            add(Paradigm.OBJECT_ORIENTED);
        }};
        usage = new ArrayList<>(){{
            add(Usage.GENERAL_PURPOSE);
        }};
        typings = new ArrayList<>(){{
            add(Typing.DEBOLE);
        }};
        languages.add(new Language("Hack", Type.SCRIPTING, typings, paradigms, usage));

        //JavaScript
        paradigms = new ArrayList<>(){{
           add(Paradigm.IMPERATIVO);
           add(Paradigm.PROCEDURALE);
           add(Paradigm.OBJECT_ORIENTED);
           add(Paradigm.FUNZIONALE);
        }};
        usage = new ArrayList<>(){{
           add(Usage.CLIENT_SIDE);
           add(Usage.SERVER_SIDE);
           add(Usage.WEB);
        }};
        typings = new ArrayList<>(){{
            add(Typing.DEBOLE);
        }};
        languages.add(new Language("JavaScript", Type.SCRIPTING, typings, paradigms, usage));

        //TeX
        paradigms = new ArrayList<>(){{
            add(Paradigm.DICHIARATIVO);
        }};
        usage = new ArrayList<>(){{
            add(Usage.DOCUMENTI);
        }};
        typings = new ArrayList<>(){{
            add(Typing.NESSUNA);
        }};
        languages.add(new Language("TeX", Type.MARKUP, typings, paradigms, usage));

        //C#
        paradigms = new ArrayList<>(){{
            add(Paradigm.DICHIARATIVO);
            add(Paradigm.PROCEDURALE);
            add(Paradigm.OBJECT_ORIENTED);
            add(Paradigm.FUNZIONALE);
            add(Paradigm.IMPERATIVO);
        }};
        usage = new ArrayList<>(){{
            add(Usage.APPLICATION);
            add(Usage.CLIENT_SIDE);
            add(Usage.WEB);
            add(Usage.SERVER_SIDE);
            add(Usage.GENERAL_PURPOSE);
        }};
        typings = new ArrayList<>(){{
            add(Typing.FORTE);
        }};
        languages.add(new Language("C#", Type.PROGRAMMAZIONE, typings, paradigms, usage));

        //TypeScript
        paradigms = new ArrayList<>(){{
            add(Paradigm.OBJECT_ORIENTED);
            add(Paradigm.IMPERATIVO);
        }};
        usage = new ArrayList<>(){{
            add(Usage.APPLICATION);
            add(Usage.CLIENT_SIDE);
            add(Usage.WEB);
        }};
        typings = new ArrayList<>(){{
            add(Typing.FORTE);
        }};
        languages.add(new Language("TypeScript", Type.SCRIPTING, typings, paradigms, usage));

        //HTML
        paradigms = new ArrayList<>(){{
            add(Paradigm.DICHIARATIVO);
        }};
        usage = new ArrayList<>(){{
            add(Usage.APPLICATION);
            add(Usage.CLIENT_SIDE);
            add(Usage.WEB);
        }};
        typings = new ArrayList<>(){{
            add(Typing.NESSUNA);
        }};
        languages.add(new Language("HTML", Type.MARKUP, typings, paradigms, usage));

        //Lua
        paradigms = new ArrayList<>(){{
            add(Paradigm.DICHIARATIVO);
            add(Paradigm.RIFLESSIVO);
        }};
        usage = new ArrayList<>(){{
            add(Usage.APPLICATION);
            add(Usage.GENERAL_PURPOSE);
        }};
        typings = new ArrayList<>(){{
            add(Typing.FORTE);
        }};
        languages.add(new Language("Lua", Type.SCRIPTING, typings, paradigms, usage));

        //Perl
        paradigms = new ArrayList<>(){{
           add(Paradigm.RIFLESSIVO);
           add(Paradigm.OBJECT_ORIENTED);
           add(Paradigm.FUNZIONALE);
           add(Paradigm.IMPERATIVO);
           add(Paradigm.PROCEDURALE);
        }};
        usage = new ArrayList<>(){{
            add(Usage.APPLICATION);
            add(Usage.WEB);
            add(Usage.TEXT_PROCESSING);
        }};
        typings = new ArrayList<>(){{
            add(Typing.FORTE);
            add(Typing.DEBOLE);
        }};
        languages.add(new Language("Perl", Type.SCRIPTING, typings, paradigms, usage));

        //Ruby
        paradigms = new ArrayList<>(){{
           add(Paradigm.RIFLESSIVO);
           add(Paradigm.FUNZIONALE);
           add(Paradigm.IMPERATIVO);
           add(Paradigm.OBJECT_ORIENTED);
        }};
        usage = new ArrayList<>(){{
            add(Usage.APPLICATION);
            add(Usage.WEB);
        }};
        typings = new ArrayList<>(){{
            add(Typing.FORTE);
        }};
        languages.add(new Language("Ruby", Type.SCRIPTING, typings, paradigms, usage));

        //Groovy
        paradigms = new ArrayList<>(){{
            add(Paradigm.IMPERATIVO);
            add(Paradigm.OBJECT_ORIENTED);
        }};
        usage = new ArrayList<>(){{
            add(Usage.APPLICATION);
            add(Usage.WEB);
            add(Usage.GENERAL_PURPOSE);
        }};
        typings = new ArrayList<>(){{
            add(Typing.FORTE);
        }};
        languages.add(new Language("Groovy", Type.SCRIPTING, typings, paradigms, usage));

        //Java
        paradigms = new ArrayList<>(){{
           add(Paradigm.OBJECT_ORIENTED);
        }};
        usage = new ArrayList<>(){{
            add(Usage.GENERAL_PURPOSE);
            add(Usage.SERVER_SIDE);
            add(Usage.APPLICATION);
            add(Usage.MOBILE_DEVELOPMENT);
        }};
        typings = new ArrayList<>(){{
            add(Typing.FORTE);
        }};
        languages.add(new Language("Java", Type.PROGRAMMAZIONE, typings, paradigms, usage));

        //Python
        paradigms = new ArrayList<>(){{
            add(Paradigm.OBJECT_ORIENTED);
            add(Paradigm.PROCEDURALE);
            add(Paradigm.FUNZIONALE);
        }};
        usage = new ArrayList<>(){{
            add(Usage.GENERAL_PURPOSE);
            add(Usage.WEB);
            add(Usage.APPLICATION);
            add(Usage.ARTIFICIAL_INTELLIGENCE);
        }};
        typings = new ArrayList<>(){{
            add(Typing.FORTE);
        }};
        languages.add(new Language("Python", Type.SCRIPTING, typings, paradigms, usage));

        //SQL
        paradigms = new ArrayList<>(){{
            add(Paradigm.DICHIARATIVO);
        }};
        usage = new ArrayList<>(){{
            add(Usage.DATABASE);
        }};
        typings = new ArrayList<>(){{
            add(Typing.FORTE);
        }};
        languages.add(new Language("SQL", Type.QUERY, typings, paradigms, usage));

        //CSS
        paradigms = new ArrayList<>(){{
            add(Paradigm.DICHIARATIVO);
        }};
        usage = new ArrayList<>(){{
            add(Usage.APPLICATION);
            add(Usage.CLIENT_SIDE);
            add(Usage.WEB);
        }};
        typings = new ArrayList<>(){{
            add(Typing.NESSUNA);
        }};
        languages.add(new Language("CSS", Type.STYLESHEET, typings, paradigms, usage));

        //C
        paradigms = new ArrayList<>(){{
            add(Paradigm.IMPERATIVO);
            add(Paradigm.PROCEDURALE);
        }};
        usage = new ArrayList<>(){{
            add(Usage.APPLICATION);
            add(Usage.EMBDEDDED_SYSTEM);
            add(Usage.GENERAL_PURPOSE);
            add(Usage.LOW_LEVEL);
        }};
        typings = new ArrayList<>(){{
            add(Typing.FORTE);
        }};
        languages.add(new Language("C", Type.PROGRAMMAZIONE, typings, paradigms, usage));

        //PHP
        paradigms = new ArrayList<>(){{
            add(Paradigm.IMPERATIVO);
            add(Paradigm.FUNZIONALE);
            add(Paradigm.OBJECT_ORIENTED);
            add(Paradigm.PROCEDURALE);
        }};
        usage = new ArrayList<>(){{
            add(Usage.SERVER_SIDE);
            add(Usage.WEB);
        }};
        typings = new ArrayList<>(){{
            add(Typing.DEBOLE);
        }};
        languages.add(new Language("PHP", Type.SCRIPTING, typings, paradigms, usage));

        //Assembly
        paradigms = new ArrayList<>(){{
            add(Paradigm.IMPERATIVO);
        }};
        usage = new ArrayList<>(){{
            add(Usage.LOW_LEVEL);
            add(Usage.EMBDEDDED_SYSTEM);
        }};
        typings = new ArrayList<>(){{
            add(Typing.NESSUNA);
        }};
        languages.add(new Language("Assembly", Type.PROGRAMMAZIONE, typings, paradigms, usage));

        //CoffeeScript
        paradigms = new ArrayList<>(){{
            add(Paradigm.FUNZIONALE);
            add(Paradigm.IMPERATIVO);
        }};
        usage = new ArrayList<>(){{
            add(Usage.WEB);
        }};
        typings = new ArrayList<>(){{
            add(Typing.NESSUNA);
        }};
        languages.add(new Language("CoffeeScript", Type.SCRIPTING, typings, paradigms, usage));

        //Kotlin
        paradigms = new ArrayList<>(){{
            add(Paradigm.OBJECT_ORIENTED);
        }};
        usage = new ArrayList<>(){{
            add(Usage.WEB);
            add(Usage.SERVER_SIDE);
            add(Usage.APPLICATION);
            add(Usage.MOBILE_DEVELOPMENT);
            add(Usage.CLIENT_SIDE);
        }};
        typings = new ArrayList<>(){{
            add(Typing.FORTE);
        }};
        languages.add(new Language("Kotlin", Type.PROGRAMMAZIONE, typings, paradigms, usage));

        //Shell
        paradigms = new ArrayList<>(){{
            add(Paradigm.PROCEDURALE);
        }};
        usage = new ArrayList<>(){{
            add(Usage.LOW_LEVEL);
        }};
        typings = new ArrayList<>(){{
            add(Typing.NESSUNA);
        }};
        languages.add(new Language("Shell", Type.SCRIPTING, typings, paradigms, usage));

        //PowerShell
        paradigms = new ArrayList<>(){{
            add(Paradigm.PROCEDURALE);
        }};
        usage = new ArrayList<>(){{
            add(Usage.LOW_LEVEL);
        }};
        typings = new ArrayList<>(){{
            add(Typing.NESSUNA);
        }};
        languages.add(new Language("PowerShell", Type.SCRIPTING, typings, paradigms, usage));

        //Batch
        paradigms = new ArrayList<>(){{
            add(Paradigm.PROCEDURALE);
        }};
        usage = new ArrayList<>(){{
            add(Usage.LOW_LEVEL);
        }};
        typings = new ArrayList<>(){{
            add(Typing.NESSUNA);
        }};
        languages.add(new Language("Batch", Type.SCRIPTING, typings, paradigms, usage));

        Gson g = new Gson();
        String jsonLangs = g.toJson(languages);
        try {
            PrintWriter writer = new PrintWriter("langs.txt", "UTF-8");
            writer.write(jsonLangs);
            writer.close();
        } catch (Exception e){
            e.printStackTrace();
        }
        for(Language l : languages){
            System.out.println(l);
        }

        paradigms = new ArrayList<>(){{
            add(Paradigm.IMPERATIVO);
            add(Paradigm.FUNZIONALE);
            add(Paradigm.OBJECT_ORIENTED);
            add(Paradigm.PROCEDURALE);
        }};
        usage = new ArrayList<>(){{
            add(Usage.SERVER_SIDE);
            add(Usage.WEB);
        }};
        typings = new ArrayList<>(){{
            add(Typing.DEBOLE);
        }};
        Language input = new Language("PHP", Type.SCRIPTING, typings, paradigms, usage);
        ArrayList<Language> typeLang = new ArrayList<>();

        for(Language lang : languages){
            if(lang.getType().equals(input.getType())){
                typeLang.add(lang);
            }
        }

        int intersection = 0;
        Language suggested = new Language();
        HashSet<Usage> inputUsages = new HashSet<>(input.getUsages());
        HashMap<Language, Integer> map = new HashMap<>();

        for(Language lang : typeLang){
            if(lang.getName().equals(input.getName())) continue;
            HashSet<Usage> usages = new HashSet<>(lang.getUsages());
            usages.retainAll(inputUsages);
            map.put(lang, usages.size());
            if(usages.size() > intersection){
                intersection = usages.size();
                suggested = lang;
            }
        }

        System.out.println("INPUT LANG");
        System.out.println(input);

        System.out.println("MAP");
        System.out.println(map);

        System.out.println("SUGGESTED");
        System.out.println(suggested);

    }

}
