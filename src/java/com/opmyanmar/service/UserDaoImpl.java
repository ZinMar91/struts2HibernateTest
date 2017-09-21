/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.opmyanmar.service;

import com.opmyanmar.entity.LoginUsers;
import com.opmyanmar.util.HibernateUtil;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author Admin
 */
public class UserDaoImpl {

    private Transaction tx = null;
    private Session session = null;

    public boolean save(LoginUsers user, int update_flag) {
        try {
            session = HibernateUtil.getSession();
            tx = session.beginTransaction();
            if(update_flag==1) {session.update(user);System.out.println("Update flag is true");}
            else session.persist(user);
            tx.commit();
            return true;
        } catch (Exception e) {
            if (tx != null) {
                tx.rollback();
                e.printStackTrace();
            }
        } finally {
            session.close();
        }
        return false;
    }

    public boolean delete(int id) {
        try {
            session = HibernateUtil.getSession();
            tx = session.beginTransaction();
            LoginUsers user = (LoginUsers) session.get(LoginUsers.class, id);
            session.delete(user);
            tx.commit();
            return true;
        } catch (Exception e) {
            if (tx != null) {
                tx.rollback();
            }
            e.printStackTrace();
        } finally {
            session.close();
        }
        return false;
    }

    public LoginUsers getUser(String email) {
        LoginUsers user = null;
        try {
            session = HibernateUtil.getSession();
            tx = session.beginTransaction();
            SQLQuery q = session.createSQLQuery("select * from users u where u.email= :email");
            q.addEntity(LoginUsers.class);
            q.setParameter("email", email);
            user = (LoginUsers) q.uniqueResult();
            System.out.println("User >>>>> " + user.toString());
        } catch (Exception e) {
            if (tx != null) {
                tx.rollback();
            }
            e.printStackTrace();
        } finally {
            session.close();
        }
        return user;
    }

    public LoginUsers getUserDetail(int id) {
        LoginUsers user = null;
        try {
            session = HibernateUtil.getSession();
            tx = session.beginTransaction();
            user = (LoginUsers) session.get(LoginUsers.class, id);
            tx.commit();
            System.out.println("User >>>>> " + user.toString());
        } catch (Exception e) {
            if (tx != null) {
                tx.rollback();
            }
            e.printStackTrace();
        } finally {
            session.close();
        }
        return user;
    }

    public List<LoginUsers> retrieveUsers() {
        List<LoginUsers> userList = null;
        try {
            session = HibernateUtil.getSession();
            tx = session.beginTransaction();
            Query q = session.createQuery("from LoginUsers u");
            userList = q.list();
            for (LoginUsers u : userList) {
                System.out.println("User >>> " + u.toString());
            }
            tx.commit();
        } catch (Exception e) {
            if (tx != null) {
                tx.rollback();
            }
            e.printStackTrace();
        } finally {
            session.close();
        }
        return userList;
    }
}
