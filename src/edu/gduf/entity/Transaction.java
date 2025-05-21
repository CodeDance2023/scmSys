package edu.gduf.entity;

import java.time.LocalDateTime;
import java.util.Objects;

// 消费记录
public class Transaction {

    // 消费的金额
    private Double money;
    // 消费的时间
    private LocalDateTime date;
    //消费的卡的id
    private String cardId;

    public Transaction(Double money, LocalDateTime date, String cardId) {
        this.money = money;
        this.date = date;
        this.cardId = cardId;
    }

    public Double getMoney() {
        return money;
    }

    public void setMoney(Double money) {
        this.money = money;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }

    public String getCardId() {
        return cardId;
    }

    public void setCardId(String cardId) {
        this.cardId = cardId;
    }

    @Override
    public String toString() {
        return "Transaction{" +
                "money=" + money +
                ", date=" + date +
                ", cardId='" + cardId + '\'' +
                '}';
    }

    @Override
    //根据三个属性是否相等来比较两个对象是否相等
    public boolean equals(Object o) {
        Transaction transaction = (Transaction) o;
        int ret  = this.getDate().compareTo(transaction.getDate());
        int ret_ = this.getMoney().compareTo(((Transaction) o).getMoney());
        if (ret == 0) {
            if (this.getCardId().equals(transaction.getCardId())) {
                if (ret_ == 0) {
                    return true;
                }
                else{
                    return false;
                }
            }
            else {
                return false;
            }
        }
        else {
            return false;
        }
    }


}
