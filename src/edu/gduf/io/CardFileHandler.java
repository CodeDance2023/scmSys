package edu.gduf.io;

import edu.gduf.entity.Card;
import edu.gduf.entity.User;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;

public class CardFileHandler {


    //读入数据
    public static ArrayList<Card> load() throws IOException {
        ArrayList<Card> cards = new ArrayList<>();
        File cardFilePath = new File("resource/cards.txt");
        BufferedReader cardBf = new BufferedReader(new FileReader(cardFilePath));

        //读取cards.txt里面的数据
        String line;
        while ((line = cardBf.readLine()) != null) {
            String[] s = line.split(" ");
            Card card = new Card(s[0],Double.parseDouble(s[1]),Integer.parseInt(s[2]));
            cards.add(card);
        }
        return cards;
    }




    //写出数据--追加模式
    //返回值：是否写出成功
    public static boolean writeAppend(Card card) throws IOException {
        File path = new File ("resource/cards.txt");
        BufferedWriter bw = new BufferedWriter(new FileWriter(path,true));
        String cardId = card.getCardId();
        Double balance = card.getBalance();
        Integer status = card.getStatus();
        String content = cardId + " " + balance + " " + status;
        bw.write(content);
        bw.newLine();
        bw.close();
        return true;
    }


    //写出数据--覆盖模式
    //返回值：是否写出成功
    public static boolean writeNotAppend(Card card) throws IOException {

        File path = new File ("resource/cards.txt");
        BufferedWriter bw = new BufferedWriter(new FileWriter(path));
        String cardId = card.getCardId();
        Double balance = card.getBalance();
        Integer status = card.getStatus();
        String content = cardId + " " + balance + " " + status;
        bw.write(content);
        bw.newLine();
        bw.close();
        return true;
    }


    //判断卡是否存在了
    public static boolean hasCard(Card card) throws IOException {
        //要查找的卡的卡号
        int cardIdToFind = Integer.parseInt(card.getCardId());

        ArrayList<Card> cardData = load();

        int size = cardData.size();
        Integer[] cardsInt = new Integer[size];

        //将id数组变成数字数组，方便排序和查找
        for (int i = 0; i < size; i++) {
            cardsInt[i] = Integer.parseInt(cardData.get(i).getCardId());
        }
        //排序
        Arrays.sort(cardsInt);
        //二分查找
        int left = 0;
        int right = size - 1;
        while (left <= right) {
            int mid = left + ((right - left) >> 1);
            if (cardIdToFind < cardsInt[mid]) left = mid + 1;
            else if (cardIdToFind > cardsInt[mid]) right = mid - 1;
                //找到了
            else {
                return true;
            }
        }
        return false;

    }




}
