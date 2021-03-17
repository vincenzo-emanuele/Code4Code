package com.example.TestGithubAuth.jsonwrappers;

import java.util.Arrays;

public class Question {

    public Question(Item[] items) {
        this.items = items;
    }

    public Item[] getItems() {
        return items;
    }

    public void setItems(Item[] items) {
        this.items = items;
    }

    @Override
    public String toString() {
        return "Question{" +
                "items=" + Arrays.toString(items) +
                '}';
    }

    private Item items[];

}
