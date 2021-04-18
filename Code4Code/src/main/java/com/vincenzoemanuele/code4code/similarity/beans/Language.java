package com.vincenzoemanuele.code4code.similarity.beans;

import java.util.ArrayList;

public class Language {

    public Language() {
    }

    public Language(String name, Type type, ArrayList<Paradigm> paradigms, ArrayList<Usage> usages) {
        this.name = name;
        this.type = type;
        this.paradigms = paradigms;
        this.usages = usages;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }

    public ArrayList<Paradigm> getParadigms() {
        return paradigms;
    }

    public void setParadigms(ArrayList<Paradigm> paradigms) {
        this.paradigms = paradigms;
    }

    public ArrayList<Usage> getUsages() {
        return usages;
    }

    public void setUsages(ArrayList<Usage> usages) {
        this.usages = usages;
    }

    @Override
    public String toString() {
        return "Language{" +
                "name='" + name + '\'' +
                ", type=" + type +
                ", paradigms=" + paradigms +
                ", usages=" + usages +
                '}';
    }

    private String name;
    private Type type;
    private ArrayList<Paradigm> paradigms;
    private ArrayList<Usage> usages;

}
