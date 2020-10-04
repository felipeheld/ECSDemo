package com.example.demo.model;

public enum AccountType {

    PERSONAL("Personal account"),
    BUSINESS("Business account");

    private final String value;

    private AccountType(String value) {
        this.value = value;
    }

    public String getValue() {
        return this.value;
    }
}