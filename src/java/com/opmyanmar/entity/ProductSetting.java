/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.opmyanmar.entity;

import javax.persistence.Entity;
import java.io.Serializable;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 *
 * @author Admin
 */
@Entity
public class ProductSetting implements Serializable{
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int ps_id;
    private String ps_name;
    private PsType ps_type;
    private int ps_order_no;

    public int getPs_id() {
        return ps_id;
    }

    public void setPs_id(int ps_id) {
        this.ps_id = ps_id;
    }

    public String getPs_name() {
        return ps_name;
    }

    public void setPs_name(String ps_name) {
        this.ps_name = ps_name;
    }

    public PsType getPs_type() {
        return ps_type;
    }

    public void setPs_type(PsType ps_type) {
        this.ps_type = ps_type;
    }

    public int getPs_order_no() {
        return ps_order_no;
    }

    public void setPs_order_no(int ps_order_no) {
        this.ps_order_no = ps_order_no;
    }

    @Override
    public String toString() {
        return "ProductSetting{" + "ps_id=" + ps_id + ", ps_name=" + ps_name + ", ps_type=" + ps_type + ", ps_order_no=" + ps_order_no + '}';
    }
    
    
}
