// incomplite by some errore
package in.sp.main;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
//import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


import in.sp.main.entities.User;

@SpringBootApplication
public class SpringBootProjectHibernateCrudApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootProjectHibernateCrudApplication.class, args);
		
		Configuration cfg=new Configuration();
		
		cfg.configure("/in/sp/main/config/hibernate.xml");
		
		SessionFactory sessionFactory = cfg.buildSessionFactory();
		Session session=sessionFactory.openSession();
		
	//	Transaction transaction =session.beginTransaction();
		
		User user = session.get(User.class, 1L);
		System.out.println(user.getName());
		System.out.println(user.getEmail());
		
	}

}
