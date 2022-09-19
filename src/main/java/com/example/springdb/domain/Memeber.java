package com.example.springdb.domain;

import lombok.Data;

@Data
public class Memeber {

    private String memberId;
    private int money;

    public Memeber(){}

    public Memeber(String memberId, int money) {
        this.memberId = memberId;
        this.money = money;
    }
}
