package com.vincenzoemanuele.code4code.complementarity.beans;

import java.util.ArrayList;

public class Repo {

    public Repo() {
    }

    public Repo(ArrayList<String> langs, double totalCode, ArrayList<RepoLang> repoLangs) {
        this.langs = langs;
        this.totalCode = totalCode;
        this.repoLangs = repoLangs;
    }

    public ArrayList<String> getLangs() {
        return langs;
    }

    public void setLangs(ArrayList<String> langs) {
        this.langs = langs;
    }

    public double getTotalCode() {
        return totalCode;
    }

    public void setTotalCode(double totalCode) {
        this.totalCode = totalCode;
    }

    public ArrayList<RepoLang> getRepoLangs() {
        return repoLangs;
    }

    public void setRepoLangs(ArrayList<RepoLang> repoLangs) {
        this.repoLangs = repoLangs;
    }

    public void addLang(String lang){
        langs.add(lang);
    }

    public void addTotalCode(double codeAmount){
        totalCode += codeAmount;
    }

    @Override
    public String toString() {
        return "Repo{" +
                "langs=" + langs +
                ", totalCode=" + totalCode +
                ", repoLangs=" + repoLangs +
                '}';
    }

    private ArrayList<String> langs = new ArrayList<>();
    private double totalCode;
    private ArrayList<RepoLang> repoLangs;

}
