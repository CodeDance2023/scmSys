package edu.gduf.datas;


import edu.gduf.entity.Card;

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

//    public CardDatas getCardDatas() {
        //文件读入
        //.................
//        return new CardDatas(cardDatas);
//    }
}
