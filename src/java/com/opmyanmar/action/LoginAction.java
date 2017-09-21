/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.opmyanmar.action;

import com.opensymphony.xwork2.ActionSupport;
import com.opmyanmar.entity.LoginUsers;
import com.opmyanmar.service.UserDaoImpl;

/**
 *
 * @author Admin
 */
public class LoginAction extends ActionSupport {
    private String email;
    private String password;
    private UserDaoImpl dao = new UserDaoImpl();

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    
    public String execute() throws Exception {
        LoginUsers user = dao.getUser(email);
        if (user != null) {
            if (user.getPassword().equals(password)) {
                System.out.println("Login success");
                return SUCCESS;
            } else { return LOGIN;}
        } else {
                System.out.println("Login Error");
            return ERROR;
        }
    }
    
}
