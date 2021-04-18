package com.vincenzoemanuele.code4code.complementarity.beans;

import java.util.ArrayList;

public class Rule {

    public Rule() {
        this.pred = new ArrayList<>();
        this.succ = new ArrayList<>();
    }

    public Rule(ArrayList<String> pred, ArrayList<String> succ, double confidence) {
        this.pred = pred;
        this.succ = succ;
        this.confidence = confidence;
    }

    public ArrayList<String> getPred() {
        return pred;
    }

    public void setPred(ArrayList<String> pred) {
        this.pred = pred;
    }

    public ArrayList<String> getSucc() {
        return succ;
    }

    public void setSucc(ArrayList<String> succ) {
        this.succ = succ;
    }

    public double getConfidence() {
        return confidence;
    }

    public void setConfidence(double confidence) {
        this.confidence = confidence;
    }

    @Override
    public String toString() {
        return "Rule{" +
                "pred=" + pred +
                ", succ=" + succ +
                ", confidence=" + confidence +
                '}';
    }

    private ArrayList<String> pred;
    private ArrayList<String> succ;
    private double confidence;

}
