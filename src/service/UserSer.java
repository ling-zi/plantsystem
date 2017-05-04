package service;

import java.util.List;

import dao.impl.UserImpl;
import domain.User;

public class UserSer {
	
	UserImpl userimpl = new UserImpl();
	//add new user
	public boolean register(User user){
		return userimpl.adduser(user);
	}
	//delete user
	public boolean deleteUser(int uid){
		return userimpl.deleteuser(uid);
	}
	//change user information
	public boolean changeUser(User user){
		return userimpl.updateuser(user);
	}
	//query by name
	public List<User> querybyname(String uname){
		return userimpl.getUserbyname(uname);
	}
	//query by name&password
	public User login(String uname,String upassword){
		return userimpl.getuserbynameandpwd(uname, upassword);
	}
	//query all user
	public List<User> queryalluser(){
		return userimpl.getAll();
	}
}
