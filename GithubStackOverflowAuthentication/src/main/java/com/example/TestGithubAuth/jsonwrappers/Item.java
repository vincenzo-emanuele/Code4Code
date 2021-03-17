package com.example.TestGithubAuth.jsonwrappers;

import java.util.Arrays;

public class Item {

    public Item(String[] tags) {
        this.tags = tags;
    }

    public String[] getTags() {
        return tags;
    }

    public void setTags(String[] tags) {
        this.tags = tags;
    }

    @Override
    public String toString() {
        return "Item{" +
                "tags=" + Arrays.toString(tags) +
                '}';
    }

    private String tags[];

}
