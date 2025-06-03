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
    public static UserDatas getUserDatas() throws IOException {
        //文件读入
        ArrayList<User> usersLoaded = UserFileHandler.load();
        return new UserDatas(usersLoaded);
    }

    //添加用户
    public boolean addUser(User user) throws IOException {
        if (UserFileHandler.hasUser(user)) {
            return false;
        }
        return UserFileHandler.writeAppend(user);

    }

    //修改用户
    public boolean updateUser(User user) throws IOException {
        boolean ret = UserFileHandler.hasUser(user);
        //如果用户不存在，不允许修改
        if (!ret) {
            return false;
        }
        else {
            //加载所有数据
            ArrayList<User> userDatas = UserFileHandler.load();
            //删除要修改的用户
            userDatas.remove(user);
            //添加新的用户
            userDatas.add(user);

            //覆盖旧的文件内容
            //第一次对象的写入利用覆盖模式，把文件覆盖
            UserFileHandler.writeNotAppend(userDatas.get(0));
            //第二次开始利用追加模式,追加剩余的内容
            for (int i = 1; i < userDatas.size(); i++) {
                UserFileHandler.writeAppend(userDatas.get(i));
            }
            return true;
        }

    }

    //根据account删除用户
    public boolean deleteUser(String account) throws IOException {
        boolean hasUser = UserFileHandler.hasUser(new User(account));
        if (!hasUser) {
            return false;
        }
        else {
            ArrayList<User> userDatas = UserFileHandler.load();
            User user = new User(account);
            //删除特定account的user
            userDatas.remove(user);
            //重写写回数据
            //第一次对象的写入利用覆盖模式，把文件覆盖
            UserFileHandler.writeNotAppend(userDatas.get(0));
            //第二次开始利用追加模式,追加剩余的内容
            for (int i = 1; i < userDatas.size(); i++) {
                UserFileHandler.writeAppend(userDatas.get(i));
            }
            return true;
        }
    }


    //查找一个用户信息
    public User findUser(String account) throws IOException {
        //加载全部数据
        ArrayList<User> userDatas = UserFileHandler.load();
        for (User userData : userDatas) {
            if (userData.getAccount().equals(account)) {
                return userData;
            }
        }
        return null;
    }
}