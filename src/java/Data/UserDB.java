package Data;

import User.User;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.NoResultException;
import javax.persistence.TypedQuery;

public class UserDB 
{
    public static void insert(User users)
    {
        //Create connection using the connection pool
        EntityManager em = DBUtil.getEmFactory().createEntityManager();
        EntityTransaction trans = em.getTransaction();
        trans.begin();
        
        try
        {
            em.persist(users);
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
    
    public static void update(User users)
    {
        //Create connection using the connection pool
        EntityManager em = DBUtil.getEmFactory().createEntityManager();
        EntityTransaction trans = em.getTransaction();
        trans.begin();
        
        try
        {
            em.merge(users);
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
    
    public static void delete(User users)
    {
        //Create connection using the connection pool
        EntityManager em = DBUtil.getEmFactory().createEntityManager();
        EntityTransaction trans = em.getTransaction();
        trans.begin();
        
        try
        {
            em.remove(users);
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
    
    public static User selectUser(String email)
    {
        //Create connection using the connection pool
        EntityManager em = DBUtil.getEmFactory().createEntityManager();
        String qString = "SELECT u FROM User u " +
                        "WHERE u.email = :email";
        TypedQuery<User> q = em.createQuery(qString, User.class);
        q.setParameter("email", email);
        
        try
        {
            User user = q.getSingleResult();
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
    
    public static User selectUsers(String userName)
    {
        //Create connection using the connection pool
        EntityManager em = DBUtil.getEmFactory().createEntityManager();
        String qString = "SELECT u FROM User u " +
                        "WHERE u.userName = :userName";
        TypedQuery<User> q = em.createQuery(qString, User.class);
        q.setParameter("userName", userName);
        
        try
        {
            User user = q.getSingleResult();
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
    
    public static List<User> selectAllUsers()
    {
        //Create connection using the connection pool
        EntityManager em = DBUtil.getEmFactory().createEntityManager();
        String qString = "SELECT u FROM User u ";
        TypedQuery<User> q = em.createQuery(qString, User.class);
        
        List<User> allUsers;
        
        try
        {
            allUsers = q.getResultList();
            if(allUsers == null || allUsers.isEmpty())
                allUsers = null;
        }
        finally
        {
            em.close();
        }
        return allUsers;
    }
    
    public static boolean emailExists(String email){
        User u = selectUser(email);
        return u != null;
    }
    
    public static boolean userExists(String user){
        User u = selectUsers(user);
        return u != null;
    }   
}
    
        
        
    

