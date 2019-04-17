/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Models;

import java.util.Date;

/**
 *
 * @author nicolaenastas
 */
public class Expenses {
    private int iD;
    private Date date;
    private int amount;
    private String methodPayment;
    private String comments;

    public Expenses() {
    }

    public Expenses(int iD, Date date, int amount, String methodPayment, String comments) {
        this.iD = iD;
        this.date = date;
        this.amount = amount;
        this.methodPayment = methodPayment;
        this.comments = comments;
    }
        public Expenses(Date date, int amount, String methodPayment, String comments) {
        this.date = date;
        this.amount = amount;
        this.methodPayment = methodPayment;
        this.comments = comments;
    }

    public int getiD() {
        return iD;
    }

    public void setiD(int iD) {
        this.iD = iD;
    }

    
    
    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    
    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public String getMethodPayment() {
        return methodPayment;
    }

    public void setMethodPayment(String methodPayment) {
        this.methodPayment = methodPayment;
    }

    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }
    
    
    
}
