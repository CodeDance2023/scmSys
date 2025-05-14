package edu.gduf.entity;

// 用户
public class User {
    // 等同于学号
    private String account;
    private String password;
    private String type;    //用户类型
    private Card card;

    public User(String account, String password, String type) {
        this.account = account;
        this.password = password;
        this.type = type;
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

    public Card getCard() {
        return card;
    }

    public void setCard(Card card) {
        this.card = card;
    }

    @Override
    public String toString() {
        return "User{" +
                "account='" + account + '\'' +
                ", password='" + password + '\'' +
                ", type='" + type + '\'' +
                ", card=" + card +
                '}';
    }
}
