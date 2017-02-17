/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TransferClass;

import User.User;
import java.io.Serializable;
import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 *
 * @author Marco
 */
@Entity
public class Transfer implements Serializable {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)   
    private int transactionID;
    private int date;
    private String fromAccount;
    private String toAccount;
    private Double amount; 
    private User userAccount;

    public Transfer(){
       fromAccount = "";
       toAccount = "";
       amount = 0.00;
       this.transactionID = (int)(Math.random() * 1000000000);
    }
    
    public Transfer(String from, String to, Double amount, User user)
    {
        this.fromAccount = from;
        this.toAccount = to;
        this.amount = amount;
        this.userAccount = user;
        this.transactionID = (int)(Math.random() * 1000000000);
    }
    
    //ALL SETTERS AND GETTERS BELOW
    
    public String getFrom() {
        return fromAccount;
    }

    public void setFrom(String from) {
        this.fromAccount = from;
    }

    public String getToAccount() {
        return toAccount;
    }

    public void setToAccount(String to) {
        this.toAccount = to;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }
    
    public User getUser() {
        return userAccount;
    }

    public void setUser(User user) {
        this.userAccount = user;
    }
    
      public int getTransactionID() {
        return transactionID;
    }

    public void setTransactionID(int transactionID) {
        this.transactionID = transactionID;
    }

    public String getFromAccount() {
        return fromAccount;
    }

    public void setFromAccount(String fromAccount) {
        this.fromAccount = fromAccount;
    }

    public User getUserAccount() {
        return userAccount;
    }

    public void setUserAccount(User userAccount) {
        this.userAccount = userAccount;
    }
     public int getDate() {
        return date;
    }

    public void setDate(int date) {
        this.date = date;
    }
}
