package com.example.oumayma_lahmer_mesure_glycmie.model;

public class User {
private String name ;
private String pwd;

    public User(String name, String pwd) {
        this.name = name;
        this.pwd = pwd;
    }
    public String getName() {
        return name;
    }
    public String getPwd() {
        return pwd;
    }

}
