/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.opmyanmar.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author Admin
 */
@Entity
@Table (name = "users")
public class LoginUsers implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    
    private String email;
    private String password;
    private String type;
    private String status;
    private String description;
    
//    @OneToMany(cascade=CascadeType.ALL, fetch = FetchType.EAGER)
//    @JoinColumn(name = "id", referencedColumnName = "custs_id")
//    private List<Products> productList = new ArrayList<>();

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

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

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

//    public List<Products> getProductList() {
//        return productList;
//    }
//
//    public void setProductList(List<Products> productList) {
//        this.productList = productList;
//    }

    @Override
    public String toString() {
        return "LoginUsers{" + "id=" + id + ", email=" + email + ", password=" + password + ", type=" + type + ", status=" + status + ", description=" + description + '}';
    }

    
    

}
