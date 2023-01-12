package com.practice.phone_management.service;

import com.practice.phone_management.model.SmartPhone;

import java.util.List;

public interface ISmartphoneService {
    List<SmartPhone> findAll();
    SmartPhone findById (Long id);
    SmartPhone save (SmartPhone smartPhone);
    void remove (Long id);
}
