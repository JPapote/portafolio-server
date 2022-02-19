/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.portafolioServer.service;

import com.portafolioServer.model.Educacion;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.portafolioServer.repository.EducacionRepo;

/**
 *
 * @author Antonio
 */
@Service
public class ServiceEducacion implements IEducacion{

    @Autowired
    private EducacionRepo eduRepo;
    
    @Override
    public List<Educacion> getEducaion() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void savedEducacion(Educacion edu) {
       eduRepo.save(edu);
    }

    @Override
    public void deletedEducacion(Long id) {
        eduRepo.deleteById(id);
    }

    @Override
    public void updateEducacion(Educacion edu) {
       savedEducacion(edu);
    }

    @Override
    public Educacion findEducacion(Long id) {
        Educacion educ = eduRepo.findById(id).orElse(null);
       
       return educ;
    }
    
}
