/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.portafolioServer.service;

import com.portafolioServer.model.Usuario;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.portafolioServer.repository.MiRepository;

/**
 *
 * @author Antonio
 */
@Service
public class ServiceUsuario implements IService {
    
    @Autowired
    private MiRepository repo;

    @Override
    public List<Usuario> getUsuario() {
        List<Usuario> listUsuario = repo.findAll();
       return listUsuario;
    }

    @Override
    public void savedUsuario(Usuario usuario) {
        repo.save(usuario);
    }

    @Override
    public void deletedUsuario(Long id) {
        repo.deleteById(id);
    }

    @Override
    public Usuario findUsuario(Long id) {
        Usuario usuario = repo.findById(id).orElse(null);
       
       return usuario;
    }

    @Override
    public void updateUsuario(Usuario usuario) {
        savedUsuario(usuario);
        
    }

    @Override
    public Usuario findByNombre(String nombre) {
        return repo.findByNombre(nombre);
    }
    
    
   

}
   