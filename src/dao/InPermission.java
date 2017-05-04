package dao;

import java.util.List;

import domain.Permission;

public interface InPermission {
	// 添加权限
	boolean addPermission(Permission pms);
	// 删除权限
	boolean deletePermission(Permission pms);
	// 修改权限
	boolean updatePermission(Permission pms);
	// 查询权限(通过名字)
	Permission queryPermission(String pmsname);
	// 按照ID查询
	Permission queryPermission(int pmsid);
	// 查询全部
	public List<Permission> getAllPermission();
	// 查询多条分页
	// 查询多条分页
}
