/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.portafolioServer.service;

import com.portafolioServer.model.SobreMi;
import com.portafolioServer.repository.SobreMiRepo;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Antonio
 */
@Service
public class ServiceSobreMi implements ISobreMi{

    @Autowired
    private SobreMiRepo sobreMi;
    
    
    @Override
    public List<SobreMi> getSobreMi() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void savedSobreMi(SobreMi proyec) {
       sobreMi.save(proyec);
    }

    @Override
    public void deletedSobreMi(Long id) {
      sobreMi.deleteById(id);
    }

    @Override
    public void updateSobreMi(SobreMi proyec) {
       savedSobreMi(proyec);
    }

    @Override
    public SobreMi findSobreMi(Long id) {
      SobreMi mi = sobreMi.findById(id).orElse(null);
      
      return mi;
    }
    
}
