package dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dao.InPlants;
import domain.Plant;
import domain.User;
import utils.JDBCTools;

public class PlantImpl implements InPlants{
	//实现查询植物（通过名称）
	@Override
	public List<Plant> queryplantbypname(String pname) {

		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		// 创建一个list用于接收查询出来的数据
		List<Plant> ls = new ArrayList<>();
		String sql = "select * from plant where pname =?";
		try {
			conn = JDBCTools.getConnection();
			ps = conn.prepareStatement(sql);
			ps.setString(1, pname);
			rs = ps.executeQuery();
			Plant plant = null;
			while (rs.next()) {
				// 获取书的字段值
				plant = new Plant(rs.getInt("pid"), rs.getString("pname"), 
						rs.getString("pphotos"), rs.getString("pdesc"),
						rs.getString("pfamily"), rs.getString("pgenus"),rs.getString("phylum"));
				// 将记录存入list
				ls.add(plant);
				
			}
			// 返回list
			return ls;

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTools.releaseDB(conn, ps, rs);
		}
		return null;
	
	}
	//实现通过id查询植物
	@Override
	public Plant queryplantbypid(int pid) {

		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		String sql = "select * from plant where pid =?";
		try {
			conn = JDBCTools.getConnection();
			ps = conn.prepareStatement(sql);
			ps.setInt(1, pid);
			rs = ps.executeQuery();
			Plant plant = null;
			while (rs.next()) {
				// 获取对象的字段值
				plant = new Plant(rs.getInt("pid"), rs.getString("pname"), 
						rs.getString("pphotos"), rs.getString("pdesc"),
						rs.getString("pfamily"), rs.getString("pgenus"),rs.getString("phylum"));
			}
			// 返回list
			return plant;

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTools.releaseDB(conn, ps, rs);
		}
		return null;
	
	}
	//删除植物（通过id）
	@Override
	public boolean deleteplantbypid(int pid) {
		Connection conn = null;
		PreparedStatement ps = null;
		String sql = "DELETE FROM plant WHERE pid = ?";
		int i =0;
	
		try {
			conn = JDBCTools.getConnection();
			ps = conn.prepareStatement(sql);
			//先设置，再执行
			ps.setInt(1, pid);
			i = ps.executeUpdate();
			if(i==0){
				return false;
			}
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			JDBCTools.releaseDB(conn, ps, null);
		}
		return false;
	}
	//删除植物通过名字
	@Override
	public boolean deleteplantbypname(String pname) {
		Connection conn = null;
		PreparedStatement ps = null;
		String sql = "DELETE FROM plant WHERE pname = ?";
		int i =0;
	
		try {
			conn = JDBCTools.getConnection();
			ps = conn.prepareStatement(sql);
			ps.setString(1, pname);
			i = ps.executeUpdate();
			if(i==0){
				//如果executeupdate执行成功，会返回1，失败返回0
				return false;
			}
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			JDBCTools.releaseDB(conn, ps, null);
		}
		return false;
	}
	//添加植物
	@Override
	public boolean addplant(Plant plant) {
		Connection conn = null;
		PreparedStatement ps = null;
		String sql = " INSERT INTO plant(pname,pphotos,pdesc,pfamily,pgenus,phylum) VALUES(?,?,?,?,?,?);";
		try {
			conn = JDBCTools.getConnection();
			ps = conn.prepareStatement(sql);
			ps.setString(1, plant.getPname());
			ps.setString(2, plant.getPphotos());
			ps.setString(3, plant.getPdesc());
			ps.setString(4, plant.getPfamily());
			ps.setString(5,plant.getPgenus());
			ps.setString(6,plant.getPhylum());
			int i = ps.executeUpdate();
			if(i==0){
				return false;
			}
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			JDBCTools.releaseDB(conn, ps, null);
		}
		return false;
	}
	//修改植物信息
	@Override
	public boolean updateplant(Plant plant) {
		Connection conn = null;
		PreparedStatement ps = null;
		String sql = "update plant set pname=?,pphotos=?,pdesc=?,pfamily=?,pgenus=?,phylum=? where pid=?";
		
		try {
			conn = JDBCTools.getConnection();
			ps = conn.prepareStatement(sql);
			ps.setString(1, plant.getPname());
			ps.setString(2, plant.getPphotos());
			ps.setString(3, plant.getPdesc());
			ps.setString(4, plant.getPfamily());
			ps.setString(5,plant.getPgenus());
			ps.setString(6,plant.getPhylum());
			ps.setInt(7, plant.getPid());
			int i = ps.executeUpdate();
			if(i==0){
				return false;
			}
			return true;
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		finally {
			JDBCTools.releaseDB(conn, ps, null);
		}
		return false;
	
	}
	//实现查询所有植物信息
	@Override
	public List<Plant> getAllplant() {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		Plant plant = null;
		String sql = "SELECT * from plant";
		List<Plant> plants = new ArrayList<>();
		try {
			conn = JDBCTools.getConnection();
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			plant = null;
			while (rs.next()) {
				plant = new Plant(rs.getInt("pid"), rs.getString("pname"), 
						rs.getString("pphotos"),rs.getString("pdesc"), rs.getString("pfamily"), 
						rs.getString("pgenus"),rs.getString("getPhylum"));
				plants.add(plant);
			}
			if (plants != null) {
				return plants;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTools.releaseDB(conn, ps, null);
		}
		return null;
	
	}

}
