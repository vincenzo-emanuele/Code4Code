package com.vincenzoemanuele.code4code.complementarity.beans;

public class RepoLang {

    public RepoLang() {
    }

    public RepoLang(String language, double percentage) {
        this.language = language;
        this.percentage = percentage;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public double getPercentage() {
        return percentage;
    }

    public void setPercentage(double percentage) {
        this.percentage = percentage;
    }

    @Override
    public String toString() {
        return "RepoLang{" +
                "language='" + language + '\'' +
                ", percentage=" + percentage +
                '}';
    }

    private String language;
    private double percentage;

}
