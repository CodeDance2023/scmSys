package edu.gduf.service;

import edu.gduf.datas.UserDatas;
import edu.gduf.entity.User;

public class ManagerService {
    private User user;
    private UserDatas userDatas;
    public ManagerService(User user) {
        this.user = user;
        // 初始化userDatas
    }
    // 创建新用户
    public void createUser(String accountNum){}
    // 删除用户
    public void deleteUser(String accountNum){}
    // 查询用户
    public User queryUser(String accountNum){return null;}
}
