/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.portafolioServer.repository;

import com.portafolioServer.model.Educacion;
import com.portafolioServer.model.Experiencia;
import com.portafolioServer.model.HabilidadesDurasBlandas;
import com.portafolioServer.model.Proyecto;
import com.portafolioServer.model.SobreMi;
import com.portafolioServer.model.Usuario;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;


/**
 *
 * @author Antonio
 */
public interface Repository extends JpaRepository <Usuario, Long>{
    public Usuario findByPassword(String password);

}
