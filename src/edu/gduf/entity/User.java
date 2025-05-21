package edu.gduf.entity;

import com.sun.xml.internal.ws.api.ha.StickyFeature;

import java.util.Objects;

// 用户
public class User {
    // 等同于学号
    private String account;
    private String password;
    private String type;    //用户类型
    private String cardId;  //消费的卡的id

    public User(String account, String password, String type, String cardId) {
        this.account = account;
        this.password = password;
        this.type = type;
        this.cardId = cardId;
    }

    public User(String account, String password, String type) {
        this.account = account;
        this.password = password;
        this.type = type;
    }

    public User(String account) {
        this.account = account;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getCardId() {
        return cardId;
    }

    public void setCardId(String card) {
        this.cardId = card;
    }

    @Override
    public String toString() {
        return "User{" +
                "account='" + account + '\'' +
                ", password='" + password + '\'' +
                ", type='" + type + '\'' +
                ", cardId=" + cardId +
                '}';
    }

    //重写equals()方法，再利用List.remove()的时候，根据账号比较
    @Override
    public boolean equals(Object obj) {
        User user = (User)obj;
        return (this.getAccount().equals(user.getAccount()));
    }
}
