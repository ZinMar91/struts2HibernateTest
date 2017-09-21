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
import javax.persistence.OneToOne;

/**
 *
 * @author Admin
 */
@Entity
public class Products implements Serializable{
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)    
    private int p_id;
    private String p_code;
    private String p_name;
    private double p_price;
    
    @OneToOne
    private Categories category;
    
    private String p_description;
    
    @OneToMany(cascade=CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "p_id", referencedColumnName = "p_id")
    private List<ProductSetting> p_Settings = new ArrayList<>();

    public int getP_id() {
        return p_id;
    }

    public void setP_id(int p_id) {
        this.p_id = p_id;
    }

    public String getP_code() {
        return p_code;
    }

    public void setP_code(String p_code) {
        this.p_code = p_code;
    }

    public String getP_name() {
        return p_name;
    }

    public void setP_name(String p_name) {
        this.p_name = p_name;
    }

    public double getP_price() {
        return p_price;
    }

    public void setP_price(double p_price) {
        this.p_price = p_price;
    }

    public Categories getCategory() {
        return category;
    }

    public void setCategory(Categories category) {
        this.category = category;
    }

    public String getP_description() {
        return p_description;
    }

    public void setP_description(String p_description) {
        this.p_description = p_description;
    }

    public List<ProductSetting> getP_Settings() {
        return p_Settings;
    }

    public void setP_Settings(List<ProductSetting> p_Settings) {
        this.p_Settings = p_Settings;
    }

    @Override
    public String toString() {
        return "Products{" + "p_id=" + p_id + ", p_code=" + p_code + ", p_name=" + p_name + ", p_price=" + p_price + ", category=" + category + ", p_description=" + p_description + ", p_Settings=" + "-> psetting" + '}';
    }
    
    
}
