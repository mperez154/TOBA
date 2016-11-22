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
    private String type;    //Checking or Savings
    private double balance; //Balance
    private String userID;
    
    //No arg constructor
    public Account(){
        type = "";
        balance = 0.00;
    }
    
    //Preferred constructor
    public Account(double initBalance, String accountType, String userID){
        balance = initBalance;
        type = accountType;
        this.userID = userID;      
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
} 
