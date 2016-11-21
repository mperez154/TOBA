package Data;

import Account.Account;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.NoResultException;
import javax.persistence.TypedQuery;

public class AccountDB {
    
    public static void insert(Account account)
    {
        //Create connection using the connection pool
        EntityManager em = DBUtil.getEmFactory().createEntityManager();
        EntityTransaction trans = em.getTransaction();
        trans.begin();
        
        try
        {
            em.persist(account);
            trans.commit();
        }
        catch(Exception e)
        {
            System.out.println(e);
            trans.rollback();
        }
        finally
        {
            em.close();
        }
    }
    
    public static Account selectAccount(String userID)
    {
        //Create connection using the connection pool
        EntityManager em = DBUtil.getEmFactory().createEntityManager();
        String qString = "SELECT a FROM Account a " +
                        "WHERE a.userID = :userID";
        TypedQuery<Account> q = em.createQuery(qString, Account.class);
        q.setParameter("userID", userID);
        
        try
        {
            Account user = q.getSingleResult();
            return user;
        }
        catch(NoResultException e)
        {
            return null;
        }
        finally
        {
            em.close();
        }
    }
    
}
