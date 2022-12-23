package com.practice.customer_manager.service;

import com.practice.customer_manager.model.Province;

import java.util.List;

public interface IProvinceService {
    public List<Province> findAll();
    public Province findById(Integer id);
    public void save(Province province);
    public void remove(Integer id);

}
