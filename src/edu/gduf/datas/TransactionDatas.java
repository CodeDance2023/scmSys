package edu.gduf.datas;

import edu.gduf.entity.Card;
import edu.gduf.entity.Transaction;
import edu.gduf.io.CardFileHandler;
import edu.gduf.io.TransactionFileHandler;

import java.io.IOException;
import java.util.ArrayList;

public class TransactionDatas {

    ArrayList<Transaction> transactions;

    public TransactionDatas(ArrayList<Transaction> transactions) {
        this.transactions = transactions;
    }

    public ArrayList<Transaction> getTransactions() {
        return transactions;
    }

    public void setTransactions(ArrayList<Transaction> transactions) {
        this.transactions = transactions;
    }

    //查找所有交易
    public static TransactionDatas getTransactionDatas() throws IOException {
        ArrayList<Transaction> transactionLoaded = TransactionFileHandler.load();
        return new TransactionDatas(transactionLoaded);
    }

    //添加一条交易
    public boolean addTransaction(Transaction transaction) throws IOException {
        return TransactionFileHandler.writeAppend(transaction);
    }

    //删除一条交易
    public boolean deleteTransaction(Transaction transaction) throws IOException {
        boolean hasTransaction = TransactionFileHandler.hasTransaction(transaction);
        //如果交易存在
        if (!hasTransaction) {
            return false;
        }
        else {
            ArrayList<Transaction> transactionDatas = TransactionFileHandler.load();
            //删除特定的交易
            transactionDatas.remove(transaction);  //重写了equals方法
            //重写写回数据
            //第一次对象的写入利用覆盖模式，把文件覆盖
            TransactionFileHandler.writeNotAppend(transactionDatas.get(0));
            //第二次开始利用追加模式,追加剩余的内容
            for (int i = 1; i < transactionDatas.size(); i++) {
                TransactionFileHandler.writeAppend(transactionDatas.get(i));
            }
            return true;
        }
    }

    // 缺少标识每一条信息的主键，无法实现，也没有必要！！！

//    //修改一条交易
//
//    public boolean updateTransaction(Transaction transaction) throws IOException {
//        boolean ret = TransactionFileHandler.hasTransaction(transaction);
//        if (!ret) {
//            return false;
//        }
//
//        else {
//            //加载所有数据
//            ArrayList<Transaction> transactionDatas = TransactionFileHandler.load();
//            //删除要修改的交易
//            transactionDatas.remove(transaction);
//            //添加新的交易
//            transactionDatas.add(transaction);
//
//            //覆盖旧的文件内容
//            //第一次对象的写入利用覆盖模式，把文件覆盖
//            TransactionFileHandler.writeNotAppend(transactionDatas.get(0));
//            //第二次开始利用追加模式,追加剩余的内容
//            for (int i = 1; i < transactionDatas.size(); i++) {
//                TransactionFileHandler.writeAppend(transactionDatas.get(i));
//            }
//            return true;
//        }
//
//    }

    //查找一张卡的所有交易
//    返回值为null说明不存在这张卡

    public static ArrayList<Transaction> find(String cardId) throws IOException {
        boolean hasCard = false;  //是否存在这张卡的标志
        ArrayList<Transaction> transactions = new ArrayList<>();
        //加载所有数据
        ArrayList<Transaction> tranData = TransactionFileHandler.load();

        for (Transaction tran : tranData) {
            //将cardId的交易全部存入
            if (tran.getCardId().equals(cardId)) {
                hasCard = true;  //存在这张卡
                transactions.add(tran);
            }
        }
        if (hasCard) {
            return transactions;
        }
        else {
            return null;
        }

    }

}
