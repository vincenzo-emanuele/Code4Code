package com.example.TestGithubAuth.jsonwrappers;

public class RepoWrapper {

    public RepoWrapper(long id, String full_name) {
        this.id = id;
        this.full_name = full_name;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getFull_name() {
        return full_name;
    }

    public void setFull_name(String full_name) {
        this.full_name = full_name;
    }

    @Override
    public String toString() {
        return "RepoWrapper{" +
                "id=" + id +
                ", name='" + full_name + '\'' +
                '}';
    }

    private long id;
    private String full_name;

}
