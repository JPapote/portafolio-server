/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.portafolioServer.service;

import com.portafolioServer.model.SobreMi;
import java.util.List;

/**
 *
 * @author Antonio
 */
public interface ISobreMi {
    public List<SobreMi> getSobreMi();
    
    public void savedSobreMi(SobreMi proyec);
    
    public void deletedSobreMi(Long id);
    
    public void updateSobreMi(SobreMi proyec);
    
    public SobreMi findSobreMi(Long id);
}
