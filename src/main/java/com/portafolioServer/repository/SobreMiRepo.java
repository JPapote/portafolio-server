/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.portafolioServer.repository;

import com.portafolioServer.model.SobreMi;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author Antonio
 */
public interface SobreMiRepo extends JpaRepository <SobreMi, Long>{
    
}