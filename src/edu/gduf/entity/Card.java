package edu.gduf.entity;

// 校园卡
public class Card {
    // 等同于用户账号
    private String cardId;
    // 余额
    private Double money;

    Card(String cardId, Double money) {
        this.cardId = cardId;
        this.money = money;
    }
    public String getCardId() {
        return cardId;
    }
    public Double getMoney() {
        return money;
    }
}
