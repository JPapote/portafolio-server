/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.portafolioServer.service;

import com.portafolioServer.model.Experiencia;
import com.portafolioServer.repository.ExperienciaRepo;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Antonio
 */
@Service
public class ServiceExperiencia implements IExperiencia{

    @Autowired
    private ExperienciaRepo experiencia;
            
    @Override
    public List<Experiencia> getExperiencia() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void savedExperiencia(Experiencia exp) {
       experiencia.save(exp);
    }

    @Override
    public void deletedExperiencia(Long id) {
        experiencia.deleteById(id);
    }

    @Override
    public void updateExperiencia(Experiencia exp) {
        savedExperiencia(exp);
    }

    @Override
    public Experiencia findExperiencia(Long id) {
        Experiencia ex = experiencia.findById(id).orElse(null);
        
        return ex;
    }
    
}
