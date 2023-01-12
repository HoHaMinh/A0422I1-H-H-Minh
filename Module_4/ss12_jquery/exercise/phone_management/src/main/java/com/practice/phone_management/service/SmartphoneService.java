package com.practice.phone_management.service;

import com.practice.phone_management.model.SmartPhone;
import com.practice.phone_management.repository.ISmartphoneRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SmartphoneService implements ISmartphoneService{
    @Autowired
    private ISmartphoneRepository smartphoneRepository;

    @Override
    public List<SmartPhone> findAll() {
        return (List<SmartPhone>) smartphoneRepository.findAll();
    }

    @Override
    public SmartPhone findById(Long id) {
        return (SmartPhone) smartphoneRepository.findById(id).orElse(null);
    }

    @Override
    public SmartPhone save(SmartPhone smartPhone) {
        smartphoneRepository.save(smartPhone);
        return smartPhone;
    }

    @Override
    public void remove(Long id) {
        smartphoneRepository.deleteById(id);
    }
}
