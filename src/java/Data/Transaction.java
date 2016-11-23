package Data;

import Account.Account;
import java.io.Serializable;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Transaction implements Serializable {
    
    @OneToMany(fetch=FetchType.EAGER, cascade=CascadeType.ALL)
    private Account account;
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int transactionNum;
    
    public Transaction()
    {
        
    }
}
