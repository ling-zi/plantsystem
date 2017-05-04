package utils;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

import javax.sql.rowset.JdbcRowSet;

import jdk.internal.dynalink.beans.StaticClass;

//这是一个JDBC工具类，里面包含了连接数据库，释放连接，查询信息等功能。
public class JDBCTools {
	//把需要成员变量定义在这里。
	static String driver = null;
	static String url = null;
	static String user = null;
	static String password = null;
	// 在静态代码段中不能访问非静态变量
	static {
		// 创建properties对象用以读取外部配置信息
		Properties property = new Properties();
	
		try {
			
			// 通过类的加载器读取文件流，也可用file文件流
			InputStream in = JDBCTools.class.getClassLoader().getResourceAsStream("jdbc.properties");

			property.load(in);
			// properties里数据时以Key-V对的形式存放，通过getproperty（）去取值，如果取不到，就默认用第二个
			driver = property.getProperty("driver", "com.mysql.jdbc.Driver");
			url = property.getProperty("url");// 没有写默认值了
			user = property.getProperty("user");
			password = property.getProperty("password");
			// 用Class（反射）将driver类加载一下
			Class.forName(driver);

		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	// 获取链接
	public static Connection getConnection() {
		if (url == null || user == null)
			return null;
		try {
			return DriverManager.getConnection(url, user, password);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	// 释放连接
	public static void releaseDB(Connection conn, Statement stat, ResultSet rs) {
		try {
			if (conn != null) {
				conn.close();
			}
			if (stat != null) {
				stat.close();
			}
			if (rs != null) {
				rs.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	// 查询信息
	public static ResultSet myexcutequery(String sql) {
		//首先，判断参数为不为空
		if (sql == null || sql.length() == 0 || sql.equals(""))
			return null;
		Connection conn = null;
		Statement stat = null;
		try {
			// 1.获取连接
			conn = JDBCTools.getConnection();
			// 2.创建Statement对象
			stat = conn.createStatement();
			//3.执行sql语句，返回的是一个resultset集合
			ResultSet rs = stat.executeQuery(sql);
			//4.将结果返回
			if(rs!=null){
				return rs;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		//如果rs为空，就返回null
		return null;
	}
}
