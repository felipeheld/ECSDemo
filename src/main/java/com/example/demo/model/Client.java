package com.example.demo.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;

@Entity
public class Client extends BaseClient {

    @JacksonXmlElementWrapper(localName = "accounts")
    @JacksonXmlProperty(localName = "account")
    @JsonProperty("acc")
    @OneToMany(cascade = CascadeType.ALL)
    private List<Account> accountList;

    public Client() {
        this.accountList = new ArrayList<Account>();
    }

    public void addAccount(Account acc) {
        this.accountList.add(acc);
    }

    public List<Account> getAccountList() {
        return this.accountList;
    }
}