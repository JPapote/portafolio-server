/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.portafolioServer.service;

import com.portafolioServer.model.Educacion;
import java.util.List;

/**
 *
 * @author Antonio
 */
public interface IEducacion {
     public List<Educacion> getEducaion();
    
    public void savedEducacion(Educacion edu);
    
    public void deletedEducacion(Long id);
    
    public void updateEducacion(Educacion edu);
    
    public Educacion findEducacion(Long id);
}
