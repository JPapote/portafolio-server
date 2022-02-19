/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.portafolioServer.service;

import com.portafolioServer.model.HabilidadesDurasBlandas;
import java.util.List;

/**
 *
 * @author Antonio
 */
public interface IHDB {
    public List<HabilidadesDurasBlandas> getHabilidadesDurasBlandas();
    
    public void savedHabilidadesDurasBlandas(HabilidadesDurasBlandas hdb);
    
    public void deletedHabilidadesDurasBlandas(Long id);
    
    public void updateHabilidadesDurasBlandas(HabilidadesDurasBlandas hdb);
    
    public HabilidadesDurasBlandas findHabilidadesDurasBlandas(Long id);
}
