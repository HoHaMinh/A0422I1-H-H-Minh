package com.practice.phone_management.controller;

import com.practice.phone_management.model.SmartPhone;
import com.practice.phone_management.service.ISmartphoneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class HomeController {
    @Autowired
    private ISmartphoneService smartphoneService;

    @PostMapping("")
    public ResponseEntity<SmartPhone> createSmartphone(@RequestBody SmartPhone smartphone) {
        return new ResponseEntity<>(smartphoneService.save(smartphone), HttpStatus.CREATED);
    }

    @GetMapping("/list")
    public ModelAndView getAllSmartphonePage() {
        ModelAndView modelAndView = new ModelAndView("list");
        modelAndView.addObject("smartphones", smartphoneService.findAll());
        return modelAndView;
    }

    @GetMapping("")
    public ResponseEntity<List<SmartPhone>> getAllSmartphone() {
        return new ResponseEntity<>(smartphoneService.findAll(), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<SmartPhone> deleteSmartphone(@PathVariable Long id) {
        SmartPhone smartphoneOptional = smartphoneService.findById(id);
        if (smartphoneOptional == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        smartphoneService.remove(id);
        return new ResponseEntity<>(smartphoneOptional, HttpStatus.NO_CONTENT);
    }

    @PutMapping("/{id}")
    public ResponseEntity<SmartPhone> editSmartphone(@PathVariable Long id, @RequestBody SmartPhone smartphone) {
        SmartPhone smartPhone1 = smartphoneService.findById(id);
        if (smartPhone1 == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        smartphone.setId(smartPhone1.getId());
        return new ResponseEntity<>(smartphoneService.save(smartphone), HttpStatus.OK);
    }
}
