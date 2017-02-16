package Account;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Account implements Serializable {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int accountNumber;
    private String type;    //Checking or Savings
    private double balance; //Balance
    private String userID;
    
    //No arg constructor
    public Account(){
        type = "";
        balance = 0.00;
        accountNumber = 0;
    }
    
    //Preferred constructor
    public Account(String accountType, String userID){
        balance = (int)(Math.random() * 10000) + 20;
        type = accountType;
        this.userID = userID; 
        //Generate random account number
        accountNumber = (int)(Math.random() * 100000000) + 20;
    }
    
    //Credit method
    public void credit(double deposit){
        balance = balance + deposit;        
    }
    
    //Debit method
    public void debit(double charges)
    {
        balance = balance - charges;
    }
    
    //Setter to set the account type
    public void setType(String type) {
        this.type = type;
    }
    
    //Setter to set the Balance
    public void setBalance(double balance)
    {
        this.balance = balance;
    }
    
    //Getter to get the account Type
    public String getType() {
        return type;
    }

    //Getter to get the account balance
    public double getBalance() {
        return balance;
    }  
    
    public String getUserID() {
        return userID;
    }

    public void setUserID(String userID) {
        this.userID = userID;
    }
    
    public int getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(int accountNumber) {
        this.accountNumber = accountNumber;
    }
} 
