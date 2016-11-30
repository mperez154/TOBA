package Data;

import TransferClass.Transfer;
import java.util.Iterator;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
        
public class TransferDB {
    
     public static void insert(Transfer transfer)
    {
        //Create connection using the connection pool
        EntityManager em = DBUtil.getEmFactory().createEntityManager();
        EntityTransaction trans = em.getTransaction();
        trans.begin();
        
        try
        {
            em.persist(transfer);
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
    
    public static void update(Transfer transfer)
    {
        //Create connection using the connection pool
        EntityManager em = DBUtil.getEmFactory().createEntityManager();
        EntityTransaction trans = em.getTransaction();
        trans.begin();
        
        try
        {
            em.merge(transfer);
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
    
    public static void delete(Transfer transfer)
    {
        //Create connection using the connection pool
        EntityManager em = DBUtil.getEmFactory().createEntityManager();
        EntityTransaction trans = em.getTransaction();
        trans.begin();
        
        try
        {
            em.remove(transfer);
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
    
    public static List<Transfer> selectAllTransactions(String userName)
    {
        EntityManager em = DBUtil.getEmFactory().createEntityManager();
        List<Transfer> transferObject = (List<Transfer>)em.createQuery("SELECT c from Transfer c").getResultList();
        System.out.println("List of all transfers:");
        Iterator i = transferObject.iterator();
        Transfer test2;
        while(i.hasNext())
        {
            test2 = (Transfer) i.next();
            System.out.print(test2.getAmount() + "\t\t");
            System.out.print(test2.getFrom() + "\t\t");
            System.out.print(test2.getToAccount() + "\t\t");
            System.out.println(test2.getUser().getUserName());   
        }
        return transferObject;
    }    
}
