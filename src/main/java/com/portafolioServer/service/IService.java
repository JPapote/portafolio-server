/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.portafolioServer.service;

import com.portafolioServer.model.Usuario;
import java.util.List;

/**
 *
 * @author Antonio
 */
public interface IService {
     public List<Usuario> getUsuario();
    
    public void savedUsuario(Usuario user);
    
    public void deletedUsuario(Long id);
    
    public void updateUsuario( Usuario user);
    
    public Usuario findByPassword(String password);
    
    public Usuario findUsuario(Long id);
    
    
}
