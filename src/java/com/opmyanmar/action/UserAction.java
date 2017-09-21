/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.opmyanmar.action;

import com.opensymphony.xwork2.ActionSupport;
import com.opmyanmar.entity.LoginUsers;
import com.opmyanmar.entity.Products;
import com.opmyanmar.service.UserDaoImpl;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Admin
 */
public class UserAction extends ActionSupport {

    private UserDaoImpl userDao = new UserDaoImpl();
    private LoginUsers user;
    private List<String> type = new ArrayList<>();
    private List<String> status = new ArrayList<>();
    List<LoginUsers> userList = new ArrayList<>();
    private int id=0;
    private int update_flag = 0;

    public int getUpdate_flag() {
        return update_flag;
    }

    public void setUpdate_flag(int update_flag) {
        this.update_flag = update_flag;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    
    public LoginUsers getUser() {
        return user;
    }

    public void setUser(LoginUsers user) {
        this.user = user;
    }

    public UserDaoImpl getUserDao() {
        return userDao;
    }

    public void setUserDao(UserDaoImpl userDao) {
        this.userDao = userDao;
    }

    public List<String> getType() {
        return type;
    }

    public void setType(List<String> type) {
        this.type = type;
    }

    public List<String> getStatus() {
        return status;
    }

    public void setStatus(List<String> status) {
        this.status = status;
    }

    public List<LoginUsers> getUserList() {
        return userList;
    }

    public void setUserList(List<LoginUsers> userList) {
        this.userList = userList;
    }

    public String goToForm() {
        System.out.println("In form method");
        type.add("admin");
        type.add("user");
        status.add("ative");
        status.add("noactive");
        return "success";
    }

    public String save() {
        if (userDao.save(user, update_flag)) {
            userList = userDao.retrieveUsers();
            return SUCCESS;
        }
        return ERROR;
    }

    public String retrieveUsers() throws Exception {
        userList = userDao.retrieveUsers();
        System.out.println("in user action");
        return SUCCESS;
    }

    public String deleteUser() throws Exception {
        System.out.println("Delete id :" + String.valueOf(id));
        userDao.delete(id);
        userList = userDao.retrieveUsers();
        return SUCCESS;
    }

    public String getUserDetail() throws Exception {
        System.out.println("User id :" + String.valueOf(id));
        update_flag = 1;
        user = userDao.getUserDetail(id);
        return SUCCESS;
    }

}
