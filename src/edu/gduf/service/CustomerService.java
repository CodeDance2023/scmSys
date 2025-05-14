package edu.gduf.service;

import edu.gduf.datas.CardDatas;
import edu.gduf.datas.TransactionDatas;
import edu.gduf.entity.Card;
import edu.gduf.entity.Transaction;
import edu.gduf.entity.User;

import java.util.List;

// 卡用户功能
public class CustomerService {
    private User user;
    private TransactionDatas transactionDatas;
    private CardDatas cardDatas;

    public CustomerService(User user) {
        this.user = user;
        // 初始化transactionDatas，从文件中读取transactionDatas的数据
        // 初始化cardDatas，从文件中读取cardDatas的数据
    }
    // 查询卡信息
    public Card getCard() {return user.getCard();}
    // 充值
    public void recharge(double money){}
    // 查看消费记录
    public List<Transaction> getTransactions() {return null;}
}
