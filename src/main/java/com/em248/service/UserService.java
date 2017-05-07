package com.em248.service;

import com.em248.dao.impl.UserImpl;
import com.em248.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by tian on 2017/5/4.
 */
@Service
public class UserService {

    private UserImpl userimpl;

    @Autowired
    public UserService(UserImpl userimpl) {
        this.userimpl = userimpl;
    }

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
    //query by id
    public User querybyid(int uid){
        return userimpl.getUserbyid(uid);
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
