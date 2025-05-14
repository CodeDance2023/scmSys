package edu.gduf.datas;

import edu.gduf.entity.User;
import edu.gduf.io.UserFileHandler;

import java.io.IOException;
import java.util.ArrayList;

public class UserDatas {
    ArrayList<User> users;

    public UserDatas(ArrayList<User> users) {
        this.users = users;
    }

    public ArrayList<User> getUsers() {
        return users;
    }

    public void setUsers(ArrayList<User> users) {
        this.users = users;
    }

    //获取全部用户数据
    public UserDatas getUserDatas() throws IOException {
        //文件读入
        ArrayList<User> userLoaded = UserFileHandler.load();
        return new UserDatas(userLoaded);
    }

//    //添加用户数据
//    public Boolean addUser(User user) {
//        ;
//    }
//    //修改用户数据
//    public Boolean updateUser(User user) {
//        ;
//    }
//    //删除用户数据
//    public Boolean deleteUser(String account) {
//        ;
//    }
//    //查找用户数据
//    public Boolean findUser(String account) {
//        ;
//    }
}
