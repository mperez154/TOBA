package Data;

import TransferClass.Transfer;
import java.util.Iterator;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;
        
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
    public static List<Transfer> selectAllTransfers()
    {
        //Create connection using the connection pool
        EntityManager em = DBUtil.getEmFactory().createEntityManager();
        String qString = "SELECT t FROM Transfer t ";
        TypedQuery<Transfer> q = em.createQuery(qString, Transfer.class);
        
        List<Transfer> allTransfers;
        
        try
        {
            allTransfers = q.getResultList();
            if(allTransfers == null || allTransfers.isEmpty())
                allTransfers = null;
        }
        finally
        {
            em.close();
        }
        return allTransfers;
    }
}
