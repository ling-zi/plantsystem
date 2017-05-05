package com.em248.service;

import java.util.List;


import com.em248.dao.impl.PlantImpl;
import com.em248.model.Plant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PlantService {
    private PlantImpl plantimpl;

    @Autowired
    public PlantService(PlantImpl plantimpl) {
        this.plantimpl = plantimpl;
    }

    // 添加植物
    public boolean addplant(Plant plant) {
        return plantimpl.addplant(plant);
    }

    //delete by id
    public boolean deleteplant(int pid) {
        return plantimpl.deleteplantbypid(pid);
    }

    //delete by name
    public boolean deleteplant(String name) {
        return plantimpl.deleteplantbypname(name);
    }

    //update
    public boolean changeplant(Plant plant) {
        return plantimpl.updateplant(plant);
    }

    //query by id
    public Plant querybyid(int pid) {
        return plantimpl.queryplantbypid(pid);
    }

    //query by name
    public List<Plant> querybyname(String pname) {
        return plantimpl.queryplantbypname(pname);
    }

    //query all
    public List<Plant> queryallplant() {
        return plantimpl.getAllplant();
    }
}
