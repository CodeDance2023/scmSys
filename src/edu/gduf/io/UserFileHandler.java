package edu.gduf.io;

import edu.gduf.datas.UserDatas;
import edu.gduf.entity.User;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class UserFileHandler {

    //读入数据
    public static ArrayList<User> load() throws IOException {
        ArrayList<User> users = new ArrayList<>();

        File path = new File("resource/users.txt");
        BufferedReader bf = new BufferedReader(new FileReader(path));
        String line;
        while ((line = bf.readLine())!= null) {
            String[] s = line.split(" ");
            User user = new User(s[0],s[1],s[2]);
            users.add(user);
        }
        return users;
    }

    public static void main(String[] args) throws IOException {
        ArrayList<User> load = UserFileHandler.load();
        for (User user : load) {
            System.out.println(user);
        }
    }
}
