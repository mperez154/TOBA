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
    
     public static void update(Account account)
    {
        //Create connection using the connection pool
        EntityManager em = DBUtil.getEmFactory().createEntityManager();
        EntityTransaction trans = em.getTransaction();
        trans.begin();
        
        try
        {
            em.merge(account);
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
     
     public static Account selectChecking(String userID, String checking)
    {
        //Create connection using the connection pool
        EntityManager em = DBUtil.getEmFactory().createEntityManager();
        String qString = "SELECT a FROM Account a " +
                        "WHERE a.userID = :userID " +
                        "AND a.type = :checking";
        TypedQuery<Account> q = em.createQuery(qString, Account.class);
        q.setParameter("userID", userID);
        q.setParameter("checking", checking);
         
        try
        {
            Account account = q.getSingleResult();
            return account;
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
     
    public static Account selectSavings(String userID, String savings)
    {
        //Create connection using the connection pool
        EntityManager em = DBUtil.getEmFactory().createEntityManager();
        String qString = "SELECT a FROM Account a " +
                        "WHERE a.userID = :userID " +
                        "AND a.type = :savings";
        TypedQuery<Account> q = em.createQuery(qString, Account.class);
        q.setParameter("userID", userID);
        q.setParameter("savings", savings);
         
        try
        {
            Account account = q.getSingleResult();
            return account;
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
