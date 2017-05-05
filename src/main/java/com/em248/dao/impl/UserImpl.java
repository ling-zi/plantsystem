package com.em248.dao.impl;

import com.em248.dao.InUser;
import com.em248.model.User;
import com.em248.utils.JDBCTools;
import org.springframework.stereotype.Repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Repository
public class UserImpl implements InUser {

    @Override
    //实现添加用户
    public boolean adduser(User user) {
        Connection conn = null;
        PreparedStatement ps = null;
        String sql = "INSERT INTO user(uname,uemail,upassword,uimageurl,ustatus,"
                + "ucellphone,usexy,uaddress)VALUES(?,?,?,?,?,?,?,?)";

        try {
            conn = JDBCTools.getConnection();
            ps = conn.prepareStatement(sql);
            ps.setString(1, user.getUname());
            ps.setString(2, user.getUemail());
            ps.setString(3, user.getUpassword());
            ps.setString(4, user.getUimageurl());
            ps.setInt(5, user.getUstatus());
            ps.setString(6, user.getUcellphone());
            ps.setString(7, user.getUsexy());
            ps.setString(8, user.getUaddress());
            int i = ps.executeUpdate();
            if (i == 0) {
                return false;
            }
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JDBCTools.releaseDB(conn, ps, null);
        }
        return false;

    }

    // 更新用户信息
    @Override
    public boolean updateuser(User user) {
        Connection conn = null;
        PreparedStatement ps = null;
        String sql = "UPDATE user SET uname =?,uemail=?,upassword=?,uimageurl=?,"
                + "ustatus=?,ucellphone=?,usexy=?,uaddress=? WHERE uid = ?";

        try {
            conn = JDBCTools.getConnection();
            ps = conn.prepareStatement(sql);
            ps.setString(1, user.getUname());
            ps.setString(2, user.getUemail());
            ps.setString(3, user.getUpassword());
            ps.setString(4, user.getUimageurl());
            ps.setInt(5, user.getUstatus());
            ps.setString(6, user.getUcellphone());
            ps.setString(7, user.getUsexy());
            ps.setString(8, user.getUaddress());
            ps.setInt(9, user.getUid());
            int i = ps.executeUpdate();
            if (i == 0) {
                return false;
            }
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JDBCTools.releaseDB(conn, ps, null);
        }
        return false;
    }

    //实现通过id删除用户
    @Override
    public boolean deleteuser(int uid) {
        Connection conn = null;
        PreparedStatement ps = null;
        String sql = "DELETE from user WHERE uid =?";
        try {
            conn = JDBCTools.getConnection();
            ps = conn.prepareStatement(sql);
            ps.setInt(1, uid);
            int i = ps.executeUpdate();
            if (i == 0) {
                return false;
            }
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JDBCTools.releaseDB(conn, ps, null);
        }
        return false;
    }

    //实现通过id和密码查询用户
    //实则用邮箱登录
    @Override
    public User getuserbynameandpwd(String uname, String upassword) {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        User user1 = null;
        String sql = "SELECT * from user where uemail =? AND upassword = ?";
        try {
            conn = JDBCTools.getConnection();
            ps = conn.prepareStatement(sql);
            ps.setString(1, uname);
            ps.setString(2, upassword);
            rs = ps.executeQuery();
            user1 = null;
            while (rs.next()) {
                user1 = new User(rs.getInt("uid"), rs.getInt("ustatus"), rs.getString("uname"),
                        rs.getString("uemail"), rs.getString("upassword"), rs.getString("uimageurl"),
                        rs.getString("ucellphone"), rs.getString("usexy"), rs.getString("uaddress"));
                return user1;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JDBCTools.releaseDB(conn, ps, null);
        }
        return null;

    }

    //实现查询所有用户信息
    @Override
    public List<User> getAll() {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        User user1 = null;
        String sql = "SELECT * from user";
        List<User> users = new ArrayList<>();
        try {
            conn = JDBCTools.getConnection();
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();
            user1 = null;
            while (rs.next()) {
                user1 = new User(rs.getInt("uid"), rs.getInt("ustatus"), rs.getString("uname"),
                        rs.getString("uemail"), rs.getString("upassword"), rs.getString("uimageurl"),
                        rs.getString("ucellphone"), rs.getString("usexy"), rs.getString("uaddress"));
                users.add(user1);
            }
            if (users != null) {
                return users;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JDBCTools.releaseDB(conn, ps, null);
        }
        return null;

    }

    @Override
    public List<User> getUserbyname(String uname) {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        User user = null;
        String sql = "SELECT * from user where uname = ?";
        List<User> users = new ArrayList<>();
        try {
            conn = JDBCTools.getConnection();
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();
            user = null;
            while (rs.next()) {
                user = new User(rs.getInt("uid"), rs.getInt("ustatus"), rs.getString("uname"),
                        rs.getString("uemail"), rs.getString("upassword"), rs.getString("uimageurl"),
                        rs.getString("ucellphone"), rs.getString("usexy"), rs.getString("uaddress"));
                users.add(user);
            }
            if (users != null) {
                return users;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JDBCTools.releaseDB(conn, ps, null);
        }
        return null;

    }

}
