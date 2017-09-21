/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.opmyanmar.action;

import com.opmyanmar.entity.Categories;
import com.opmyanmar.entity.LoginUsers;
import com.opmyanmar.entity.ProductSetting;
import com.opmyanmar.entity.Products;
import com.opmyanmar.entity.PsType;
import com.opmyanmar.util.HibernateUtil;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author Admin
 */
public class InitialSaveData {
    public String saveData() {
        
        Categories c = new Categories();
        c.setC_name("cloths");
        
        ProductSetting pSetting1 = new ProductSetting();
        pSetting1.setPs_name("size");
        pSetting1.setPs_type(PsType.num);
        pSetting1.setPs_order_no(1);
        ProductSetting pSetting2 = new ProductSetting();
        pSetting2.setPs_name("color");
        pSetting2.setPs_type(PsType.text);
        pSetting2.setPs_order_no(2);
        List<ProductSetting> psList = new ArrayList<>();
        psList.add(pSetting1);
        psList.add(pSetting2);
        
        Products p1 = new Products();        
        p1.setCategory(c);
        p1.setP_code("11111");
        p1.setP_name("Man shirt");
        p1.setP_price(8500);
        p1.setP_Settings(psList);
        
        Products p2 = new Products();        
        p2.setCategory(c);
        p2.setP_code("22222");
        p2.setP_name("Baby dress");
        p2.setP_price(7000);
        p2.setP_Settings(psList);
        
        List<Products> pList = new ArrayList<>();
        pList.add(p1);
        pList.add(p2);
        
        
        LoginUsers user = new LoginUsers();
        user.setEmail("zin@gmail.com");
        user.setPassword("11111");
        user.setType("admin");
        user.setStatus("active");
        user.setDescription("dlsdfsdlkfsdl ls lflsd ff");
        
//        Transaction tx = null;
//        Session session = null;
          Session session = HibernateUtil.getSession();
            Transaction tx = session.beginTransaction();
            session.save(c);
            session.save(user);
//            session.persist(pSetting1);
//            session.persist(pSetting2);
//            session.save(p1);
//            session.save(p2);
//            session.save(user);
            tx.commit();
            return "success";
        
//        try {
//        } catch(Exception e) {
//            if (tx != null)
//                tx.rollback();
//            e.printStackTrace();
//            return "error";
//        } finally {
////            session.close();
//        }
    }
}
