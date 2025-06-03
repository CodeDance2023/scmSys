package edu.gduf.io;

import edu.gduf.datas.UserDatas;
import edu.gduf.entity.Card;
import edu.gduf.entity.User;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;

public class UserFileHandler {

    //读入数据
    public static ArrayList<User> load() throws IOException {
        ArrayList<User> users = new ArrayList<>();

        File userFilePath = new File("resource/users.txt");

        BufferedReader userBf = new BufferedReader(new FileReader(userFilePath));

        //读取user.txt文件里面的数据
        String line;
        while ((line = userBf.readLine())!= null) {
            String[] s = line.split(" ");
            User user = new User(s[0],s[1],s[2],s[3]);
            users.add(user);
        }
        return users;
    }


    //写出数据--追加模式
    //返回值：是否写出成功
    public static boolean writeAppend(User user) throws IOException {
        File path = new File ("resource/users.txt");
        BufferedWriter bw = new BufferedWriter(new FileWriter(path,true));  //打开追加模式开关
        String account = user.getAccount();
        String password = user.getPassword();
        String type = user.getType();
        String cardId = user.getCardId();
        String content = account + " " + password + " " + type + " " + cardId;
        bw.write(content);
        bw.newLine();
        bw.close();
        return true;
    }

    //写出数据--覆盖模式
    //返回值：是否写出成功
    public static boolean writeNotAppend(User user) throws IOException {
        File path = new File ("resource/users.txt");
        BufferedWriter bw = new BufferedWriter(new FileWriter(path));
        String account = user.getAccount();
        String password = user.getPassword();
        String type = user.getType();
        String cardId = user.getCardId();
        String content = account + " " + password + " " + type + " " + cardId;
        bw.write(content);
        bw.newLine();
        bw.close();
        return true;
    }



    //判断用户是否存在了
    public static boolean hasUser(User user) throws IOException {
        //要查找的用户的账号
        int userAccountToFind = Integer.parseInt(user.getAccount());

        ArrayList<User> userData = load();
        int size = userData.size();
        Integer[] accountsInt = new Integer[size];
        //将id变成数字
        for (int i = 0; i < size; i++) {
            accountsInt[i] = Integer.parseInt(userData.get(i).getAccount());
        }
        //排序
        Arrays.sort(accountsInt);
        //二分查找
        int left = 0;
        int right = size - 1;
        while (left <= right) {
            int mid = left + ((right - left) >> 1);
            if (userAccountToFind < accountsInt[mid]) left = mid + 1;
            else if (userAccountToFind > accountsInt[mid]) right = mid - 1;
            //找到了
            else {
                return true;
            }
        }
        return false;

    }



}
