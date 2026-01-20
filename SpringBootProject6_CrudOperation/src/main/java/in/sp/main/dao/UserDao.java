package in.sp.main.dao;




import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import in.sp.main.entity.User;

@Repository
public class UserDao {
	
	//--------------------------------------insert data----------------------------
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	public boolean  insertUser(User user) {
		
		boolean status =false;
		
		try {
		String query="insert into users(name,email,gender,city) values(?,?,?,?);";
		
		int count=jdbcTemplate.update(query, user.getName(),user.getEmail(),user.getGender(),user.getCity());
		if(count>0) {
			status= true;
		}
		else {
			status =false;
		}
		}
		catch (Exception e)
		{
			status =false;
	     System.out.println(e.getMessage());
		}
		
		return status;
	
	}
	
//-------------------------------updation--------------------------------
	
	public boolean updateUser(User user) {
		boolean status=false;
		
		try {
		String query="update `users` set name=?, gender=?, city=? where email=?";
	 int count=	jdbcTemplate.update(query, user.getName(),user.getGender(),user.getCity(),user.getEmail());
	if(count>0)
	{
		status=true;
	}
	else
	{
		status=false;
	}
	}
	catch (Exception e) {
		
		System.out.println(e.getMessage());
		status=false;
	}
		return status;
	}

	//------------------------------------delete----------------------------------
/*	
	public boolean deleteUserByEmail(String email) {
		boolean status=false;
		try {
		String query="delete from users where email=?";
		int count=jdbcTemplate.update(query, email);
		if(count>0) {
			status=true;
		}else {
			status=false;
		}
		}catch (Exception e) {
			status=false;
			System.out.println(e.getMessage());
		}
		return status;
	}
*/
	public User getUserByEmail(String email) {
		String query="select *from users where email=?";
	 return	jdbcTemplate.queryForObject(query, new UserRowMapper(),email);
		
	}
	
	public static final class UserRowMapper implements RowMapper<User>{

		@Override
		public User mapRow(ResultSet rs, int rowNum) throws SQLException {
			
			User user=new User();
			user.setName(rs.getString("name"));
			user.setEmail(rs.getString("email"));
			user.setGender(rs.getString("gender"));
			user.setCity(rs.getString("City"));
			return user;
		}
		
	}
	
	//---------------select all user------------
	
	public List<User> getAllUsers(){
		String query1="select *from users";
		return jdbcTemplate.query(query1, new UserRowMapper());
	}
}
