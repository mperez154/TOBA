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
    
    public Account(){
        type = "";
        balance = 0.00;
    }
    
    public Account(double initBalance, String accountType, String userID){
        balance = initBalance;
        type = accountType;
        this.userID = userID;
        
    }
    
    public void credit(double deposit){
        balance = balance + deposit;        
    }
    
    public void debit(double charges)
    {
        balance = balance - charges;
    }
    
    //Setter to set the account type
    public void setType(String type) {
        this.type = type;
    }
    
    public void setBalance(double balance)
    {
        this.balance = balance;
    }
    
    
    
    
    
} 
