package edu.gduf.service;

import edu.gduf.datas.CardDatas;
import edu.gduf.entity.Card;
import edu.gduf.entity.User;

public class OperatorService {
    private User user;
    private CardDatas cardDatas;
    public OperatorService(User user) {
        this.user = user;
        // 初始化cardDatas
    }
    // 查询卡信息
    public Card operatorQueryCard(String accountNum){return null;}
    // 开卡
    public void applyCard(String accountNum){}
    // 冻结
    public void freezeCardView(String accountNum){}
    // 解冻
    public void unfreezeCardView(String accountNum){}
}
