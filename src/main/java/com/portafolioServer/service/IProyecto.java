/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.portafolioServer.service;

import com.portafolioServer.model.Proyecto;
import java.util.List;

/**
 *
 * @author Antonio
 */
public interface IProyecto {
    
public List<Proyecto> getProyecto();
    
    public void savedProyecto(Proyecto proyec);
    
    public void deletedProyecto(Long id);
    
    public void updateProyecto(Proyecto proyec);
    
    public Proyecto findProyecto(Long id);
}