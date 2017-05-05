package com.em248.dao;

import com.em248.model.Plant;

import java.util.List;


public interface InPlants {
		//查询植物(通过植物名称)
		List<Plant> queryplantbypname(String pname);
		//查询植物(通过植物id)
		Plant queryplantbypid(int pid);
		//删除植物(通过植物id)
		boolean deleteplantbypid(int pid);
		//删除植物(通过名称)
		boolean deleteplantbypname(String pname);
		//添加植物
		boolean addplant(Plant plant);
		//修改植物信息
		boolean updateplant(Plant plant);
		//查询所有植物
		List<Plant> getAllplant();
}
