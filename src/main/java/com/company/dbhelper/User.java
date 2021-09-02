package com.company.dbhelper;

public enum User {

    USERNAME("alija_jeniceka"),
    PASSWORD("Juldaweva");

    private String value;

    User(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}