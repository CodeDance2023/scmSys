package edu.gduf.entity;

import java.time.LocalDateTime;

// 消费记录
public class Transaction {
    // 消费的卡
    private String cardId;
    // 消费的金额
    private Double money;
    // 消费的时间
    private LocalDateTime date;
    Transaction(String cardId, Double money, LocalDateTime date) {
        this.cardId = cardId;
        this.money = money;
        this.date = date;
    }
    public String getCardId() {
        return cardId;
    }

    public Double getMoney() {
        return money;
    }

    public LocalDateTime getDate() {
        return date;
    }
}
