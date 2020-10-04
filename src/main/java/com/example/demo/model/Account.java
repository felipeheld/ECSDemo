package com.example.demo.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

@Entity
public class Account {
    
    @Id
    @SequenceGenerator(name = "accountSeqGen", sequenceName = "accountSeq")
    @GeneratedValue(generator = "accountSeqGen")
    private Long accountNumber;
    private Long balance;
    private AccountType type;

    public Long getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(Long number) {
        this.accountNumber = number;
    }

    public long getBalance() {
        return this.balance;
    }

    public void setBalance(long balance) {
        this.balance = balance;
    }

    public AccountType getType() {
        return this.type;
    }

    public void setType(AccountType type) {
        this.type = type;
    }
}