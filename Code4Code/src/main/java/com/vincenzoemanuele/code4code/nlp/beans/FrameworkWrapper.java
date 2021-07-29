package com.vincenzoemanuele.code4code.nlp.beans;

public class FrameworkWrapper {

    public FrameworkWrapper() {
    }

    public FrameworkWrapper(String language, double similarity) {
        this.language = language;
        this.similarity = similarity;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public double getSimilarity() {
        return similarity;
    }

    public void setSimilarity(double similarity) {
        this.similarity = similarity;
    }

    @Override
    public String toString() {
        return "FrameworkWrapper{" +
                "language='" + language + '\'' +
                ", similarity=" + similarity +
                '}';
    }

    private String language;
    private double similarity;

}
