package edu.gduf.io;

import edu.gduf.entity.Card;
import edu.gduf.entity.Transaction;

import java.io.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;

public class TransactionFileHandler {

    //读入数据
    public static ArrayList<Transaction> load() throws IOException {
        ArrayList<Transaction> transactions = new ArrayList<>();
        File transactionFilePath = new File("resource/transactions.txt");
        BufferedReader tranBf = new BufferedReader(new FileReader(transactionFilePath));

        //读取transactions.txt里面的数据
        String line;
        while ((line = tranBf.readLine()) != null) {
            String[] s = line.split(" ");
            double money = Double.parseDouble(s[0]);
            //将字符串的变成一个LocalDateTime对象
            DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
            String dateString = s[1] + " " + s[2];
            LocalDateTime date = LocalDateTime.parse(dateString, dateTimeFormatter);

            String cardId = s[3];

            Transaction transaction = new Transaction(money,date,cardId);
            transactions.add(transaction);
        }
        return transactions;
    }

    //写出数据--追加模式
    //返回值：是否写出成功
    public static boolean writeAppend(Transaction transaction) throws IOException {

        File path = new File ("resource/transactions.txt");
        BufferedWriter bw = new BufferedWriter(new FileWriter(path,true));
        Double money = transaction.getMoney();

        LocalDateTime dateTime = transaction.getDate();
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
        // 讲Date变成字符串的形式，存入文件
        String stringDate = dateTime.format(dateTimeFormatter);

        String cardId = transaction.getCardId();

        String content = money + " " + stringDate + " " + cardId;
        bw.write(content);
        bw.newLine();
        bw.close();
        return true;
    }

    //写出数据--覆盖模式
    //返回值：是否写出成功
    public static boolean writeNotAppend(Transaction transaction) throws IOException {

        File path = new File ("resource/transactions.txt");
        BufferedWriter bw = new BufferedWriter(new FileWriter(path));
        Double money = transaction.getMoney();

        LocalDateTime dateTime = transaction.getDate();
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
        // 讲Date变成字符串的形式，存入文件
        String stringDate = dateTime.format(dateTimeFormatter);

        String cardId = transaction.getCardId();
        String content = money + " " + stringDate + " " + cardId;
        bw.write(content);
        bw.newLine();
        bw.close();
        return true;
    }


    //判断消费信息是否存在
    public static boolean hasTransaction(Transaction transaction) throws IOException {
        ArrayList<Transaction> data = load();
        for (Transaction t : data) {
           if (t.equals(transaction)) {
               return true;
           }
           else {
               return false;
           }
        }
        return false;
    }


}
