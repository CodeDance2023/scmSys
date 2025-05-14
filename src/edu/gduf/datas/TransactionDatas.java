package edu.gduf.datas;

import edu.gduf.entity.Transaction;

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

//    public TransactionDatas getTransactionDatas() {
        //文件读写
        //..........
//        return new TransactionDatas(transactionDatas);
//    }
}
