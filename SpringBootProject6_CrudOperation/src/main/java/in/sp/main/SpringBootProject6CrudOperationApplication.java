package in.sp.main;



import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import in.sp.main.dao.UserDao;
import in.sp.main.entity.User;

@SpringBootApplication
public class SpringBootProject6CrudOperationApplication implements  CommandLineRunner {
	
	@Autowired
	private UserDao userDao;
	

	public static void main(String[] args) {
		SpringApplication.run(SpringBootProject6CrudOperationApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
/*		  // data Insertion
	
		User user1=new User("nitesh", "nitesh@gmail.com", "male", "khandwa");
		
		User user2=new User("bhavini","bhavini@gmail.com","female","khandwa");
		
		User user3 =new User("bhanu","bhan@gmail.com","male","khalwa");
		
		boolean status=userDao.insertUser(user3);
		if(status)
		{
			System.out.println("User Insert Sucessfully");
		}else 
		{
			System.out.println("User not Inserted due to some error");
		}
	*/	
		
	//----------------update----------------------------------------------
/*		User user=new User("nitesh", "nitesh@gmail.com", "male","singot");
		boolean status=userDao.updateUser(user);
		if(status) {
		System.out.println("update sucessfully");	
		}
		else {
			System.out.println("updation failed");
		}
*/		
		//-------------Delete User-------------------------
	/*	boolean status=userDao.deleteUserByEmail("nitesh@gmail.com");
		if(status) {
			System.out.println("delete User");
		}else {
			System.out.println("deletion faild");
		} */
		
		//---------------select one user Data------------------
/*		User user=userDao.getUserByEmail("bhavini@gmail.com");
		System.out.println("Nama :"+user.getName());
		System.out.println("Email :"+user.getEmail());
		System.out.println("Gender  :"+user.getGender());
		System.out.println("City :"+user.getCity());
	*/	
		//------------select All User-------------------------
	   List<User> list=userDao.getAllUsers();
		
		for(User user:list) {
			System.out.println("Nama :"+user.getName());
			System.out.println("Email :"+user.getEmail());
			System.out.println("Gender  :"+user.getGender());
			System.out.println("City :"+user.getCity());
             System.out.println("---------------------------------------------");
		}
	}

}
