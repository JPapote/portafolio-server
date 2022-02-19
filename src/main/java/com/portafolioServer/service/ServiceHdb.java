/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.portafolioServer.service;

import com.portafolioServer.model.HabilidadesDurasBlandas;
import com.portafolioServer.repository.HabilidadesDurasBlandasRepo;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Antonio
 */
@Service
public class ServiceHdb implements IHDB{

    @Autowired
    private HabilidadesDurasBlandasRepo hdbr;
    
    @Override
    public List<HabilidadesDurasBlandas> getHabilidadesDurasBlandas() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void savedHabilidadesDurasBlandas(HabilidadesDurasBlandas hdb) {
        hdbr.save(hdb);
    }

    @Override
    public void deletedHabilidadesDurasBlandas(Long id) {
       hdbr.deleteById(id);
    }

    @Override
    public void updateHabilidadesDurasBlandas(HabilidadesDurasBlandas hdb) {
        savedHabilidadesDurasBlandas(hdb);
    }

    @Override
    public HabilidadesDurasBlandas findHabilidadesDurasBlandas(Long id) {
        HabilidadesDurasBlandas hdb = hdbr.findById(id).orElse(null);
        
        return hdb;
    }
    
}
