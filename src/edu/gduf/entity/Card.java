package edu.gduf.entity;

import java.util.Objects;

// 校园卡
public class Card {

    // 等同于用户账号
    private String cardId;
    // 余额
    private Double balance;
    //状态
    private Integer status;

    public Card(String cardId) {
        this.cardId = cardId;
        this.balance = 0.0;
        this.status = 1;
    }

    public Card(String cardId, Double balance,Integer status) {
        this.cardId = cardId;
        this.balance = balance;
        this.status = status;
    }

    public String getCardId() {
        return cardId;
    }

    public void setCardId(String cardId) {
        this.cardId = cardId;
    }

    public Double getBalance() {
        return balance;
    }

    public void setBalance(Double balance) {
        this.balance = balance;
    }


    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Card{" +
                "cardId='" + cardId + '\'' +
                ", balance=" + balance +
                ", status=" + status +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        Card card = (Card)o;
        return card.getCardId().equals(this.getCardId());
    }


}
