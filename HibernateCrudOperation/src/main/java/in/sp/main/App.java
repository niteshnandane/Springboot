package in.sp.main;

import java.nio.channels.SelectableChannel;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import in.sp.entities.User;




/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
    	 User user1 =new User();
    //	 user1.setId(1);
    	 user1.setName("ankit");
    	 user1.setEmail("ankit@gmail.com");
    	 user1.setPassword("ankitl123");
    	 user1.setGender("male");
         user1.setCity("khandwa");
        
    	
      Configuration cfg=new Configuration();
      
      cfg.configure("/in/sp/config/hibernate.cfg.xml");
      
     SessionFactory  sessionFactory=cfg.buildSessionFactory();
      Session session=sessionFactory.openSession();
      Transaction transaction=session.beginTransaction();

   /*  
 //-------------------insertion-----------------------------------     
   try {
      session.save(user1);
      transaction.commit();
      System.out.println("User details Insert Successfully");
   }catch (Exception e) {
	
	   transaction.rollback();
	   e.printStackTrace();
	   System.out.println("dua to some error");
} 

 */
      
// ----------------Select Operation----------------------------- 
    /*  
      try {
    	  User user2=session.get(User.class, 4L);
    	  
    	  if(user2!=null) {
    	
    	  System.out.println(user2.getId());
    	  System.out.println(user2.getName());
    	  System.out.println(user2.getEmail());
    	  System.out.println(user2.getPassword());
    	  System.out.println(user2.getGender());
    	  System.out.println(user2.getCity());
    	  }
    	  else {
    		  System.out.println("user not found");
    	  }
      }catch (Exception e) {
		e.printStackTrace();
	}
      
      */
      
      //-------------update------------------------
 /*    
      User user3 =session.get(User.class, 1L);
  
      user3.setCity("mumbai");
      
      try {
          session.saveOrUpdate(user3);
          transaction.commit();
          System.out.println("User details Updated Successfully");
       }catch (Exception e) {
    	
    	   transaction.rollback();
    	   e.printStackTrace();
    	   System.out.println("dua to some error");
    }
    
   */
      
//-----------------delete---------------------------------
      
      User user4 =new User();
      user4.setId(6L);
      
      user4.setCity("mumbai");
      
      try {
          session.delete(user4);
          transaction.commit();
          System.out.println("User details Delete Successfully");
       }catch (Exception e) {
    	
    	   transaction.rollback();
    	   e.printStackTrace();
    	   System.out.println("dua to some error");
    }
    

    }
}
