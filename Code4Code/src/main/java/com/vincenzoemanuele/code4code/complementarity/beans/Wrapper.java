package com.vincenzoemanuele.code4code.complementarity.beans;

import java.util.ArrayList;

public class Wrapper {

    public Wrapper() {
        this.rules = new ArrayList<>();
        this.linguaggi = new ArrayList<>();
    }

    public Wrapper(ArrayList<String> linguaggi, double support, ArrayList<Rule> rules) {
        this.linguaggi = linguaggi;
        this.support = support;
        this.rules = rules;
    }

    public ArrayList<String> getLinguaggi() {
        return linguaggi;
    }

    public void setLinguaggi(ArrayList<String> linguaggi) {
        this.linguaggi = linguaggi;
    }

    public double getSupport() {
        return support;
    }

    public void setSupport(double support) {
        this.support = support;
    }

    public ArrayList<Rule> getRules() {
        return rules;
    }

    public void setRules(ArrayList<Rule> rules) {
        this.rules = rules;
    }

    public void addRule(Rule r){
        this.rules.add(r);
    }

    @Override
    public String toString() {
        return "Wrapper{" +
                "linguaggi=" + linguaggi +
                ", support=" + support +
                ", rules=" + rules +
                '}';
    }

    private ArrayList<String> linguaggi;
    private double support;
    private ArrayList<Rule> rules;

}
