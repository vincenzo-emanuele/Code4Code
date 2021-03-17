package com.example.TestGithubAuth.jsonwrappers;

import java.io.Serializable;

public class Token implements Serializable {

    public Token(String access_token, String token_type, String bearer) {
        this.access_token = access_token;
        this.token_type = token_type;
        this.bearer = bearer;
    }

    public String getAccess_token() {
        return access_token;
    }

    public void setAccess_token(String access_token) {
        this.access_token = access_token;
    }

    public String getToken_type() {
        return token_type;
    }

    public void setToken_type(String token_type) {
        this.token_type = token_type;
    }

    public String getBearer() {
        return bearer;
    }

    public void setBearer(String bearer) {
        this.bearer = bearer;
    }

    @Override
    public String toString() {
        return "Token{" +
                "access_token='" + access_token + '\'' +
                ", token_type='" + token_type + '\'' +
                ", bearer='" + bearer + '\'' +
                '}';
    }

    private String access_token;
    private String token_type;
    private String bearer;

}
