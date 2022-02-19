/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.portafolioServer.service;

import com.portafolioServer.model.Experiencia;
import java.util.List;

/**
 *
 * @author Antonio
 */
public interface IExperiencia {
     public List<Experiencia> getExperiencia();
    
    public void savedExperiencia(Experiencia exp);
    
    public void deletedExperiencia(Long id);
    
    public void updateExperiencia(Experiencia exp);
    
    public Experiencia findExperiencia(Long id);
}
