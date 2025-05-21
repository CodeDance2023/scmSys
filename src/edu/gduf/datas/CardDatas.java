package edu.gduf.datas;


import edu.gduf.entity.Card;
import edu.gduf.entity.User;
import edu.gduf.io.CardFileHandler;
import edu.gduf.io.UserFileHandler;

import java.io.IOException;
import java.util.ArrayList;

public class CardDatas {

   ArrayList<Card> cards;

    public CardDatas(ArrayList<Card> cards) {
        this.cards = cards;
    }

    public ArrayList<Card> getCards() {
        return cards;
    }

    public void setCards(ArrayList<Card> cards) {
        this.cards = cards;
    }


    //获取所有卡信息
    public static CardDatas getCardDatas() throws IOException {
        ArrayList<Card> cardLoaded = CardFileHandler.load();
        return new CardDatas(cardLoaded);
    }

    //增加一张卡
    public boolean addCard(Card card) throws IOException {
      return CardFileHandler.writeAppend(card);
    }


    //根据cardId删除卡
    public boolean deleteCard(String cardId) throws IOException {
        boolean hasCard = CardFileHandler.hasCard(new Card(cardId));
        //如果卡不存在
        if (!hasCard) {
            return false;
        }
        else {
            ArrayList<Card> cardDatas = CardFileHandler.load();
            Card card = new Card(cardId);
            //删除特定account的user
           cardDatas.remove(card);
            //重写写回数据
            //第一次对象的写入利用覆盖模式，把文件覆盖
           CardFileHandler.writeNotAppend(cardDatas.get(0));
            //第二次开始利用追加模式,追加剩余的内容
            for (int i = 1; i < cardDatas.size(); i++) {
                CardFileHandler.writeAppend(cardDatas.get(i));
            }
            return true;
        }
    }

    //修改一张卡

    public boolean updateCard(Card card) throws IOException {
        boolean ret = CardFileHandler.hasCard(card);
        if (!ret) {
            return false;
        }

        else {
            //加载所有数据
            ArrayList<Card> cardDatas = CardFileHandler.load();
            //删除要修改的用户
           cardDatas.remove(card);
            //添加新的用户
           cardDatas.add(card);

            //覆盖旧的文件内容
            //第一次对象的写入利用覆盖模式，把文件覆盖
           CardFileHandler.writeNotAppend(cardDatas.get(0));
            //第二次开始利用追加模式,追加剩余的内容
            for (int i = 1; i < cardDatas.size(); i++) {
                CardFileHandler.writeAppend(cardDatas.get(i));
            }
            return true;
        }

    }
    //查找一张卡
    public static Card find(String cardId) throws IOException {
        //加载全部数据
        ArrayList<Card> cardData = CardFileHandler.load();
        for (Card card : cardData) {
            if (cardId.equals(card.getCardId())) {
                return card;
            }
        }
        return null;
    }
}
