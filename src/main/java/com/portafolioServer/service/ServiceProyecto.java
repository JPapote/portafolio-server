/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.portafolioServer.service;

import com.portafolioServer.model.Proyecto;
import com.portafolioServer.repository.ProyectoRepo;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Antonio
 */
@Service
public class ServiceProyecto implements IProyecto{

    
    @Autowired
    private ProyectoRepo proyecto;
    
    @Override
    public List<Proyecto> getProyecto() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void savedProyecto(Proyecto proyec) {
        proyecto.save(proyec);
    }

    @Override
    public void deletedProyecto(Long id) {
      proyecto.deleteById(id);
    }

    @Override
    public void updateProyecto(Proyecto proyec) {
       savedProyecto(proyec);
    }

    @Override
    public Proyecto findProyecto(Long id) {
       Proyecto pro = proyecto.findById(id).orElse(null);
       
       return pro;
    }
    
}
