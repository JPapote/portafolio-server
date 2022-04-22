/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.portafolioServer.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;

import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import lombok.Getter;
import lombok.Setter;

/**
 *
 * @author Antonio
 */
@Getter @Setter
@Entity
public class Usuario implements Serializable {
    
    @Id
    @GeneratedValue(strategy=GenerationType.SEQUENCE)
    private Long id;
    private String nombre;
    @JsonIgnore
    private String password;
    private String fotobaner;
  
    
    
    
    @OneToMany(cascade={CascadeType.ALL})
    @JoinColumn(name="usuarioID")
    private List<Proyecto> proyecto;
    
    @OneToMany(cascade={CascadeType.ALL})
    @JoinColumn(name="usuarioID")
    private List<Experiencia> experiencia;
    
    @OneToMany(cascade={CascadeType.ALL})
    @JoinColumn(name="usuarioID")
    private List<Educacion> educacion;
    
   
    @OneToMany(cascade={CascadeType.ALL})
    @JoinColumn(name="usuarioID")
    private List<HabilidadesDurasBlandas> hdb;
    
   
  @OneToMany(cascade={CascadeType.ALL})
  @JoinColumn(name="usuarioID")
   private List<SobreMi> sobreMi;
}
