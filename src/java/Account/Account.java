package Account;

import User.User;

public class Account {
    private String type;    //Checking or Savings
    private double balance; //Balance
    private User user;      //To maintain a reference to the user class? 
    
    public Account(){
        type = "";
        balance = 0.00;
    }
    
    public Account(User user, double initBalance){
        balance = initBalance;
        
    }
    
    public void credit(double deposit){
        balance = balance + deposit;        
    }
    
    public void debit(double charges)
    {
        balance = balance - charges;
    }
    
    
    
    
    
    
} 
